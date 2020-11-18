package user.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import user.vo.User;

public class UserDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü

	// ȸ������ ����
	public int insertUser(User user) {
		SqlSession ss = null;
		int count = 0;
		try {
			ss = factory.openSession();
			UserMapper mapper = ss.getMapper(UserMapper.class);
			count = mapper.insertUser(user);
			if (user.getPhone() != null) {
				mapper.insertUserAdd(user);
			}
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

	// ��ü ȸ�� ���
	public ArrayList<User> listUser() {
		ArrayList<User> list = new ArrayList<User>();
		SqlSession ss = null;
		try {
			ss = factory.openSession();
			UserMapper mapper = ss.getMapper(UserMapper.class);
			list = mapper.listUser();
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
