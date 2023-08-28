create table rocket(
	id serial primary key,
	food varchar(255),
	routine time,
	quantity int
)

insert into rocket(food, routine, quantity) values('мясо', '08:30:00', 100);

select * from rocket;

update rocket set routine = '08:00:00';

select * from rocket;

delete from rocket;

select * from rocket;