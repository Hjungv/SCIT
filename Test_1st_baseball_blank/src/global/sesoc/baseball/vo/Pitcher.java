package global.sesoc.baseball.vo;

/**
 * ���� ���� VO
 */
public class Pitcher extends Player {

	public Pitcher(String id, String name, String team, int salary, double war, double era, int inning, int wins, int losses, int save, int hold) {
		super(id, name, team, salary, war);
		this.era = era;
		this.inning = inning;
		this.wins = wins;
		this.losses = losses;
		this.save = save;
		this.hold = hold;
	}


	/**
	 * ��� ��å
	 */
	private double era;
	/**
	 * �̴�
	 */
	private int inning;
	/**
	 * ��
	 */
	private int wins;
	/**
	 * ��
	 */
	private int losses;
	/**
	 * ���̺�
	 */
	private int save;
	/**
	 * Ȧ��
	 */
	private int hold;

	public double getEra() {
		return era;
	}

	public void setEra(double era) {
		this.era = era;
	}

	public int getInning() {
		return inning;
	}

	public void setInning(int inning) {
		this.inning = inning;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getSave() {
		return save;
	}

	public void setSave(int save) {
		this.save = save;
	}

	public int getHold() {
		return hold;
	}

	public void setHold(int hold) {
		this.hold = hold;
	}

	@Override
	public String toString() {
		return "��� ��å" + era + ", �̴�" + inning + ", ��" + wins + ", ��" + losses + ", ���̺�" + save + ", Ȧ��" + hold;
	}
}
