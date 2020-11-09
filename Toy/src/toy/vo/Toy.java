package toy.vo;

public class Toy {
	private String serialNum;
	private String name;
	private int price;

	public Toy() {
		super();
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
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

	@Override
	public String toString() {
		return "Toy [serialNum=" + serialNum + ", name=" + name + ", price=" + price + "]";
	}

}
