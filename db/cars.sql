create table car_bodies(
    id serial primary key,
    name text
);

create table car_engines(
    id serial primary key,
    name text
);

create table car_transmissions(
    id serial primary key,
    name text
);

create table cars(
    id serial primary key,
    name text,
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('Седан');
insert into car_bodies(name) values ('Хэчбек');
insert into car_bodies(name) values ('Универсал');
insert into car_bodies(name) values ('Пикап');

insert into car_transmissions(name) values ('МКПП');
insert into car_transmissions(name) values ('АКПП');
insert into car_transmissions(name) values ('РКПП');
insert into car_transmissions(name) values ('Вариатор');

insert into car_engines(name) values ('Бензин');
insert into car_engines(name) values ('Дизель');
insert into car_engines(name) values ('Газ');
insert into car_engines(name) values ('Гибрид');
insert into car_engines(name) values ('Вода');

insert into cars(name, body_id, engine_id, transmission_id) values ('Chery', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('Geely', 2, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('Honda', 1, 3, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota', 2, 4, 2);
insert into cars(name, engine_id, transmission_id) values ('Suzuki', 1, 1);
insert into cars(name, body_id, transmission_id) values ('Nissan', 3, 2);
insert into cars(name, body_id, engine_id) values ('Infiniti', 2, 3);

select c.name, cb.name, ce.name, ct.name
from cars c
full join car_bodies as cb
on c.body_id = cb.id
full join car_engines as ce
on c.engine_id = ce.id
full join car_transmissions as ct
on ct.id = c.transmission_id ;

select cb.name
from car_bodies as cb
left join cars c
on cb.id = c.body_id
where c.body_id is null;

select ct.name
from car_transmissions as ct
left join cars c
on ct.id = c.transmission_id
where c.transmission_id is null;

select ce.name
from car_engines as ce
left join cars c
on ce.id = c.engine_id
where c.engine_id is null;