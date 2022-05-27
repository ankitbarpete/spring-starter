package com.bitbybit.springdemo.service;

import com.bitbybit.springdemo.dao.DemoDAO;
import com.bitbybit.springdemo.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    private final DemoDAO demoDAO;

    public DemoService(@Autowired DemoDAO demoDAO) {
        this.demoDAO = demoDAO;
    }

    public Team createTeam(String teamName, String leader) {
        return demoDAO.createTeam(teamName, leader);
    }

    public Team getTeam() {
        return demoDAO.getTeam();
    }

    public List<String> addTeammate(String teammate){
        return demoDAO.addTeammate(teammate);
    }

    public List<String> getMembers() {
        return demoDAO.getMembers();
    }
}
