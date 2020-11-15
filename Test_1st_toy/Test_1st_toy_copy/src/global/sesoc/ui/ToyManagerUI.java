package global.sesoc.ui;

import java.util.ArrayList;
import java.util.Scanner;

import global.sesoc.manager.ToyManagerMgr;
import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

/**
 * ����� �������̽�
 */
public class ToyManagerUI {
	Scanner input = new Scanner(System.in);
	ToyManagerMgr manager = new ToyManagerMgr();

	/**
	 * ������
	 */

	public ToyManagerUI() {
		int mNum = 0;

		while (true) {
			try {
				mainMenu();
				mNum = inputNum();

				switch (mNum) {
				case 1:
					// �峭�� ���
					insertToy();
					break;
				case 2:
					// �峭�� �˻�
					selectToy();
					break;
				case 3:
					//�峭�� ����
					deleteToy();
					break;
				case 4:
					// �峭�� ����

				case 5:
					searchByPrice();
					break;
				case 6:
					// �峭�� ���� ���
				case 0:
					System.out.println("������ ���� �� ���α׷� �����մϴ�.");
				default:
					System.out.println("���� >>> �ٽ� �Է��� �ּ���.");
				}

			} catch (Exception e) {
				System.out.println("����>>> �ٽ� �Է��� �ּ���.");
				input.nextLine();
				continue;
			}
		}
	}

	public int inputNum() {
		int result = 0;
		try {
			result = input.nextInt();
		} catch (Exception e) {
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
		} finally {
			input.nextLine();
		}

		return result;

	}

	/**
	 * �ָ޴��� ȭ�鿡 ����Ѵ�.
	 */

	public void mainMenu() {
		System.out.println("\n===== Toy Manager =====");
		System.out.println("1. �峭�� ���");
		System.out.println("2. �峭�� �˻�");
		System.out.println("3. �峭�� ����");
		System.out.println("4. �峭�� ����");
		System.out.println("5. ���ݴ� �˻�");
		System.out.println("6. �峭�� ���� ���");
		System.out.println("0. ����");
		System.out.println("======================");
		System.out.println("[ �޴� ���� ]");
	}

	/**
	 * �峭�� ��ü�� �����ϱ� ���� Toy ��ü�� �����Ѵ�. �峭���� ������ ���� ������(1. ���ο�, 2. ��ǿ�), ���(���� ����),
	 * ���ӱ�(�޴밡�� ����)�� �Է¹޴´�.
	 *
	 * @param toyType �峭�� ����
	 * @return ������ �峭�� ��ü
	 */

	public void insertToy() {

		while (true) {
			System.out.println("===== �峭�� ��� �޴� =====");
			System.out.println("1. ������");
			System.out.println("2. ���");
			System.out.println("3. ���ӱ�");
			System.out.println("9. �����޴�");
			System.out.println("[ �峭�� ���� ]");
			int selectToy = inputNum();

			System.out.println("> ������ȣ : ");
			String serialNum = input.nextLine();

			System.out.println("> �̸� : ");
			String name = input.nextLine();
			System.out.println("> ���� : ");
			int price = inputNum();

			Toy toy = new Toy();

			if (selectToy == 9) {
				// �����޴��� ���ư���
			} else if (selectToy >= 1 || selectToy <= 3) {
				boolean result = false;
				if (selectToy == 1) {
//					�����ŵ��
					Bicycle bicycle = new Bicycle();
					System.out.println("> ����������(1. ���ο�, 2. ��ǿ�) => ");
					int sc = input.nextInt();
					String type = null;
					if (sc == 1) {
						type = "road";
					} else if (sc == 2) {
						type = "mountain";
					}

					bicycle.setSerialNum(serialNum);
					bicycle.setName(name);
					bicycle.setPrice(price);
					bicycle.setType(type);

					result = manager.insertToy(bicycle);

				} else if (selectToy == 2) {
//					��е��
					System.out.println(">���� �� :");
					int wingCount = input.nextInt();

					Drone drone = new Drone();
					drone.setSerialNum(serialNum);
					drone.setName(name);
					drone.setPrice(price);
					drone.setWingCount(wingCount);

					result = manager.insertToy(drone);

				} else if (selectToy == 3) {
//					���ӱ���
					System.out.print("> �޴밡�� (���Է½� �ƴϿ� > 1. �� 2. �ƴϿ�) : ");
					int portableInput = input.nextInt();

					GameConsole console = new GameConsole();
					console.setSerialNum(serialNum);
					console.setName(name);
					console.setPrice(price);

					boolean portableresult = false;
					if (portableInput == 1) {
						portableresult = true;
					} else if (portableInput == 2) {
						portableresult = false;

					}
					console.setPortable(portableresult);

				}

				if (result == true) {
					System.out.println("[�˸�] ��� �Ǿ����ϴ�.");
					break;
				} else {
					System.out.println("[�˸�] ��ϵ��� �ʾҽ��ϴ�.");
				}

			} else {
				System.out.println("�߸��Է�");

			}
		}

	}

	/**
	 * �峭�� ��ü�� ����ϱ� ���� �޴��� ȭ�鿡 ���
	 */

	public void insertMenu() {
		System.out.println("\n ===== �峭�� ��� �޴� =====");
		System.out.println("1. ������");
		System.out.println("2. ���");
		System.out.println("3. ���ӱ�");
		System.out.println("9. �����޴�");
		System.out.println("[ �峭�� ���� ���� ]");
	}

	/**
	 * ������ȣ�� �ش��ϴ� �峭���� �˻��Ͽ� ȭ�鿡 ����Ѵ�. �˻��� ���� ���� ��� �޽��� ���
	 */
	public void selectToy() {
		System.out.print("> �峭�� ������ȣ : ");
		String serialNum = input.nextLine();
		/*
		 * parmater :�峭��������ȣ retrun : Toy - ������ȣ�� ���� toy��
		 */
		Toy result = manager.searchToy(serialNum);
		System.out.println(result);
	}

	/**
	 * �峭���� �ø����ȣ�� �Է¹޾� �ش��ϴ� �峭�� ������ �����Ѵ�.
	 */
	public void deleteToy() {
		System.out.println("===== �峭�� ���� �޴� =====");
		System.out.print("> �峭�� ���� ��ȣ : ");
		String serialNum = input.nextLine();
		boolean result = manager.deleteToy(serialNum);

		if (result) {
			System.out.println("[ ���� ���� ]");
		} else {
			System.out.println("[�˸�] �������� �ʾҽ��ϴ�.");
		}

	}

	public void searchByPrice() {
		System.out.print("> �ּҰ��� : ");
		int minPrice = inputNum();
		System.out.print("> �ִ밡�� : ");
		int maxPrice = inputNum();

		ArrayList<Toy> result = manager.toyListForPrice(minPrice, maxPrice);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

//		count = result.size();
//		System.out.println(result.size());
	}

	/**
	 * �峭�� ������ ȭ�鿡 ���
	 * �峭�� ������ ����ϰ� �� �� �˻��� �峭���� ���� ���
	 * �˻��� ���� ���� ��� ��ϵ� �峭���� ���ٴ� �޽��� ���
	 */

}
