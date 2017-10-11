# --- !Ups

CREATE TABLE FoodTypes (
    id UUID primary key default gen_random_uuid(),
    name varchar(50) not null
);

CREATE TABLE Restaurants (
    id UUID primary key default gen_random_uuid(),
    name varchar(255) not null,
    description text not null,
    latitude float not null,
    longitude float not null,
    priceRange int not null,
    imageFileName varchar(255) not null,
    coverFileName varchar(255) not null,
    location UUID not null,
    foreign key(location) references Cities(id) on delete restrict
);

CREATE TABLE Restaurant_FoodType (
    id UUID primary key default gen_random_uuid(),
    restaurant UUID not null,
    foodType UUID not null,
    foreign key(restaurant) references Restaurants(id) on delete restrict,
    foreign key(foodType) references FoodTypes(id) on delete restrict
);

CREATE TABLE Restaurant_Menu (
    id UUID primary key default gen_random_uuid(),
    restaurant UUID not null,
    type varchar(50) not null,
    name varchar(50) not null,
    price int not null,
    description text not null,
    foreign key(restaurant) references Restaurants(id) on delete restrict
);

CREATE TABLE Reviews (
    id UUID primary key default gen_random_uuid(),
    mark int not null,
    userId UUID not null,
    restaurant UUID not null,
    comment text not null,
    foreign key(userId) references Users(id) on delete restrict,
    foreign key(restaurant) references Restaurants(id) on delete restrict
);

# --- !Downs

DROP TABLE FoodTypes;
DROP TABLE Restaurants;
DROP TABLE Restaurant_FoodType;
DROP TABLE Restaurant_Menu;
DROP TABLE Reviews;