package student.mgr;

import java.util.ArrayList;

import student.dao.StudentDAO;
import student.vo.Student;

public class StudentManager {
	StudentDAO dao = new StudentDAO();

	// �л����� ����
	public int insert(Student s) {
		int count = dao.insert(s);
		return count;

	}

	// ��ü �б�
	public ArrayList<Student> selectAll() {
		ArrayList<Student> list = dao.selectAll();
		return list;
	}

	// �л����� ����
	public int delete(String id) {
		int count = dao.delete(id);
		return count;
	}

	// �л����� ����
	public int update(Student s) {
		int count = dao.update(s);
		return count;
	}

	// ��ü �б�
	public ArrayList<Student> selectName(String name) {
		ArrayList<Student> list = dao.selectName(name);
		return list;
	}

}
