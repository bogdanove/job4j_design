create table devices(
                        id serial primary key,
                        name varchar(255),
                        price float
);
create table people(
                       id serial primary key,
                       name varchar(255)
);

create table devices_people(
                               id serial primary key,
                               device_id int references devices(id),
                               people_id int references people(id)
);

insert into devices(name, price)
values ('iphon7', 11000);
insert into devices(name, price)
values ('iphon8', 15000);
insert into devices(name, price)
values ('iphon9', 25000);
insert into devices(name, price)
values ('iphon10', 36000);
insert into devices(name, price)
values ('iphon11', 50000);
insert into devices(name, price)
values ('iphon12', 73000);
insert into devices(name, price)
values ('iphon13', 110000);
insert into people(name)
values ('Anna');
insert into people(name)
values ('Igor');
insert into people(name)
values ('Ivan');
insert into people(name)
values ('Viktor');
insert into people(name)
values ('Zayac');

insert into devices_people(device_id, people_id)
values (1, 1);
insert into devices_people(device_id, people_id)
values (2, 1);
insert into devices_people(device_id, people_id)
values (3, 2);
insert into devices_people(device_id, people_id)
values (4, 3);
insert into devices_people(device_id, people_id)
values (1, 4);
insert into devices_people(device_id, people_id)
values (7, 5);
insert into devices_people(device_id, people_id)
values (5, 3);
insert into devices_people(device_id, people_id)
values (6, 4);
insert into devices_people(device_id, people_id)
values (1, 5);

select avg(price) from devices;
select p.name, avg(d.price)
from devices_people as dp
         join people p
              on dp.people_id = p.id
         join devices d
              on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp
         join people p
              on dp.people_id = p.id
         join devices d
              on dp.device_id = d.id
group by p.name
having avg(d.price) > 30000;