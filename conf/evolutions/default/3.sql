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
    values(
        'Sarajevo',
        1
    );

insert into Cities(name, country)
    values(
        'Visoko',
        1
    );

insert into Cities(name, country)
    values(
        'Zenica',
        1
    );

insert into Cities(name, country)
    values(
        'Zagreb',
        2
    );

insert into Users (firstName, lastName, email, phone, city, isAdmin, password)
    values(
        'Irhad',
        'Halilovic',
        'irhadhalilovic@gmail.com',
        '062720716',
        1,
        true,
        "admin"
    );

insert into Users (firstName, lastName, email, phone, city, isAdmin, password)
    values(
        'Novi',
        'Korisnik',
        'novi@gmail.com',
        '123123123',
        2,
        false,
        "regular"
    );

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
    values(
        'Njam Njam',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis. Nulla mauris nisl, finibus et arcu vitae, commodo gravida ipsum. Nam sed felis vel est congue rhoncus. Phasellus malesuada suscipit urna a viverra. Mauris mattis tellus lacus, quis bibendum neque rhoncus varius. In ultrices dolor risus, at elementum dui vestibulum eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam metus augue, accumsan nec risus vel, varius mollis odio. Pellentesque in est euismod, scelerisque lectus ac, lobortis augue. Vivamus quis lorem vel orci tincidunt maximus. Praesent hendrerit finibus felis.',
        43.8563,
        18.4131,
        1,
        'assets/images/restaurant_logo.jpg',
        '"assets/images/restaurant_cover.jpg',
        2
    );

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    values(
        'Zeljo',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis. Nulla mauris nisl, finibus et arcu vitae, commodo gravida ipsum. Nam sed felis vel est congue rhoncus. Phasellus malesuada suscipit urna a viverra. Mauris mattis tellus lacus, quis bibendum neque rhoncus varius. In ultrices dolor risus, at elementum dui vestibulum eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam metus augue, accumsan nec risus vel, varius mollis odio. Pellentesque in est euismod, scelerisque lectus ac, lobortis augue. Vivamus quis lorem vel orci tincidunt maximus. Praesent hendrerit finibus felis.',
        43.8563,
        18.4131,
        2,
        'assets/images/restaurant_logo.jpg',
        '"assets/images/restaurant_cover.jpg',
        1
    );

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    values(
        'Mc Donalds',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis. Nulla mauris nisl, finibus et arcu vitae, commodo gravida ipsum. Nam sed felis vel est congue rhoncus. Phasellus malesuada suscipit urna a viverra. Mauris mattis tellus lacus, quis bibendum neque rhoncus varius. In ultrices dolor risus, at elementum dui vestibulum eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam metus augue, accumsan nec risus vel, varius mollis odio. Pellentesque in est euismod, scelerisque lectus ac, lobortis augue. Vivamus quis lorem vel orci tincidunt maximus. Praesent hendrerit finibus felis.',
        43.8563,
        18.4131,
        2,
        'assets/images/restaurant_logo.jpg',
        '"assets/images/restaurant_cover.jpg',
        3
    );

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    values(
        'Cordoba',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis. Nulla mauris nisl, finibus et arcu vitae, commodo gravida ipsum. Nam sed felis vel est congue rhoncus. Phasellus malesuada suscipit urna a viverra. Mauris mattis tellus lacus, quis bibendum neque rhoncus varius. In ultrices dolor risus, at elementum dui vestibulum eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam metus augue, accumsan nec risus vel, varius mollis odio. Pellentesque in est euismod, scelerisque lectus ac, lobortis augue. Vivamus quis lorem vel orci tincidunt maximus. Praesent hendrerit finibus felis.',
        43.8563,
        18.4131,
        3,
        'assets/images/restaurant_logo.jpg',
        '"assets/images/restaurant_cover.jpg',
        1
    );

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    values(
        'Mrkva',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis. Nulla mauris nisl, finibus et arcu vitae, commodo gravida ipsum. Nam sed felis vel est congue rhoncus. Phasellus malesuada suscipit urna a viverra. Mauris mattis tellus lacus, quis bibendum neque rhoncus varius. In ultrices dolor risus, at elementum dui vestibulum eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam metus augue, accumsan nec risus vel, varius mollis odio. Pellentesque in est euismod, scelerisque lectus ac, lobortis augue. Vivamus quis lorem vel orci tincidunt maximus. Praesent hendrerit finibus felis.',
        43.8563,
        18.4131,
        4,
        'assets/images/restaurant_logo.jpg',
        '"assets/images/restaurant_cover.jpg',
        4
    );

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    values(
        'Java',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis. Nulla mauris nisl, finibus et arcu vitae, commodo gravida ipsum. Nam sed felis vel est congue rhoncus. Phasellus malesuada suscipit urna a viverra. Mauris mattis tellus lacus, quis bibendum neque rhoncus varius. In ultrices dolor risus, at elementum dui vestibulum eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam metus augue, accumsan nec risus vel, varius mollis odio. Pellentesque in est euismod, scelerisque lectus ac, lobortis augue. Vivamus quis lorem vel orci tincidunt maximus. Praesent hendrerit finibus felis.',
        43.8563,
        18.4131,
        5,
        'assets/images/restaurant_logo.jpg',
        '"assets/images/restaurant_cover.jpg',
        3
    );

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    values(
        'Kimono',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis. Nulla mauris nisl, finibus et arcu vitae, commodo gravida ipsum. Nam sed felis vel est congue rhoncus. Phasellus malesuada suscipit urna a viverra. Mauris mattis tellus lacus, quis bibendum neque rhoncus varius. In ultrices dolor risus, at elementum dui vestibulum eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam metus augue, accumsan nec risus vel, varius mollis odio. Pellentesque in est euismod, scelerisque lectus ac, lobortis augue. Vivamus quis lorem vel orci tincidunt maximus. Praesent hendrerit finibus felis.',
        43.8563,
        18.4131,
        2,
        'assets/images/restaurant_logo.jpg',
        '"assets/images/restaurant_cover.jpg',
        2
    );

insert into Restaurants(name, description, latitude, longitude, priceRange, imageFileName, coverFileName, location)
    values(
        'Mrvica',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare ut diam et mattis. Nulla mauris nisl, finibus et arcu vitae, commodo gravida ipsum. Nam sed felis vel est congue rhoncus. Phasellus malesuada suscipit urna a viverra. Mauris mattis tellus lacus, quis bibendum neque rhoncus varius. In ultrices dolor risus, at elementum dui vestibulum eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam metus augue, accumsan nec risus vel, varius mollis odio. Pellentesque in est euismod, scelerisque lectus ac, lobortis augue. Vivamus quis lorem vel orci tincidunt maximus. Praesent hendrerit finibus felis.',
        43.8563,
        18.4131,
        1,
        'assets/images/restaurant_logo.jpg',
        '"assets/images/restaurant_cover.jpg',
        1
    );

# --- !Downs