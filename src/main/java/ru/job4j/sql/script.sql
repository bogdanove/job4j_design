create table animals (
    id serial primary key,
	name varchar(255),
	time timestamp without time zone default now(),
	area text
);
insert into animals (name, area) values ('Crocodile', 'Africa');
select * from animals;
update animals set name='Lion';
delete from animals;