package com.ctw.workstation.rack.service;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class RackService  {

    @Inject
    RackRepository rackRepository;

    public List<Rack> findAllRacks(){
        return rackRepository.listAll();
    }

    public Rack findRackById(UUID id){
        return rackRepository.findById(id);
    }

    public void addRack(Rack rack){
        rackRepository.addRack(rack);
    }

    public void deleteRack(UUID id){
        Rack rack = rackRepository.findById(id);
        rackRepository.deleteRack(rack);
    }

    public void updateRack(UUID id, Rack rack){
            Rack r = rackRepository.findById(id);
            rackRepository.updateRack(r.getId(), rack);
    }
}
