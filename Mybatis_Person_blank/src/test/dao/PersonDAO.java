package test.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.vo.Person;

/**
 * DB관련 처리 클래스
 */
public class PersonDAO {
//	필요한 설정을 읽어와서 정보를 가지고 있는 객체를 만들었고
//	이를 사용하기 위해 factory로 전달받는 것
//	마이바티스 객체
// factory 정보만 가지고 있는 객체
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// 회원정보 저장
	public void insertPerson(Person p) {
		//접속 관련 일을 하는 객체
		SqlSession ss = null;

		try {
//			openSession -> java와 DB의 연결통로를 만드는 코드
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
//			mapper 인터페이스로 전달됨
			mapper.insertPerson(p);
//			commit 절대 빼먹으면 안됨
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}
	}

}
