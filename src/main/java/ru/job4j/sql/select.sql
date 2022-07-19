create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('fixfishtucan', 11000, date '1901-09-01');
insert into fauna(name, avg_age, discovery_date)
values ('lion', 21500, date '1960-08-01');
insert into fauna(name, avg_age, discovery_date)
values ('panter', 600000, date '1925-06-01');
insert into fauna(name, avg_age, discovery_date)
values ('chiken', 5550000, date '1836-12-01');
insert into fauna(name, avg_age, discovery_date)
values ('tucan', 1000, date '1761-03-01');
insert into fauna(name, avg_age, discovery_date)
values ('rabbit', 227000, date '1978-07-01');
insert into fauna(name, avg_age, discovery_date)
values ('ant', 15000, date '1999-05-01');
insert into fauna(name, avg_age, discovery_date)
values ('eagle', 8000, date '1358-02-01');
insert into fauna(name, avg_age, discovery_date)
values ('wolf', 100, date '1888-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('panda', 11357, date '2001-01-01');
insert into fauna(name, avg_age)
values ('racoon', 337000);

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';