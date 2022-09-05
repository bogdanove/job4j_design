select * from show_students;

create view show_students as
select s.name, count(b.author_id) from students as s
join orders o on s.id = o.student_id
join books b on o.book_id = b.id
join authors a on b.author_id = a.id
group by (s.name)
having count(b.author_id) = (select count(*)
        size from books
        group by author_id
        order by size
        desc limit 1);