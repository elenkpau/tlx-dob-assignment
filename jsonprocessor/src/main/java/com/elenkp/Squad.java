package com.elenkp;

import java.util.List;

public class Squad {

    private String squadName;
    private String homeTown;
    private int formed;
    private String secretBase;
    private boolean active;
    private List<SquadMember> members;

    public Squad(String squadName, String homeTown, int formed, String secretBase, boolean active,
            List<SquadMember> members) {
        this.squadName = squadName;
        this.homeTown = homeTown;
        this.formed = formed;
        this.secretBase = secretBase;
        this.active = active;
        this.members = members;
    }

    public Squad() {
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public int getFormed() {
        return formed;
    }

    public void setFormed(int formed) {
        this.formed = formed;
    }

    public String getSecretBase() {
        return secretBase;
    }

    public void setSecretBase(String secretBase) {
        this.secretBase = secretBase;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<SquadMember> getMembers() {
        return members;
    }

    public void setMembers(List<SquadMember> members) {
        this.members = members;
    }

}
