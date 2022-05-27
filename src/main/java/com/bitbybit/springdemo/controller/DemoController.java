package com.bitbybit.springdemo.controller;

import com.bitbybit.springdemo.model.Team;
import com.bitbybit.springdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/")
public class DemoController {

    private final DemoService demoService;

    public DemoController(@Autowired DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> home() {
        HashMap<String, String> result = new HashMap<>();
        result.put("Status", "Running");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/team")
    ResponseEntity<Team> getTeam(){
        Team team = demoService.getTeam();
        return ResponseEntity.ok(team);
    }

    @GetMapping("/members")
    public ResponseEntity<List<String>> getMembers(){
        List<String> members = demoService.getMembers();
        return ResponseEntity.ok(members);
    }

    @PostMapping("/create-team")
    public ResponseEntity<URI> createTeam(@RequestBody TeamForm teamForm) {
        Team team = demoService.createTeam(teamForm.teamName, teamForm.leaderName);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/createTeam")
                .buildAndExpand(team.getTeamName()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/detail")
    public ResponseEntity<HashMap<String, String>> getApiDetail() {
        HashMap<String, String> result = new HashMap<>();
        result.put("Stack", "Java, Spring Boot");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addmember")
    public ResponseEntity<List<String>> addTeammate(@RequestBody MemberForm teamMember) {
        return ResponseEntity.ok(demoService.addTeammate(teamMember.newmember));
    }

    static class TeamForm {
        private String teamName;
        private String leaderName;

        public void setLeaderName(String leaderName) {
            this.leaderName = leaderName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }
    }

    static class MemberForm{
        private String newmember;

    }
}
