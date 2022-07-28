create table departments(
                            id serial primary key,
                            name varchar(255)
);

create table employees(
                          id serial primary key,
                          name varchar(255),
                          department_id int references departments(id)
);

insert into departments(name) values ('Departments 1');
insert into departments(name) values ('Departments 2');
insert into departments(name) values ('Departments 3');
insert into departments(name) values ('Departments 4');
insert into departments(name) values ('Departments 5');

insert into employees(name, department_id) values ('Employees 1', 1);
insert into employees(name, department_id) values ('Employees 2', 2);
insert into employees(name, department_id) values ('Employees 3', 3);
insert into employees(name, department_id) values ('Employees 4', null);
insert into employees(name, department_id) values ('Employees 5', null);
insert into employees(name, department_id) values ('Employees 6', 1);
insert into employees(name, department_id) values ('Employees 7', 1);
insert into employees(name, department_id) values ('Employees 8', 2);
insert into employees(name, department_id) values ('Employees 9', 3);
insert into employees(name, department_id) values ('Employees 10', null);
insert into employees(name, department_id) values ('Employees 11', null);
insert into employees(name, department_id) values ('Employees 12', 1);

select * from employees e left join  departments d on d.id = e.department_id;

select * from employees e right join  departments d on d.id = e.department_id;

select * from employees e full join  departments d on d.id = e.department_id;

select * from employees cross join  departments;

select * from departments d left join employees e on d.id = e.department_id where e.id is null;

select * from departments d left join employees e on d.id = e.department_id where d.id is not null and e.id is not null;

select * from departments d right join employees e on d.id = e.department_id where d.id is not null and e.id is not null;

create table teens(
                      id serial primary key,
                      name varchar(255),
                      gender varchar(255)
);

insert into teens(name, gender) values ('Teen_1', 'male');
insert into teens(name, gender) values ('Teen_2', 'female');
insert into teens(name, gender) values ('Teen_3', 'male');
insert into teens(name, gender) values ('Teen_4', 'male');
insert into teens(name, gender) values ('Teen_5', 'female');
insert into teens(name, gender) values ('Teen_6', 'male');
insert into teens(name, gender) values ('Teen_7', 'male');
insert into teens(name, gender) values ('Teen_8', 'female');
insert into teens(name, gender) values ('Teen_9', 'male');
insert into teens(name, gender) values ('Teen_10', 'male');
insert into teens(name, gender) values ('Teen_11', 'female');
insert into teens(name, gender) values ('Teen_12', 'male');
insert into teens(name, gender) values ('Teen_13', 'male');
insert into teens(name, gender) values ('Teen_14', 'female');
insert into teens(name, gender) values ('Teen_15', 'male');
insert into teens(name, gender) values ('Teen_16', 'male');
insert into teens(name, gender) values ('Teen_17', 'female');
insert into teens(name, gender) values ('Teen_18', 'male');
insert into teens(name, gender) values ('Teen_19', 'male');
insert into teens(name, gender) values ('Teen_20', 'female');
insert into teens(name, gender) values ('Teen_21', 'male');
insert into teens(name, gender) values ('Teen_22', 'male');
insert into teens(name, gender) values ('Teen_23', 'female');
insert into teens(name, gender) values ('Teen_24', 'male');
insert into teens(name, gender) values ('Teen_25', 'male');
insert into teens(name, gender) values ('Teen_26', 'female');
insert into teens(name, gender) values ('Teen_27', 'male');
insert into teens(name, gender) values ('Teen_28', 'male');
insert into teens(name, gender) values ('Teen_29', 'female');
insert into teens(name, gender) values ('Teen_30', 'male');

select n1.name, n2.name from teens n1 cross join teens n2 where n1.gender != n2.gender;