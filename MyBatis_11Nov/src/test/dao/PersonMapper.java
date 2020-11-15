package test.dao;

import java.util.ArrayList;

import test.vo.PersonVO;

public interface PersonMapper {
//	������ sql ������ insert, udate, delete�� ��� ����� Ƚ���� return ���ش�
//	�ùٸ��� ����� Ƚ���� ������
//	void �� int �� ����
	public int insertPerson(PersonVO person);
	public ArrayList<PersonVO> selectPerson();
	public PersonVO selectOnePerson(int num);
	public int deletePerson(int num);
}
