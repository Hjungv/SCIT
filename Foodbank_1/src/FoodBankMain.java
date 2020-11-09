import java.util.Scanner;

public class FoodBankMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Food[] fArray = new Food[20];
		int index = 0;

		while (true) {
			System.out.println("===========");
			System.out.println("1. ����ϱ�");
			System.out.println("2. ��Ϻ���");
			System.out.println("3. ��������");
			System.out.println("4. ����");
			System.out.println("===========");
			System.out.print("�޴� ��ȣ �Է�: ");
			int menuNum = sc.nextInt();

//			if�� - �������� �� �� ����
//			switch�� - �� ������ ���� �� ����

			switch (menuNum) {
			case 1:
				sc.nextLine();
//				����->���ڷ� �Ѿ ��� ����ֱ� ���� �ؾ� ��
				System.out.println("����ϱ� ���");
				System.out.print("���� �̸� : ");
				String foodName = sc.nextLine();
				System.out.print("���� ���� : ");
				String foodType = sc.nextLine();
				System.out.print("���� ���� : ");
				int foodCount = sc.nextInt();
				System.out.println(foodName + " | " + foodType + " | " + foodCount);
				Food food = new Food(foodName, foodType, foodCount);
				fArray[index++] = food;

				break;
			case 2:
				System.out.println("��Ϻ��� ���");

				for (int i = 0; i < index; i++) {
//					�׳� fArray[i]�� ������ �����ڷ�� �ּҰ��� ����, �׷��� toString�� �ʿ�~~~
					System.out.println(fArray[i]);
				}

				break;
			case 3:
				sc.nextLine();
				System.out.println("�������� ���");
				System.out.println("������ ���� �̸� : ");
				String takeFoodName = sc.nextLine();

//				�ε����� ǥ������, ���� �̸��� ������ �� ã���� �갡 ��µ�
				int temp = -1;
				for (int i = 0; i < index; i++) {
					String saveFoodName = fArray[i].getFoodName();
					System.out.println(saveFoodName);
					if(takeFoodName.equals(saveFoodName)) {
//						���� �̸��� ������ ã�Ҵٸ�
						temp = i;
						break;
					}
				}
				
				if(temp != -1) {
//				�ش� �ϴ� ������ �ִ� ������ ���翡�� �����ϸ鼭
//				���� �� ���� ������ �Է� ���� ��
					int maxFoodCount = fArray[temp].getFoodCount();
					System.out.println("���� �� ���� ���� [�ִ�" + maxFoodCount + "��]"+ ": ");
					int takeFoodCount = sc.nextInt();
					
					if(maxFoodCount<takeFoodCount) {
						System.out.println("�ִ� ������ �Ѿ ���� �� �� �����ϴ�.");
					}else {
						fArray[temp].setFoodCount(maxFoodCount-takeFoodCount);
						System.out.println(takeFoodName+"��"+takeFoodCount+"�� ���������ϴ�.");
					}
					
				}else {
					System.out.println("�ش� ������ �����ϴ�.");
				}
				
				
				break;
			case 4:
				System.out.println("���� ���");
				System.exit(0);
				break;
			default:
				System.out.println("�߸� �Է� �ϼ̽��ϴ�");
				break;
			}

//			�޴��� ����ϴ� ���

//			������ ����ϴ� ���

//			������ ����Ʈ�� ���� ���

//			������ �������� ���

		}
	}

}
