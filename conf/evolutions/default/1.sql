# --- !Ups

CREATE TABLE Countries (
    id serial not null primary key,
    name varchar(50) not null unique
);

CREATE TABLE Cities (
    id serial not null primary key,
    name varchar(50) not null ,
    country int not null ,
    foreign key(country) references Countries(id) on delete cascade
);

CREATE TABLE Users (
    id serial not null primary key,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    email varchar(255) not null unique,
    phone varchar(50) not null,
    city int not null,
    isAdmin boolean not null,
    password text not null,
    foreign key(city) references Cities(id) on delete restrict
);

# --- !Downs

DROP TABLE Users;
DROP TABLE Cities;
DROP TABLE Countries;