drop table if exists users;
create table users
(
	id           bigserial    primary key,
	username     varchar(255) unique
);
insert into users(username,id)
values ('user1',1),('user2',2),('user007',3);

Drop table if exists products;
create table products
(
    id  bigserial   primary key,
    acc varchar(25),
    balance numeric,
    type    varchar(30),
    user_id bigserial references users(id)
);
insert into products(acc,balance,type,user_id)
values ('40817810001',100,'CARD',2 );
insert into products(acc,balance,type,user_id)
values ('40817810007',100500,'CARD',3 );
insert into products(acc,balance,type,user_id)
values ('42301810001',0,'DEP',1 );
insert into products(acc,balance,type,user_id)
values ('42301810002',20000,'DEP',2 );
insert into products(acc,balance,type,user_id)
values ('42301810007',777000,'DEP',3 );
