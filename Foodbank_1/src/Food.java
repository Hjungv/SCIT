
public class Food {
	private String foodName;
	private String foodType;
	private int foodCount;
	
	public Food(String foodName, String foodType, int foodCount) {
		super(); // object ��ü�� �����ؼ� ����� �� �ְԵ�, �갡 �־� toString�� overriding �ؼ� ��� ����
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

//	��ü ��� -> toString�� ����� -> ������ �ּҰ��� ��µ����� �ٸ� ������ ����ϱ� ���� �߰�(=������)
	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", foodType=" + foodType + ", foodCount=" + foodCount + "]";
	}
	
	
	
}
