create table type(
    id serial primary key,
    name text
);

create table product(
    id serial primary key,
    name text,
    type_id int references type(id),
	expired_date date,
	price int
);

insert into type(name) values ('СЫР'), ('МОЛОКО'), ('ОВОЩИ'), ('ФРУКТЫ');

insert into product(name, type_id, expired_date, price) values
('Сыр плавленный', 1, '09.09.2023', 100),
('Сыр моцарелла', 1, '30.08.2023', 200),
('Капуста', 3, '30.10.2023', 70),
('Банан', 4, '30.09.2023', 90),
('Яблоко', 4, '15.10.2023', 50),
('Клубника', 4, '15.08.2023', 500),
('Малина', 4, '16.08.2023', 700),
('Ананас', 4, '27.08.2023', 200),
('Кокос', 4, '05.11.2023', 150),
('Сыр российский', 1, '05.09.2023', 170),
('Йогурт', 2, '30.10.2023', 70),
('Сметана', 2, '30.09.2023', 90),
('Масло сливочное', 2, '15.10.2023', 120),
('Творог', 2, '15.08.2023', 300),
('Ряженка', 2, '16.08.2023', 130),
('Сырок', 2, '27.08.2023', 30),
('Творог зерна', 2, '05.11.2023', 150),
('Сыр творожный', 1, '07.09.2023', 210),
('Кабачок', 3, '30.10.2023', 350),
('Брынза', 1, '30.09.2023', 250),
('Огурец', 3, '15.10.2023', 120),
('Помидор', 3, '15.08.2023', 300),
('Лук', 3, '16.08.2023', 30),
('Картофель', 3, '27.08.2023', 90),
('Чеснок', 3, '05.11.2023', 60);

select p.name, p.expired_date, p.price
from product p
join type t on p.type_id = t.id
where t.name like '%СЫР%';

select p.name, p.expired_date, p.price
from product p
where p.name like '%Лук%';

select p.name, p.expired_date
from product p
where p.expired_date < current_date;

select name, price
from product
where price = (select max(price) from product);

select t.name, count(p.name)
from type t
join product p
on t.id = p.type_id
group by t.name;

select p.name, p.expired_date, p.price, t.name
from product p
join type t on p.type_id = t.id
where t.name like '%СЫР%' or t.name like '%МОЛОКО%';

select t.name, count(p.name)
from type t
join product p
on t.id = p.type_id
group by t.name
having count(p.name) <= 6;

select p.name, t.name
from product p
join type t on p.type_id = t.id;