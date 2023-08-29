create table person(
    id serial primary key,
    name varchar(255)
);

create table DNA(
    id serial primary key,
    dna text,
    person_id int references person(id) unique
);

insert into person(name) values ('Boris');

insert into dna(dna, person_id) values ('369852147', 1);

select * from dna;

