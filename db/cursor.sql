create table product
(
    id    serial primary key,
    name  varchar(50),
    count integer default 0,
    price integer
);

insert into product (name, count, price)
VALUES ('product_1', 1, 5);
insert into product (name, count, price)
VALUES ('product_2', 2, 10);
insert into product (name, count, price)
VALUES ('product_3', 3, 15);
insert into product (name, count, price)
VALUES ('product_4', 4, 20);
insert into product (name, count, price)
VALUES ('product_5', 5, 25);
insert into product (name, count, price)
VALUES ('product_6', 6, 30);
insert into product (name, count, price)
VALUES ('product_7', 7, 35);
insert into product (name, count, price)
VALUES ('product_8', 8, 40);
insert into product (name, count, price)
VALUES ('product_9', 9, 45);
insert into product (name, count, price)
VALUES ('product_10', 10, 50);
insert into product (name, count, price)
VALUES ('product_11', 11, 55);
insert into product (name, count, price)
VALUES ('product_12', 12, 60);
insert into product (name, count, price)
VALUES ('product_13', 13, 65);
insert into product (name, count, price)
VALUES ('product_14', 14, 70);
insert into product (name, count, price)
VALUES ('product_15', 15, 75);
insert into product (name, count, price)
VALUES ('product_16', 16, 80);
insert into product (name, count, price)
VALUES ('product_17', 17, 85);
insert into product (name, count, price)
VALUES ('product_18', 18, 90);
insert into product (name, count, price)
VALUES ('product_19', 19, 95);
insert into product (name, count, price)
VALUES ('product_20', 20, 100);

BEGIN;
DECLARE
cursor_product cursor for
select * from product;

FETCH LAST FROM cursor_product;

MOVE BACKWARD 6 FROM cursor_product;
FETCH NEXT FROM cursor_product;

MOVE BACKWARD 9 FROM cursor_product;
FETCH NEXT FROM cursor_product;

MOVE BACKWARD 6 FROM cursor_product;
FETCH NEXT FROM cursor_product;

FETCH PRIOR FROM cursor_product;
commit transaction;