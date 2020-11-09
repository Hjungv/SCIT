package denshikiki.vo;

public class KikiVO {

	private int serialNo;
	private String brand;
	private int price;

	public KikiVO() {
		super();
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return   "[ 제품 번호 : " + serialNo + ", 브랜드명 : " + brand + ", 가격 : " + price;
	}

}
