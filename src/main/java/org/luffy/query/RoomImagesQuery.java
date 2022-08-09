package org.luffy.query;

import static org.luffy.jooq.tables.RoomImages.ROOM_IMAGES;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.jooq.DSLContext;
import org.luffy.models.Room;
import org.luffy.models.RoomImages;
import org.springframework.beans.factory.annotation.Autowired;

@ApplicationScoped
public class RoomImagesQuery {

  @Autowired
  DSLContext query;

  @Autowired
  RoomQuery roomQuery;

  // Get all images of room according to room_id
  public List<RoomImages> queryGetImagesOfRoom(Long id) {
    return query.selectFrom(ROOM_IMAGES)
        .where(ROOM_IMAGES.ROOM_ID.eq(id.intValue()))
        .fetch(roomItemImage -> {
          return new RoomImages(roomItemImage.getId().longValue(), roomItemImage.getUrl(),
              roomItemImage.getRoomId());
        });
  }

  // Create new record of room_images table
  public boolean queryAddImageOfRoom(RoomImages roomImages) {
    if (roomQuery.queryGetRoom((long) roomImages.getRoomId()) == null) {
      return false;
    }

    int result = query.insertInto(ROOM_IMAGES, ROOM_IMAGES.URL, ROOM_IMAGES.ROOM_ID)
        .values(roomImages.getUrl(), roomImages.getRoomId())
        .execute();

    return result == 1;
  }

  // delete an image of room by id of room_images table
  public boolean queryDeleteImageOfRoom(Long id) {
    int result = query.delete(ROOM_IMAGES).where(ROOM_IMAGES.ID.eq(id.intValue())).execute();

    return result == 1;
  }
}
