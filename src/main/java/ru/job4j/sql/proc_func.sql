create or replace procedure delete_data()
language 'plpgsql'
as $$
BEGIN
delete from products where count <= 0;
END
$$;

create or replace function f_delete_data()
returns integer
language 'plpgsql'
as
$$
    declare
result integer;
begin
select count(*) into result from products where count <= 0;
delete from products where count <= 0;
return result;
end;
$$;