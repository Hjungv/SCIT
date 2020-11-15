package test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.vo.PersonVO;

public class PersonDAO {
//	생성된 객체를 가져온다
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public int insertPerson(PersonVO person) {
		int count = 0;

//		17~21번째까지의 코드가 실행되는 동안에는 예외가 발생할 수 있음 -> 예외처리가 필요
		SqlSession ss = null;
		try {
//		java와 db를 연결 -> sqlsession 객체를 생성해서 open
			ss = factory.openSession();
//		mapperinterface의 객체를 생성, Mybatis에 있는 기능, 객체처럼 사용할 수 있게됨
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			count = mapper.insertPerson(person);
//		insert, update, delete sql을 실행한 후에는 반드시 commit을 해야함
			ss.commit();
		} catch (Exception e) {
//		해당하는 예외가 발생했을 때 해당 정보를 콘솔에 출력해줌
			e.printStackTrace();
		} finally {
//		사용이 끝났다면 예외 발생 유무에 상관없이 연결된 session은 종료해야함
			if (ss != null) {
				ss.close();
			}
		}
		return count;
	}

	public ArrayList<PersonVO> selectPerson() {
		SqlSession ss = null;
		ArrayList<PersonVO> result = null;
		try {
			result = new ArrayList<PersonVO>();
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
//			sql문을 실행하는 코드,
//			실행하는 결과가 발생하는 쿼리문이기 때문에 selectPerson()메소드 실행하고 리턴받은 값을 result에 대입
			result = mapper.selectPerson();
			// commit 불필요
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return result;
	}

	public PersonVO selectOnePerson(int num) {
		SqlSession ss = null;
		PersonVO vo = null;
		try {
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			vo = mapper.selectOnePerson(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return vo;
	}

	public int deletePerson(int num) {
		int count = 0;
		SqlSession ss = null;
		try {
			ss= factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			count = mapper.deletePerson(num);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}

		return count;
	}
}
