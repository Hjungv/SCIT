package test.ui;

import test.dao.PersonDAO;
import test.vo.Person;

public class TestMain {

	public static void main(String[] args) {

		PersonDAO dao = new PersonDAO();

		Person pe;

		// �Է�
		pe = new Person("��ö��", 30);
		dao.insertPerson(pe);

	}
}
