# --- !Ups

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

# --- !Downs

TRUNCATE restaurant_menu RESTART IDENTITY;