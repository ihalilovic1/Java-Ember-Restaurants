# --- !Ups

CREATE TABLE RestaurantTables (
    id UUID primary key default gen_random_uuid(),
    restaurantId UUID not null,
    persons int not null,
    foreign key(restaurantId) references Restaurants(id) on delete restrict
);

CREATE TABLE Reservations (
    id UUID primary key default gen_random_uuid(),
    idTable UUID not null,
    idUser UUID not null,
    reservationTime TIMESTAMP not null,
    timeAdded TIMESTAMP not null,
    isConfirmed boolean not null,
    foreign key(idTable) references RestaurantTables(id) on delete restrict,
    foreign key(idUser) references Users(id) on delete restrict
);

# --- !Downs

DROP TABLE Tables;
DROP TABLE Reservations;