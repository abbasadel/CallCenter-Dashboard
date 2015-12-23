package com.shuratech.gis.impl.genesys.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.genesyslab.platform.applicationblocks.com.ConfService;
import com.genesyslab.platform.commons.protocol.Message;
import com.genesyslab.platform.reporting.protocol.statserver.DnActions;
import com.genesyslab.platform.reporting.protocol.statserver.DnActionsMask;
import com.genesyslab.platform.reporting.protocol.statserver.DnStatusesCollection;
import com.genesyslab.platform.reporting.protocol.statserver.IStatisticStatus;
import com.genesyslab.platform.reporting.protocol.statserver.Notification;
import com.genesyslab.platform.reporting.protocol.statserver.NotificationMode;
import com.genesyslab.platform.reporting.protocol.statserver.PlaceStatus;
import com.genesyslab.platform.reporting.protocol.statserver.StatisticCategory;
import com.genesyslab.platform.reporting.protocol.statserver.StatisticMetricEx;
import com.genesyslab.platform.reporting.protocol.statserver.StatisticObject;
import com.genesyslab.platform.reporting.protocol.statserver.StatisticObjectType;
import com.genesyslab.platform.reporting.protocol.statserver.StatisticSubject;
import com.genesyslab.platform.reporting.protocol.statserver.events.EventInfo;
import com.genesyslab.platform.reporting.protocol.statserver.events.EventStatisticOpened;
import com.genesyslab.platform.reporting.protocol.statserver.requests.RequestCloseStatistic;
import com.genesyslab.platform.reporting.protocol.statserver.requests.RequestOpenStatisticEx;
import com.genesyslab.platform.reporting.protocol.statserver.requests.RequestPeekStatistic;
import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.model.AgentStatus;
import com.shuratech.gis.api.model.AgentStatusUpdate;
import com.shuratech.gis.api.service.AgentStatusService;
import com.shuratech.gis.api.service.GroupService;
import com.shuratech.gis.impl.genesys.utils.GenesysTypes;
import com.shuratech.gis.impl.genesys.utils.GenesysUtils;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mohamed ELFayomy
 *
 *
 */
public class AgentStatusServiceImp extends ServcieImp implements AgentStatusService {

    @Autowired
    GroupService groupService;

    public AgentStatusServiceImp(ConfService userConfService) {
        super(userConfService);
    }

    @Override
    public AgentStatusUpdate get(Agent agent) {
        AgentStatusUpdate agentStatus = null;
        try {
            int refID = getRequestReferenceID(GenesysTypes.Agent, agent.getEmployeeID());
            agentStatus = pickAgentStatus(refID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return agentStatus;
    }

    @Override
    public List<AgentStatusUpdate> get(List<Agent> agents) {
        List<AgentStatusUpdate> result = new ArrayList<AgentStatusUpdate>();
        for (Agent agent : agents) {
            AgentStatusUpdate agentStatusUpdate = get(agent);
            if (agentStatusUpdate != null) {
                agentStatusUpdate.setAgent(agent);
                result.add(agentStatusUpdate);
            }
        }
        return result;
    }

    @Override
    public List<AgentStatusUpdate> get(AgentGroup group) {
        return get(groupService.get(group.getId()).getAgents());
    }

    static AgentStatusUpdate pickAgentStatus(int refID) {
        //System.out.println("refID"+refID);
        RequestPeekStatistic reqPeek = RequestPeekStatistic.create();
        reqPeek.setStatisticId(refID);
        reqPeek.setReferenceId(refID);
        //reqPeek.setStatisticId(2);
        EventInfo message;
        String status = "LoggedOut";
        Long time = null;
        try {

            Message mes = GenesysUtils.getStatServerProtocal().request(reqPeek);
            //System.out.println(mes);
            message = (EventInfo) mes;
            IStatisticStatus state = message.getStateValue();
            com.genesyslab.platform.reporting.protocol.statserver.AgentStatus agentStatus = (com.genesyslab.platform.reporting.protocol.statserver.AgentStatus) state;
            status = agentStatus.getLoginId();
            if (!"LoggedOut".equals(status)) {
                PlaceStatus placeStatus = agentStatus.getPlace();
                DnStatusesCollection dnStatuses = placeStatus.getDnStatuses();

                int count = dnStatuses.getCount();
                for (int i = 0; i < count; i++) {
                    status = DnActions.getValue(DnActions.class, dnStatuses.getItem(i).getStatus()).toString();
                    time = dnStatuses.getItem(i).getTime();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RequestCloseStatistic req = RequestCloseStatistic.create();
            req.setStatisticId(refID);
            try {
                GenesysUtils.getStatServerProtocal().send(req);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        AgentStatusUpdate agentStatusUpdate = new AgentStatusUpdate();
        agentStatusUpdate.setStatus(AgentStatus.valueOf(status));
        agentStatusUpdate.setUpdated(time);

        return agentStatusUpdate;

    }

    static int getRequestReferenceID(GenesysTypes type, String ID) throws Exception {

        int random = getRandomId();
        DnActionsMask mainMask = new DnActionsMask();
//		mainMask.setAll();
        mainMask.setBit(DnActions.AgentLogin);
        mainMask.setBit(DnActions.LoggedIn);
        mainMask.setBit(DnActions.AfterCallWork);
        mainMask.setBit(DnActions.AgentLogout);
        mainMask.setBit(DnActions.WaitForNextCall);
        mainMask.setBit(DnActions.NotReadyForNextCall);

        DnActionsMask relMask = new DnActionsMask();

        StatisticMetricEx metric = StatisticMetricEx.create();

        metric.setCategory(StatisticCategory.CurrentState);
        metric.setMainMask(mainMask);
        metric.setRelativeMask(relMask);
        metric.setSubject(StatisticSubject.DNAction);

        StatisticObject stat = StatisticObject.create();
        StatisticObjectType objectType = (StatisticObjectType) StatisticObjectType.getValue(StatisticObjectType.class, type.getType());

        //System.out.println("------------------------"+objectType);
        stat.setObjectType(objectType);
        stat.setObjectId(ID);
        stat.setTenantName("Resources");
        stat.setTenantPassword("");

        Notification notify = Notification.create();
        notify.setMode(NotificationMode.Immediate);

        RequestOpenStatisticEx req = RequestOpenStatisticEx.create();
        req.setStatisticMetricEx(metric);
        req.setStatisticObject(stat);
        req.setNotification(notify);
        req.setReferenceId(random);
        //req.setTag(1);
        //System.out.println(GenesysUtils.getStatServerProtocal().request(req));
        EventStatisticOpened opened = (EventStatisticOpened) GenesysUtils.getStatServerProtocal().request(req);

        //  System.out.println("000000000000"+opened);
        return random;
    }

    static int getRandomId() {
        return new Double(Math.random() * Integer.MAX_VALUE).intValue();
    }

}
