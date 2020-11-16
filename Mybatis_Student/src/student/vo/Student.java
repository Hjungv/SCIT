package student.vo;

/**
 * 개인 정보를 저장할 VO 클래스
 */
public class Student {
	private String id; // 학번
	private String name; // 이름
	private int kor; // 국어점수
	private int eng; // 영어점수
	private int mat; // 수학점수
	private double avg; // 평균점수

//	기본생성자 빼먹지 말기, 자동추가 안되니까 꼭 넣기
	public Student() {

	}

	public Student(String id, String name, int kor, int eng, int mat) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "학생 ID : " + id + ", 이름 : " + name + ", 국어점수 : " + kor + ", 영어점수 : " + eng + ", 수학점수 : " + mat
				+ ", 평균 : " + avg;

	}

}
