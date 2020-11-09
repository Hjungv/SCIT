package global.sesoc.baseball.vo;

/**
 * Åõ¼ö Á¤º¸ VO
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
	 * Æò±Õ ÀÚÃ¥
	 */
	private double era;
	/**
	 * ÀÌ´×
	 */
	private int inning;
	/**
	 * ½Â
	 */
	private int wins;
	/**
	 * ÆĞ
	 */
	private int losses;
	/**
	 * ¼¼ÀÌºê
	 */
	private int save;
	/**
	 * È¦µå
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
		return "Æò±Õ ÀÚÃ¥" + era + ", ÀÌ´×" + inning + ", ½Â" + wins + ", ÆĞ" + losses + ", ¼¼ÀÌºê" + save + ", È¦µå" + hold;
	}
}
