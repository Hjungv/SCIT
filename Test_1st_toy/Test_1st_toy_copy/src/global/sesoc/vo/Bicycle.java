package global.sesoc.vo;

public class Bicycle extends Toy {
	private String type;

	public Bicycle() {
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
		return "[자전거]\t" + super.toString() + ", 종류=" + type + "]";
	}
}
