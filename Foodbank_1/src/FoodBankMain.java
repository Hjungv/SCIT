import java.util.Scanner;

public class FoodBankMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Food[] fArray = new Food[20];
		int index = 0;

		while (true) {
			System.out.println("===========");
			System.out.println("1. 기부하기");
			System.out.println("2. 목록보기");
			System.out.println("3. 가져가기");
			System.out.println("4. 종료");
			System.out.println("===========");
			System.out.print("메뉴 번호 입력: ");
			int menuNum = sc.nextInt();

//			if문 - 범위지정 할 때 좋음
//			switch문 - 값 정해져 있을 때 좋음

			switch (menuNum) {
			case 1:
				sc.nextLine();
//				숫자->문자로 넘어갈 경우 비워주기 실행 해야 함
				System.out.println("기부하기 기능");
				System.out.print("음식 이름 : ");
				String foodName = sc.nextLine();
				System.out.print("음식 종류 : ");
				String foodType = sc.nextLine();
				System.out.print("음식 갯수 : ");
				int foodCount = sc.nextInt();
				System.out.println(foodName + " | " + foodType + " | " + foodCount);
				Food food = new Food(foodName, foodType, foodCount);
				fArray[index++] = food;

				break;
			case 2:
				System.out.println("목록보기 기능");

				for (int i = 0; i < index; i++) {
//					그냥 fArray[i]만 적으면 참조자료라 주소값이 나옴, 그래서 toString이 필요~~~
					System.out.println(fArray[i]);
				}

				break;
			case 3:
				sc.nextLine();
				System.out.println("가져가기 기능");
				System.out.println("가져갈 음식 이름 : ");
				String takeFoodName = sc.nextLine();

//				인덱스를 표시해줌, 같은 이름의 음식을 못 찾으면 얘가 출력됨
				int temp = -1;
				for (int i = 0; i < index; i++) {
					String saveFoodName = fArray[i].getFoodName();
					System.out.println(saveFoodName);
					if(takeFoodName.equals(saveFoodName)) {
//						같은 이름의 음식을 찾았다면
						temp = i;
						break;
					}
				}
				
				if(temp != -1) {
//				해당 하는 음식의 최대 갯수를 사용사에게 전달하면서
//				가져 갈 음식 갯수를 입력 받을 것
					int maxFoodCount = fArray[temp].getFoodCount();
					System.out.println("가져 갈 음식 갯수 [최대" + maxFoodCount + "개]"+ ": ");
					int takeFoodCount = sc.nextInt();
					
					if(maxFoodCount<takeFoodCount) {
						System.out.println("최대 갯수를 넘어서 가져 갈 수 없습니다.");
					}else {
						fArray[temp].setFoodCount(maxFoodCount-takeFoodCount);
						System.out.println(takeFoodName+"을"+takeFoodCount+"개 가져갔습니다.");
					}
					
				}else {
					System.out.println("해당 음식은 없습니다.");
				}
				
				
				break;
			case 4:
				System.out.println("종료 기능");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력 하셨습니다");
				break;
			}

//			메뉴를 출력하는 기능

//			음식을 기부하는 기능

//			음식의 리스트를 보는 기능

//			음식을 가져가는 기능

		}
	}

}
