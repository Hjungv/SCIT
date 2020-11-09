package toy.vo;

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
		return super.toString()+"Bicycle [type=" + type + "]";
	}
	
	
	
}
