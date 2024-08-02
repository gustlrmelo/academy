package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.service.TeamService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.slf4j.MDC;

import java.util.List;
import java.util.UUID;


@Path("/teams")
public class TeamResource {


    Logger logger = Logger.getLogger(TeamResource.class);

    @Inject
    TeamService teamService;

    @GET
    public Response getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        logger.info("Fetching all teams");
        return Response.ok(teams).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeamById(@PathParam("id") UUID id) {
        Team team = teamService.getTeamById(id);
        logger.info("Requesting team with ID :" + id);
        UUID requestId = UUID.randomUUID();
        MDC.put("requestId", requestId.toString());
        return team != null ? Response.ok(team).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response createTeam(Team team) {
        teamService.createTeam(team);
        logger.info("Creating team: " + team);
        return Response.status(Response.Status.CREATED).entity(team).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response removeTeam(@PathParam("id") UUID id) {
        teamService.removeTeam(id);
        logger.info("Removing team with ID: " + id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateTeam(@PathParam("id") UUID id, Team team) {
        teamService.updateTeam(id, team);
        logger.info("Updating team with ID: " + id);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
