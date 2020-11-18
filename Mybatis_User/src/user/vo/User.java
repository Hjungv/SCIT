package user.vo;

//회원정보 VO
public class User {

	public User() {

	}

	private String id; // 회원 ID
	private String name; // 작성자 이름
	private String gender; // 성별
	private String phone; // 전화번호
	private String address; // 주소

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ID : " + id + "     이름 : " + name + "     성별 : " + gender + "     전화 :  " + phone + "     주소 : " + address;
	}

}
