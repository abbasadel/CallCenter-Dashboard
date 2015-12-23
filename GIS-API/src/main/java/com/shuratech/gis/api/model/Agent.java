package com.shuratech.gis.api.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abbas
 */
public class Agent {

    private AgentStatus status;
    private String firstName;
    private String lastName;
    private String employeeID;
    private String email;
    private List<Skill> skills;
    private List<Skill> disabledSkills;
    private String loginID;
    private User credential;
    private List<AgentLogin> loginIDs = new ArrayList<AgentLogin>();

    private List<AgentGroup> groups;

    //setters and getters
    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getLoginID() {
        if(loginID == null){
            if(loginIDs != null && loginIDs.size() > 0){
                loginID = loginIDs.get(0).getLoginCode();
            }
        }
        return loginID;
    }

    public AgentStatus getStatus() {
        return status;
    }

    public void setStatus(AgentStatus status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Skill> getDisabledSkills() {
        return disabledSkills;
    }

    public void setDisabledSkills(List<Skill> disabledSkills) {
        this.disabledSkills = disabledSkills;
    }

    public List<AgentGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<AgentGroup> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Agent [firstName=" + firstName + ", lastName=" + lastName
                + ", employeeID=" + employeeID + "]";
    }

    public User getCredential() {
        return credential;
    }

    public void setCredential(User credential) {
        this.credential = credential;
    }

    /**
     * @return the loginIDs
     */
    public List<AgentLogin> getLoginIDs() {
        return loginIDs;
    }

    /**
     * @param loginIDs the loginIDs to set
     */
    public void setLoginIDs(List<AgentLogin> loginIDs) {
        this.loginIDs = loginIDs;
    }

}
