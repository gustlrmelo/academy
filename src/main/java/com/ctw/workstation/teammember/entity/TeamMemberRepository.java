package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@RequestScoped
public class TeamMemberRepository implements PanacheRepository<TeamMember> {

    @Inject
    TeamRepository teamRepository;

    public List<TeamMember> findAllTeamMembers() {
        return findAll().stream().toList();
    }

    public TeamMember findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void addTeamMember(TeamMember teamMember) {
            persist(teamMember);
    }

    public void deleteTeamMember(TeamMember teamMember) {
        delete(teamMember);
    }

    public List<TeamMember> findMembersByTeamId(UUID id){
        return list("teamId", id);
    }

    public void updateTeamMember(UUID id, TeamMember teamMember) {
            TeamMember tm = findById(id);
                tm.setTeamId(teamMember.getTeamId());
                tm.setCtwId(teamMember.getCtwId());
                tm.setName(teamMember.getName());
    }
}
