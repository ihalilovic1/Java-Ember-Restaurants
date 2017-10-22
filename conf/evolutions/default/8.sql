# --- !Ups


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

TRUNCATE restauranttables RESTART IDENTITY;