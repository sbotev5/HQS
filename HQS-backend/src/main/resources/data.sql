-- Used for test harness with coverage data and for re-initialisation when testing prod app
CREATE SCHEMA IF NOT EXISTS hqs;
USE hqs;
DROP TABLE IF EXISTS hqs.tickets;
CREATE TABLE hqs.tickets (
  id BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  author VARCHAR(45) NOT NULL,
  description VARCHAR(255) NOT NULL,
  urgency INT,
  solution VARCHAR(255),
  time_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id));
  
INSERT INTO hqs.tickets (id, title, author, description, urgency, solution) VALUES ('1', 't1', 'a1', 'd1', '1', 's1');
INSERT INTO hqs.tickets (id, title, author, description, urgency, solution) VALUES ('2', 't2', 'a2', 'd2', '2', 's2');