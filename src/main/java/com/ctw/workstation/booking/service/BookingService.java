package com.ctw.workstation.booking.service;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingRepository;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackRepository;
import com.ctw.workstation.rack.entity.Status;
import com.ctw.workstation.team.entity.TeamRepository;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.service.TeamService;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class BookingService {

    @Inject
    BookingRepository bookingRepository;

    @Inject
    RackRepository rackRepository;

    @Inject
    TeamRepository teamRepository;

    @Inject
    TeamMemberRepository teamMemberRepository;

    public List<Booking> findAllBookings(){
        return bookingRepository.findAllBookings();
    }

    public Booking findBookingById(UUID id){
        return bookingRepository.findById(id);
    }

    public boolean createBooking(Booking booking){
        Rack pretendedRack = rackRepository.findById(booking.getRackId());
        TeamMember requester = teamMemberRepository.findById(booking.getRequesterId());
        if(pretendedRack.getStatus().equals(Status.AVAILABLE) && memberBelongsATeam(requester.getId())) {
            pretendedRack.setStatus(Status.BOOKED);
            bookingRepository.newBooking(booking);
            return true;
        }
        return false;
    }

    public boolean updateBooking(UUID id, Booking booking){
        if(bookingExists(id)){
            Booking updatedBooking = findBookingById(id);
            updatedBooking.setRackId(booking.getRackId());
            updatedBooking.setRequesterId(booking.getRequesterId());
            updatedBooking.setBookFrom(booking.getBookFrom());
            updatedBooking.setBookTo(booking.getBookTo());
            updatedBooking.setModifiedAt(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public boolean removeBooking(UUID id){
        if(bookingExists(id)){
            bookingRepository.removeBooking(id);
            return true;
        }
        return false;
    }

    public boolean bookingExists(UUID id){
        return bookingRepository.listAll().stream()
                .anyMatch(booking -> booking.getiD().equals(id));
    }

    public boolean memberBelongsATeam(UUID id){
        UUID teamId = teamMemberRepository.findById(id).getTeamId();
        return teamRepository.listAll().stream()
                .anyMatch(team -> team.getId().equals(teamId));
    }
}
