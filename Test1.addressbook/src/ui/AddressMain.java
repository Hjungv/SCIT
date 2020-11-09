package ui;

/**
 * 개인 정보를 입력받아 저장하는 주소 관리 프로그램의 최초 실행 부분
 */
public class AddressMain {

	public static void main(String[] args) {
		// AddressUI 객체를 생성하여 프로그램의 흐름을 구성

		AddressUI ui = new AddressUI();
		
		boolean exit = true;

		while (exit) {
			int num = ui.menu();

			switch (num) {
			case 1:
				ui.input();
				break;

			case 2:
				ui.output();
				break;

			case 3:
				ui.searchName();
				break;

			case 4:
				ui.searchGroup();
				break;

			case 5:
				ui.delete();
				break;

			case 0:
				ui.end();
				exit = false;
			}

		}
	}
}
