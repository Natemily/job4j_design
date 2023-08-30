insert into roles(role) values ('admin');
insert into roles(role) values ('moder');
insert into roles(role) values ('user');

insert into users(name, position_id) values ('Natalia', 1);
insert into users(name, position_id) values ('Ekatherina', 2);
insert into users(name, position_id) values ('Maria', 3);
insert into users(name, position_id) values ('Nikita', 3);

insert into rules(rule) values ('можно все');
insert into rules(rule) values ('можно не все');
insert into rules(rule) values ('нельзя ничего');

insert into rules_of_roles(role_id, rule_id) values (1, 1);
insert into rules_of_roles(role_id, rule_id) values (2, 2);
insert into rules_of_roles(role_id, rule_id) values (3, 3);

insert into attachs(attach) values ('png.png');
insert into attachs(attach) values ('avi.avi');

insert into states(state) values ('open');
insert into states(state) values ('close');

insert into categories(categorie) values ('important');
insert into categories(categorie) values ('unimportant');

insert into comments(comment) values ('все путем');
insert into comments(comment) values ('не важно');

insert into items(category_id, state_id, user_id) values (1, 1, 1);
insert into items(category_id, state_id, user_id) values (2, 2, 3);
insert into items(category_id, state_id, user_id) values (1, 2, 4);
insert into items(category_id, state_id, user_id) values (2, 1, 2);

update comments set item_id = 4 where id = 1;
update comments set item_id = 3 where id = 2;

update attachs set item_id = 2 where id = 1;
update attachs set item_id = 1 where id = 2;