
public class BankAccountVO {
	private String name;
	private String accountNo;
	private int balance;

	public BankAccountVO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "∞Ë¡¬¡÷ : " + name + ", ∞Ë¡¬π¯»£ : " + accountNo + ", ¿‹∞Ì : " + balance;
	}

}
