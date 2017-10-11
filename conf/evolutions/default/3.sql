# --- !Ups

insert into Countries(name)
    values(
        'Bosnia and Herzegovina'
    );

insert into Countries(name)
    values(
        'Croatia'
    );

insert into Cities(name, country)
    select 'Sarajevo', C.id
    from countries C
    where name='Bosnia and Herzegovina';

insert into Cities(name, country)
    select 'Visoko', C.id
    from countries C
    where name='Bosnia and Herzegovina';

insert into Cities(name, country)
    select 'Zenica', C.id
    from countries C
    where name='Bosnia and Herzegovina';

insert into Cities(name, country)
    select 'Zagreb', C.id
    from countries C
    where C.name='Croatia';

insert into Users (firstName, lastName, email, phone, city, isAdmin, password)
    select 'Irhad', 'Halilovic', 'irhadhalilovic@gmail.com', '062720716', C.id, true, 'admin'
    from cities C
    where C.name='Sarajevo';

insert into Users (firstName, lastName, email, phone, city, isAdmin, password)
    select 'Novi', 'Korisnik', 'novi@gmail.com', '123123123', C.id, false, 'regular'
    from cities C
    where C.name='Visoko';

insert into FoodTypes (name)
    values(
        'American'
    );

insert into FoodTypes (name)
    values(
        'Bosnian'
    );

insert into FoodTypes (name)
    values(
        'Vegetarian'
    );

insert into FoodTypes (name)
    values(
        'Japanese'
    );

insert into FoodTypes (name)
    values(
        'Mexican'
    );

insert into FoodTypes (name)
    values(
        'Indian'
    );

insert into FoodTypes (name)
    values(
        'Italian'
    );

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    select 'Njam Njam', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis.',
        43.8563, 18.4131, 1, 'assets/images/restaurant_logo.jpg', 'assets/images/restaurant_cover.jpg', C.id
        from cities C
        where C.name='Visoko';

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    select 'Zeljo', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis.',
        43.8563, 18.4131, 2, 'assets/images/restaurant_logo.jpg', '"assets/images/restaurant_cover.jpg', C.id
        from cities C
        where C.name='Sarajevo';

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    select 'Mc Donalds', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis.',
        43.8563, 18.4131, 2, 'assets/images/restaurant_logo.jpg', '"assets/images/restaurant_cover.jpg', C.id
        from cities C
        where C.name='Zagreb';

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    select 'Cordoba', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis.',
        43.8563, 18.4131, 3, 'assets/images/restaurant_logo.jpg', '"assets/images/restaurant_cover.jpg', C.id
        from cities C
        where C.name='Zenica';

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    select 'Mrkva', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis.',
        43.8563, 18.4131, 4, 'assets/images/restaurant_logo.jpg', '"assets/images/restaurant_cover.jpg', C.id
        from cities C
        where C.name='Sarajevo';

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    select 'Java', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis.',
        43.8563, 18.4131, 5, 'assets/images/restaurant_logo.jpg', '"assets/images/restaurant_cover.jpg', C.id
        from cities C
        where C.name='Visoko';

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    select 'Kimono', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis.',
        43.8563, 18.4131, 2, 'assets/images/restaurant_logo.jpg', '"assets/images/restaurant_cover.jpg', C.id
        from cities C
        where C.name='Zagreb';

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    select 'Mrvica', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis.',
        43.8563, 18.4131, 1, 'assets/images/restaurant_logo.jpg', '"assets/images/restaurant_cover.jpg', C.id
        from cities C
        where C.name='Sarajevo';

# --- !Downs

TRUNCATE restaurants, foodtypes, users, cities, countries RESTART IDENTITY;