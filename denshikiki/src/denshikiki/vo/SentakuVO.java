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
		return "[ 세탁기 ] " + super.toString() + ", 건조기능 : " + dry + " ]";
	}

}
