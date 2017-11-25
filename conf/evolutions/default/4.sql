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

insert into restaurant_foodtype(restaurant, foodtype)
    select r.id, ft.id 
    from restaurants r, foodtypes ft 
    where r.name='Mrkva' and ft.name='Bosnian';

insert into restaurant_foodtype(restaurant, foodtype)
    select r.id, ft.id 
    from restaurants r, foodtypes ft 
    where r.name='Mrkva' and ft.name='Italian';

insert into restaurant_foodtype(restaurant, foodtype)
    select r.id, ft.id 
    from restaurants r, foodtypes ft 
    where r.name='Mrkva' and ft.name='American';

insert into reviews(mark, userid, restaurant, comment)
    select 4, u.id, r.id, 'Great food'
    from restaurants r, users u
    where u.firstName='Irhad' and r.name='Mrkva';

insert into reviews(mark, userid, restaurant, comment)
    select 2, u.id, r.id, 'Not so great food'
    from restaurants r, users u
    where u.firstName='Novi' and r.name='Mrkva';

insert into restaurant_menu(restaurant, "type", "name", price, "description")
    select r.id, 'Breakfast', 'Cevapi', 5, 'Great cevapi'
    from restaurants r
    where r.name='Mrkva';

insert into restaurant_menu(restaurant, "type", "name", price, "description")
    select r.id, 'Lunch', 'Pizza', 6, 'Great pizza'
    from restaurants r
    where r.name='Mrkva';

insert into restaurant_menu(restaurant, "type", "name", price, "description")
    select r.id, 'Dinner', 'Salad', 4, 'Great salad'
    from restaurants r
    where r.name='Mrkva';



insert into restauranttables(restaurantId, persons)
    select r.id, 2
    from restaurants r
    where r.name='Mrkva';

insert into restauranttables(restaurantId, persons)
    select r.id, 3
    from restaurants r
    where r.name='Mrkva';

insert into restauranttables(restaurantId, persons)
    select r.id, 4
    from restaurants r
    where r.name='Mrkva';

insert into restauranttables(restaurantId, persons)
    select r.id, 4
    from restaurants r
    where r.name='Mrkva';

insert into restauranttables(restaurantId, persons)
    select r.id, 2
    from restaurants r
    where r.name='Cordoba';

insert into restauranttables(restaurantId, persons)
    select r.id, 4
    from restaurants r
    where r.name='Cordoba';
# --- !Downs

TRUNCATE restaurant_foodtype RESTART IDENTITY;

TRUNCATE restaurants, foodtypes, users, cities, countries RESTART IDENTITY;

TRUNCATE reviews RESTART IDENTITY;

TRUNCATE restaurant_menu RESTART IDENTITY;

TRUNCATE restauranttables RESTART IDENTITY;