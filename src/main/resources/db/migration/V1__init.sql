drop table if exists users;
create table users
(
	id           bigserial    primary key,
	username     varchar(255) unique
);
insert into users(username)
values ('user1'),('user2');