package org.luffy.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.luffy.handleException.HandleNullValue;
import org.luffy.handleException.Message;
import org.luffy.models.BookedRoom;
import org.luffy.query.BookedRoomQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookedRoomService {

  @Autowired
  BookedRoomQuery bookedRoomQuery;

  // Create a new record of booked_rooms table
  public Response createRoomOfBooking(BookedRoom bookedRoom) {
    try {
      if (!bookedRoomQuery.queryCreateRoomOfBooking(bookedRoom)) {
        throw new HandleNullValue("this booking or this room do not exists!!");
      }

      return Response.ok(new Message("Create Successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  // Delete a record of booked_rooms table
  public Response deleteRoomOfBooking(Long id) {
    try {
      if (!bookedRoomQuery.queryDeleteRoomOfBooking(id)){
        throw new HandleNullValue("This id does not exists!!");
      }

      return Response.ok(new Message("Delete Successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }
}
