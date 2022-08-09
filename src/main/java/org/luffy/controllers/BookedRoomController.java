package org.luffy.controllers;

import javax.ws.rs.core.Response;
import org.luffy.dto.BookedRoomDTO;
import org.luffy.services.BookedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booked_rooms")
public class BookedRoomController {

  private final BookedRoomService bookedRoomService;

  @Autowired
  public BookedRoomController(BookedRoomService bookedRoomService) {
    this.bookedRoomService = bookedRoomService;
  }

  @PostMapping
  public Response createRoomOfBooking(BookedRoomDTO bookedRoomDTO) {
    return bookedRoomService.createRoomOfBooking(bookedRoomDTO.toBookedRoom());
  }

  @DeleteMapping("/{id}")
  public Response deleteRoomOfBooking(@PathVariable("id") Long id) {
    return bookedRoomService.deleteRoomOfBooking(id);
  }
}
