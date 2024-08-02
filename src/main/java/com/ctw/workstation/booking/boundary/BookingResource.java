package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.service.BookingService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@Path("/bookings")
public class BookingResource {

    @Inject
    BookingService bookingService;

    Logger logger = Logger.getLogger(Booking.class);

    public BookingResource(BookingService bookingService){
        this.bookingService = bookingService;
    }


    @GET
    public Response findAllBookings(){
        List<Booking> bookings = bookingService.findAllBookings();
        logger.info("Fetching all bookings");
        return Response.ok(bookings).build();
    }

    @POST
    @Transactional
    public Response createBooking(Booking booking){
        logger.info("Creating booking :" + booking);
        bookingService.createBooking(booking);
        BookingResponse response = new BookingResponse(
                booking.getiD(),
                booking.getRack().getSerialNumber(),
                booking.getTeamMember().getName(),
                booking.getTeamMember().getTeam().getName(),
                booking.getRack().getStatus()
        );
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public Response findBookingById(@PathParam("id")UUID id){
        Booking booking = bookingService.findBookingById(id);
        logger.info("Requesting booking with ID: " + id);
        return booking != null ? Response.ok(booking).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteBooking(@PathParam("id") UUID id){
        bookingService.removeBooking(id);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateBooking(@PathParam("id") UUID id, Booking booking){
        bookingService.updateBooking(id, booking);
        return Response.status(Response.Status.OK).build();
    }
}
