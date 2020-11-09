import java.util.Scanner;

public class FoodBankUI {
	Scanner sc = new Scanner(System.in);
	FoodBankManager manager = new FoodBankManager();

	public FoodBankUI() {
		while (true) {
			int menuNum = printMainMenu();

			switch (menuNum) {
			case 1:
				insertFood();
				break;
			case 2:
				foodList();
				break;
			case 3:
				getFood();
				break;
			case 4:
				System.out.println("���� ���");
				System.exit(0);
				break;
			default:
				System.out.println("�߸� �Է� �ϼ̽��ϴ�");
				break;
			}
		}
	}

	public int printMainMenu() {
		System.out.println("===========");
		System.out.println("1. ����ϱ�");
		System.out.println("2. ��Ϻ���");
		System.out.println("3. ��������");
		System.out.println("4. ����");
		System.out.println("===========");
		System.out.print("�޴� ��ȣ �Է�: ");
		int menuNum = sc.nextInt();
		return menuNum;
	}

	public void insertFood() {
		sc.nextLine();
//		����->���ڷ� �Ѿ ��� ����ֱ� ���� �ؾ� ��
		System.out.println("����ϱ� ���");
		System.out.print("���� �̸� : ");
		String foodName = sc.nextLine();
		System.out.print("���� ���� : ");
		String foodType = sc.nextLine();
		System.out.print("���� ���� : ");
		int foodCount = sc.nextInt();
		System.out.println(foodName + " | " + foodType + " | " + foodCount);
		Food food = new Food(foodName, foodType, foodCount);
		manager.insertFood(food);

	}

	public void foodList() {
		System.out.println("��Ϻ��� ���");
//		if (manager.index == 0) {
//			System.out.println("����� �����ϴ�.");
//		} else {
		Food[] list = manager.searchFood();
//			int index = manager.index();

		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				System.out.println(list[i]);
			}
		}
//		}
	}

	public void getFood() {
		sc.nextLine();
		System.out.println("***************");
		System.out.println("�������� ���");
		System.out.println("***************");
		System.out.print("������ ���� �̸� : ");
		String takeFoodName = sc.nextLine();
		int index = manager.searchFoodName(takeFoodName);
		if (index != -1) {
			int maxFoodCount = manager.fArray[index].getFoodCount();
			System.out.print("���� �� ���� ���� [�ִ�" + maxFoodCount + "��] : ");
			int takeFoodCount = sc.nextInt();
			if (takeFoodCount > maxFoodCount) {
				System.out.println("�ִ� ������ �Ѿ ���� �� �� �����ϴ�.");
			} else {
				manager.fArray[index].setFoodCount(maxFoodCount - takeFoodCount);
				System.out.println(takeFoodName + "��(��) " + takeFoodCount + "�� ���������ϴ�.");
			}
		} else {
			System.out.println("�ش� ������ �����ϴ�.");
		}
	}

}
