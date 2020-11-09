package vo;

/**
 * ������ �̸�, ��ȭ��ȣ ���� ������ ������ VO Ŭ����
 * ������, Getters, Setters, toString() ���� �޼ҵ带 �����ؼ� ���
 */
public class AddressVO {
	private String name;				//�̸�
	private String group;				//�з� �׷�
	private String phone;				//��ȭ��ȣ
	private String address;				//�ּ�
	private String email;				//E-mail �ּ�
	
	/**
	 * �⺻ ������
	 */
	public AddressVO() {
	}
	
	

	public AddressVO(String name, String group, String phone, String address, String email) {
		super();
		this.name = name;
		this.group = group;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getaddress() {
		return address;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String toString() {
		return "�̸� : "  + this.name + ", �׷� : " + this.group + ", ��ȭ : " + this.phone + ", �ּ� : " + this.address + ", �̸��� : "
				+ this.email;
	}
	

}

