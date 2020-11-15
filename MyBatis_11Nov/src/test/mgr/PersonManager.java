package test.mgr;

import java.util.ArrayList;

import test.dao.PersonDAO;
import test.vo.PersonVO;

public class PersonManager {
//	UI클래스에서 전달받은 객체를 dao클래스의 메소드에게 전달
//	그러면서 수행해야 하는 기능이 있다면 기능을 수행

//	dao클래스의 객체를 생성
	private PersonDAO dao = new PersonDAO();

	public boolean insertPerson(PersonVO person) {
//		회원정보를 등록하는 기능
//		count변수에는 insertSQL구문이 실행된 횟수가 들어있음
		int count = dao.insertPerson(person);
		boolean check = false;
		if (count > 0) {
//			등록성공
			check = true;
		} else {
//			등록실패
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
