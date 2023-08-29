create table car(
    id serial primary key,
    model text
);

create table owner(
    id serial primary key,
    name varchar(255),
    position_id int references car(id)
);

insert into car(model) values ('Mazda 6');
insert into owner(name, position_id) VALUES ('Maria', 1);

select * from owner;

select * from car where id in (select position_id from owner);