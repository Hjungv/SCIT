package global.sesoc.vo;

public class Drone extends Toy {
	private int wingCount;

	public Drone() {
		super();
	}

	public int getWingCount() {
		return wingCount;
	}

	public void setWingCount(int wingCount) {
		this.wingCount = wingCount;
	}

	@Override
	public String toString() {
		return "[드론]\t" + super.toString() + ", 날개 수=" + wingCount + "]";
	}

}
