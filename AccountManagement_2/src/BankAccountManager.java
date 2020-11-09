
public class BankAccountManager {
	BankAccountVO[] list;
	int index;
	
	public BankAccountManager() {
		list = new BankAccountVO[10];
		index=0;
	}

	public boolean Registed(BankAccountVO vo) {
		 
		boolean result = false;
		int asIs = index;  
		list[index]= vo;
		index++;
		
		int toBe = index; 
		
		if(toBe >asIs) {
			result = true;
		}
		return result;
		
	}

	public BankAccountVO[] getList() {
		return list;
	}

	public void searchAccountNo(String accountNo, int depositAmount) {
		//입력계좌번호와 등록된 계좌번호를 비교함
		BankAccountVO vo = new BankAccountVO();
		for(int i=0; i<list.length; i++) {
		if(accountNo.equals(vo.getAccountNo())) {
			int temp = vo.getBalance();
			
		}
		}
	}
	
}
