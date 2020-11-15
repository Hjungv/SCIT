package test.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.vo.Person;

/**
 * DB���� ó�� Ŭ����
 */
public class PersonDAO {
//	�ʿ��� ������ �о�ͼ� ������ ������ �ִ� ��ü�� �������
//	�̸� ����ϱ� ���� factory�� ���޹޴� ��
//	���̹�Ƽ�� ��ü
// factory ������ ������ �ִ� ��ü
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// ȸ������ ����
	public void insertPerson(Person p) {
		//���� ���� ���� �ϴ� ��ü
		SqlSession ss = null;

		try {
//			openSession -> java�� DB�� ������θ� ����� �ڵ�
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
//			mapper �������̽��� ���޵�
			mapper.insertPerson(p);
//			commit ���� �������� �ȵ�
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}
	}

}
