package org.luffy.dto;

import java.time.LocalDateTime;
import org.luffy.models.Event;
import org.luffy.models.User;

public class EventDTO {
  private Long id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String title;
  private String description;
  private String banner;
  private int staffId;

  public EventDTO(LocalDateTime startDate, LocalDateTime endDate, String title, String description,
      String banner, int staffId) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.title = title;
    this.description = description;
    this.banner = banner;
    this.staffId = staffId;
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

  public int getStaffId() {
    return staffId;
  }

  public void setStaffId(int staffId) {
    this.staffId = staffId;
  }

  public Event toEvent() {
    return new Event(startDate, endDate, title, description, banner, new User((long) staffId));
  }
}
