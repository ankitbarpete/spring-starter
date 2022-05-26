package com.bitbybit.springdemo.dao;

import com.bitbybit.springdemo.model.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DemoDAO {
    Team team;
    public Team createTeam(String teamName, String leader) {
        team = new Team(teamName, leader);
        return team;
    }

    public Team getTeam() {
        if (team == null)
            team = new Team();
        return team;
    }

    public void addTeammate(String teammate){
        team.addTeamMember(teammate);
    }

    public List<String> getMembers() {
        return team.getTeamMembers();
    }
}
