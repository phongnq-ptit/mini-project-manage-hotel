/*
 * This file is generated by jOOQ.
 */
package org.luffy.jooq.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;
import org.luffy.jooq.tables.RoomImages;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoomImagesRecord extends UpdatableRecordImpl<RoomImagesRecord> implements Record3<Integer, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>manage_hotel_v2.room_images.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.room_images.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>manage_hotel_v2.room_images.url</code>.
     */
    public void setUrl(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.room_images.url</code>.
     */
    public String getUrl() {
        return (String) get(1);
    }

    /**
     * Setter for <code>manage_hotel_v2.room_images.room_id</code>.
     */
    public void setRoomId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.room_images.room_id</code>.
     */
    public Integer getRoomId() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RoomImages.ROOM_IMAGES.ID;
    }

    @Override
    public Field<String> field2() {
        return RoomImages.ROOM_IMAGES.URL;
    }

    @Override
    public Field<Integer> field3() {
        return RoomImages.ROOM_IMAGES.ROOM_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUrl();
    }

    @Override
    public Integer component3() {
        return getRoomId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUrl();
    }

    @Override
    public Integer value3() {
        return getRoomId();
    }

    @Override
    public RoomImagesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public RoomImagesRecord value2(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public RoomImagesRecord value3(Integer value) {
        setRoomId(value);
        return this;
    }

    @Override
    public RoomImagesRecord values(Integer value1, String value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RoomImagesRecord
     */
    public RoomImagesRecord() {
        super(RoomImages.ROOM_IMAGES);
    }

    /**
     * Create a detached, initialised RoomImagesRecord
     */
    public RoomImagesRecord(Integer id, String url, Integer roomId) {
        super(RoomImages.ROOM_IMAGES);

        setId(id);
        setUrl(url);
        setRoomId(roomId);
    }
}
