package user.mgr;

import java.util.ArrayList;

import user.dao.UserDAO;
import user.vo.User;

public class UserManager {
	private UserDAO dao = new UserDAO();

	//회원정보 저장
	public int insertUser(User user) {
		int count = dao.insertUser(user);
		return count;
	}

	//전체 회원 목록
	public ArrayList<User> listUser() {
		ArrayList<User> list = new ArrayList<User>();
		list = dao.listUser();
		return list;

	}
}
