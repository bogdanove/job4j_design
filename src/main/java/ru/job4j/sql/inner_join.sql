create table car(
    id serial primary key,
    name varchar(255),
    color varchar(255)
);

create table part(
    id serial primary key,
    name varchar(255),
    car_id int references car(id) unique
);

insert into car(name, color) values ('vaz', 'red');
insert into car(name, color) values ('audi', 'black');
insert into car(name, color) values ('bmw', 'white');

insert into part(name, car_id) values ('engine', 1);
insert into part(name, car_id) values ('wheel', 2);
insert into part(name, car_id) values ('door', 3);
insert into part(name) values ('transmission');
insert into part(name) values ('conditioner');

select p.name, c.name
from part as p join car as c on p.car_id = c.id;

select p.name as PART, c.color as COLOR
from part as p join car as c on p.car_id = c.id;

select p.name, c.name
from part as p join car as c on p.car_id is null;