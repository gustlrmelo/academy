package com.ctw.workstation.rackAsset.entity;

import com.ctw.workstation.rack.entity.Rack;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "t_rack_asset")
public class RackAsset {

    //id, asset_tag, rack_id)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "asset_tag", nullable = false)
    private String assetTag;

    @Column(name = "rack_id", nullable = false)
    private UUID rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    private Rack rack;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }
}
