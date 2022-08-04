package org.luffy.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String title;
  private String description;
  private String banner;
  private User staff;

  public Event(Long id, LocalDateTime startDate, LocalDateTime endDate, String title,
      String description, String banner, User staff) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.title = title;
    this.description = description;
    this.banner = banner;
    this.staff = staff;
  }

  public Event(LocalDateTime startDate, LocalDateTime endDate, String title,
      String description, String banner, User staff) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.title = title;
    this.description = description;
    this.banner = banner;
    this.staff = staff;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getBanner() {
    return banner;
  }

  public void setBanner(String banner) {
    this.banner = banner;
  }

  public User getStaff() {
    return staff;
  }

  public void setStaff(User staff) {
    this.staff = staff;
  }
}
