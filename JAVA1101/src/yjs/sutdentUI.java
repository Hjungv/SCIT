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
				System.out.print("이름 : ");
				String name = scanner.nextLine();
				System.out.print("나이 : ");
				String ageString = scanner.nextLine();
				int age = Integer.parseInt(ageString);

//				//2
//				int resultInsertStudentData = manager.insertStudentData(name, age);
//				if(resultInsertStudentData == 1) {
//					System.out.println("저장되었습니다.");
//				}else {
//					System.out.println("저장되지 않았습니다.");
//				}
				
				// 1
				studentVO studentVO = new studentVO();
				studentVO.setName(name);
				studentVO.setAge(age);
				boolean resultinsertStudentData = manager.insertStudentData(studentVO);

				if (resultinsertStudentData == true) {
					System.out.println("저장되었습니다.");
				}else {
					System.out.println("저장되지 않았습니다.");
				}

				

			} else if (num == 2) {
				System.out.println("찾고하는 주소의 주인을 입력");
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
		// 메인출력
	}
}
