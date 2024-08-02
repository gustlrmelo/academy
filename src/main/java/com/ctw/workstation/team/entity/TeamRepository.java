package com.ctw.workstation.team.entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class TeamRepository implements PanacheRepository<Team> {

    public List<Team> findAllTeams(){
        return listAll();
    }

    public Team findById(UUID id){
        return getEntityManager().find(Team.class, id);
    }

    public void addTeam(Team team){
            persist(team);
    }

    public void deleteTeam(Team team){
        Team teamPersistent = getEntityManager().find(Team.class, team.getId());
        getEntityManager().remove(teamPersistent);
    }

    public void updateTeam(UUID id, Team team){
            Team t = findById(id);
            t.setName(team.getName());
            t.setProduct(team.getProduct());
            t.setDefaultLocation(team.getDefaultLocation());
    }
}
