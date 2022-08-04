package org.luffy.controllers;

import javax.ws.rs.core.Response;
import org.luffy.dto.EventDTO;
import org.luffy.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventsController {

  private final EventService eventService;

  @Autowired
  public EventsController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping
  public Response getEvents() {
    return eventService.getEvents();
  }

  @GetMapping("/{id}")
  public Response getEvent(@PathVariable("id") Long id) {
    return eventService.getEvent(id);
  }

  @PostMapping
  public Response createEvent(EventDTO eventDTO) {
    return eventService.createEvent(eventDTO.toEvent());
  }

  @PutMapping("/{id}")
  public Response updateEvent(Long id, EventDTO eventDTO) {
    return eventService.updateEvent(id, eventDTO.toEvent());
  }

  @DeleteMapping("/{id}")
  public Response deleteEvent(Long id) {
    return eventService.deleteEvent(id);
  }
}
