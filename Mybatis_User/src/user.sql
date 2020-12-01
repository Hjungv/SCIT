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

1. ���̺��� ���� (����ڿ��� �̸��� ���̸� �Է¹޾Ƽ� �����Ϸ��� ��, �̸��� ������ �÷��� ���̸� ������ �÷��� ���, ����� DB ��ü�� ����(seq ����)
2. ������Ʈ ����
3. ������Ʈ���� ����� �ܺ� ���̺귯�� ���� (ojdbc6.jar, mybatis-3.4.6.jar ����)
4. ��Ű���� �����ϰ� voŬ�������� ���� (dao ��Ű��, vo��Ű��, ui��Ű��,manager��Ű��)
5. voŬ������ ���鶧 ���̺��� ���� (���̺� ��Ī�� ���� vo��Ī�� ����ϰ�~, �⺻������/setter/getter �ʼ�, toString/�ٸ������� ����)

6-1(�����)

UI���� �����

6-2(�ʱ���)

SQL�������� ����� (���� ���� ����� ���ø����̼ǿ��� ���۵Ǿ�� �ϴ� ����� �������� �̹� �˰� �ִ� ��Ȳ)

7. Mybatis setting

1) mybatis-config.xml ������ ���� (db.properties ����, typealiases ����)

2)MybatisConfig.java ������ ����

3)mapper.xml ������ ����

8. ������ sql������ ������ ���� �±׸� ����

9. id �� �̸��� ���� (����� ������ �̸��� ����)

10. ������ ���� �������� ����Ǿ�� �ϴ� ���� �ִ��� Ȯ�� �ִٸ� #{}�� ����Ͽ� ����ó�� �� �ش� ������ �����ϱ� ���ؼ� ���޹޾ƾ� �ϴ� ���� �ִٸ� �� ���� parameterType�� ���, ���������� �κп� ������Ī�� �ۼ�

11. mapper.xml�� namespace�� �־��� ���� mapperinterface�� ����

12. namespace�� ������ �߰�

13. mybatis-config.xml�� ���� ��� �ۼ��� mapper.xml �� ���

14.  mapperinterface�� �޼ҵ带 ����

15. daoŬ������ ����

1) �̹� �����Ǿ��ִ� sqlsessionfactory ��ü�� �����;� ��

2) mapperinterface�� ������ �޼ҵ带 �����ؼ� dao���� �����ϰ� �ۼ�

3) ������ ������ ����dao�� �޼ҵ带 ����

16. mainŬ������ ����

