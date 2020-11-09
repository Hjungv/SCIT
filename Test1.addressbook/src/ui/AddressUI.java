package ui;

import java.util.ArrayList;
import java.util.Scanner;

import manager.AddressManager;
import vo.AddressVO;

/**
 * ����� ȭ���� �����ϰ� Ű����κ����� �Է��� ����ϴ� Ŭ����
 */
public class AddressUI {
	/**
	 * �ּ� ���� ó�� ����� ����ϴ� Ŭ������ ��ü
	 */
	AddressManager manager;
	/**
	 * Ű���� �Է� ����� ��ü
	 */
	Scanner scan;

	/**
	 * �⺻ ������ - ���� ��ü ���� ������ AddressManager�� Scanner Ŭ������ ��ü�� �����Ͽ� ����Ѵ�.
	 */
	public AddressUI() {

		manager = new AddressManager();
		scan = new Scanner(System.in);

	}

	/**
	 * �޴� ��� ȭ�� & �޴� ��ȣ �Է�
	 * 
	 * @return ����ڰ� �Է��� �޴� ��ȣ
	 */
	public int menu() {
		int num = 0;
		System.out.println("   [ �ּҷ� ]");
		System.out.println("1. ���ּ� ���");
		System.out.println("2. �ּҷ� ���");
		System.out.println("3. �̸� �˻�");
		System.out.println("4. �׷� �˻�");
		System.out.println("5. �ּ� ����");
		System.out.println("0. ���α׷� ����");
		System.out.print("* ��ȣ���� : ");

//		����ڷκ��� �޴���ȣ�� �Է¹޾ƾ� �Ѵ�
		num = scan.nextInt();

		if (!(num <= 5 && num >= 0)) {
			System.out.println("[�˸�] �ٽ� �Է��ϼ���.");
		}
		scan.nextLine();
		return num;
	}

	/**
	 * �� �ּ� ���� �Է� ȭ��
	 */
	public void input() {
		System.out.println("[ �� �ּ� ��� ] ");
		System.out.print("����� �̸� : ");
		String name = scan.nextLine();
//		1�� �Է� ���� �̸��� ��ϵ� �̸����� �˻��Ѵ�
		AddressVO vo = manager.getAddress(name);
		if (vo == null) {
//			��ϵ��� ���� �̸��� ���� ������ ������ �Է¹޴´�

			System.out.print("�׷� : ");
			String group = scan.nextLine();
			System.out.print("��ȭ : ");
			String phone = scan.nextLine();
			System.out.print("�ּ� : ");
			String address = scan.nextLine();
			System.out.print("�̸��� : ");
			String email = scan.nextLine();
//			�Էµ� ������ ����ϴ� ����� �����Ѵ�
			AddressVO param = new AddressVO(name, group, phone, address, email);
			manager.addAddress(param);
			System.out.println("[�˸�] ��ϵǾ����ϴ�.");
		} else {
//			��ϵ� �̸��� ���� �˸������� ����Ѵ�
			System.out.println("[�˸�] �̹� ��ϵ� �̸��Դϴ�.");
		}

	}

	/**
	 * ��ü ���� ��� ȭ��
	 */
	public void output() {

		System.out.println("[ �ּҷ� ��� ]");
		ArrayList<AddressVO> list = manager.getList();

//		null�� �ɸ��� ������ Ȥ�ó��� ��Ȳ�� ���� �� �־ �����ϰ� ¥�� ���� ���Խ�Ŵ
		if (list == null || list.size() <= 0) {
			System.out.println("[�˸�] ��ϵ� �����Ͱ� �����ϴ�.");
//			������ �� �����ϱ� return ���ִ°� ����
//			return;
		} else
			for (int i = 0; i < list.size(); i++) {
//				AddressVO�� toString�� overriding�ؼ� ���¸� ����� ��� ������ vo��ü ��½� �ּҰ��� �ƴ϶� toStringó�� ��µǴ°�
				System.out.println(list.get(i));
			}
	}

	/**
	 * �̸����� �ּ� �˻� ȭ��
	 */
	public void searchName() {

		System.out.println("[ �̸����� �ּ� �˻� ]");
		System.out.println("�˻��� �̸� : ");
		String name = scan.nextLine();
		AddressVO vo = manager.getAddress(name);

		if (vo == null||"".equals(vo.getName())) {
			System.out.println("[�˸�] �˻� ����� �����ϴ�.");
		} else {
//			������ �ּҰ��� �������� AddressVO�� toString�� overriding �߱� ������ ������ ��µ�
			System.out.print(vo);
		}
	}

	/**
	 * �׷����� �ּ� �˻�
	 */
	public void searchGroup() {

		System.out.println("[ �׷����� �ּ� �˻� ]");
		System.out.print("�˻��� �׷� : ");
		String group = scan.nextLine();
		ArrayList<AddressVO> list = manager.getGroupList(group);
		if (list == null || list.size() <= 0) {
			System.out.println("[�˸�] �˻� ����� �����ϴ�.");
		} else {
			System.out.println(list);
		}
	}

	/**
	 * �̸����� ã�Ƽ� �ּ� ����
	 */
	public void delete() {
		System.out.println("[�ּ� ����]");
		System.out.print("������ �̸� : ");
		String name = scan.nextLine();
		boolean vo = manager.removeAddress(name);

		if (vo == true) {
			System.out.println("[�˸�] �����Ǿ����ϴ�.");
		} else {
			System.out.println("������ �����Ͱ� �����ϴ�.");
		}
	}

	/**
	 * ���α׷� ���� �� ������ �۾�
	 */
	public void end() {

		System.out.println("[�˸�] ���α׷��� �����մϴ�.");
	}

}
