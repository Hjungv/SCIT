
public class Food {
	private String foodName;
	private String foodType;
	private int foodCount;
	
	public Food(String foodName, String foodType, int foodCount) {
		super(); // object 객체를 생성해서 사용할 수 있게됨, 얘가 있어 toString을 overriding 해서 사용 가능
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodCount = foodCount;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getFoodCount() {
		return foodCount;
	}

	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}

//	객체 출력 -> toString이 실행됨 -> 원래는 주소값이 출력되지만 다른 값으로 출력하기 위해 추가(=재정의)
	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", foodType=" + foodType + ", foodCount=" + foodCount + "]";
	}
	
	
	
}
