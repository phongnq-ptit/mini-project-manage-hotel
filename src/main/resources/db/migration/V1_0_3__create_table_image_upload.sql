CREATE TABLE image_upload (
  id INT NOT NULL AUTO_INCREMENT,
  key_name VARCHAR(255) NULL,
  file_size INT NULL,
  mimetype VARCHAR(255) NULL,
  original_name VARCHAR(255) NULL,
  PRIMARY KEY (id));