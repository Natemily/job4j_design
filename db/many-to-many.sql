 create table person(
     id serial primary key,
     name varchar(255)
 );

 create table concert(
     id serial primary key,
     name varchar(255)
 );

 create table person_concert(
     id serial primary key,
     person_id int references person(id),
     concert_id int references concert(id)
 );

insert into person(name) values ('Natalia');
insert into person(name) values ('Alexey');
insert into person(name) values ('Sergey');

insert into concert(name) values ('Evanescence');
insert into concert(name) values ('Imagine Dragons');
insert into concert(name) values ('The Score');

insert into person_concert(person_id, concert_id) values (1, 1);
insert into person_concert(person_id, concert_id) values (1, 2);
insert into person_concert(person_id, concert_id) values (1, 3);
insert into person_concert(person_id, concert_id) values (2, 1);
insert into person_concert(person_id, concert_id) values (2, 2);
insert into person_concert(person_id, concert_id) values (3, 3);

select * from person_concert;