package book.ui;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

import book.mgr.BookManager;
import book.vo.BookVO;

/**
 * ���� ���� ����� �������̽�
 */
public class BookUI {

	/**
	 * ���� ���� ó�� ����� ����ϴ� Ŭ������ ��ü
	 */
	BookManager mgr;
	/**
	 * Ű���� �Է� ����� ��ü
	 */
	Scanner scan;

	/**
	 * �⺻ ������ - ���� ��ü ���� ������ BookDAO�� Scanner Ŭ������ ��ü�� �����Ͽ� ����Ѵ�.
	 */
	public BookUI() {
		mgr = new BookManager();
		scan = new Scanner(System.in);

		boolean exit = true;
		while (exit) {

			int menu = printMenu();

			if (menu == 1) {
				// �������� ���
				input();
			} else if (menu == 2) {
				// ��ü��� ���
				output();
			} else if (menu == 3) {
				// �������� ����
				delete();
			} else if (menu == 4) {
				// �������� ����
				update();
			} else if (menu == 5) {
				// �˻�
				search();
			} else if (menu == 6) {
				// ���ǻ纰 �˻�
				search2();
			} else if (menu == 0) {
				// ���α׷� ����
				System.out.println("[�˸�] ���α׷��� �����մϴ�.");
				exit = false;

			} else {
				System.out.println("[�˸�] �ٽ� �Է��ϼ���.");

			}
		}

	}

	/**
	 * �޴� ��� ȭ�� & �޴� ��ȣ �Է�
	 *
	 * @return ����ڰ� �Է��� �޴� ��ȣ
	 */
	public int printMenu() {
		System.out.println("[ ���� ���� ]");
		System.out.println("1. �������� ���");
		System.out.println("2. ��ü��� ���");
		System.out.println("3. �������� ����");
		System.out.println("4. �������� ����");
		System.out.println("5. �˻�");
		System.out.println("6. ���ǻ纰 �˻�");
		System.out.println("0. ���α׷� ����");
		System.out.print(" * ��ȣ���� : ");

		int inputNum = 0;

		try {
			inputNum = scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			printMenu();
		}
		return inputNum;

	}

	/**
	 * �� �������� ��� ȭ��
	 */
	public void input() {
		scan.nextLine();
		System.out.println("[ �� �������� ��� ]");
		System.out.print("���� : ");
		String title = scan.nextLine();
		System.out.print("���� : ");
		String author = scan.nextLine();
		System.out.print("���ǻ� : ");
		String publisher = scan.nextLine();
		System.out.print("���� : ");

		int price = 0;
		try {
			price = scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
		}

		BookVO book = new BookVO();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPrice(price);

		boolean insertResult = mgr.insertBook(book);

		if (insertResult) {
			System.out.println("[�˸�] ����Ǿ����ϴ�.");
		} else {
			System.out.println("[�˸�] ���忡 �����Ͽ����ϴ�.");
		}

	}

	/**
	 * ��ü ������� ��� ȭ��
	 */
	public void output() {
		System.out.println("[ ��ü ������� ]");
		System.out.println("��ȣ" + "\t" + "����" + "\t" + "����" + "\t" + "���ǻ�" + "\t" + "����" + "\t" + "�����");
		System.out.println("===============================================");
		ArrayList<BookVO> list = mgr.listAll();
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("[�˸�] ��ϵ� �����Ͱ� �����ϴ�.");
		}
	}

	/**
	 * ��ȣ�� ���� ���� ȭ��
	 */
	public void delete() {
		System.out.println(" [�������� ���� ]");
		System.out.print("������ ��ȣ : ");

		int bnum = 0;

		try {
			bnum = scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return;
		}

		boolean deleteResult = mgr.deleteBook(bnum);

		if (deleteResult) {
			System.out.println("[�˸�] �����Ǿ����ϴ�.");
		} else {
			System.out.println("[�˸�] ������ �����Ͱ� �����ϴ�.");
		}
	}

	/**
	 * �������� ���� ȭ��
	 */
	public void update() {
		scan.nextLine();
		System.out.println("[ �������� ���� ]");
		System.out.print("������ ������ȣ : ");
		int bnum = 0;
		try {
			bnum = scan.nextInt();

		} catch (Exception e) {
			scan.nextLine();
			return;
		}
		BookVO vo = new BookVO();
		vo = mgr.getBook(bnum);
		boolean updateResult = false;
		if (vo == null) {
			System.out.println("[�˸�] ���� �� �����Ͱ� �����ϴ�.");
		} else if (bnum == vo.getBnum()) {
			System.out.println("* ���� ���� ");
			System.out.println("��ȣ : " + vo.getBnum());
			System.out.println("���� : " + vo.getTitle());
			System.out.println("���� : " + vo.getAuthor());
			System.out.println("���ǻ� : " + vo.getPublisher());
			System.out.println("���� : " + vo.getPrice());
			System.out.println("======================");
			System.out.println("* ������ ����");
			scan.nextLine();
			System.out.print("���� : ");
			String title = scan.nextLine();
			System.out.print("���� : ");
			String author = scan.nextLine();
			System.out.print("���ǻ� : ");
			String publisher = scan.nextLine();
			System.out.print("���� : ");
			int price = 0;
			try {
				price = scan.nextInt();
			} catch (Exception e) {
				scan.nextLine();
				return;
			}

			BookVO bookVo = new BookVO(bnum, title, author, publisher, price);

			updateResult = mgr.updateBook(bookVo);

			if (updateResult) {
				System.out.println("[�˸�] �����Ǿ����ϴ�.");
			}
		}

	}

	/**
	 * �˻� ȭ��
	 */
	public void search() {
		scan.nextLine();
		System.out.println("[ �˻� ]");
		System.out.print("�˻� �� ���� : ");
		String text = scan.nextLine();
		System.out.println("��ȣ" + "\t" + "����" + "\t" + "����" + "\t" + "���ǻ�" + "\t" + "����" + "\t" + "�����");
		System.out.println("===============================================");
		ArrayList<BookVO> list = mgr.searchBook(text);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("[�˸�] �˻� ����� �����ϴ�.");
		}

	}

	/**
	 * ���ǻ纰 �˻� ȭ��
	 */
	public void search2() {
		System.out.println("[ ���ǻ纰 �ּ� ���� �˻� ]");
		System.out.println("���ǻ�" + "\t" + "����");
		System.out.println("=====================");
		ArrayList<BookVO> list = mgr.searchPublisher();
		if (list.size() == 0 || list == null) {
			System.out.println("[�˸�] �˻� ����� �����ϴ�.");
		} else {
			for (BookVO bookVO : list) {
				System.out.println(bookVO.getPublisher() + "\t" + bookVO.getPrice());
			}

		}
	}

}
