package denshikiki.vo;

public class SentakuVO extends KikiVO {
	private String dry;

	public SentakuVO() {
		super();
	}

	public String getDry() {
		return dry;
	}

	public void setDry(String dry) {
		this.dry = dry;
	}

	@Override
	public String toString() {
		return "[ ��Ź�� ] " + super.toString() + ", ������� : " + dry + " ]";
	}

}
