# --- !Ups

CREATE TABLE Countries (
    id UUID primary key default gen_random_uuid(),
    name varchar(50) not null unique
);

CREATE TABLE Cities (
    id UUID primary key default gen_random_uuid(),
    name varchar(50) not null ,
    country UUID not null ,
    foreign key(country) references Countries(id) on delete cascade
);

CREATE TABLE Users (
    id UUID primary key default gen_random_uuid(),
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    email varchar(255) not null unique,
    phone varchar(50) not null,
    city UUID not null,
    isAdmin boolean not null,
    password text not null,
    foreign key(city) references Cities(id) on delete restrict
);

# --- !Downs

DROP TABLE Users;
DROP TABLE Cities;
DROP TABLE Countries;