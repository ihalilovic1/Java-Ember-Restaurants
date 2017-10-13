# --- !Ups

insert into reviews(mark, userid, restaurant, comment)
    select 4, u.id, r.id, 'Great food' 
    from restaurants r, users u 
    where u.firstName='Irhad' and r.name='Mrkva';

insert into reviews(mark, userid, restaurant, comment)
    select 2, u.id, r.id, 'Not so great food' 
    from restaurants r, users u 
    where u.firstName='Novi' and r.name='Mrkva';

# --- !Downs

TRUNCATE reviews RESTART IDENTITY;

