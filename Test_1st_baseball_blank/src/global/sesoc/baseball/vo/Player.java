package global.sesoc.baseball.vo;

/**
 * ���� ���� VO Ŭ�������� ���� Ŭ����
 */
public class Player {
	public Player(String id, String name, String team, int salary, double war) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.salary = salary;
		this.war = war;
	}
	/**
	 * ���� ���� ��ȣ
	 */

	private String id;
	/**
	 * ���� �̸�
	 */
	private String name;
	/**
	 * �Ҽ� �� ����
	 */
	private String team;
	/**
	 * ����
	 */
	private int salary;
	/**
	 * WAR
	 */
	private double war;


	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTeam() {
		return team;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setWar(double war) {
		this.war = war;
	}

	public double getWar() {
		return war;
	}

	@Override
	public String toString() {
		return "���� ���� ��ȣ" + id + ", ���� �̸�" + name + ", �Ҽ���" + team + ", ����" + salary + ", WAR" + war;
	}

}
