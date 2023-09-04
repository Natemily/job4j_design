create table departments(
    id serial primary key,
    name text
);

create table employees(
    id serial primary key,
    name varchar(255),
    dep_id int references departments(id)
);

insert into departments(name) values ('Бухгалтерия');
insert into departments(name) values ('Проектный отдел');
insert into departments(name) values ('IT-отдел');

insert into employees(name, dep_id) values ('Иван', 1);
insert into employees(name, dep_id) values ('Анастасия', 1);
insert into employees(name, dep_id) values ('Константин', 2);
insert into employees(name, dep_id) values ('Марина', 2);
insert into employees(name, dep_id) values ('Никита', 2);
insert into employees(name) values ('Анна');

select * from departments d
left join employees e
on d.id = e.dep_id
where e.dep_id is null;

select * from departments d
full join employees e
on d.id = e.dep_id
where d.id = 2;

select * from departments d
left join employees e
on d.id = e.dep_id
where d.id = 2;

select * from departments d
right join employees e
on d.id = e.dep_id
where d.id = 2;

create table teens(
    id serial primary key,
    name varchar(255),
	gender text
);

insert into teens(name, gender) values ('Вася', 'm');
insert into teens(name, gender) values ('Петя', 'm');
insert into teens(name, gender) values ('Маша', 'f');
insert into teens(name, gender) values ('Настя', 'f');
insert into teens(name, gender) values ('Аня', 'f');

select m.name as m, f.name as f, (m.name, f.name) as "Пары"
from teens m
cross join teens f
where m.gender != f.gender;