package com.ctw.workstation.team.service;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@RequestScoped
public class TeamService {

    @Inject
    TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAllTeams();
    }

    public Team getTeamById(UUID id) {
        return teamRepository.findById(id);
    }

    public void createTeam(Team team) {
        if (team.getId() != null && getTeamById(team.getId()) != null) {
            updateTeam(team.getId(), team);
        } else {
            teamRepository.addTeam(team);
        }
    }

    public void removeTeam(UUID id) {
        Team team = teamRepository.findById(id);
        if (team != null) {
            teamRepository.deleteTeam(team);
        }
    }

    public void updateTeam(UUID id, Team team) {
        teamRepository.updateTeam(id, team);
    }
}
