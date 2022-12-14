/*
 * This file is generated by jOOQ.
 */
package org.luffy.jooq.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;
import org.luffy.jooq.tables.Events;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EventsRecord extends UpdatableRecordImpl<EventsRecord> implements Record7<Integer, LocalDateTime, LocalDateTime, String, String, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>manage_hotel_v2.events.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.events.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>manage_hotel_v2.events.start_date</code>.
     */
    public void setStartDate(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.events.start_date</code>.
     */
    public LocalDateTime getStartDate() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>manage_hotel_v2.events.end_date</code>.
     */
    public void setEndDate(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.events.end_date</code>.
     */
    public LocalDateTime getEndDate() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>manage_hotel_v2.events.title</code>.
     */
    public void setTitle(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.events.title</code>.
     */
    public String getTitle() {
        return (String) get(3);
    }

    /**
     * Setter for <code>manage_hotel_v2.events.description</code>.
     */
    public void setDescription(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.events.description</code>.
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>manage_hotel_v2.events.banner</code>.
     */
    public void setBanner(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.events.banner</code>.
     */
    public String getBanner() {
        return (String) get(5);
    }

    /**
     * Setter for <code>manage_hotel_v2.events.staff_id</code>.
     */
    public void setStaffId(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>manage_hotel_v2.events.staff_id</code>.
     */
    public Integer getStaffId() {
        return (Integer) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, LocalDateTime, LocalDateTime, String, String, String, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, LocalDateTime, LocalDateTime, String, String, String, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Events.EVENTS.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Events.EVENTS.START_DATE;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Events.EVENTS.END_DATE;
    }

    @Override
    public Field<String> field4() {
        return Events.EVENTS.TITLE;
    }

    @Override
    public Field<String> field5() {
        return Events.EVENTS.DESCRIPTION;
    }

    @Override
    public Field<String> field6() {
        return Events.EVENTS.BANNER;
    }

    @Override
    public Field<Integer> field7() {
        return Events.EVENTS.STAFF_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public LocalDateTime component2() {
        return getStartDate();
    }

    @Override
    public LocalDateTime component3() {
        return getEndDate();
    }

    @Override
    public String component4() {
        return getTitle();
    }

    @Override
    public String component5() {
        return getDescription();
    }

    @Override
    public String component6() {
        return getBanner();
    }

    @Override
    public Integer component7() {
        return getStaffId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public LocalDateTime value2() {
        return getStartDate();
    }

    @Override
    public LocalDateTime value3() {
        return getEndDate();
    }

    @Override
    public String value4() {
        return getTitle();
    }

    @Override
    public String value5() {
        return getDescription();
    }

    @Override
    public String value6() {
        return getBanner();
    }

    @Override
    public Integer value7() {
        return getStaffId();
    }

    @Override
    public EventsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public EventsRecord value2(LocalDateTime value) {
        setStartDate(value);
        return this;
    }

    @Override
    public EventsRecord value3(LocalDateTime value) {
        setEndDate(value);
        return this;
    }

    @Override
    public EventsRecord value4(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public EventsRecord value5(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public EventsRecord value6(String value) {
        setBanner(value);
        return this;
    }

    @Override
    public EventsRecord value7(Integer value) {
        setStaffId(value);
        return this;
    }

    @Override
    public EventsRecord values(Integer value1, LocalDateTime value2, LocalDateTime value3, String value4, String value5, String value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EventsRecord
     */
    public EventsRecord() {
        super(Events.EVENTS);
    }

    /**
     * Create a detached, initialised EventsRecord
     */
    public EventsRecord(Integer id, LocalDateTime startDate, LocalDateTime endDate, String title, String description, String banner, Integer staffId) {
        super(Events.EVENTS);

        setId(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setTitle(title);
        setDescription(description);
        setBanner(banner);
        setStaffId(staffId);
    }
}
