package denshikiki.vo;

public class PCVO extends KikiVO {

	private String type;

	public PCVO() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "[ PC ] " + super.toString() + ", е╦ют : " + type + " ]";
	}

}
