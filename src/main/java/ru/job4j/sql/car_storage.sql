create table car_bodies(
                           id serial primary key,
                           name varchar(255)
);

create table car_engines(
                            id serial primary key,
                            name varchar(255)
);

create table car_transmissions(
                                  id serial primary key,
                                  name varchar(255)
);

create table cars(
                     id serial primary key,
                     name varchar(255),
                     body_id int references car_bodies(id),
                     engine_id int references car_engines(id),
                     transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('sedan');
insert into car_bodies(name) values ('hatchback');
insert into car_bodies(name) values ('universal');
insert into car_bodies(name) values ('liftback');
insert into car_bodies(name) values ('limuzin');
insert into car_bodies(name) values ('offroad');
insert into car_bodies(name) values ('crossover');

insert into car_engines(name) values ('diesel');
insert into car_engines(name) values ('electro');
insert into car_engines(name) values ('petrol');
insert into car_engines(name) values ('hybrid');

insert into car_transmissions(name) values ('manual');
insert into car_transmissions(name) values ('variator');
insert into car_transmissions(name) values ('automatic');
insert into car_transmissions(name) values ('robot');
insert into car_transmissions(name) values ('horse');

insert into cars(name, body_id, engine_id, transmission_id) values ('volvo', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('lexus', 6, 3, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('bmw', null, 2, 4);
insert into cars(name, body_id, engine_id, transmission_id) values ('mercedes', 3, 1, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('toyota', null, 3, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('hyunday', 1, null, 4);
insert into cars(name, body_id, engine_id, transmission_id) values ('kia', 2, 1, null);
insert into cars(name, body_id, engine_id, transmission_id) values ('nissan', 2, null, 4);

select c.id, c.name, b.name, e.name, t.name from cars as c
                                                     left join car_bodies b on c.body_id = b.id
                                                     left join car_engines e on c.engine_id = e.id
                                                     left join car_transmissions t on c.transmission_id = t.id;

select b.name from car_bodies b left join cars c on c.body_id = b.id where c.body_id is null;

select e.name from car_engines e left join cars c on c.engine_id = e.id where c.engine_id is null;

select t.name from car_transmissions t left join cars c on c.transmission_id = t.id where c.transmission_id is null;