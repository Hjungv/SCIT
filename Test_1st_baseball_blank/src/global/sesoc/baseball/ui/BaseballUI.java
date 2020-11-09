package global.sesoc.baseball.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import global.sesoc.baseball.manager.BaseballManager;
import global.sesoc.baseball.vo.Batter;
import global.sesoc.baseball.vo.Pitcher;
import global.sesoc.baseball.vo.Player;

/**
 * ����� �������̽�
 */
public class BaseballUI {
	Scanner input = new Scanner(System.in);
	BaseballManager manager = new BaseballManager();

	/**
	 * ������
	 */
	public BaseballUI() {
		int menuNum = 0;

		// ���α׷� ����ñ��� ���� �ݺ�
		while (true) {

			printMainMenu();
			menuNum = input.nextInt();

			switch (menuNum) {
			case 1:
				add();
				break;

			case 2:
				delete();
				break;

			case 3:
				update();
				break;

			case 4:
				search();
				break;

			case 0:
				exit();

			default:
				if (menuNum < 0 || menuNum >= 5) {
					System.out.println("[����] �ٽ� �����ϼ���.");
				}
				System.out.println("[����] �Է������� �߸��Ǿ����ϴ�.");
			}

		}
	}

	/**
	 * ���� �޴� ���
	 */
	public void printMainMenu() {
		System.out.println("[�߱� ���� ���� ����]");
		System.out.println("1. ���� ���� �Է�");
		System.out.println("2. ���� ���� ����");
		System.out.println("3. ���� ���� ����");
		System.out.println("4. �˻�");
		System.out.println("0. ���α׷� ����");
		System.out.print("** ��ȣ ���� >");

	}

	/**
	 * ���� ���� �Է�
	 */
	public void add() {
		System.out.println("1. ����");
		System.out.println("2. Ÿ��");
		System.out.print("** ���� ���� ���� >");
		int menuNum = input.nextInt();
		if (menuNum == 1) {
			input.nextLine();
			System.out.print("���� ���� ��ȣ >");
			String id = input.nextLine();
			Player p = manager.searchId(id);
			if (p == null) {
				System.out.print("���� �̸� >");
				String name = input.nextLine();
				System.out.print("�Ҽ��� >");
				String team = input.nextLine();
				System.out.print("���� >");
				int salary = input.nextInt();
				System.out.print("war >");
				double war = input.nextFloat();
				System.out.print("��� ��å >");
				int era = input.nextInt();
				System.out.println("�̴� >");
				int inning = input.nextInt();
				System.out.print("�� >");
				int wins = input.nextInt();
				System.out.print("�� >");
				int losses = input.nextInt();
				System.out.print("���̺� >");
				int save = input.nextInt();
				System.out.print("Ȧ�� >");
				int hold = input.nextInt();

//				�Էµ� ������ ����ϴ� ����� ����
				Pitcher param = new Pitcher(id, name, team, salary, war, era, inning, wins, losses, save, hold);
				manager.insertPlayer(param);
				System.out.println("[����] ����Ǿ����ϴ�.");
			} else {

				System.out.println("[����] �̹� �����ϴ� ��ȣ�Դϴ�.");
			}
		} else if (menuNum == 2) {
			input.nextLine();
			System.out.print("���� ���� ��ȣ >");
			String id = input.nextLine();
			Player p = manager.searchId(id);
			if (p == null) {
				System.out.print("���� �̸� >");
				String name = input.nextLine();
				System.out.print("�Ҽ��� >");
				String team = input.nextLine();
				System.out.print("���� >");
				int salary = input.nextInt();
				System.out.print("war >");
				double war = input.nextFloat();
				System.out.print("��� ��å >");
				int era = input.nextInt();
				System.out.print("�̴� >");
				int inning = input.nextInt();
				System.out.print("�� >");
				int wins = input.nextInt();
				System.out.print("�� >");
				int losses = input.nextInt();
				System.out.print("���̺� >");
				int save = input.nextInt();
				System.out.print("Ȧ�� >");
				int hold = input.nextInt();

//				�Էµ� ������ ����ϴ� ���
				Pitcher param = new Pitcher(id, name, team, salary, war, era, inning, wins, losses, save, hold);
				manager.insertPlayer(param);
				System.out.println("[����] ����Ǿ����ϴ�.");
			} else {
				System.out.println("[����] �̹� �����ϴ� ��ȣ�Դϴ�.");
			}

		} else {
			System.out.println("[����] �߸� �Է��ϼ̽��ϴ�.");
		}

	}

	/**
	 * ���� ���� ����
	 */
	public void delete() {
		input.nextLine();
		System.out.print("[ ���� ���� ]");
		System.out.print("** ������ ���� ��ȣ > ");
		String id = input.nextLine();
		Player p = manager.searchId(id);
		if (p == null) {
			System.out.println("[����] ���� ����� �������� �ʽ��ϴ�.");
		} else {
			manager.deletePlayer(id);
			System.out.println("[����] �����Ǿ����ϴ�.");
		}

	}

	/**
	 * ���� ���� ����
	 */
	public void update() {
		input.nextLine();
		System.out.println("[ ���� ���� ]");
		System.out.print("** ������ ���� ��ȣ > ");
		String pNum = input.nextLine();
		Player p = manager.searchId(pNum);
		if (p == null) {
			System.out.println("[����] �ش� ��ȣ�� ���� ������ �����ϴ�.");
		} else {
			System.out.print("** ������ ���� ����> ");
			int salary = input.nextInt();
			manager.updatePlayer(p);
			System.out.println("[����] �����Ǿ����ϴ�.");
			System.out.println(p);

		}

	}

	/**
	 * ���� ���� �˻�
	 */
	public void search() {

	}

	// ��� ���
	public void print(ArrayList<Player> list) {

	}

	/**
	 * ���α׷� ����
	 */
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}

}
