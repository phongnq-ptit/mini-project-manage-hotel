package org.luffy.controllers;

import javax.ws.rs.core.Response;
import org.luffy.dto.BookingDTO;
import org.luffy.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

  private final BookingService bookingService;

  @Autowired
  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @GetMapping
  public Response getBookings() {
    return bookingService.getBookings();
  }

  @GetMapping("/{id}")
  public Response getBooking(@PathVariable("id") Long id) {
    return bookingService.getBooking(id);
  }

  @PostMapping
  public Response createBooking(BookingDTO bookingDTO) {
    return bookingService.createBooking(bookingDTO.toBooking());
  }

  @PatchMapping("/{id}")
  public Response updateBooking(BookingDTO bookingDTO, @PathVariable("id") Long id) {
    return bookingService.updateBooking(bookingDTO.toBooking(), id);
  }
}
