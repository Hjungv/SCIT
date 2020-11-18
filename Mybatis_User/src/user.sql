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



