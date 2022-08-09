/*
 * This file is generated by jOOQ.
 */
package org.luffy.jooq;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import org.luffy.jooq.tables.BookedRooms;
import org.luffy.jooq.tables.Bookings;
import org.luffy.jooq.tables.Events;
import org.luffy.jooq.tables.FlywaySchemaHistory;
import org.luffy.jooq.tables.ImageUpload;
import org.luffy.jooq.tables.RoomImages;
import org.luffy.jooq.tables.Rooms;
import org.luffy.jooq.tables.Users;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ManageHotelV2 extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>manage_hotel_v2</code>
     */
    public static final ManageHotelV2 MANAGE_HOTEL_V2 = new ManageHotelV2();

    /**
     * The table <code>manage_hotel_v2.booked_rooms</code>.
     */
    public final BookedRooms BOOKED_ROOMS = BookedRooms.BOOKED_ROOMS;

    /**
     * The table <code>manage_hotel_v2.bookings</code>.
     */
    public final Bookings BOOKINGS = Bookings.BOOKINGS;

    /**
     * The table <code>manage_hotel_v2.events</code>.
     */
    public final Events EVENTS = Events.EVENTS;

    /**
     * The table <code>manage_hotel_v2.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>manage_hotel_v2.image_upload</code>.
     */
    public final ImageUpload IMAGE_UPLOAD = ImageUpload.IMAGE_UPLOAD;

    /**
     * The table <code>manage_hotel_v2.room_images</code>.
     */
    public final RoomImages ROOM_IMAGES = RoomImages.ROOM_IMAGES;

    /**
     * The table <code>manage_hotel_v2.rooms</code>.
     */
    public final Rooms ROOMS = Rooms.ROOMS;

    /**
     * The table <code>manage_hotel_v2.users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * No further instances allowed
     */
    private ManageHotelV2() {
        super("manage_hotel_v2", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            BookedRooms.BOOKED_ROOMS,
            Bookings.BOOKINGS,
            Events.EVENTS,
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            ImageUpload.IMAGE_UPLOAD,
            RoomImages.ROOM_IMAGES,
            Rooms.ROOMS,
            Users.USERS
        );
    }
}
