CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

INSERT INTO customers
VALUES (1, 'Ньют', 'Скамандер', 35, 'Англия'),
       (2, 'Панси', 'Паркинсон', 22, 'Ирландия'),
       (3, 'Гермиона', 'Грейнджер', 21, 'США'),
	   (4, 'Блейз', 'Замбини', 27, 'Куба'),
	   (5, 'Ровена', 'Рейвенкло', 42, 'Франция');

SELECT first_name as name, last_name as surname, age as minage
FROM customers
WHERE age = (SELECT MIN(age) FROM customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

INSERT INTO orders
VALUES (1, 5000, 3),
       (2, 3500, 2),
       (3, 200, 1);

SELECT first_name as name, last_name as surname, age as minage
FROM customers
WHERE orders.customer_id = null;

SELECT first_name as name, last_name as surname
FROM customers
WHERE id NOT IN (SELECT customer_id FROM orders);