package user.ui;

import java.util.ArrayList;
import java.util.Scanner;

import user.mgr.UserManager;
import user.vo.User;

/**
 * 회원 관리 프로그램의 사용자 화면
 */
public class UserUI {
	private UserManager mgr = new UserManager();
	private Scanner sc = new Scanner(System.in); // 키보드로부터 입력받기 위한 클래스의 객체

	/**
	 * 생성자. 메뉴화면을 띄우고 사용자의 입력을 받는다.
	 */
	public UserUI() {

		while (true) {
			printMainMenu();
			int menu = sc.nextInt();
			if (menu == 1) {
				// 회원정보 등록
				insert();

			} else if (menu == 2) {
				list();

			} else if(menu == 9) {
				// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("번호를 다시 선택하세요.");
			}
		}
	}

	/**
	 * 메인 메뉴를 출력한다.
	 */
	public void printMainMenu() {
		System.out.println("[ 회원 관리 ]");
		System.out.println("1. 회원정보 등록");
		System.out.println("2. 전체 회원 목록");
		System.out.println("9. 프로그램 종료");
		System.out.print("* 메뉴 번호를 선택하세요 > ");
	}

	/**
	 * 회원정보 등록
	 */
	void insert() {

		User user = new User();
		int insertResult = 0;

		sc.nextLine();
		System.out.println("[ 회원정보 등록 ]");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("성별 (남:M 여:F ) 입력 : ");
		String gender = sc.nextLine();

		user.setId(id);
		user.setName(name);
		user.setGender(gender.toUpperCase());

		System.out.println("추가 정보를 입력하시겠습니까?");
		String addInfo = sc.nextLine();

		if (addInfo.equals("y") || addInfo.equals("Y")) {
			System.out.print("전화번호 : ");
			String phone = sc.nextLine();
			System.out.print("주소 : ");
			String address = sc.nextLine();
			user.setPhone(phone);
			user.setAddress(address);
		} else {
		}

		insertResult = mgr.insertUser(user);

		if (insertResult > 0) {
			System.out.println("[알림] 저장되었습니다.");
		} else {
			System.out.println("[알림] 저장에 실패하였습니다.");
		}

	}

	/**
	 * 전체 회원 목록
	 */
	void list() {
		System.out.println("[ 전체 회원 목록 ]");
		ArrayList<User> list = mgr.listUser();

		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("등록된 회원 정보가 없습니다.");
		}

	}

}
