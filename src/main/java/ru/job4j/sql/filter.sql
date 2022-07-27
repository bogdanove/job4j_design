create table type
(
    id   serial primary key,
    name varchar(255)
);

create table product
(
    id           serial primary key,
    name         varchar(255),
    type_id      int references type (id),
    expired_date date,
    price        float
);

insert into type(name)
values ('СЫР');
insert into type(name)
values ('МОРОЖЕНОЕ');
insert into type(name)
values ('МОЛОКО');
insert into type(name)
values ('КОФЕ');
insert into type(name)
values ('МАСЛО');

insert into product(name, type_id, expired_date, price)
values ('Сыр косичка', 1, date '2022-07-30', 200);
insert into product(name, type_id, expired_date, price)
values ('Пошехонский сыр', 1, date '2022-07-015', 250);
insert into product(name, type_id, expired_date, price)
values ('Пломбир/мороженое', 2, date '2022-07-29', 100);
insert into product(name, type_id, expired_date, price)
values ('Кефир', 3, date '2022-07-20', 200);
insert into product(name, type_id, expired_date, price)
values ('Ряженка', 3, date '2022-07-29', 200);
insert into product(name, type_id, expired_date, price)
values ('Зерна кофе', 4, date '2023-07-01', 500);
insert into product(name, type_id, expired_date, price)
values ('Подсолнечное масло', 5, date '2022-09-01', 150);

select *
from product as pr
         join type p on p.name = 'СЫР' and p.id = pr.type_id;

select *
from product
where name like '%мороженое%';

select *
from product
where expired_date < current_date;

select *
from product
where price = (select max(price)
               from product);

select t.name, p.count
from type as t
         join product p on t.id = p.type_id
group by t.name;

select *
from product as pr
         join type p on (p.name = 'СЫР' and p.id = pr.type_id) or (p.name = 'МОЛОКО' and p.id = pr.type_id);

select t.name, p.count
from type as t,
     product as p
where t.id = p.type_id
group by t.name
having p.count > 1;

select p.name, t.name from product as p join type t on p.type_id = t.id;