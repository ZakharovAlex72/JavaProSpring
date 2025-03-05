drop table if exists users;
create table users
(
	id           bigserial    primary key,
	username     varchar(255) unique
);
insert into users(id,username)
values (1,"user1"),(2,"user2");