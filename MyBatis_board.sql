create table board(
Boardnum    number primary key  
,Name   varchar2(20) not null
,Title  varchar2(200) not null
,Content    varchar2(2000) not null
,Hits   number default 0
,Indate date default sysdate
);

drop table board;

create SEQUENCE boardseq;

insert into board
(boardnum, name, title, content
)values(
boardseq.nextval, 'Â÷Â÷Â÷', 'È«Â÷','¸ÀÀÖ¾î¿©');

select
    boardnum
    ,name
    ,title
from
    board;
    
    commit;
    
select
name
    ,hits
    ,indate
    ,title
    ,content
from
    board;
    
update
    board
set
    hits = hits +1
where
    boardnum = 1;
    
delete 
from
    board
where
    boardnum = 1;
    
select
    boardnum
    ,name
    ,title
from
    board
where
    upper (title) LIKE '%' || upper('va') || '%'
;

	select
		boardnum
		,name
    	,hits
    	,indate
    	,title
   		,content
	from
    	board
	where
    	boardnum = 11;
        
        update
    board
set
    hits = hits +1
where1
    boardnum = 11;
    