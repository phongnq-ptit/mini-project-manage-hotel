package org.luffy.controllers;

import javax.ws.rs.core.Response;
import org.luffy.dto.RoomImagesDTO;
import org.luffy.services.RoomImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room_images")
public class RoomImagesController {

  private final RoomImagesService roomImagesService;

  @Autowired
  public RoomImagesController(RoomImagesService roomImagesService) {
    this.roomImagesService = roomImagesService;
  }

  @PostMapping
  public Response addNewImageOfRoom(@RequestBody RoomImagesDTO roomImagesDTO) {
    return roomImagesService.addNewImageOfRoom(roomImagesDTO.toRoomImages());
  }

  @DeleteMapping("/{id}")
  public Response deleteImageOfRoom(@PathVariable("id") Long id) {
    return roomImagesService.deleteImageOfRoom(id);
  }
}
