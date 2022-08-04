package org.luffy.services;

import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.luffy.handleException.HandleNullValue;
import org.luffy.handleException.Message;
import org.luffy.models.Event;
import org.luffy.query.EventQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  EventQuery eventQuery;

  /*
   * Get list Event type JSON
   * */
  public Response getEvents() {
    try {
      List<Event> events = eventQuery.queryGetEvents();

      return Response.ok(events).build();

    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  /*
   * Get an event type JSON
   * */
  public Response getEvent(Long id) {
    try {
      Event event = eventQuery.queryGetEvent(id);

      if (event == null) {
        throw new HandleNullValue("This event does not exist!!");
      }

      return Response.ok(event).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  /*
   * Create new event
   * */
  public Response createEvent(Event event) {
    try {
      if (!eventQuery.queryCreateEvent(event)) {
        throw new HandleNullValue("Event creation failed!!");
      }

      return Response.ok(new Message("Successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  /**
   * Update an event
   * */
  public Response updateEvent(Long id, Event eventUpdate) {
    try {
      if (!eventQuery.queryUpdateEvent(id, eventUpdate)){
        throw new HandleNullValue("This event does not exist!!");
      }

      return Response.ok(new Message("Successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  /**
   * Delete an event
   * */
  public Response deleteEvent(Long id) {
    try {
      if (!eventQuery.queryDeleteEvent(id)){
        throw new HandleNullValue("This event does not exist!!");
      }

      return Response.ok(new Message("Successful!!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }
}
