package test.ui;

import java.util.ArrayList;
import java.util.Scanner;

import test.mgr.PersonManager;
import test.vo.PersonVO;

public class PersonUI {

//	manager클래스의 메소드에게 사용자로부터 입력받은 데이터를 전달
//	manager클래스의 객체를 생성
// 다음 갈 곳을 선언하는게 중요
	private PersonManager mgr = new PersonManager();
	private Scanner sc = new Scanner(System.in);

	public PersonUI() {
		System.out.println("========");
		System.out.println("1. 등록");
		System.out.println("2. 출력");
		System.out.println("3. 특정회원 출력");
		System.out.println("4. 회원삭제");
		System.out.println("0. 종료");
		System.out.println("========");
		System.out.println("메뉴번호를 입력 : ");
		int num = sc.nextInt();
		switch (num) {
		case 1:
//			등록기능
			sc.nextLine();
			System.out.println("=====");
			System.out.println("이름 : ");
			String name = sc.nextLine();
			System.out.println("나이 : ");
			int age = sc.nextInt();

			PersonVO p = new PersonVO();
			p.setName(name);
			p.setAge(age);
			boolean check = mgr.insertPerson(p);
			if (check) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}

			break;
		case 2:
//			출력기능
			System.out.println("=======");
			ArrayList<PersonVO> result = mgr.selectPerson();
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
			break;
		case 3:
			System.out.println("=======");
			System.out.println("회원번호 입력 :");
			int personNum = sc.nextInt();
			PersonVO vo = mgr.selectOnePerson(personNum);
//			회원번호를 입력했는데 그 회원번호를 가진 회원이 없을 수도 있음
			if (vo != null) {
				System.out.println(vo);
			} else {
				System.out.println("회원이 없습니다.");
			}
			break;
		case 4 :
			System.out.println("=======");
			System.out.println("삭제할 회원번호 입력: ");
			int deleteNum = sc.nextInt();
			boolean deleteResult = mgr.deletePerson(deleteNum);
			if(deleteResult){
				System.out.println("삭제성공");
			}else {
				System.out.println("삭제실패");
			}
		case 0:
			break;
		default:
			break;
		}

	}
}
