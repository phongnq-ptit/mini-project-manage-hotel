package org.luffy.query;

import static org.luffy.jooq.tables.Bookings.BOOKINGS;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.jooq.DSLContext;
import org.luffy.jooq.tables.records.BookingsRecord;
import org.luffy.models.Booking;
import org.luffy.models.Room;
import org.luffy.models.User;
import org.springframework.beans.factory.annotation.Autowired;

@ApplicationScoped
public class BookingQuery {

  @Autowired
  DSLContext query;

  @Autowired
  BookedRoomQuery bookedRoomQuery;

  @Autowired
  UserQuery userQuery;

  // Get List All booking
  public List<Booking> queryGetBookings() {
    return query.selectFrom(BOOKINGS)
        .fetch(row -> {
          List<Room> bookedRoom = bookedRoomQuery.queryGetListRoomOfBooking(
              row.getId().longValue());
          User client = userQuery.queryGetUser(row.getClientId().longValue());

          return new Booking(row.getId().longValue(), row.getStartDate(), row.getEndDate(),
              row.getNote(), row.getStatus(),
              row.getStar(), row.getComment(), client, bookedRoom);
        });
  }

  // Get booking's information by id
  public Booking queryGetBooking(Long id) {
    BookingsRecord row = query.selectFrom(BOOKINGS)
        .where(BOOKINGS.ID.eq(id.intValue()))
        .fetchOne();

    if (row == null) {
      return null;
    }

    List<Room> rooms = bookedRoomQuery.queryGetListRoomOfBooking(row.getId().longValue());
    User client = userQuery.queryGetUser(row.getClientId().longValue());

    return new Booking(row.getId().longValue(), row.getStartDate(), row.getEndDate(),
        row.getNote(), row.getStatus(),
        row.getStar(), row.getComment(), client, rooms);
  }

  // Create a booking
  public boolean queryCreateBooking(Booking booking) {

    User client = userQuery.queryGetUser(booking.getClient().getId());

    System.out.println(client);

    if (client == null) return false;

    int result = query.insertInto(BOOKINGS, BOOKINGS.START_DATE, BOOKINGS.END_DATE, BOOKINGS.NOTE,
            BOOKINGS.CLIENT_ID)
        .values(booking.getStartDate(), booking.getEndDate(), booking.getNote(),
            client.getId().intValue())
        .execute();

    return result == 1;
  }

  // Update a booking's information by id
  public boolean queryUpdateBooking(Booking booking, Long id) {
    int result = query.update(BOOKINGS)
        .set(BOOKINGS.START_DATE, booking.getStartDate())
        .set(BOOKINGS.END_DATE, booking.getEndDate())
        .set(BOOKINGS.NOTE, booking.getNote())
        .set(BOOKINGS.STAR, booking.getStar())
        .set(BOOKINGS.COMMENT, booking.getcomment())
        .set(BOOKINGS.STATUS, booking.getStatus())
        .where(BOOKINGS.ID.eq(id.intValue()))
        .execute();

    return result == 1;
  }
}
