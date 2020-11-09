package ui;

import java.util.ArrayList;
import java.util.Scanner;

import manager.AddressManager;
import vo.AddressVO;

/**
 * 사용자 화면을 구성하고 키보드로부터의 입력을 담당하는 클래스
 */
public class AddressUI {
	/**
	 * 주소 정보 처리 기능을 담당하는 클래스의 객체
	 */
	AddressManager manager;
	/**
	 * 키보드 입력 기능의 객체
	 */
	Scanner scan;

	/**
	 * 기본 생성자 - 현재 객체 최초 생성시 AddressManager와 Scanner 클래스의 객체를 생성하여 사용한다.
	 */
	public AddressUI() {

		manager = new AddressManager();
		scan = new Scanner(System.in);

	}

	/**
	 * 메뉴 출력 화면 & 메뉴 번호 입력
	 * 
	 * @return 사용자가 입력한 메뉴 번호
	 */
	public int menu() {
		int num = 0;
		System.out.println("   [ 주소록 ]");
		System.out.println("1. 새주소 등록");
		System.out.println("2. 주소록 출력");
		System.out.println("3. 이름 검색");
		System.out.println("4. 그룹 검색");
		System.out.println("5. 주소 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("* 번호선택 : ");

//		사용자로부터 메뉴번호를 입력받아야 한다
		num = scan.nextInt();

		if (!(num <= 5 && num >= 0)) {
			System.out.println("[알림] 다시 입력하세요.");
		}
		scan.nextLine();
		return num;
	}

	/**
	 * 새 주소 정보 입력 화면
	 */
	public void input() {
		System.out.println("[ 새 주소 등록 ] ");
		System.out.print("등록할 이름 : ");
		String name = scan.nextLine();
//		1번 입력 받은 이름이 등록된 이름인지 검사한다
		AddressVO vo = manager.getAddress(name);
		if (vo == null) {
//			등록되지 않은 이름일 경우는 나머지 정보를 입력받는다

			System.out.print("그룹 : ");
			String group = scan.nextLine();
			System.out.print("전화 : ");
			String phone = scan.nextLine();
			System.out.print("주소 : ");
			String address = scan.nextLine();
			System.out.print("이메일 : ");
			String email = scan.nextLine();
//			입력된 정보를 등록하는 기능을 실행한다
			AddressVO param = new AddressVO(name, group, phone, address, email);
			manager.addAddress(param);
			System.out.println("[알림] 등록되었습니다.");
		} else {
//			등록된 이름일 경우는 알림문구를 출력한다
			System.out.println("[알림] 이미 등록된 이름입니다.");
		}

	}

	/**
	 * 전체 정보 출력 화면
	 */
	public void output() {

		System.out.println("[ 주소록 출력 ]");
		ArrayList<AddressVO> list = manager.getList();

//		null이 될리는 없지만 혹시나의 상황이 있을 수 있어서 안전하게 짜기 위해 포함시킴
		if (list == null || list.size() <= 0) {
			System.out.println("[알림] 등록된 데이터가 없습니다.");
//			실행할 게 없으니까 return 써주는게 좋음
//			return;
		} else
			for (int i = 0; i < list.size(); i++) {
//				AddressVO에 toString을 overriding해서 형태를 만들어 줬기 때문에 vo객체 출력시 주소값이 아니라 toString처럼 출력되는것
				System.out.println(list.get(i));
			}
	}

	/**
	 * 이름으로 주소 검색 화면
	 */
	public void searchName() {

		System.out.println("[ 이름으로 주소 검색 ]");
		System.out.println("검색할 이름 : ");
		String name = scan.nextLine();
		AddressVO vo = manager.getAddress(name);

		if (vo == null||"".equals(vo.getName())) {
			System.out.println("[알림] 검색 결과가 없습니다.");
		} else {
//			원래는 주소값이 나오지만 AddressVO가 toString을 overriding 했기 때문에 내용이 출력됨
			System.out.print(vo);
		}
	}

	/**
	 * 그룹으로 주소 검색
	 */
	public void searchGroup() {

		System.out.println("[ 그룹으로 주소 검색 ]");
		System.out.print("검색할 그룹 : ");
		String group = scan.nextLine();
		ArrayList<AddressVO> list = manager.getGroupList(group);
		if (list == null || list.size() <= 0) {
			System.out.println("[알림] 검색 결과가 없습니다.");
		} else {
			System.out.println(list);
		}
	}

	/**
	 * 이름으로 찾아서 주소 삭제
	 */
	public void delete() {
		System.out.println("[주소 삭제]");
		System.out.print("삭제할 이름 : ");
		String name = scan.nextLine();
		boolean vo = manager.removeAddress(name);

		if (vo == true) {
			System.out.println("[알림] 삭제되었습니다.");
		} else {
			System.out.println("삭제할 데이터가 없습니다.");
		}
	}

	/**
	 * 프로그램 종료 시 마무리 작업
	 */
	public void end() {

		System.out.println("[알림] 프로그램을 종료합니다.");
	}

}
