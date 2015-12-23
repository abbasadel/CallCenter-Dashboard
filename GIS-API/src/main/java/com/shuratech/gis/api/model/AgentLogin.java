package com.shuratech.gis.api.model;

public class AgentLogin {

    private String loginCode;
    private int dbID;
    private int switchID;

    /**
     * Agent Logins are unique codes defined within a Switch and assigned to
     * agents. They identify which Agent is working at which Place during a
     * particular working session.
     *
     *
     */

    public AgentLogin() {
        // TODO Auto-generated constructor stub
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public int getDbID() {
        return dbID;
    }

    public void setDbID(int dbID) {
        this.dbID = dbID;
    }

    public int getSwitchID() {
        return switchID;
    }

    public void setSwitchID(int switchID) {
        this.switchID = switchID;
    }

}
