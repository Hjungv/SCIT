import java.util.Scanner;

public class BankAccountUI {
	Scanner sc = new Scanner(System.in);
	BankAccountManager mng = new BankAccountManager();

	public BankAccountUI() {
		while (true) {
			printMenu();
			int menu = inputNum();

			if (menu == 1) {
				// ���µ��
				accountRegister();
			} else if (menu == 2) {
				// ��ü���
				accountList();
			} else if (menu == 3) {
				// �Ա�
				deposit();
			} else if (menu == 4) {
				// ���
				withdrawl();
			} else if (menu == 5) {
				// �۱�
				send();
			} else if (menu == 6) {
				// ���α׷�����
				break;
			}
		}
	}

	public int inputNum() {
		int num = 0;

		try {
			num = sc.nextInt();
		} catch (Exception e) {
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
		} finally {
			sc.nextLine();
		}
		return num;
	}

	public void printMenu() {
		System.out.println("=====������°���====");
		System.out.println("1.���µ��");
		System.out.println("2.��ü���");
		System.out.println("3.�Ա�");
		System.out.println("4.���");
		System.out.println("5.�۱�");
		System.out.println("6.���α׷�����");
		System.out.println("==================");
		System.out.print("���� : ");
	}

	public void accountRegister() {
		System.out.print("������ �̸� �Է� : ");
		String name = sc.nextLine();
		System.out.print("���� ��ȣ �Է� : ");
		String accountNo = sc.nextLine();
		System.out.print("�ܰ��Է� : ");
		int balance = inputNum();

		BankAccountVO vo = new BankAccountVO();
		vo.setName(name);
		vo.setAccountNo(accountNo);
		vo.setBalance(balance);
		boolean result = mng.addAccount(vo);
		if (result == true) {
			System.out.println("��� �Ǿ����ϴ�.");
		} else {
			System.out.println("��Ͽ� �����Ͽ����ϴ�.");
		}
	}

	public void accountList() {
		System.out.println("��ü���");
		BankAccountVO[] resultGetList = mng.getList();
		for (int i = 0; i < resultGetList.length; i++) {
			if (resultGetList[i] != null) {
				System.out.println(resultGetList[i].toString());
			}
		}
	}

	public void deposit() {
		System.out.println("�Ա�");
		System.out.print("�Ա� �� ���¹�ȣ �Է� : ");
		String accountNo = sc.nextLine();
		System.out.print("�Աݱݾ� �Է� :");
		int balance = inputNum();
		mng.searchAccount(accountNo, balance);
	}

	public void withdrawl() {
		System.out.println("����� �Ұſ���");
		System.out.println("��� �� ���¹�ȣ �Է� :");
		String accountNo = sc.nextLine();
		System.out.println("��� �ݾ� �Է� : ");
		int balance = inputNum();
		mng.lookupAccount(accountNo, balance);
	}

	public void send() {
		System.out.println("�۱� �� ���¹�ȣ �Է� : ");
		String outAccount = sc.nextLine();
		System.out.println("�۱� ���� ���¹�ȣ �Է� : ");
		String inAccount = sc.nextLine();
		System.out.println("�۱� �ݾ� �Է� : ");
		int sendNum = inputNum();
		mng.sendSearch(outAccount, inAccount, sendNum);
	}
}
