# --- !Ups

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

# --- !Downs

TRUNCATE restaurant_foodtype RESTART IDENTITY;

