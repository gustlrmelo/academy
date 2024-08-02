package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.service.RackService;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/racks")
public class RackResource {

    @Inject
    RackService rackService;

    @GET
    public Response allRacks() {
        List<Rack> racks = rackService.findAllRacks();
        return Response.ok(racks).build();
    }

    @GET
    @Path("/{id}")
    public Response rackById(@PathParam("id") UUID id) {
        Rack rack = rackService.findRackById(id);
        return rack != null ? Response.ok(rack).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response createRack(Rack rack) {
        rackService.addRack(rack);
        return Response.status(Response.Status.CREATED).entity(rack).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response removeRack(@PathParam("id") UUID id) {
        rackService.deleteRack(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateRack(@PathParam("id") UUID id, Rack rack) {
        rackService.updateRack(id, rack);
        return Response.ok(rack).build();
    }
}
