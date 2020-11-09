package denshikiki.ui;

import java.util.ArrayList;
import java.util.Scanner;

import denshikiki.manager.KikiManager;
import denshikiki.vo.KikiVO;
import denshikiki.vo.PCVO;
import denshikiki.vo.SentakuVO;

public class KikiUI {
	Scanner input;
	KikiManager manager;

// ������
	public KikiUI() {
		input = new Scanner(System.in);
		manager = new KikiManager();

		while (true) {
			int inputNum = menu();
			if (inputNum == 1) {
				// ����ϱ�
				registerResult();
			} else if (inputNum == 2) {
				// �����ϱ�
				updateResult();
			} else if (inputNum == 3) {
				// �����ϱ�
				deleteResult();
			} else if (inputNum == 4) {
				// ����ϱ�
				printResult();
			} else if (inputNum == 5) {
				// ����

			} else {
				System.out.println("[�˸�] ����");

			}

		}

	}

	public int inputNum() {
		int i = 0;
		try {
			i = input.nextInt();
		} catch (Exception e) {
			System.out.println("[����] ");
		} finally {
			input.nextLine();

		}
		return i;

	}

	public int menu() {
		System.out.println("=============");
		System.out.println("1. ���");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ���");
		System.out.println("0. �ý��� ����");
		System.out.println("=============");
		System.out.println("> ��ȣ�� �����ϼ���: ");
		return inputNum();
	}

	public void registerResult() {
		System.out.println("���ڱ�� ���� > 1. PC 2. ��Ź��");
		int kikiType = inputNum();

		System.out.println("========");
		System.out.print("��ǰ��ȣ :");
		int serialNum = inputNum();
		System.out.print("�귣��� : ");
		String brandName = input.nextLine();
		System.out.print("���� : ");
		int price = inputNum();

		boolean result = false;
		if (kikiType == 1) {
			// PC ���� ���
			System.out.print("PC ���� > (��Ʈ�� / ����ũž) : ");
			String typeSelect = input.nextLine();

			PCVO pcvo = new PCVO();
			pcvo.setSerialNo(serialNum);
			pcvo.setBrand(brandName);
			pcvo.setPrice(price);
			pcvo.setType(typeSelect);
			result = manager.register(pcvo);

		} else if (kikiType == 2) {
			// ��Ź�� ���� �Է�
			System.out.println("��Ź�� �������> (Y / N)");
			String dry = input.nextLine();

			SentakuVO vo = new SentakuVO();
			vo.setSerialNo(serialNum);
			vo.setBrand(brandName);
			vo.setPrice(price);
			vo.setDry(dry);

			result = manager.register(vo);

		}

		if (result == true) {
			System.out.println("[�˸�] ��ϵǾ����ϴ�.");
		} else {
			System.out.println("[�˸�] ��ϵ��� �ʾҽ��ϴ�.");
		}
	}

	public void updateResult() {
		System.out.println("=====");
		System.out.print("������ ��ǰ��ȣ : ");
		int modifyNo = inputNum();
		KikiVO result = manager.checkSerialNum(modifyNo);
		if (result != null) {

			System.out.println("������ ������ �Է��Ͻÿ�");
			System.out.print("��ǰ��ȣ : ");
			int serialNo = inputNum();
			System.out.println("�귣��� : ");
			String brandName = input.nextLine();
			System.out.println("���� : ");
			int price = inputNum();
			boolean updateResult = false;
			if (result instanceof PCVO) {
				System.out.println("PC ���� > (��Ʈ�� / ����ũž) : ");
				String type = input.nextLine();

				PCVO pcvo = new PCVO();
				pcvo.setSerialNo(serialNo);
				pcvo.setBrand(brandName);
				pcvo.setPrice(price);
				pcvo.setType(type);

				updateResult = manager.update(pcvo, modifyNo);

			} else if (result instanceof SentakuVO) {
				System.out.println("������ ��� > (Y / N) : ");
				String dry = input.nextLine();

				SentakuVO sentakuvo = new SentakuVO();
				sentakuvo.setSerialNo(serialNo);
				sentakuvo.setBrand(brandName);
				sentakuvo.setPrice(price);
				sentakuvo.setDry(dry);

				updateResult = manager.update(sentakuvo, modifyNo);
			}

			if (updateResult == true) {
				System.out.println("[�˸�] ������Ʈ �Ǿ����ϴ�.");
			} else {
				System.out.println("[�˸�] ������Ʈ�� �����Ͽ����ϴ�.");
			}

		} else {
			System.out.println("[�˸�] �˻� ����� �����ϴ�.");

		}
	}

	public void deleteResult() {
		System.out.println("������ ��ǰ�� ��ǰ��ȣ�� �Է� : ");
		int serialNum = inputNum();
		boolean result = manager.delete(serialNum);
		if (result == true) {
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("��������");
		}
	}

	public void printResult() {
		System.out.println("1. ��ü��� ");
		System.out.println("2. PC ���");
		System.out.println("3. ��Ź�� ���");
		System.out.println("��ȣ�� �Է�");
		int printInput = inputNum();
		ArrayList<KikiVO> result = manager.print(printInput);
		for(int i=0; i<result.size(); i++) {
			
			System.out.println(result.get(i));
		}

	}
}
