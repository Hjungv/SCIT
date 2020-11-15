package test.mgr;

import java.util.ArrayList;

import test.dao.PersonDAO;
import test.vo.PersonVO;

public class PersonManager {
//	UIŬ�������� ���޹��� ��ü�� daoŬ������ �޼ҵ忡�� ����
//	�׷��鼭 �����ؾ� �ϴ� ����� �ִٸ� ����� ����

//	daoŬ������ ��ü�� ����
	private PersonDAO dao = new PersonDAO();

	public boolean insertPerson(PersonVO person) {
//		ȸ�������� ����ϴ� ���
//		count�������� insertSQL������ ����� Ƚ���� �������
		int count = dao.insertPerson(person);
		boolean check = false;
		if (count > 0) {
//			��ϼ���
			check = true;
		} else {
//			��Ͻ���
		}
		return check;
	}

	public ArrayList<PersonVO> selectPerson() {
		ArrayList<PersonVO> list = dao.selectPerson();
		return list;
//		return dao.selectPerson();
	}

	public PersonVO selectOnePerson(int num) {
		PersonVO vo = dao.selectOnePerson(num);
		return vo;
	}

	public boolean deletePerson(int num) {
		boolean deleteCheck = false;
		int count = dao.deletePerson(num);
		if (count > 0) {
			deleteCheck = true;
		}
		return deleteCheck;
	}
}
