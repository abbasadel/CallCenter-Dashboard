package com.shuratech.gis.impl.genesys.utils;

import java.net.URI;

import com.genesyslab.platform.applicationblocks.com.ConfService;
import com.genesyslab.platform.applicationblocks.com.ConfServiceFactory;
import com.genesyslab.platform.applicationblocks.commons.protocols.ProtocolManagementServiceImpl;
import com.genesyslab.platform.applicationblocks.commons.protocols.StatServerConfiguration;
import com.genesyslab.platform.commons.protocol.ChannelState;
import com.genesyslab.platform.commons.protocol.Endpoint;
import com.genesyslab.platform.commons.protocol.ProtocolException;
import com.genesyslab.platform.configuration.protocol.ConfServerProtocol;
import com.genesyslab.platform.reporting.protocol.StatServerProtocol;
import com.shuratech.gis.api.exceptions.GISGeneralExceptions;
import com.shuratech.gis.api.model.User;
import com.shuratech.gis.impl.genesys.service.ServiceLocator;

public class GenesysUtils {
	private static ProtocolManagementServiceImpl impl = new ProtocolManagementServiceImpl();
	static String statServer="Stat_Server";

	public static ConfService getuserConfService(User user) {
		String applicationName = ServiceLocator.getProperty("CFG.APP_NAME");
		String configrationServerHost = ServiceLocator.getProperty("CFG.HOST");
		String confPortST = ServiceLocator.getProperty("CFG.PORT");
		int confPort = 0;
		try {
			confPort = Integer.parseInt(confPortST);
		} catch (NumberFormatException ex) {
			throw new GISGeneralExceptions(
					"Missing or Invalid Port Value in configration file:", ex);
		}
		Endpoint endpoint = new Endpoint(applicationName,
				configrationServerHost, confPort);
		ConfServerProtocol confProtocol = new ConfServerProtocol(endpoint);
		confProtocol.setUserName(user.getUsername());
		confProtocol.setUserPassword(user.getPassword());
		ConfService userConfService = (ConfService) ConfServiceFactory
				.createConfService(confProtocol);
		
		return userConfService;
	}

	public static void openIfClosed(ConfService userConfService) {
		if (userConfService != null
				&& ChannelState.Closed.asInteger() == userConfService
						.getProtocol().getState().asInteger()) {
			try {
				userConfService.getProtocol().open();

			} catch (Exception e) {
			}
		}
	}

	public static void closeIfOpened(ConfService userConfService) {
		if (userConfService != null
				&& ChannelState.Opened.asInteger() == userConfService
						.getProtocol().getState().asInteger()) {
			try {
				userConfService.getProtocol().close();

			} catch (Exception e) {
			}
		}
	}

	public static StatServerProtocol getStatServerProtocal() throws Exception {
		StatServerProtocol protocol = null;
		try {
			protocol = (StatServerProtocol) impl.getProtocol(statServer);
			if (protocol.getState().asInteger().intValue() == 3){
				protocol.open();
			}
		} catch (Exception ex) {
			StatServerConfiguration statServerConfiguration = new StatServerConfiguration(
					statServer);
			statServerConfiguration.setClientName("Shura");

	
				String host = ServiceLocator.getProperty("STAT_HOST");
				String port = ServiceLocator.getProperty("STAT_PORT");
				statServerConfiguration.setUri(new URI("tcp://" + host + ":"
						+ port));
				statServerConfiguration.setUseAddp(true);

				statServerConfiguration.setAddpClientTimeout(10);
				impl.register(statServerConfiguration);
				protocol = (StatServerProtocol) impl.getProtocol(statServer);
				if (protocol.getState().asInteger().intValue() == 3){
					protocol.open();
				}
			} 

		return protocol;
	}

}
