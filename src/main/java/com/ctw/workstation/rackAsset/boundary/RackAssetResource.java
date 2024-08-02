package com.ctw.workstation.rackAsset.boundary;

import com.ctw.workstation.rackAsset.service.RackAssetService;
import com.ctw.workstation.rackAsset.entity.RackAsset;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/rackassets")
public class RackAssetResource {

    @Inject
    RackAssetService rackAssetService;

    @GET
    public Response allRackAssets() {
        List<RackAsset> rackAssets = rackAssetService.findAllRackAssets();
        return Response.ok(rackAssets).build();
    }

    @GET
    @Path("/{id}")
    public Response findRackAssetById(@PathParam("id") UUID id) {
        RackAsset rackAsset = rackAssetService.findRackAssetById(id);
        return rackAsset != null ? Response.ok(rackAsset).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response addNewRackAsset(RackAsset rackAsset) {
        rackAssetService.addNewRackAsset(rackAsset);
        return Response.status(Response.Status.CREATED).entity(rackAsset).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response removeRackAsset(@PathParam("id") UUID id) {
        rackAssetService.removeRackAsset(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateRackAsset(@PathParam("id") UUID id, RackAsset rackAsset) {
        rackAssetService.updateRackAsset(id, rackAsset);
        return Response.ok(rackAsset).build();
    }
}
