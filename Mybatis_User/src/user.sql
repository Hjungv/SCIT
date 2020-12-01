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

1. 테이블을 생성 (사용자에게 이름과 나이를 입력받아서 저장하려고 함, 이름을 저장할 컬럼과 나이를 저장할 컬럼을 명시, 사용할 DB 객체를 생성(seq 포함)
2. 프로젝트 생성
3. 프로젝트에서 사용할 외부 라이브러리 설정 (ojdbc6.jar, mybatis-3.4.6.jar 설정)
4. 패키지를 설정하고 vo클래스부터 생성 (dao 패키지, vo패키지, ui패키지,manager패키지)
5. vo클래스를 만들때 테이블을 참고 (테이블 명칭을 보고 vo명칭을 비슷하게~, 기본생성자/setter/getter 필수, toString/다른생성자 선택)

6-1(고급자)

UI부터 만든다

6-2(초급자)

SQL구문부터 만든다 (지금 내가 만드는 어플리케이션에서 동작되어야 하는 기능이 무엇인지 이미 알고 있는 상황)

7. Mybatis setting

1) mybatis-config.xml 파일을 설정 (db.properties 설정, typealiases 설정)

2)MybatisConfig.java 파일을 생성

3)mapper.xml 파일을 설정

8. 생성한 sql구문의 내용을 보고 태그를 만듬

9. id 의 이름을 설정 (기능을 내포한 이름을 설정)

10. 쿼리를 보고 동적으로 변경되어야 하는 값이 있는지 확인 있다면 #{}를 사용하여 변수처리 → 해당 쿼리를 실행하기 위해서 전달받아야 하는 값이 있다면 그 값을 parameterType에 명시, 동적데이터 부분에 변수명칭을 작성

11. mapper.xml의 namespace에 넣어줄 값인 mapperinterface를 생성

12. namespace의 내용을 추가

13. mybatis-config.xml에 가서 방금 작성한 mapper.xml 을 등록

14.  mapperinterface의 메소드를 생성

15. dao클래스를 생성

1) 이미 생성되어있는 sqlsessionfactory 객체를 가져와야 함

2) mapperinterface의 생성한 메소드를 복사해서 dao에서 동일하게 작성

3) 정해진 문법에 따라서dao의 메소드를 구성

16. main클래스를 생성

