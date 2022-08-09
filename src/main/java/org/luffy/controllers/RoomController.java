package org.luffy.controllers;

import javax.ws.rs.core.Response;
import org.luffy.dto.RoomDTO;
import org.luffy.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

  private final RoomService roomService;

  @Autowired
  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping
  public Response getRooms() {
    return roomService.getRooms();
  }

  @GetMapping("/{id}")
  public Response getRoom(@PathVariable("id") Long id) {
    return roomService.getRoom(id);
  }

  @PostMapping
  public Response createRoom(@RequestBody RoomDTO roomDTO) {
    return roomService.createRoom(roomDTO.toRoom());
  }

  @PutMapping("/{id}")
  public Response updateRoom(@RequestBody RoomDTO roomDTO, @PathVariable("id") Long id) {
    return roomService.updateRoom(roomDTO.toRoom(), id);
  }

  @DeleteMapping("/{id}")
  public Response deleteRoom(@PathVariable("id") Long id) {
    return roomService.deleteRoom(id);
  }
}
