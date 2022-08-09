package org.luffy.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.luffy.handleException.HandleNullValue;
import org.luffy.handleException.Message;
import org.luffy.models.RoomImages;
import org.luffy.query.RoomImagesQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomImagesService {

  @Autowired
  RoomImagesQuery roomImagesQuery;

  // Add a new record to room_images table
  public Response addNewImageOfRoom(RoomImages roomImages) {
    try {
      if (!roomImagesQuery.queryAddImageOfRoom(roomImages)) {
        throw new HandleNullValue("This roomId does not exists!!");
      }

      return Response.ok(new Message("Add a new image to room successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  // Delete an image of room
  public Response deleteImageOfRoom(Long id) {
    try {
      if (!roomImagesQuery.queryDeleteImageOfRoom(id)) {
        throw new HandleNullValue("This id does not exists!!");
      }

      return Response.ok(new Message("Successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }
}
