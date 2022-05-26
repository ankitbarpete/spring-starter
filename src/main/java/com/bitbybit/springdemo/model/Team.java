package com.bitbybit.springdemo.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    String teamName = "BitByBit";
    List<String> teamMembers = List.of("Sanjeev", "Prathmesh", "Ankit");

    public Team(){}

    public Team(String teamName, String teamLead) {
        this.teamName = teamName;
        teamMembers = new ArrayList<>();
        teamMembers.add(teamLead);
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(String name){
        teamMembers.add(name);
    }

    public String getTeamName() {
        return teamName;
    }

    public List<String> getTeamMembers() {
        return teamMembers;
    }
}
