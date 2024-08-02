package com.ctw.workstation.teammember.control;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.service.TeamService;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@RequestScoped
public class TeamMemberService {

    @Inject
    TeamMemberRepository teamMemberRepository;

    @Inject
    TeamService teamService;

    public List<TeamMember> findAllTeamMembers() {
        return teamMemberRepository.findAllTeamMembers();
    }

    public TeamMember findTeamMemberById(UUID id) {
        return teamMemberRepository.findById(id);
    }

    public List<TeamMember> findMembersFromTeam(UUID teamId){
        return teamMemberRepository.findMembersByTeamId(teamId);
    }

    public void createTeamMember(TeamMember teamMember) {
        if(teamExists(teamMember.getTeamId())){
            teamMemberRepository.addTeamMember(teamMember);
        }
    }

    public void removeTeamMember(UUID id) {
        TeamMember teamMember = teamMemberRepository.findById(id);
        if (teamMember != null) {
            teamMemberRepository.deleteTeamMember(teamMember);
        }
    }

    public void updateTeamMember(UUID id, TeamMember teamMember) {
        teamMemberRepository.updateTeamMember(id, teamMember);
    }

    public boolean teamExists(UUID id){
        return teamService.getAllTeams().stream()
                .anyMatch(team -> team.getId().equals(id));
    }
}
