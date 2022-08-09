package org.luffy.services;

import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.luffy.handleException.HandleNullValue;
import org.luffy.handleException.Message;
import org.luffy.models.Booking;
import org.luffy.query.BookingQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  @Autowired
  BookingQuery bookingQuery;

  // Get List all bookings type JSON
  public Response getBookings() {
    try {
      List<Booking> bookings = bookingQuery.queryGetBookings();

      return Response.ok(bookings).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  // Get booking by is type JSON
  public Response getBooking(Long id) {
    try {
      Booking booking = bookingQuery.queryGetBooking(id);

      if (booking == null) {
        throw new HandleNullValue("This booking does not exists!!");
      }

      return Response.ok(booking).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  // Create a new booking
  public Response createBooking(Booking booking) {
    try {
      if (!bookingQuery.queryCreateBooking(booking)) {
        throw new HandleNullValue(("This user does not exists!!"));
      }

      return Response.ok(new Message("Create Successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  // Update a booking by Id
  public Response updateBooking(Booking booking, Long id) {
    try {
      if (!bookingQuery.queryUpdateBooking(booking, id)) {
        throw new HandleNullValue("This booking does not exists!!");
      }

      return Response.ok(new Message("Update Successful!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

}
