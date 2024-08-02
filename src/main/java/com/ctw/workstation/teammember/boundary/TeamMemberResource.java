package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

import org.jboss.logging.Logger;

@Path(("/teammembers"))
public class TeamMemberResource {

    @Inject
    TeamMemberService teamMemberService;

    Logger logger = Logger.getLogger(TeamMemberResource.class);

    @GET
    public Response findAllTeamMembers(){
        List<TeamMember> teamMembers = teamMemberService.findAllTeamMembers();
        logger.info("Fetching all team members");
        return Response.ok(teamMembers).build();
    }

    @GET
    @Path("/team/{id}")
    public Response findMembersFromTeam(@PathParam("id")UUID id){
        List<TeamMember> teamMembers = teamMemberService.findMembersFromTeam(id);
        return Response.ok(teamMembers).build();
    }

    @POST
    @Transactional
    public Response addTeamMember(TeamMember teamMember){
        teamMemberService.createTeamMember(teamMember);
        logger.info("Creating team member: " + teamMember);
        return Response.status(Response.Status.CREATED).entity(teamMember).build();
    }

}
