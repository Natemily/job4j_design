create table roles(
    id serial primary key,
    role text
);

create table users(
    id serial primary key,
    name varchar(255),
    position_id int references roles(id)
);

create table rules(
    id serial primary key,
    rule text
);

create table rules_of_roles(
    id serial primary key,
    role_id int references roles(id),
    rule_id int references rules(id)
);

create table comments(
     id serial primary key,
     comment text
 );

create table attachs(
     id serial primary key,
     attach text
 );

create table states(
     id serial primary key,
     state text
 );

 create table categories(
     id serial primary key,
     categorie text
 );

create table items(
    id serial primary key,
    comment_id int references comments(id),
    attach_id int references attachs(id),
	category_id int references categories(id),
	state_id int references states(id)
);

ALTER TABLE users ADD COLUMN item_id int references items(id);

ALTER TABLE users DROP COLUMN item_id;

ALTER TABLE items ADD COLUMN user_id int references users(id);

ALTER TABLE items DROP COLUMN comment_id;
ALTER TABLE items DROP COLUMN attach_id;

ALTER TABLE comments ADD COLUMN item_id int references items(id);
ALTER TABLE attachs ADD COLUMN item_id int references items(id);