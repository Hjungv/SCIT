drop table userinfo;
drop table useraddr;

create table userinfo(
id  varchar2(20)  constraint id_pk primary key
,Name varchar2 (20) not null
,Gender char (1) default 'M'
);

create table useraddr(
id unique constraint id_fk references userinfo(id) 
,Phone  varchar2(50) not null
,Address    varchar2(100) not null
);

insert into userinfo(id, name)
values('g', 'È«');



insert into useraddr(
phone, address) values
('01044885374', 'ÀÌ¿ÀÇáµµ');

select 
i.id as id
,i.name as name
,i.gender as gender
,NVL(a.phone,' ') as phone
,NVL(a.address, ' ') as address
from 
userinfo i, useraddr a
where i.id = a.id(+);



