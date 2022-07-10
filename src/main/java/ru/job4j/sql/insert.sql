insert into role (name) values ('User');
insert into role (name) values ('Developer');
insert into rules (name) values ('Read');
insert into rules (name) values ('Write');
insert into rules (name) values ('Delete');
insert into category (name) values ('Furniture');
insert into category (name) values ('Stationery');
insert into state (name) values ('NEW');
insert into state (name) values ('SALE');
insert into users (name, role_id) values ('Igor', 1);
insert into users (name, role_id) values ('Ivan', 1);
insert into users (name, role_id) values ('Vladislave', 2);
insert into rules_roles (rules_id, role_id) values (1, 1);
insert into rules_roles (rules_id, role_id) values (2, 2);
insert into rules_roles (rules_id, role_id) values (1, 3);
insert into rules_roles (rules_id, role_id) values (3, 2);
insert into item (name, users_id, state_id, category_id) values ('Door', 1, 1, 1);
insert into item (name, users_id, state_id, category_id) values ('Window', 1, 2, 1);
insert into item (name, users_id, state_id, category_id) values ('Chair', 2, 1, 1);
insert into item (name, users_id, state_id, category_id) values ('Pencil', 3, 2, 2);
insert into comments (comment, item_id) values ('Some text', 1);
insert into comments (comment, item_id) values ('Some text', 2);
insert into comments (comment, item_id) values ('Some text', 3);
insert into comments (comment, item_id) values ('Some text', 4);
insert into attachs (name, item_id) values ('Photo1', 1);
insert into attachs (name, item_id) values ('Photo2', 2);
insert into attachs (name, item_id) values ('Photo3', 3);
insert into attachs (name, item_id) values ('Photo4', 3);
insert into attachs (name, item_id) values ('Photo5', 4);