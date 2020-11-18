
--게시판 글정보 테이블
create table board(
Boardnum    number primary key
,Name   varchar2(20) not null
,Title  varchar2(200) not null
,Content    varchar2(2000) not null
,Hits   number default 0
,Indate date default sysdate
);

--게시판 글 일련번호에 사용할 시퀀스 생성
create SEQUENCE boardseq;

