create table role (
    id serial primary key,
    name text
);

create table users (
    id serial primary key,
    name text,
    role_id int references role(id)
);

create table rules (
    id serial primary key,
    name text
);

create table rules_roles (
    id serial primary key,
    rules_id int references rules(id),
    role_id int references role(id)
);

create table state (
    id serial primary key,
    name text
);

create table category (
    id serial primary key,
    name text
);

create table item (
    id serial primary key,
    name text,
    users_id int references users(id),
    state_id int references state(id),
    category_id int references category(id)
);

create table comments (
    id serial primary key,
    comment text,
    item_id int references item(id)
);

create table attachs (
    id serial primary key,
    name text,
    item_id int references item(id)
);