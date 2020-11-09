
public class BankAccountManager {
	BankAccountVO[] list;
	int index;

	public BankAccountManager() {
		list = new BankAccountVO[20];
		index = 0;
	}

	public boolean addAccount(BankAccountVO vo) {
		boolean result = false;
		// asIs = 0
		int asIs = index;
		list[index] = vo;
		index++;
		// toBe = 1
		int toBe = index;

		if (toBe > asIs) {
			result = true;
		}
		return result;
	}

	public BankAccountVO[] getList() {
		return list;
	}

	public void searchAccount(String accountNo, int balance) {
		for (int i = 0; i < index; i++) {
			if (accountNo.equals(list[i].getAccountNo())) {
				int temp = list[i].getBalance();
				list[i].setBalance(temp + balance);
				break;
			}
		}
	}

	public void lookupAccount(String accountNo, int balance) {
		for (int i = 0; i < index; i++) {
			if (accountNo.equals(list[i].getAccountNo())) {
				int temp = list[i].getBalance();
				list[i].setBalance(temp - balance);
				break;
			}
		}
	}

	public void sendSearch(String outAccount, String inAccount, int sendNum) {
		for (int i = 0; i < index; i++) {
			if (outAccount.equals(list[i].getAccountNo())) {
				int temp = list[i].getBalance();
				int result = temp - sendNum;
				list[i].setBalance(result);

			}
			//
			if (inAccount.equals(list[i].getAccountNo())) {
				int temp = list[i].getBalance();
				int result = temp + sendNum;
				list[i].setBalance(result);
			}
		}
	}


}
