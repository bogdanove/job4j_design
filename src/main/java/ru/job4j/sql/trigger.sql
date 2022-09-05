1)  Триггер должен срабатывать после вставки данных,
    для любого товара и просто насчитывать налог на товар (нужно прибавить налог к цене товара).
    Действовать он должен не на каждый ряд, а на запрос (statement уровень).

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

create or replace function tax()
    returns trigger as
$$
BEGIN
update products
set price = price + price * 0.18
where id = (select id from inserted);
return new;
END;
$$
LANGUAGE 'plpgsql';

2) Триггер должен срабатывать до вставки данных и насчитывать налог на товар
    (нужно прибавить налог к цене товара). Здесь используем row уровень.

create trigger tax_trigger
    before insert
    on products
    for each row
    execute procedure tax();

create or replace function tax()
    returns trigger as
$$
BEGIN
new.price = new.price + new.price * 0.18;
return new;
END;
$$
LANGUAGE 'plpgsql';

3) Нужно написать триггер на row уровне, который при вставке продукта в таблицу products,
    будет заносить имя, цену и текущую дату в таблицу history_of_price.

create trigger history_of_price_trigger
    after insert on products
    for each row
    execute procedure history_of_price();

create or replace function history_of_price()
    returns trigger as
$$
BEGIN
insert into history_of_price(name, price, date)
values(new.name,
       new.price,
       current_date);
return new;
END;
$$
LANGUAGE 'plpgsql';