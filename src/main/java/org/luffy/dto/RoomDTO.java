package org.luffy.dto;

import org.luffy.models.Room;

public class RoomDTO {

  private Long id;
  private int floor;
  private int roomNumber;
  private String roomType;
  private float price;
  private String description;
  private String note;
  private int capacity;
  private boolean active;

  public RoomDTO(Long id, int floor, int roomNumber, String roomType, float price,
      String description,
      String note, int capacity, boolean active) {
    this.id = id;
    this.floor = floor;
    this.roomNumber = roomNumber;
    this.roomType = roomType;
    this.price = price;
    this.description = description;
    this.note = note;
    this.capacity = capacity;
    this.active = active;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getFloor() {
    return floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Room toRoom() {
    return new Room(floor, roomNumber, roomType, price, description, note, capacity, active);
  }
}
