package org.luffy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookedRoom {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int bookingId;
  private int roomId;

  public BookedRoom(Long id, int bookingId, int roomId) {
    this.id = id;
    this.bookingId = bookingId;
    this.roomId = roomId;
  }

  public BookedRoom(int bookingId, int roomId) {
    this.bookingId = bookingId;
    this.roomId = roomId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
    this.bookingId = bookingId;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }
}
