
public class FoodBankManager {

	Food[] fArray = new Food[20];
	//int index = 0;

	public void insertFood(Food food) {
		fArray[2] = food;
	}

	public Food[] searchFood() {
		return fArray;
	}

//	public int index() {
//		return index;
//	}

	public int searchFoodName(String foodName) {
		int temp = -1;
		for (int i = 0; i < 5; i++) {
			if (fArray[i].getFoodName().equals(foodName)) {
				temp = i;
				break;
			}
		}
		return temp;
	}

}
