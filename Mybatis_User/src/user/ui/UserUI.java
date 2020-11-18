package user.ui;

import java.util.ArrayList;
import java.util.Scanner;

import user.mgr.UserManager;
import user.vo.User;

/**
 * ȸ�� ���� ���α׷��� ����� ȭ��
 */
public class UserUI {
	private UserManager mgr = new UserManager();
	private Scanner sc = new Scanner(System.in); // Ű����κ��� �Է¹ޱ� ���� Ŭ������ ��ü

	/**
	 * ������. �޴�ȭ���� ���� ������� �Է��� �޴´�.
	 */
	public UserUI() {

		while (true) {
			printMainMenu();
			int menu = sc.nextInt();
			if (menu == 1) {
				// ȸ������ ���
				insert();

			} else if (menu == 2) {
				list();

			} else if(menu == 9) {
				// ���α׷� ����
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}else {
				System.out.println("��ȣ�� �ٽ� �����ϼ���.");
			}
		}
	}

	/**
	 * ���� �޴��� ����Ѵ�.
	 */
	public void printMainMenu() {
		System.out.println("[ ȸ�� ���� ]");
		System.out.println("1. ȸ������ ���");
		System.out.println("2. ��ü ȸ�� ���");
		System.out.println("9. ���α׷� ����");
		System.out.print("* �޴� ��ȣ�� �����ϼ��� > ");
	}

	/**
	 * ȸ������ ���
	 */
	void insert() {

		User user = new User();
		int insertResult = 0;

		sc.nextLine();
		System.out.println("[ ȸ������ ��� ]");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("���� (��:M ��:F ) �Է� : ");
		String gender = sc.nextLine();

		user.setId(id);
		user.setName(name);
		user.setGender(gender.toUpperCase());

		System.out.println("�߰� ������ �Է��Ͻðڽ��ϱ�?");
		String addInfo = sc.nextLine();

		if (addInfo.equals("y") || addInfo.equals("Y")) {
			System.out.print("��ȭ��ȣ : ");
			String phone = sc.nextLine();
			System.out.print("�ּ� : ");
			String address = sc.nextLine();
			user.setPhone(phone);
			user.setAddress(address);
		} else {
		}

		insertResult = mgr.insertUser(user);

		if (insertResult > 0) {
			System.out.println("[�˸�] ����Ǿ����ϴ�.");
		} else {
			System.out.println("[�˸�] ���忡 �����Ͽ����ϴ�.");
		}

	}

	/**
	 * ��ü ȸ�� ���
	 */
	void list() {
		System.out.println("[ ��ü ȸ�� ��� ]");
		ArrayList<User> list = mgr.listUser();

		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("��ϵ� ȸ�� ������ �����ϴ�.");
		}

	}

}
