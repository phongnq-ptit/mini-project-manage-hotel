package org.luffy.query;

import static org.luffy.jooq.tables.Events.EVENTS;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.jooq.DSLContext;
import org.luffy.jooq.tables.records.EventsRecord;
import org.luffy.models.Event;
import org.luffy.models.User;
import org.springframework.beans.factory.annotation.Autowired;

@ApplicationScoped
public class EventQuery {

  @Autowired
  DSLContext query;
  @Autowired
  UserQuery userQuery;

  // Execute a query that retrieves all events
  public List<Event> queryGetEvents() {
    return query.selectFrom(EVENTS).fetch(row -> {
      User staff = userQuery.queryGetUser(row.getStaffId().longValue());

      return new Event(row.getId().longValue(), row.getStartDate(), row.getEndDate(),
          row.getTitle(),
          row.getDescription(), row.getBanner(), staff);
    });
  }

  // Execute a query to get event information by id
  public Event queryGetEvent(Long id) {
    EventsRecord event = query.selectFrom(EVENTS)
        .where(EVENTS.ID.eq(id.intValue()))
        .fetchOne();

    if (event == null) {
      return null;
    }

    return new Event((long) event.getId(), event.getStartDate(), event.getEndDate(),
        event.getTitle(), event.getDescription(), event.getBanner(),
        userQuery.queryGetUser(event.getStaffId().longValue()));
  }

  // Execute the query command create a new event
  public boolean queryCreateEvent(Event event) {
    int result = query.insertInto(EVENTS, EVENTS.START_DATE, EVENTS.END_DATE, EVENTS.TITLE,
            EVENTS.DESCRIPTION, EVENTS.BANNER, EVENTS.STAFF_ID)
        .values(event.getStartDate(), event.getEndDate(), event.getTitle(), event.getDescription(),
            event.getBanner(), event.getStaff().getId().intValue())
        .execute();

    return result == 1;
  }

  // Execute an event edit query by id
  public boolean queryUpdateEvent(Long id, Event eventUpdate) {
    int result = query.update(EVENTS)
        .set(EVENTS.START_DATE, eventUpdate.getStartDate())
        .set(EVENTS.END_DATE, eventUpdate.getEndDate())
        .set(EVENTS.TITLE, eventUpdate.getTitle())
        .set(EVENTS.DESCRIPTION, eventUpdate.getDescription())
        .set(EVENTS.BANNER, eventUpdate.getBanner())
        .where(EVENTS.ID.eq(id.intValue()))
        .execute();

    return result == 1;
  }

  // Execute an event delete query by id
  public boolean queryDeleteEvent(Long id) {
    int result = query.delete(EVENTS)
        .where(EVENTS.ID.eq(id.intValue()))
        .execute();

    return result == 1;
  }
}
