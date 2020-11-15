package global.sesoc.vo;

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
		return "[게임콘솔]\t" + super.toString() + ", 휴대용=" + isPortable + "]";
	}
}
