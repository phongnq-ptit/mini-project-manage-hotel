package org.luffy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImageUpload {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String originalName;
  private String KeyName;
  private String mimetype;
  private Long fileSize;

  public ImageUpload() {
  }

  public ImageUpload(Long id, String originalName, String keyName, String mimetype, Long fileSize) {
    this.id = id;
    this.originalName = originalName;
    KeyName = keyName;
    this.mimetype = mimetype;
    this.fileSize = fileSize;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOriginalName() {
    return originalName;
  }

  public void setOriginalName(String originalName) {
    this.originalName = originalName;
  }

  public String getKeyName() {
    return KeyName;
  }

  public void setKeyName(String keyName) {
    KeyName = keyName;
  }

  public String getMimetype() {
    return mimetype;
  }

  public void setMimetype(String mimetype) {
    this.mimetype = mimetype;
  }

  public Long getFileSize() {
    return fileSize;
  }

  public void setFileSize(Long fileSize) {
    this.fileSize = fileSize;
  }
}
