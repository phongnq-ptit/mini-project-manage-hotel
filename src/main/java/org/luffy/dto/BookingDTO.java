package org.luffy.dto;

import java.time.LocalDateTime;
import org.luffy.models.Booking;
import org.luffy.models.User;

public class BookingDTO {

  private Long id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String note;
  private String status;
  private int star;
  private String comment;
  private int clientId;

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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getClientId() {
    return clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

  public Booking toBooking() {
    return new Booking(startDate, endDate, note, status, star, comment, new User((long) clientId));
  }
}
