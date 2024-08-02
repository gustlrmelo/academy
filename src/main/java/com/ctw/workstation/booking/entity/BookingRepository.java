package com.ctw.workstation.booking.entity;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class BookingRepository implements PanacheRepository<Booking> {

    public List<Booking> findAllBookings(){
        return listAll();
    }

    public Booking findById(UUID id){
        return getEntityManager().find(Booking.class, id);
    }

    public void newBooking(Booking booking){
        persist(booking);
    }

    public void removeBooking(UUID id){
        Booking bookingPersist = getEntityManager().find(Booking.class, id);
        getEntityManager().remove(bookingPersist);
    }

    public void updateBooking(UUID id, Booking booking){
        Booking b = findById(id);
        b.setRackId(booking.getRackId());
        b.setRequesterId(booking.getRequesterId());
        b.setBookTo(booking.getBookTo());
        b.setBookFrom(booking.getBookFrom());
    }
}
