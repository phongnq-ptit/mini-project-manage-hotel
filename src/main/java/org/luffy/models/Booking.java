package org.luffy.models;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String note;
  private String status;
  private int star;
  private String comment;
  private User client;
  private List<Room> bookedRoom;

  public Booking(Long id, LocalDateTime startDate, LocalDateTime endDate, String note,
      String status,
      int star, String comment, User client, List<Room> bookedRoom) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.note = note;
    this.status = status;
    this.star = star;
    this.comment = comment;
    this.client = client;
    this.bookedRoom = bookedRoom;
  }

  public Booking(LocalDateTime startDate, LocalDateTime endDate, String note, String status,
      int star, String comment, User client) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.note = note;
    this.status = status;
    this.star = star;
    this.comment = comment;
    this.client = client;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getStar() {
    return star;
  }

  public void setStar(int star) {
    this.star = star;
  }

  public String getcomment() {
    return comment;
  }

  public void setcomment(String comment) {
    comment = comment;
  }

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }

  public List<Room> getBookedRoom() {
    return bookedRoom;
  }

  public void setBookedRoom(List<Room> bookedRoom) {
    this.bookedRoom = bookedRoom;
  }
}
