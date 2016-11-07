DROP TABLE customer IF EXISTS;

CREATE TABLE customer (
  id        BIGINT IDENTITY PRIMARY KEY,
  firstname VARCHAR(30),
  lastname  VARCHAR(30),
  email     VARCHAR(30),
  UNIQUE (email)
);

CREATE TABLE users (
  ID BIGINT IDENTITY PRIMARY KEY,
  EMAIL varchar(100),
  LOGIN varchar(100),
  FIO varchar(100),
  PASSWORD varchar(100)
);

CREATE TABLE menu (
  id        BIGINT IDENTITY PRIMARY KEY,
  menu_date DATE,
  restaurant_id BIGINT
);