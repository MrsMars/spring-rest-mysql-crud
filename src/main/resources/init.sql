<!-- reset -->
drop database if exists test;

<!-- create -->
create database test;
use test;

drop table if exists users;
create table users (
    id integer auto_increment primary key,
    first_name varchar(20),
    last_name varchar(20),
    age integer
);

<!-- init -->
insert into users(first_name, last_name, age) values
    ('Tom', 'Adams', 34),
    ('Jack', 'Baker', 22),
    ('Evans', 'Clark', 27),
    ('Frank', 'Franklin', 29),
    ('Joe', "Hills", 30);

<!-- select -->
select * from users;
select last_name from users where id = 2;
