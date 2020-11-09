package ui;

/**
 * ���� ������ �Է¹޾� �����ϴ� �ּ� ���� ���α׷��� ���� ���� �κ�
 */
public class AddressMain {

	public static void main(String[] args) {
		// AddressUI ��ü�� �����Ͽ� ���α׷��� �帧�� ����

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
