package yjs;

import java.util.ArrayList;
import java.util.Scanner;

public class sutdentUI {
	Scanner scanner = new Scanner(System.in);
	sutdentManager manager = new sutdentManager();

	public sutdentUI() {
		while (true) {
			firstPrint();
			String numString = scanner.nextLine();
			int num = Integer.parseInt(numString);
			if (num == 1) {
				System.out.print("�̸� : ");
				String name = scanner.nextLine();
				System.out.print("���� : ");
				String ageString = scanner.nextLine();
				int age = Integer.parseInt(ageString);

//				//2
//				int resultInsertStudentData = manager.insertStudentData(name, age);
//				if(resultInsertStudentData == 1) {
//					System.out.println("����Ǿ����ϴ�.");
//				}else {
//					System.out.println("������� �ʾҽ��ϴ�.");
//				}
				
				// 1
				studentVO studentVO = new studentVO();
				studentVO.setName(name);
				studentVO.setAge(age);
				boolean resultinsertStudentData = manager.insertStudentData(studentVO);

				if (resultinsertStudentData == true) {
					System.out.println("����Ǿ����ϴ�.");
				}else {
					System.out.println("������� �ʾҽ��ϴ�.");
				}

				

			} else if (num == 2) {
				System.out.println("ã���ϴ� �ּ��� ������ �Է�");
				String name= scanner.nextLine();
				String resultData = manager.searchStudentData(name);
				
			} else if (num == 3) {

			} else if (num == 4) {

			} else if (num == 5) {

			} else if (num == 6) {

			} else {

			}
		}
	}

	public void firstPrint() {
		// �������
	}
}
