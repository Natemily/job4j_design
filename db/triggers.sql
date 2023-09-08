create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

	create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 5, 100);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 8, 120);

select * from products;

drop trigger tax_trigger on products;

create or replace function tax_before()
    returns trigger as
$$
    BEGIN
        new.price = new.price + new.price * 0.2;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_before_trigger
    before insert
    on products
    for each row
    execute procedure tax_before();

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 150);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 1, 200);

select * from products;

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function add_history()
    returns trigger as
$$
    BEGIN
        insert into "history_of_price" (name, price, date)
		values(new.name, new.price, current_date);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger add_history_a_table
    after insert
    on products
    for each row
    execute procedure add_history();

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 10, 350);

select * from products;
select * from history_of_price;

create or replace procedure update_data(u_count integer, u_id integer)
language 'plpgsql'
as $$
    BEGIN
        update products set count = count - u_count
		where id = u_id;
        delete from products
		where count <= 0 and id = u_id;
    END;
$$;

call update_data(3, 3);
select * from products;


create or replace function f_update_data(u_count integer, u_id integer)
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
	BEGIN
        update products set count = count - u_count
		where id = u_id;
        delete from products
		where count <= 0 and id = u_id;
		select into result id from products where id = u_id;
    return result;
	END;
$$;

select f_update_data(1, 4);
select * from products;
