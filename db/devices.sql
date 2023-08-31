create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Xiaomi', 200), ('Samsung', 800), ('Iphone', 1200), ('Galaxy Watch', 300), ('Mac', 500), ('AirPods', 200);
insert into people(name) values ('Наталия'), ('Ксения'), ('Ольга');
insert into devices_people(device_id, people_id) values (1, 1), (2, 3), (3, 2), (4, 3), (5, 2), (6, 2);

select avg(price) from devices;

select p.name, avg(d.price)
from devices_people as dp
join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp
join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 300;