package test.ui;

import java.util.ArrayList;
import java.util.Scanner;

import board.mgr.BoardManager;
import board.vo.Board;

/**
 * �Խ��� ���α׷��� ����� ȭ��
 */
public class BoardUI {
	private BoardManager mgr = new BoardManager();
	private Scanner sc = new Scanner(System.in); // Ű����κ��� �Է¹ޱ� ���� Ŭ������ ��ü

	/**
	 * ������. �޴�ȭ���� ���� ������� �Է��� �޴´�.
	 */
	public BoardUI() {
		while (true) {
			printMainMenu();
			int menu = sc.nextInt();

			if (menu == 1) {
				// �۾���
				insert();
			} else if (menu == 2) {
				// �� ��ü ���
				list();
			} else if (menu == 3) {
				// �� �б�
				readBoard();
			} else if (menu == 4) {
				// �� ����
				delete();
			} else if (menu == 5) {
				// �� �˻�
				search();
			} else if (menu == 9) {
				// ���α׷� ����
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			} else {
				System.out.println("�ٽ��Է��ϼ���.");
			}
		}

	}

	/**
	 * ���� �޴��� ����Ѵ�.
	 */
	public void printMainMenu() {
		System.out.println("[ �Խ��� ���� ]");
		System.out.println("1. �� ����");
		System.out.println("2. �� ��ü ���");
		System.out.println("3. �� �б�");
		System.out.println("4. �� ����");
		System.out.println("5. �� �˻�");
		System.out.println("9. ���α׷� ����");
		System.out.print("* �޴� ��ȣ�� �����ϼ��� > ");

	}

	/**
	 * �۾���
	 */
	void insert() {
		Board board = new Board();

		sc.nextLine();
		System.out.println("[ �۾��� ] ");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("���� : ");
		String title = sc.nextLine();
		System.out.print("���� : ");
		String content = sc.nextLine();

		board.setName(name);
		board.setTitle(title);
		board.setContent(content);

		boolean insertResult = mgr.insertBoard(board);
		if (insertResult) {
			System.out.println("����Ǿ����ϴ�.");
		} else {
			System.out.println("���忡 �����Ͽ����ϴ�.");
		}

	}

	/**
	 * ��ü �� ���
	 */
	void list() {
		System.out.println("[ �۸�� ]");
		ArrayList<Board> list = mgr.listBoard();

		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("���� �����ϴ�.");
		}

	}

	/**
	 * �� 1�� �б�
	 */
	void readBoard() {
		System.out.println("[ ���б� ]");
		System.out.print("* ���� �� ��ȣ : ");
		int boardnum = sc.nextInt();

		Board board = new Board();

		board = mgr.readBoard(boardnum);

		if (board != null) {
			System.out.println("��ȣ : " + board.getBoardnum());
			System.out.println("�ۼ��� : " + board.getName());
			System.out.println("��ȸ�� : " + board.getHits());
			System.out.println("�ۼ���¥ :" + board.getIndate());
			System.out.println("���� : " + board.getTitle());
			System.out.println("���� : " + board.getContent());
		} else {
			System.out.println("�ش��ȣ�� ���� �����ϴ�.");
		}

	}

	/**
	 * �� 1�� ����
	 */
	void delete() {
		System.out.println(" [ �ۻ��� ] ");
		System.out.print("* ������ �� ��ȣ : ");
		int boardnum = sc.nextInt();

		boolean deleteResult = mgr.deleteBoard(boardnum);

		if (deleteResult) {
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("�ش� ��ȣ�� ���� �����ϴ�.");
		}

	}

	/**
	 * �˻�
	 */
	void search() {
		sc.nextLine();
		System.out.println("[ �۰˻� ]");
		System.out.print("* ������ �Է����ּ��� > ");
		String title = sc.nextLine();

		ArrayList<Board> list = new ArrayList<Board>();
		list = mgr.searchBoard(title);

		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

}
