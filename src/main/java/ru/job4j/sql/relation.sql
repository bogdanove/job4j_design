create table finger(
                         id serial primary key,
                         name varchar(50)
);

create table people(
                          id serial primary key,
                          name varchar(255),
                          finger_id int references finger(id)
);

create table people(
                         id serial primary key,
                         name varchar(50)
);

create table car(
                        id serial primary key,
                        name varchar(50)
);

create table people_cars(
                                 id serial primary key,
                                 people_id int references people(id),
                                 cars_id int references car(id)
);

create table nose(
                         id serial primary key,
                         name varchar (50)
);

create table people(
                       id serial primary key,
                       name varchar(255),
                       nose_id int references nose(id) unique
);