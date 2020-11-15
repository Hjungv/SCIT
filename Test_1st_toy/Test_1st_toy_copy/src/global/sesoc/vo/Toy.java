package global.sesoc.vo;

public class Toy {
	private String serialNum;
	private String name;
	private int price;

	public Toy() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	@Override
	public String toString() {
		return "[고유번호 = " + serialNum + ", 이름 = " + name + ", 가격 = " + price + "원";
	}
}
