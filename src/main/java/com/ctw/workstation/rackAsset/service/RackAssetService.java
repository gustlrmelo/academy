package com.ctw.workstation.rackAsset.service;

import com.ctw.workstation.rackAsset.entity.RackAsset;
import com.ctw.workstation.rackAsset.entity.RackAssetRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackAssetService {

    @Inject
    RackAssetRepository rackAssetRepository;

    public List<RackAsset> findAllRackAssets() {
        return rackAssetRepository.findAllRackAssets();
    }

    public RackAsset findRackAssetById(UUID id) {
        return rackAssetRepository.findById(id);
    }

    public void addNewRackAsset(RackAsset rackAsset) {
        if (rackAsset.getId() != null && findRackAssetById(rackAsset.getId()) != null) {
            updateRackAsset(rackAsset.getId(), rackAsset);
        } else {
            rackAssetRepository.addRackAsset(rackAsset);
        }
    }

    public void removeRackAsset(UUID id) {
        RackAsset rackAsset = rackAssetRepository.findById(id);
        if (rackAsset != null) {
            rackAssetRepository.deleteRackAsset(rackAsset);
        }
    }

    public void updateRackAsset(UUID id, RackAsset rackAsset) {
        rackAssetRepository.updateRackAsset(id, rackAsset);
    }
}
