package test.ui;

import java.util.ArrayList;
import java.util.Scanner;

import test.mgr.PersonManager;
import test.vo.PersonVO;

public class PersonUI {

//	managerŬ������ �޼ҵ忡�� ����ڷκ��� �Է¹��� �����͸� ����
//	managerŬ������ ��ü�� ����
// ���� �� ���� �����ϴ°� �߿�
	private PersonManager mgr = new PersonManager();
	private Scanner sc = new Scanner(System.in);

	public PersonUI() {
		System.out.println("========");
		System.out.println("1. ���");
		System.out.println("2. ���");
		System.out.println("3. Ư��ȸ�� ���");
		System.out.println("4. ȸ������");
		System.out.println("0. ����");
		System.out.println("========");
		System.out.println("�޴���ȣ�� �Է� : ");
		int num = sc.nextInt();
		switch (num) {
		case 1:
//			��ϱ��
			sc.nextLine();
			System.out.println("=====");
			System.out.println("�̸� : ");
			String name = sc.nextLine();
			System.out.println("���� : ");
			int age = sc.nextInt();

			PersonVO p = new PersonVO();
			p.setName(name);
			p.setAge(age);
			boolean check = mgr.insertPerson(p);
			if (check) {
				System.out.println("��ϼ���");
			} else {
				System.out.println("��Ͻ���");
			}

			break;
		case 2:
//			��±��
			System.out.println("=======");
			ArrayList<PersonVO> result = mgr.selectPerson();
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
			break;
		case 3:
			System.out.println("=======");
			System.out.println("ȸ����ȣ �Է� :");
			int personNum = sc.nextInt();
			PersonVO vo = mgr.selectOnePerson(personNum);
//			ȸ����ȣ�� �Է��ߴµ� �� ȸ����ȣ�� ���� ȸ���� ���� ���� ����
			if (vo != null) {
				System.out.println(vo);
			} else {
				System.out.println("ȸ���� �����ϴ�.");
			}
			break;
		case 4 :
			System.out.println("=======");
			System.out.println("������ ȸ����ȣ �Է�: ");
			int deleteNum = sc.nextInt();
			boolean deleteResult = mgr.deletePerson(deleteNum);
			if(deleteResult){
				System.out.println("��������");
			}else {
				System.out.println("��������");
			}
		case 0:
			break;
		default:
			break;
		}

	}
}
