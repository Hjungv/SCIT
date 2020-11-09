package test.ui;

import test.dao.PersonDAO;
import test.vo.Person;

public class TestMain {

	public static void main(String[] args) {

		PersonDAO dao = new PersonDAO();

		Person pe;

		// ÀÔ·Â
		pe = new Person("±èÃ¶¼ö", 30);
		dao.insertPerson(pe);

	}
}
