package com.ctw.workstation.rackAsset.entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;
import java.util.UUID;

@RequestScoped
public class RackAssetRepository implements PanacheRepository<RackAsset> {

    public List<RackAsset> findAllRackAssets() {
        return findAll().stream().toList();
    }

    public RackAsset findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void addRackAsset(RackAsset rackAsset) {
        if (rackAsset != null) {
            persist(rackAsset);
        }
    }

    public void deleteRackAsset(RackAsset rackAsset) {
        delete(rackAsset);
    }

    public void updateRackAsset(UUID id, RackAsset rackAsset) {
        if (rackAsset != null) {
            RackAsset ra = findById(id);
            if (ra != null) {
                ra.setAssetTag(rackAsset.getAssetTag());
                ra.setRackId(rackAsset.getRackId());
            } else {
                throw new IllegalArgumentException("RackAsset not found with ID: " + id);
            }
        } else {
            throw new IllegalArgumentException("RackAsset cannot be null");
        }
    }
}
