import java.util.Scanner;

public class BankAccountUI {
	BankAccountManager mng = new BankAccountManager();
	Scanner sc = new Scanner(System.in);

	public BankAccountUI() {
		int i = 1;
		while (i == 1) {
			menu();
			int num = num();

			if (num == 1) {
				// 계좌등록
				accountRegister();

			} else if (num == 2) {
				// 전체계좌출력
				accountList();
			} else if (num == 3) {
				// 입금
				deposit();
			} else if (num == 4) {
				// 출금
			} else if (num == 5) {
				// 송금
			} else if (num == 6) {
				// 종료
				System.out.println("시스템을 종료합니다.");
			}
		}
		i++;
	}

	public int num() {
		int num = 0;
		try {
			num = sc.nextInt();

		} catch (Exception e) {
			System.out.println("잘못 입력 하셨습니다.");
		} finally {
			sc.nextLine();
		}

		return num;
	}

	public void menu() {
		System.out.println("============");
		System.out.println("1. 계좌등록");
		System.out.println("2. 전체계좌보기");
		System.out.println("3. 입금하기");
		System.out.println("4. 출금하기");
		System.out.println("5. 송금하기");
		System.out.println("6. 종료");
		System.out.println("============");
		System.out.print("선택 : ");

	}

	public void accountRegister() {

		System.out.print("등록 할 계좌주 : ");
		String name = sc.nextLine();
		System.out.println("등록 할 계좌번호");
		String accountNo = sc.nextLine();
		System.out.println("등록 할 금액 : ");
		int balance = sc.nextInt();
		
		BankAccountVO vo = new BankAccountVO();
		vo.setName(name);
		vo.setAccountNo(accountNo);
		vo.setBalance(balance);

		boolean result = mng.Registed(vo);
		if (result == true) {
			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록되지 않았습니다.");
		}

	}

	public void accountList() {
		BankAccountVO[] list = mng.getList();
		for (int i = 0; i < mng.index; i++) {
			if (list[i] != null) {
				System.out.println(list[i].toString());
			}
		}
	}
	
	public void deposit() {
		System.out.println("입금");
		System.out.println("입금 할 계좌");
		String accountNo = sc.nextLine();
		System.out.println("입금 할 금액");
		int depositAmount = sc.nextInt();
		mng.searchAccountNo(accountNo, depositAmount);
	}

}
