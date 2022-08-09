package org.luffy.services;

import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.luffy.handleException.HandleNullValue;
import org.luffy.handleException.Message;
import org.luffy.models.Room;
import org.luffy.query.RoomQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

  @Autowired
  RoomQuery roomQuery;

  // Get list rooms type JSON
  public Response getRooms() {
    try {
      List<Room> rooms = roomQuery.queryGetRooms();

      return Response.ok(rooms).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  // Get room's information by id type JSON
  public Response getRoom(Long id) {
    try {
      Room room = roomQuery.queryGetRoom(id);

      if (room == null) {
        throw new HandleNullValue("This room does not exists!!");
      }

      return Response.ok(room).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  // Create a new room
  public Response createRoom(Room room) {
    try {
      if (!roomQuery.queryCreateRoom(room)) {
        throw new HandleNullValue("Room number already exists or adding new room failed!!");
      }

      return Response
          .ok(new Message("Create a new room successful!!"))
          .build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  // Update room's information by id type JSON
  public Response updateRoom(Room room, Long id) {
    try {
      if (!roomQuery.queryUpdateRoom(room, id)) {
        throw new HandleNullValue("This room does not exists!!");
      }

      return Response.ok(new Message("Update Successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  // Delete room by id
  public Response deleteRoom(Long id) {
    try {
      if (!roomQuery.queryDeleteRoom(id)){
        throw new HandleNullValue("This room does not exists!!");
      }

      return Response.ok(new Message("Delete Successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

}
