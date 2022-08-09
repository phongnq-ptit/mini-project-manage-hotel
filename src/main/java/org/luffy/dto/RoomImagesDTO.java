package org.luffy.dto;

import org.luffy.models.RoomImages;

public class RoomImagesDTO {
  private Long id;
  private String url;
  private int roomId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public RoomImages toRoomImages() {
    RoomImages roomImages = new RoomImages();
    roomImages.setUrl(this.url);
    roomImages.setRoomId(this.roomId);

    return roomImages;
  }
}
