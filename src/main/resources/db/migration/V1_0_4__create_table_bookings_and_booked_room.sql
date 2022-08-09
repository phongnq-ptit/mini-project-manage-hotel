CREATE TABLE bookings (
  id INT NOT NULL AUTO_INCREMENT,
  start_date DATETIME NOT NULL,
  end_date DATETIME NOT NULL,
  note MEDIUMTEXT NULL,
  status VARCHAR(45) NULL DEFAULT 'request',
  comment MEDIUMTEXT NULL,
  star INT NULL,
  client_id INT NULL,
  PRIMARY KEY (id));

CREATE TABLE booked_rooms (
  id INT NOT NULL AUTO_INCREMENT,
  booking_id INT NULL,
  room_id INT NULL,
  PRIMARY KEY (id));