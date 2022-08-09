package org.luffy.dto;

import org.luffy.models.BookedRoom;

public class BookedRoomDTO {
  private Long id;
  private int bookingId;
  private int roomId;

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

  public BookedRoom toBookedRoom() {
    return new BookedRoom(bookingId, roomId);
  }
}
