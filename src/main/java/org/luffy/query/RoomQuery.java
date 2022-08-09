package org.luffy.query;

import static org.luffy.jooq.tables.Rooms.ROOMS;
import static org.luffy.jooq.tables.RoomImages.ROOM_IMAGES;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.jooq.DSLContext;
import org.luffy.jooq.tables.records.RoomsRecord;
import org.luffy.models.Room;
import org.luffy.models.RoomImages;
import org.springframework.beans.factory.annotation.Autowired;

@ApplicationScoped
public class RoomQuery {

  @Autowired
  DSLContext query;
  @Autowired
  RoomImagesQuery roomImagesQuery;

  // Get list rooms
  public List<Room> queryGetRooms() {
    return query.selectFrom(ROOMS)
        .fetch(row -> {
          List<RoomImages> roomImages = roomImagesQuery.queryGetImagesOfRoom(
              row.getId().longValue());

          return new Room(row.getId().longValue(), row.getFloor(), row.getRoomNumber(),
              row.getRoomType(), row.getPrice().floatValue(), row.getDescription(),
              row.getNote(), row.getCapacity(), row.getActive() == 1, roomImages);
        });
  }

  // Get room's information by id
  public Room queryGetRoom(Long id) {
    RoomsRecord row = query.selectFrom(ROOMS).where(ROOMS.ID.eq(id.intValue())).fetchOne();

    if (row == null) {
      return null;
    }

    List<RoomImages> roomImages = roomImagesQuery.queryGetImagesOfRoom(
        row.getId().longValue());

    return new Room(row.getId().longValue(), row.getFloor(), row.getRoomNumber(),
        row.getRoomType(), row.getPrice().floatValue(), row.getDescription(),
        row.getNote(), row.getCapacity(), row.getActive() == 1, roomImages);
  }

  // Create a new room
  public boolean queryCreateRoom(Room room) {

    // Check room number exists
    RoomsRecord row = query.selectFrom(ROOMS)
        .where(ROOMS.ROOM_NUMBER.eq(room.getRoomNumber()))
        .fetchOne();

    if (row != null) {
      return false;
    }

    int result = query.insertInto(ROOMS, ROOMS.FLOOR, ROOMS.ROOM_NUMBER, ROOMS.ROOM_TYPE,
            ROOMS.CAPACITY, ROOMS.PRICE, ROOMS.DESCRIPTION, ROOMS.NOTE)
        .values(room.getFloor(), room.getRoomNumber(), room.getRoomType(), room.getCapacity(),
            (double) room.getPrice(), room.getDescription(), room.getNote())
        .execute();

    return result == 1;
  }

  // Update room's information by id
  public boolean queryUpdateRoom(Room room, Long id) {
    int result = query.update(ROOMS)
        .set(ROOMS.DESCRIPTION, room.getDescription())
        .set(ROOMS.ACTIVE, room.isActive() ? (byte) 1 : (byte) 0)
        .set(ROOMS.ROOM_NUMBER, room.getRoomNumber())
        .set(ROOMS.ROOM_TYPE, room.getRoomType())
        .set(ROOMS.CAPACITY, room.getCapacity())
        .set(ROOMS.FLOOR, room.getFloor())
        .set(ROOMS.NOTE, room.getNote())
        .set(ROOMS.PRICE, (double) room.getPrice())
        .where(ROOMS.ID.eq(id.intValue()))
        .execute();

    return result == 1;
  }

  // Delete a room
  public boolean queryDeleteRoom(Long id) {
    query.delete(ROOM_IMAGES).where(ROOM_IMAGES.ROOM_ID.eq(id.intValue())).execute();

    int result = query.delete(ROOMS).where(ROOMS.ID.eq(id.intValue())).execute();

    return result == 1;
  }
}
