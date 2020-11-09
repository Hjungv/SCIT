package yjs;

public class studentVO {
	private String name;
	private int age;

	public studentVO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "studentVO [name=" + name + ", age=" + age + "]";
	}

}
