package test.dao;

import test.vo.Person;

/**
 * Mapper XML�� SQL�� ��� �޼��� ����
 */
public interface PersonMapper {
	// Person��ü ����
	// DAO���� ����� �Ѿ���� ������ personMapper.xml ���� ��
	public int insertPerson(Person p);

}
