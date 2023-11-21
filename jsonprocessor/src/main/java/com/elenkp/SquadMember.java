package com.elenkp;

import java.util.Arrays;

public class SquadMember {

    private String name;
    private int age;
    private String secretIdentity;
    private String[] powers;

    public SquadMember(String name, int age, String secretIdentity, String[] powers) {
        this.name = name;
        this.age = age;
        this.secretIdentity = secretIdentity;
        this.powers = powers;
    }

    public SquadMember() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public void setPowers(String[] powers) {
        this.powers = powers;
    }

    public int getNumOfPowers() {
        return powers.length;
    }

    @Override
    public String toString() {
        return "SquadMember [name=" + name + ", age=" + age + ", secretIdentity=" + secretIdentity + ", powers="
                + Arrays.toString(powers) + "]";
    }

}
