package user.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import user.vo.User;

public class UserDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	// 회원정보 저장
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

	// 전체 회원 목록
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
