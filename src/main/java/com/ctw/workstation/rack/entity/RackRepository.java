package com.ctw.workstation.rack.entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class RackRepository implements PanacheRepository<Rack> {

    public List<Rack> findAllRacks() {
        return listAll();
    }

    public Rack findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void addRack(Rack rack) {
        persist(rack);
    }

    public void deleteRack(Rack rack) {
        delete(rack);
    }

    public void updateRack(UUID id, Rack rack) {
        if (rack != null) {
            Rack r = findById(id);
                r.setSerialNumber(rack.getSerialNumber());
                r.setStatus(rack.getStatus().toString());
                r.setTeamId(rack.getTeamId());
        }
    }
}
