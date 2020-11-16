package student.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import student.vo.Student;

/**
 * DB관련 처리 클래스
 */
public class StudentDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	// 학생정보 저장
	public int insert(Student s) {
		SqlSession ss = null;
//		리턴값 설정
		int count = 0;
		try {
			ss = factory.openSession();
//			studentMapper의 class 형태로 만듬
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
//			insert문 실행해서 돌려줄 횟수를 count로 받음
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

	// 전체 읽기
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

	// 학생정보 삭제
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

	// 학생정보 수정
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

	// 이름으로 검색
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
