create table person (
    id serial primary key,
    name varchar(50)
);

create table director (
    id serial primary key,
    name varchar(50)
);

create table movie (
    id serial primary key,
    name varchar(200),
    director_id integer references director(id)
);

create table rental (
    id serial primary key,
    active boolean default true,
    movie_id integer references movie(id),
    person_id integer references person(id)
);

insert into person (name) values ('Иван Иванов');
insert into person (name) values ('Петр Петров');
insert into person (name) values ('Василий Васильев');

insert into director (name) values ('Кристофер Нолан');
insert into director (name) values ('Зак Снайдер');

insert into movie (name, director_id) values ('Начало', 1);
insert into movie (name, director_id) values ('Довод', 1);
insert into movie (name, director_id) values ('Темный рыцарь', 1);
insert into movie (name, director_id) values ('Мятежная Луна', 2);
insert into movie (name, director_id) values ('300 спартанцев', 2);

insert into rental (active, movie_id, person_id) values (true, 1, 1);
insert into rental (active, movie_id, person_id) values (false, 3, 1);
insert into rental (active, movie_id, person_id) values (true, 5, 2);
insert into rental (active, movie_id, person_id) values (false, 4, 1);
insert into rental (active, movie_id, person_id) values (true, 2, 2);
insert into rental (active, movie_id, person_id) values (true, 4, 1);

create view show_persons_and_movie_with_active_rental
 as select p.name as person, m.name as movie from person as p
    join rental r on p.id = r.person_id
    join movie m on r.movie_id = m.id
    where r.active = true;

select * from show_persons_and_movie_with_active_rental;

