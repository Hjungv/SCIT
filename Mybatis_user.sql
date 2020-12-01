insert into
	userinfo(
		id
		,name
		,gender
	)values(
		'dsghh'
		,'AAAAAA'
		,DECODE(:gender, null, 'M', :gender)
		);
commit;

select * from userinfo;