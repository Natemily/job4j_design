create table pets(
    id serial primary key,
    pet text
);

create table persons(
    id serial primary key,
    name varchar(255),
    pet_id int references pets(id)
);

insert into pets(pet) values ('dog');
insert into pets(pet) values ('cat');
insert into pets(pet) values ('parrot');

insert into persons(name, pet_id) values('Natalia', 1);
insert into persons(name, pet_id) values('Natalia', 2);
insert into persons(name, pet_id) values('Maria', 1);
insert into persons(name, pet_id) values ('Kristina', 3);
insert into persons(name) values ('Kseniya');

select * from persons
join pets on persons.pet_id = pets.id;

select ps.name, p.pet
from persons as ps join pets as p on ps.pet_id = p.id;

select ps.name as Имя, p.pet as Животное
from persons as ps join pets as p on ps.pet_id = p.id;

select ps.name as "Имя владельца", p.pet Животное
from persons ps join pets p on ps.pet_id = p.id;