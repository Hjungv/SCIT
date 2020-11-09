import java.util.Scanner;

public class BankAccountUI {
	Scanner sc = new Scanner(System.in);
	BankAccountManager mng = new BankAccountManager();

	public BankAccountUI() {
		while (true) {
			printMenu();
			int menu = inputNum();

			if (menu == 1) {
				// 계좌등록
				accountRegister();
			} else if (menu == 2) {
				// 전체출력
				accountList();
			} else if (menu == 3) {
				// 입금
				deposit();
			} else if (menu == 4) {
				// 출금
				withdrawl();
			} else if (menu == 5) {
				// 송금
				send();
			} else if (menu == 6) {
				// 프로그램종료
				break;
			}
		}
	}

	public int inputNum() {
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

	public void printMenu() {
		System.out.println("=====은행계좌관리====");
		System.out.println("1.계좌등록");
		System.out.println("2.전체출력");
		System.out.println("3.입금");
		System.out.println("4.출금");
		System.out.println("5.송금");
		System.out.println("6.프로그램종료");
		System.out.println("==================");
		System.out.print("선택 : ");
	}

	public void accountRegister() {
		System.out.print("계좌주 이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("계좌 번호 입력 : ");
		String accountNo = sc.nextLine();
		System.out.print("잔고입력 : ");
		int balance = inputNum();

		BankAccountVO vo = new BankAccountVO();
		vo.setName(name);
		vo.setAccountNo(accountNo);
		vo.setBalance(balance);
		boolean result = mng.addAccount(vo);
		if (result == true) {
			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록에 실패하였습니다.");
		}
	}

	public void accountList() {
		System.out.println("전체출력");
		BankAccountVO[] resultGetList = mng.getList();
		for (int i = 0; i < resultGetList.length; i++) {
			if (resultGetList[i] != null) {
				System.out.println(resultGetList[i].toString());
			}
		}
	}

	public void deposit() {
		System.out.println("입금");
		System.out.print("입금 할 계좌번호 입력 : ");
		String accountNo = sc.nextLine();
		System.out.print("입금금액 입력 :");
		int balance = inputNum();
		mng.searchAccount(accountNo, balance);
	}

	public void withdrawl() {
		System.out.println("출금을 할거에용");
		System.out.println("출금 할 계좌번호 입력 :");
		String accountNo = sc.nextLine();
		System.out.println("출금 금액 입력 : ");
		int balance = inputNum();
		mng.lookupAccount(accountNo, balance);
	}

	public void send() {
		System.out.println("송금 할 계좌번호 입력 : ");
		String outAccount = sc.nextLine();
		System.out.println("송금 받을 계좌번호 입력 : ");
		String inAccount = sc.nextLine();
		System.out.println("송금 금액 입력 : ");
		int sendNum = inputNum();
		mng.sendSearch(outAccount, inAccount, sendNum);
	}
}
