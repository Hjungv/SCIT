--[������_Mybatis_����]

-- ���̺� ���� --
create table book(
bnum     number primary key
,title  varchar2(50)    not null
,author varchar2(50)    not null
,publisher  varchar2(50)    not null
,price  number  default 0
,inputdate  date default sysdate
);

-- ������ ���� --
create SEQUENCE bookseq;


