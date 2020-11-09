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
				// ���µ��
				accountRegister();

			} else if (num == 2) {
				// ��ü�������
				accountList();
			} else if (num == 3) {
				// �Ա�
				deposit();
			} else if (num == 4) {
				// ���
			} else if (num == 5) {
				// �۱�
			} else if (num == 6) {
				// ����
				System.out.println("�ý����� �����մϴ�.");
			}
		}
		i++;
	}

	public int num() {
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

	public void menu() {
		System.out.println("============");
		System.out.println("1. ���µ��");
		System.out.println("2. ��ü���º���");
		System.out.println("3. �Ա��ϱ�");
		System.out.println("4. ����ϱ�");
		System.out.println("5. �۱��ϱ�");
		System.out.println("6. ����");
		System.out.println("============");
		System.out.print("���� : ");

	}

	public void accountRegister() {

		System.out.print("��� �� ������ : ");
		String name = sc.nextLine();
		System.out.println("��� �� ���¹�ȣ");
		String accountNo = sc.nextLine();
		System.out.println("��� �� �ݾ� : ");
		int balance = sc.nextInt();
		
		BankAccountVO vo = new BankAccountVO();
		vo.setName(name);
		vo.setAccountNo(accountNo);
		vo.setBalance(balance);

		boolean result = mng.Registed(vo);
		if (result == true) {
			System.out.println("��� �Ǿ����ϴ�.");
		} else {
			System.out.println("��ϵ��� �ʾҽ��ϴ�.");
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
		System.out.println("�Ա�");
		System.out.println("�Ա� �� ����");
		String accountNo = sc.nextLine();
		System.out.println("�Ա� �� �ݾ�");
		int depositAmount = sc.nextInt();
		mng.searchAccountNo(accountNo, depositAmount);
	}

}
