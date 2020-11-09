package global.sesoc.baseball.vo;

/**
 * Ÿ�� ���� VO
 */
public class Batter extends Player {

	public Batter(String id, String name, String team, int salary, double war) {
		super(id, name, team, salary, war);
	}

	/**
	 * Ÿ��
	 */
	private double average;
	/**
	 * Ÿ��
	 */
	private int atbat;
	/**
	 * Ÿ��
	 */
	private int rbi;
	/**
	 * ����
	 */
	private int score;

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public int getAtbat() {
		return atbat;
	}

	public void setAtbat(int atbat) {
		this.atbat = atbat;
	}

	public int getRbi() {
		return rbi;
	}

	public void setRbi(int rbi) {
		this.rbi = rbi;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Ÿ�� : " + average + ", Ÿ�� : " + atbat + ", Ÿ�� : " + rbi + ", ���� : " + score;
	}

}
