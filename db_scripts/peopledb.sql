CREATE DATABASE peopledb;

USE peopledb;

CREATE TABLE people(
  firstname VARCHAR(64),
  lastname VARCHAR(64),
  email VARCHAR(256),
  phone VARCHAR(32),
  PRIMARY KEY (lastname, firstname)
);