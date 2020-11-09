package global.sesoc.baseball.vo;

/**
 * 선수 정보 VO 클래스들의 상위 클래스
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
	 * 선수 고유 번호
	 */

	private String id;
	/**
	 * 선수 이름
	 */
	private String name;
	/**
	 * 소속 팀 정보
	 */
	private String team;
	/**
	 * 연봉
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
		return "선수 고유 번호" + id + ", 선수 이름" + name + ", 소속팀" + team + ", 연봉" + salary + ", WAR" + war;
	}

}
