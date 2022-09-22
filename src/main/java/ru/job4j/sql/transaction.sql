create table studentics(
    id serial primary key,
    name varchar(50),
    faculty varchar(50),
    lection_count integer default 0,
    mark integer
);

insert into studentics (name, faculty, lection_count, mark) VALUES ('student_1', 'faculty_1', 6, 3);
insert into studentics (name, faculty, lection_count, mark) VALUES ('student_2', 'faculty_1', 5, 4);
insert into studentics (name, faculty, lection_count, mark) VALUES ('student_3', 'faculty_2', 12, 5);
insert into studentics (name, faculty, lection_count, mark) VALUES ('student_4', 'faculty_1', 5, 2);
insert into studentics (name, faculty, lection_count, mark) VALUES ('student_5', 'faculty_1', 6, 5);
insert into studentics (name, faculty, lection_count, mark) VALUES ('student_6', 'faculty_3', 11, 5);

#1 transaction
1. select sum(mark) from studentics
   where lection_count = 6;
2. update studentics set lection_count = 6 where name = 'student_3';
6. commit;
#2 transaction
3. select sum(mark) from studentics
   where lection_count = 6;
4. update studentics set mark = 2 where name = 'student_5';
5. commit;