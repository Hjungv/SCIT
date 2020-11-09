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
				System.out.println("종료 기능");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력 하셨습니다");
				break;
			}
		}
	}

	public int printMainMenu() {
		System.out.println("===========");
		System.out.println("1. 기부하기");
		System.out.println("2. 목록보기");
		System.out.println("3. 가져가기");
		System.out.println("4. 종료");
		System.out.println("===========");
		System.out.print("메뉴 번호 입력: ");
		int menuNum = sc.nextInt();
		return menuNum;
	}

	public void insertFood() {
		sc.nextLine();
//		숫자->문자로 넘어갈 경우 비워주기 실행 해야 함
		System.out.println("기부하기 기능");
		System.out.print("음식 이름 : ");
		String foodName = sc.nextLine();
		System.out.print("음식 종류 : ");
		String foodType = sc.nextLine();
		System.out.print("음식 갯수 : ");
		int foodCount = sc.nextInt();
		System.out.println(foodName + " | " + foodType + " | " + foodCount);
		Food food = new Food(foodName, foodType, foodCount);
		manager.insertFood(food);

	}

	public void foodList() {
		System.out.println("목록보기 기능");
//		if (manager.index == 0) {
//			System.out.println("목록이 없습니다.");
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
		System.out.println("가져가기 기능");
		System.out.println("***************");
		System.out.print("가져갈 음식 이름 : ");
		String takeFoodName = sc.nextLine();
		int index = manager.searchFoodName(takeFoodName);
		if (index != -1) {
			int maxFoodCount = manager.fArray[index].getFoodCount();
			System.out.print("가져 갈 음식 갯수 [최대" + maxFoodCount + "개] : ");
			int takeFoodCount = sc.nextInt();
			if (takeFoodCount > maxFoodCount) {
				System.out.println("최대 갯수를 넘어서 가져 갈 수 없습니다.");
			} else {
				manager.fArray[index].setFoodCount(maxFoodCount - takeFoodCount);
				System.out.println(takeFoodName + "을(를) " + takeFoodCount + "개 가져갔습니다.");
			}
		} else {
			System.out.println("해당 음식은 없습니다.");
		}
	}

}
