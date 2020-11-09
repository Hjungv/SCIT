package toy.vo;

public class GameConsole extends Toy {
	private boolean isPortable;

	public GameConsole() {
		super();
	}

	public boolean isPortable() {
		return isPortable;
	}

	public void setPortable(boolean isPortable) {
		this.isPortable = isPortable;
	}

	@Override
	public String toString() {
		return super.toString()+"GameConsole [isPortable=" + isPortable + "]";
	}

}
