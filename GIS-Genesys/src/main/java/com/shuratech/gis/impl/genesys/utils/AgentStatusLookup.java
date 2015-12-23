package com.shuratech.gis.impl.genesys.utils;
import java.util.HashMap;
public class AgentStatusLookup {

	public static final int AfterCallWork = 9;
	public static final int AfterCallWorkConsult = 0x35;
	public static final int AfterCallWorkInbound = 0x33;
	public static final int AfterCallWorkInternal = 50;
	public static final int AfterCallWorkOutbound = 0x34;
	public static final int AfterCallWorkUnknown = 0x31;
	public static final int AgentLogin = 0xc3;
	public static final int AgentLogout = 0xc4;
	public static final int BreakType1 = 11;
	public static final int BreakType2 = 12;
	public static final int CallAbandoned = 0x52;
	public static final int CallAbandonedConsult = 0x66;
	public static final int CallAbandonedFromDialing = 0x19;
	public static final int CallAbandonedFromDialingConsult = 0x3f;
	public static final int CallAbandonedFromDialingInbound = 0x3d;
	public static final int CallAbandonedFromDialingInternal = 60;
	public static final int CallAbandonedFromDialingOutbound = 0x3e;
	public static final int CallAbandonedFromDialingUnknown = 0x3b;
	public static final int CallAbandonedFromHold = 30;
	public static final int CallAbandonedFromHoldConsult = 0x4e;
	public static final int CallAbandonedFromHoldInbound = 0x4c;
	public static final int CallAbandonedFromHoldInternal = 0x4b;
	public static final int CallAbandonedFromHoldOutbound = 0x4d;
	public static final int CallAbandonedFromHoldUnknown = 0x4a;
	public static final int CallAbandonedFromRinging = 0x1b;
	public static final int CallAbandonedFromRingingConsult = 0x49;
	public static final int CallAbandonedFromRingingInbound = 0x47;
	public static final int CallAbandonedFromRingingInternal = 70;
	public static final int CallAbandonedFromRingingOutbound = 0x48;
	public static final int CallAbandonedFromRingingUnknown = 0x45;
	public static final int CallAbandonedInbound = 100;
	public static final int CallAbandonedInternal = 0x63;
	public static final int CallAbandonedOutbound = 0x65;
	public static final int CallAbandonedUnknown = 0x62;
	public static final int CallAnswered = 0x1a;
	public static final int CallAnsweredConsult = 0x44;
	public static final int CallAnsweredInbound = 0x42;
	public static final int CallAnsweredInternal = 0x41;
	public static final int CallAnsweredOutbound = 0x43;
	public static final int CallAnsweredUnknown = 0x40;
	public static final int CallConferenceJoined = 0x23;
	public static final int CallConferenceMade = 0x22;
	public static final int CallConferenceOriginated = 0xc1;
	public static final int CallConferencePartyAdded = 0x24;
	public static final int CallConferencePartyDeleted = 0x25;
	public static final int CallConsult = 0x13;
	public static final int CallConsultCompleted = 0xa2;
	public static final int CallConsultOriginated = 0x9d;
	public static final int CallConsultReceived = 0x9e;
	public static final int CallConsultStarted = 0x89;
	public static final int CallDialConferenced = 0x73;
	public static final int CallDialed = 0x18;
	public static final int CallDialedConsult = 0x71;
	public static final int CallDialedInbound = 0x6f;
	public static final int CallDialedInternal = 110;
	public static final int CallDialedOutbound = 0x70;
	public static final int CallDialedUnknown = 0x6d;
	public static final int CallDialing = 6;
	public static final int CallDialingConsult = 0x2b;
	public static final int CallDialingInbound = 0x29;
	public static final int CallDialingInternal = 40;
	public static final int CallDialingOutbound = 0x2a;
	public static final int CallDialingUnknown = 0x27;
	public static final int CallDialTransferred = 0x72;
	public static final int CallDistributed = 0x51;
	public static final int CallDistributedConsult = 0x61;
	public static final int CallDistributedInbound = 0x5f;
	public static final int CallDistributedInternal = 0x5e;
	public static final int CallDistributedOutbound = 0x60;
	public static final int CallDistributedUnknown = 0x5d;
	public static final int CallEntered = 80;
	public static final int CallEnteredConsult = 0x5c;
	public static final int CallEnteredInbound = 90;
	public static final int CallEnteredInternal = 0x59;
	public static final int CallEnteredOutbound = 0x5b;
	public static final int CallEnteredUnknown = 0x58;
	public static final int CallForwarded = 0x92;
	public static final int CallForwardedConsult = 0x97;
	public static final int CallForwardedInbound = 0x95;
	public static final int CallForwardedInternal = 0x94;
	public static final int CallForwardedOutbound = 150;
	public static final int CallForwardedUnknown = 0x93;
	public static final int CallHeld = 0x1c;
	public static final int CallInbound = 0x16;
	public static final int CallInboundCompleted = 0xa5;
	public static final int CallInboundStarted = 140;
	public static final int CallInternal = 20;
	public static final int CallInternalCompleted = 0xa3;
	public static final int CallInternalOriginated = 0x9f;
	public static final int CallInternalReceived = 160;
	public static final int CallInternalStarted = 0x8a;
	public static final int CallObservedConsult = 0x8e;
	public static final int CallObservedInbound = 0x91;
	public static final int CallObservedInternal = 0x8f;
	public static final int CallObservedOutbound = 0x90;
	public static final int CallObservedUnknown = 0x8d;
	public static final int CallOnHold = 13;
	public static final int CallOnHoldConsult = 0x3a;
	public static final int CallOnHoldInbound = 0x38;
	public static final int CallOnHoldInternal = 0x37;
	public static final int CallOnHoldOutbound = 0x39;
	public static final int CallOnHoldUnknown = 0x36;
	public static final int CallOutbound = 0x15;
	public static final int CallOutboundCompleted = 0xa4;
	public static final int CallOutboundStarted = 0x8b;
	public static final int CallPartyChanged = 0x87;
	public static final int CallRetrievedFromHold = 0x1d;
	public static final int CallRinging = 7;
	public static final int CallRingingConsult = 0x30;
	public static final int CallRingingInbound = 0x2e;
	public static final int CallRingingInternal = 0x2d;
	public static final int CallRingingOutbound = 0x2f;
	public static final int CallRingingUnknown = 0x2c;
	public static final int CallTransferMade = 0x1f;
	public static final int CallTransferMadeConsult = 0x9c;
	public static final int CallTransferMadeInbound = 0x9a;
	public static final int CallTransferMadeInternal = 0x99;
	public static final int CallTransferMadeOutbound = 0x9b;
	public static final int CallTransferMadeUnknown = 0x98;
	public static final int CallTransferPartyChanged = 0x21;
	public static final int CallTransferTaken = 0x20;
	public static final int CallUnknown = 0x12;
	public static final int CallUnknownCompleted = 0xa1;
	public static final int CallUnknownStarted = 0x88;
	public static final int CallWait = 0x4f;
	public static final int CallWaitConsult = 0x57;
	public static final int CallWaitInbound = 0x55;
	public static final int CallWaitInternal = 0x54;
	public static final int CallWaitOutbound = 0x56;
	public static final int CallWaitUnknown = 0x53;
	public static final int DialingStarted = 0x67;
	public static final int DialingStartedConsult = 0x6c;
	public static final int DialingStartedInbound = 0x6a;
	public static final int DialingStartedInternal = 0x69;
	public static final int DialingStartedOutbound = 0x6b;
	public static final int DialingStartedUnknown = 0x68;
	public static final int LoggedIn = 2;
	public static final int LoggedInQueue = 0xc5;
	public static final int LoggedOut = 0x17;
	public static final int Monitored = 1;
	public static final int NotMonitored = 0;
	public static final int NotReadyForNextCall = 8;
	public static final int NotUsed1 = 0xc2;
	public static final int OffHook = 5;
	public static final int OfflineWorkType2 = 10;
	public static final int OnHook = 3;
	public static final int PartyChangedFromHold = 0x80;
	public static final int PlaceholderForBeingCoached = 0xb7;
	public static final int PlaceholderForBeingMonitored = 0xb1;
	public static final int PlaceholderForCoaching = 0xb8;
	public static final int PlaceholderForCoachingByIntrusionInitiated = 0xb6;
	public static final int PlaceholderForCoachingByRequestInitiated = 0xb5;
	public static final int PlaceholderForCoachingRequested = 0xb3;
	public static final int PlaceholderForCoachingStarted = 180;
	public static final int PlaceholderForConferenceJoinedByIntrusion = 0xb9;
	public static final int PlaceholderForInteractionPulled = 0xba;
	public static final int PlaceholderForInteractionStarted1 = 0xa7;
	public static final int PlaceholderForInteractionStarted2 = 0xa8;
	public static final int PlaceholderForInteractionStarted3 = 0xa9;
	public static final int PlaceholderForInteractionStarted4 = 170;
	public static final int PlaceholderForInteractionStopped1 = 0xab;
	public static final int PlaceholderForInteractionStopped2 = 0xac;
	public static final int PlaceholderForInteractionStopped3 = 0xad;
	public static final int PlaceholderForInteractionStopped4 = 0xae;
	public static final int PlaceholderForMonitoring = 0xb2;
	public static final int PlaceholderForMonitoringInitiated = 0xb0;
	public static final int PlaceholderForMonitoringStarted = 0xaf;
	public static final int PlaceholderForRevoking = 0xa6;
	public static final int RetrievedFromHoldConsult = 0x7f;
	public static final int RetrievedFromHoldInbound = 0x7d;
	public static final int RetrievedFromHoldInternal = 0x7c;
	public static final int RetrievedFromHoldOutbound = 0x7e;
	public static final int RetrievedFromHoldUnknown = 0x7b;
	public static final int RingingPartyChanged = 0x7a;
	public static final int RingingStarted = 0x74;
	public static final int RingingStartedConsult = 0x79;
	public static final int RingingStartedInbound = 0x77;
	public static final int RingingStartedInternal = 0x76;
	public static final int RingingStartedOutbound = 120;
	public static final int RingingStartedUnknown = 0x75;
	public static final int SM_Engaged = 0x10;
	public static final int SM_Outbound = 0x11;
	public static final int StuckCallCleanedWhileRinging = 0xbb;
	public static final int StuckCallCleanedWhileRingingConsult = 0xc0;
	public static final int StuckCallCleanedWhileRingingInbound = 190;
	public static final int StuckCallCleanedWhileRingingInternal = 0xbd;
	public static final int StuckCallCleanedWhileRingingOutbound = 0xbf;
	public static final int StuckCallCleanedWhileRingingUnknown = 0xbc;
	public static final int TransferredFromHold = 0x81;
	public static final int TransferredFromHoldConsult = 0x86;
	public static final int TransferredFromHoldInbound = 0x84;
	public static final int TransferredFromHoldInternal = 0x83;
	public static final int TransferredFromHoldOutbound = 0x85;
	public static final int TransferredFromHoldUnknown = 130;
	public static final int UserEvent = 0x26;
	public static final int WaitForNextCall = 4;

	// custom status
	public static final int InvalidEmployeeId = -1;

	private static HashMap<Long, String> lookup = new HashMap<Long, String>();

	static
	{
		lookup.put(new Long(AfterCallWork), "AfterCallWork");
		lookup.put(new Long(AfterCallWorkConsult), "After Call Work Consult");
		lookup.put(new Long(AfterCallWorkInbound), "After Call Work Inbound");
		lookup.put(new Long(AfterCallWorkInternal), "After Call Work Internal");
		lookup.put(new Long(AfterCallWorkOutbound), "After Call Work Outbound");
		lookup.put(new Long(AfterCallWorkUnknown), "After Call Work Unknown");
		lookup.put(new Long(AgentLogin), "Agent Login");
		lookup.put(new Long(AgentLogout), "Agent Logout");
		lookup.put(new Long(BreakType1), "Break Type1");
		lookup.put(new Long(BreakType2), "Break Type2");
		lookup.put(new Long(CallAbandoned), "Call Abandoned");
		lookup.put(new Long(CallAbandonedConsult), "Call Abandoned Consult");
		lookup.put(new Long(CallAbandonedFromDialing), "Call Abandoned FromDialing");
		lookup.put(new Long(CallAbandonedFromDialingConsult), "Call Abandoned From Dialing Consult");
		lookup.put(new Long(CallAbandonedFromDialingInbound), "Call Abandoned From Dialing Inbound");
		lookup.put(new Long(CallAbandonedFromDialingInternal), "Call Abandoned From Dialing Internal");
		lookup.put(new Long(CallAbandonedFromDialingOutbound), "Call Abandoned From Dialing Outbound");
		lookup.put(new Long(CallAbandonedFromDialingUnknown), "Call Abandoned From Dialing Unknown");
		lookup.put(new Long(CallAbandonedFromHold), "Call Abandoned FromHold");
		lookup.put(new Long(CallAbandonedFromHoldConsult), "Call Abandoned From Hold Consult");
		lookup.put(new Long(CallAbandonedFromHoldInbound), "Call Abandoned From Hold Inbound");
		lookup.put(new Long(CallAbandonedFromHoldInternal), "Call Abandoned From Hold Internal");
		lookup.put(new Long(CallAbandonedFromHoldOutbound), "Call Abandoned From Hold Outbound");
		lookup.put(new Long(CallAbandonedFromHoldUnknown), "Call Abandoned From Hold Unknown");
		lookup.put(new Long(CallAbandonedFromRinging), "Call Abandoned From Ringing");
		lookup.put(new Long(CallAbandonedFromRingingConsult), "Call Abandoned From Ringing Consult");
		lookup.put(new Long(CallAbandonedFromRingingInbound), "Call Abandoned From Ringing Inbound");
		lookup.put(new Long(CallAbandonedFromRingingInternal), "Call Abandoned From Ringing Internal");
		lookup.put(new Long(CallAbandonedFromRingingOutbound), "Call Abandoned From Ringing Outbound");
		lookup.put(new Long(CallAbandonedFromRingingUnknown), "Call Abandoned From Ringing Unknown");
		lookup.put(new Long(CallAbandonedInbound), "Call Abandoned Inbound");
		lookup.put(new Long(CallAbandonedInternal), "Call Abandoned Internal");
		lookup.put(new Long(CallAbandonedOutbound), "Call Abandoned Outbound");
		lookup.put(new Long(CallAbandonedUnknown), "Call Abandoned Unknown");
		lookup.put(new Long(CallAnswered), "Call Answered");
		lookup.put(new Long(CallAnsweredConsult), "Call Answered Consult");
		lookup.put(new Long(CallAnsweredInbound), "Call Answered Inbound");
		lookup.put(new Long(CallAnsweredInternal), "Call Answered Internal");
		lookup.put(new Long(CallAnsweredOutbound), "Call Answered Outbound");
		lookup.put(new Long(CallAnsweredUnknown), "Call Answered Unknown");
		lookup.put(new Long(CallConferenceJoined), "Call Conference Joined");
		lookup.put(new Long(CallConferenceMade), "Call Conference Made");
		lookup.put(new Long(CallConferenceOriginated), "Call Conference Originated");
		lookup.put(new Long(CallConferencePartyAdded), "Call Conference Party Added");
		lookup.put(new Long(CallConferencePartyDeleted), "Call Conference Party Deleted");
		lookup.put(new Long(CallConsult), "CallConsult");
		lookup.put(new Long(CallConsultCompleted), "Call Consult Completed");
		lookup.put(new Long(CallConsultOriginated), "Call Consult Originated");
		lookup.put(new Long(CallConsultReceived), "Call Consult Received");
		lookup.put(new Long(CallConsultStarted), "Call Consult Started");
		lookup.put(new Long(CallDialConferenced), "Call Dial Conferenced");
		lookup.put(new Long(CallDialed), "Call Dialed");
		lookup.put(new Long(CallDialedConsult), "Call Dialed Consult");
		lookup.put(new Long(CallDialedInbound), "Call Dialed Inbound");
		lookup.put(new Long(CallDialedInternal), "Call Dialed Internal");
		lookup.put(new Long(CallDialedOutbound), "Call Dialed Outbound");
		lookup.put(new Long(CallDialedUnknown), "Call Dialed Unknown");
		lookup.put(new Long(CallDialing), "Call Dialing");
		lookup.put(new Long(CallDialingConsult), "Call Dialing Consult");
		lookup.put(new Long(CallDialingInbound), "Call Dialing Inbound");
		lookup.put(new Long(CallDialingInternal), "Call Dialing Internal");
		lookup.put(new Long(CallDialingOutbound), "Call Dialing Outbound");
		lookup.put(new Long(CallDialingUnknown), "Call Dialing Unknown");
		lookup.put(new Long(CallDialTransferred), "Call Dial Transferred");
		lookup.put(new Long(CallDistributed), "Call Distributed");
		lookup.put(new Long(CallDistributedConsult), "Call Distributed Consult");
		lookup.put(new Long(CallDistributedInbound), "Call Distributed Inbound");
		lookup.put(new Long(CallDistributedInternal), "Call Distributed Internal");
		lookup.put(new Long(CallDistributedOutbound), "Call Distributed Outbound");
		lookup.put(new Long(CallDistributedUnknown), "Call Distributed Unknown");
		lookup.put(new Long(CallEntered), "CallEntered");
		lookup.put(new Long(CallEnteredConsult), "Call Entered Consult");
		lookup.put(new Long(CallEnteredInbound), "Call Entered Inbound");
		lookup.put(new Long(CallEnteredInternal), "Call Entered Internal");
		lookup.put(new Long(CallEnteredOutbound), "Call Entered Outbound");
		lookup.put(new Long(CallEnteredUnknown), "Call Entered Unknown");
		lookup.put(new Long(CallForwarded), "Call Forwarded");
		lookup.put(new Long(CallForwardedConsult), "Call Forwarded Consult");
		lookup.put(new Long(CallForwardedInbound), "Call Forwarded Inbound");
		lookup.put(new Long(CallForwardedInternal), "Call Forwarded Internal");
		lookup.put(new Long(CallForwardedOutbound), "Call Forwarded Outbound");
		lookup.put(new Long(CallForwardedUnknown), "Call Forwarded Unknown");
		lookup.put(new Long(CallHeld), "Call Held");
		lookup.put(new Long(CallInbound), "Call Inbound");
		lookup.put(new Long(CallInboundCompleted), "Call Inbound Completed");
		lookup.put(new Long(CallInboundStarted), "Call Inbound Started");
		lookup.put(new Long(CallInternal), "Call Internal");
		lookup.put(new Long(CallInternalCompleted), "Call Internal Completed");
		lookup.put(new Long(CallInternalOriginated), "Call Internal Originated");
		lookup.put(new Long(CallInternalReceived), "Call Internal Received");
		lookup.put(new Long(CallInternalStarted), "Call Internal Started");
		lookup.put(new Long(CallObservedConsult), "Call Observed Consult");
		lookup.put(new Long(CallObservedInbound), "Call Observed Inbound");
		lookup.put(new Long(CallObservedInternal), "Call Observed Internal");
		lookup.put(new Long(CallObservedOutbound), "Call Observed Outbound");
		lookup.put(new Long(CallObservedUnknown), "Call Observed Unknown");
		lookup.put(new Long(CallOnHold), "Call On Hold");
		lookup.put(new Long(CallOnHoldConsult), "Call On Hold Consult");
		lookup.put(new Long(CallOnHoldInbound), "Call On Hold Inbound");
		lookup.put(new Long(CallOnHoldInternal), "Call On Hold Internal");
		lookup.put(new Long(CallOnHoldOutbound), "Call On Hold Outbound");
		lookup.put(new Long(CallOnHoldUnknown), "Call On Hold Unknown");
		lookup.put(new Long(CallOutbound), "Call Outbound");
		lookup.put(new Long(CallOutboundCompleted), "Call Outbound Completed");
		lookup.put(new Long(CallOutboundStarted), "Call Outbound Started");
		lookup.put(new Long(CallPartyChanged), "Call Party Changed");
		lookup.put(new Long(CallRetrievedFromHold), "Call Retrieved From Hold");
		lookup.put(new Long(CallRinging), "Call Ringing");
		lookup.put(new Long(CallRingingConsult), "Call Ringing Consult");
		lookup.put(new Long(CallRingingInbound), "Call Ringing Inbound");
		lookup.put(new Long(CallRingingInternal), "Call Ringing Internal");
		lookup.put(new Long(CallRingingOutbound), "Call Ringing Outbound");
		lookup.put(new Long(CallRingingUnknown), "Call Ringing Unknown");
		lookup.put(new Long(CallTransferMade), "Call Transfer Made");
		lookup.put(new Long(CallTransferMadeConsult), "Call Transfer Made Consult");
		lookup.put(new Long(CallTransferMadeInbound), "Call Transfer Made Inbound");
		lookup.put(new Long(CallTransferMadeInternal), "Call Transfer Made Internal");
		lookup.put(new Long(CallTransferMadeOutbound), "Call Transfer Made Outbound");
		lookup.put(new Long(CallTransferMadeUnknown), "Call Transfer Made Unknown");
		lookup.put(new Long(CallTransferPartyChanged), "Call Transfer Party Changed");
		lookup.put(new Long(CallTransferTaken), "Call Transfer Taken");
		lookup.put(new Long(CallUnknown), "Call Unknown");
		lookup.put(new Long(CallUnknownCompleted), "Call Unknown Completed");
		lookup.put(new Long(CallUnknownStarted), "Call Unknown Started");
		lookup.put(new Long(CallWait), "Call Wait");
		lookup.put(new Long(CallWaitConsult), "Call Wait Consult");
		lookup.put(new Long(CallWaitInbound), "Call Wait Inbound");
		lookup.put(new Long(CallWaitInternal), "Call Wait Internal");
		lookup.put(new Long(CallWaitOutbound), "Call Wait Outbound");
		lookup.put(new Long(CallWaitUnknown), "Call Wait Unknown");
		lookup.put(new Long(DialingStarted), "Dialing Started");
		lookup.put(new Long(DialingStartedConsult), "Dialing Started Consult");
		lookup.put(new Long(DialingStartedInbound), "Dialing Started Inbound");
		lookup.put(new Long(DialingStartedInternal), "Dialing Started Internal");
		lookup.put(new Long(DialingStartedOutbound), "Dialing Started Outbound");
		lookup.put(new Long(DialingStartedUnknown), "Dialing Started Unknown");
		lookup.put(new Long(LoggedIn), "Logged In");
		lookup.put(new Long(LoggedInQueue), "Logged In Queue");
		lookup.put(new Long(LoggedOut), "Logged Out");
		lookup.put(new Long(Monitored), "Monitored");
		lookup.put(new Long(NotMonitored), "Not Monitored");
		lookup.put(new Long(NotReadyForNextCall), "Not Ready For Next Call");
		lookup.put(new Long(NotUsed1), "Not Used1");
		lookup.put(new Long(OffHook), "Off Hook");
		lookup.put(new Long(OfflineWorkType2), "Offline Work Type2");
		lookup.put(new Long(OnHook), "OnHook");
		lookup.put(new Long(PartyChangedFromHold), "Party Changed FromHold");
		lookup.put(new Long(PlaceholderForBeingCoached), "Placeholder For Being Coached");
		lookup.put(new Long(PlaceholderForBeingMonitored), "Placeholder For Being Monitored");
		lookup.put(new Long(PlaceholderForCoaching), "Placeholder For Coaching");
		lookup.put(new Long(PlaceholderForCoachingByIntrusionInitiated), "Placeholder For Coaching By Intrusion Initiated");
		lookup.put(new Long(PlaceholderForCoachingByRequestInitiated), "Placeholder For Coaching By Request Initiated");
		lookup.put(new Long(PlaceholderForCoachingRequested), "Placeholder For Coaching Requested");
		lookup.put(new Long(PlaceholderForCoachingStarted), "Placeholder For Coaching Started");
		lookup.put(new Long(PlaceholderForConferenceJoinedByIntrusion), "Placeholder For Conference Joined By Intrusion");
		lookup.put(new Long(PlaceholderForInteractionPulled), "Placeholder For Interaction Pulled");
		lookup.put(new Long(PlaceholderForInteractionStarted1), "Placeholder For Interaction Started1");
		lookup.put(new Long(PlaceholderForInteractionStarted2), "Placeholder For Interaction Started2");
		lookup.put(new Long(PlaceholderForInteractionStarted3), "Placeholder For Interaction Started3");
		lookup.put(new Long(PlaceholderForInteractionStarted4), "Placeholder For Interaction Started4");
		lookup.put(new Long(PlaceholderForInteractionStopped1), "Placeholder For Interaction Stopped1");
		lookup.put(new Long(PlaceholderForInteractionStopped2), "Placeholder For Interaction Stopped2");
		lookup.put(new Long(PlaceholderForInteractionStopped3), "Placeholder For Interaction Stopped3");
		lookup.put(new Long(PlaceholderForInteractionStopped4), "Placeholder For Interaction Stopped4");
		lookup.put(new Long(PlaceholderForMonitoring), "Placeholder For Monitoring");
		lookup.put(new Long(PlaceholderForMonitoringInitiated), "Placeholder For Monitoring Initiated");
		lookup.put(new Long(PlaceholderForMonitoringStarted), "Placeholder For Monitoring Started");
		lookup.put(new Long(PlaceholderForRevoking), "Placeholder For Revoking");
		lookup.put(new Long(RetrievedFromHoldConsult), "Retrieved From Hold Consult");
		lookup.put(new Long(RetrievedFromHoldInbound), "Retrieved From Hold Inbound");
		lookup.put(new Long(RetrievedFromHoldInternal), "Retrieved From Hold Internal");
		lookup.put(new Long(RetrievedFromHoldOutbound), "Retrieved From Hold Outbound");
		lookup.put(new Long(RetrievedFromHoldUnknown), "Retrieved From Hold Unknown");
		lookup.put(new Long(RingingPartyChanged), "Ringing Party Changed");
		lookup.put(new Long(RingingStarted), "Ringing Started");
		lookup.put(new Long(RingingStartedConsult), "Ringing Started Consult");
		lookup.put(new Long(RingingStartedInbound), "Ringing Started Inbound");
		lookup.put(new Long(RingingStartedInternal), "Ringing Started Internal");
		lookup.put(new Long(RingingStartedOutbound), "Ringing Started Outbound");
		lookup.put(new Long(RingingStartedUnknown), "Ringing Started Unknown");
		lookup.put(new Long(SM_Engaged), "SM_Engaged");
		lookup.put(new Long(SM_Outbound), "SM_Outbound");
		lookup.put(new Long(StuckCallCleanedWhileRinging), "Stuck Call Cleaned While Ringing");
		lookup.put(new Long(StuckCallCleanedWhileRingingConsult), "StuckCall Cleaned While Ringing Consult");
		lookup.put(new Long(StuckCallCleanedWhileRingingInbound), "StuckCall Cleaned While Ringing Inbound");
		lookup.put(new Long(StuckCallCleanedWhileRingingInternal), "StuckCall Cleaned While Ringing Internal");
		lookup.put(new Long(StuckCallCleanedWhileRingingOutbound), "StuckCall Cleaned While Ringing Outbound");
		lookup.put(new Long(StuckCallCleanedWhileRingingUnknown), "Stuck Call Cleaned While Ringing Unknown");
		lookup.put(new Long(TransferredFromHold), "Transferred From Hold");
		lookup.put(new Long(TransferredFromHoldConsult), "Transferred From Hold Consult");
		lookup.put(new Long(TransferredFromHoldInbound), "Transferred From Hold Inbound");
		lookup.put(new Long(TransferredFromHoldInternal), "Transferred From Hold Internal");
		lookup.put(new Long(TransferredFromHoldOutbound), "Transferred From Hold Outbound");
		lookup.put(new Long(TransferredFromHoldUnknown), "Transferred From Hold Unknown");
		lookup.put(new Long(UserEvent), "User Event");
		lookup.put(new Long(WaitForNextCall), "Wait For Next Call");
		lookup.put(new Long(InvalidEmployeeId), "Invalid Employee Id");
	}

	private AgentStatusLookup()
	{

	}

	public static String getValue(int key)
	{
		return lookup.get(new Long(key));
	}
}