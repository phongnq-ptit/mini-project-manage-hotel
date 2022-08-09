package org.luffy.query;

import static org.luffy.jooq.tables.BookedRooms.BOOKED_ROOMS;
import static org.luffy.jooq.tables.Rooms.ROOMS;
import static org.luffy.jooq.tables.Bookings.BOOKINGS;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.jooq.DSLContext;
import org.luffy.models.BookedRoom;
import org.luffy.models.Booking;
import org.luffy.models.Room;
import org.springframework.beans.factory.annotation.Autowired;

@ApplicationScoped
public class BookedRoomQuery {

  @Autowired
  DSLContext query;

  @Autowired
  BookingQuery bookingQuery;

  @Autowired
  RoomQuery roomQuery;

  // Get list rooms of booking by booking_id
  public List<Room> queryGetListRoomOfBooking(Long bookingId) {
    return query.select(ROOMS.ID, ROOMS.FLOOR, ROOMS.ROOM_NUMBER, ROOMS.ROOM_TYPE,
            ROOMS.PRICE, ROOMS.DESCRIPTION, ROOMS.CAPACITY, ROOMS.ACTIVE)
        .from(BOOKINGS, BOOKED_ROOMS, ROOMS)
        .where(BOOKED_ROOMS.BOOKING_ID.eq(BOOKINGS.ID))
        .and(ROOMS.ID.eq(BOOKED_ROOMS.ROOM_ID))
        .and(BOOKINGS.ID.eq(bookingId.intValue()))
        .fetch(row -> {
          return new Room((long) row.value1(), row.value2(), row.value3(), row.value4(),
              row.value5().floatValue(), row.value6(), row.value7(),
              row.value8() == 1);
        });
  }

  // Create a new record of booked_rooms table
  public boolean queryCreateRoomOfBooking(BookedRoom bookedRoom) {
    Booking booking = bookingQuery.queryGetBooking((long) bookedRoom.getBookingId());

    if (booking == null) {
      return false;
    }

    Room room = roomQuery.queryGetRoom((long) bookedRoom.getRoomId());

    if (room == null) {
      return false;
    }

    int result = query.insertInto(BOOKED_ROOMS, BOOKED_ROOMS.BOOKING_ID, BOOKED_ROOMS.ROOM_ID)
        .values(bookedRoom.getBookingId(), bookedRoom.getRoomId())
        .execute();

    return result == 1;
  }

  // Delete a record of booked_rooms table
  public boolean queryDeleteRoomOfBooking(Long id) {
    int result = query.delete(BOOKED_ROOMS).where(BOOKED_ROOMS.ID.eq(id.intValue())).execute();

    return result == 1;
  }
}
