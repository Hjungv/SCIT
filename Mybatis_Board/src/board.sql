
--�Խ��� ������ ���̺�
create table board(
Boardnum    number primary key
,Name   varchar2(20) not null
,Title  varchar2(200) not null
,Content    varchar2(2000) not null
,Hits   number default 0
,Indate date default sysdate
);

--�Խ��� �� �Ϸù�ȣ�� ����� ������ ����
create SEQUENCE boardseq;

