package student.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import student.vo.Student;

/**
 * DB���� ó�� Ŭ����
 */
public class StudentDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü

	// �л����� ����
	public int insert(Student s) {
		SqlSession ss = null;
//		���ϰ� ����
		int count = 0;
		try {
			ss = factory.openSession();
//			studentMapper�� class ���·� ����
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
//			insert�� �����ؼ� ������ Ƚ���� count�� ����
			count = mapper.insert(s);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return count;
	}

	// ��ü �б�
	public ArrayList<Student> selectAll() {
		SqlSession ss = null;
		ArrayList<Student> list = null;
		try {
			list = new ArrayList<Student>();
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			list = mapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return list;
	}

	// �л����� ����
	public int delete(String id) {
		SqlSession ss = null;
		int count = 0;
		try {
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			count = mapper.delete(id);
			ss.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return count;
	}

	// �л����� ����
	public int update(Student s) {
		SqlSession ss = null;
		int count = 0;
		try {
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			count = mapper.update(s);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return count;
	}

	// �̸����� �˻�
	public ArrayList<Student> selectName(String name) {
		SqlSession ss = null;
		ArrayList<Student> list = null;
		try {
			list = new ArrayList<Student>();
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			list = mapper.selectName(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return list;
	}
}
