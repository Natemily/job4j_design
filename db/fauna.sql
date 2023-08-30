create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('Red panda', 5475, '01.01.1821');
insert into fauna(name, avg_age, discovery_date) values ('Narwhal', 20075, '01.01.1758');
insert into fauna(name, avg_age, discovery_date) values ('Tarsius', 5110, '01.01.1780');
insert into fauna(name, discovery_date) values ('Skyfish', '01.01.1994');
insert into fauna(name, avg_age) values ('Aquila', 11000);

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';
