package test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.vo.PersonVO;

public class PersonDAO {
//	������ ��ü�� �����´�
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public int insertPerson(PersonVO person) {
		int count = 0;

//		17~21��°������ �ڵ尡 ����Ǵ� ���ȿ��� ���ܰ� �߻��� �� ���� -> ����ó���� �ʿ�
		SqlSession ss = null;
		try {
//		java�� db�� ���� -> sqlsession ��ü�� �����ؼ� open
			ss = factory.openSession();
//		mapperinterface�� ��ü�� ����, Mybatis�� �ִ� ���, ��üó�� ����� �� �ְԵ�
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			count = mapper.insertPerson(person);
//		insert, update, delete sql�� ������ �Ŀ��� �ݵ�� commit�� �ؾ���
			ss.commit();
		} catch (Exception e) {
//		�ش��ϴ� ���ܰ� �߻����� �� �ش� ������ �ֿܼ� �������
			e.printStackTrace();
		} finally {
//		����� �����ٸ� ���� �߻� ������ ������� ����� session�� �����ؾ���
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
//			sql���� �����ϴ� �ڵ�,
//			�����ϴ� ����� �߻��ϴ� �������̱� ������ selectPerson()�޼ҵ� �����ϰ� ���Ϲ��� ���� result�� ����
			result = mapper.selectPerson();
			// commit ���ʿ�
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
