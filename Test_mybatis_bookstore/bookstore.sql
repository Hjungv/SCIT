--[역량평가_Mybatis_서점]

-- 테이블 생성 --
create table book(
bnum     number primary key
,title  varchar2(50)    not null
,author varchar2(50)    not null
,publisher  varchar2(50)    not null
,price  number  default 0
,inputdate  date default sysdate
);

-- 시퀀스 생성 --
create SEQUENCE bookseq;


