package user.mgr;

import java.util.ArrayList;

import user.dao.UserDAO;
import user.vo.User;

public class UserManager {
	private UserDAO dao = new UserDAO();

	//ȸ������ ����
	public int insertUser(User user) {
		int count = dao.insertUser(user);
		return count;
	}

	//��ü ȸ�� ���
	public ArrayList<User> listUser() {
		ArrayList<User> list = new ArrayList<User>();
		list = dao.listUser();
		return list;

	}
}
