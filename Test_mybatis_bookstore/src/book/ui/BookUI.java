package book.ui;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

import book.mgr.BookManager;
import book.vo.BookVO;

/**
 * 서점 관리 사용자 인터페이스
 */
public class BookUI {

	/**
	 * 도서 정보 처리 기능을 담당하는 클래스의 객체
	 */
	BookManager mgr;
	/**
	 * 키보드 입력 기능의 객체
	 */
	Scanner scan;

	/**
	 * 기본 생성자 - 현재 객체 최초 생성시 BookDAO와 Scanner 클래스의 객체를 생성하여 사용한다.
	 */
	public BookUI() {
		mgr = new BookManager();
		scan = new Scanner(System.in);

		boolean exit = true;
		while (exit) {

			int menu = printMenu();

			if (menu == 1) {
				// 도서정보 등록
				input();
			} else if (menu == 2) {
				// 전체목록 출력
				output();
			} else if (menu == 3) {
				// 도서정보 삭제
				delete();
			} else if (menu == 4) {
				// 도서정보 수정
				update();
			} else if (menu == 5) {
				// 검색
				search();
			} else if (menu == 6) {
				// 출판사별 검색
				search2();
			} else if (menu == 0) {
				// 프로그램 종료
				System.out.println("[알림] 프로그램을 종료합니다.");
				exit = false;

			} else {
				System.out.println("[알림] 다시 입력하세요.");

			}
		}

	}

	/**
	 * 메뉴 출력 화면 & 메뉴 번호 입력
	 *
	 * @return 사용자가 입력한 메뉴 번호
	 */
	public int printMenu() {
		System.out.println("[ 서점 관리 ]");
		System.out.println("1. 도서정보 등록");
		System.out.println("2. 전체목록 출력");
		System.out.println("3. 도서정보 삭제");
		System.out.println("4. 도서정보 수정");
		System.out.println("5. 검색");
		System.out.println("6. 출판사별 검색");
		System.out.println("0. 프로그램 종료");
		System.out.print(" * 번호선택 : ");

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
	 * 새 도서정보 등록 화면
	 */
	public void input() {
		scan.nextLine();
		System.out.println("[ 새 도서정보 등록 ]");
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("저자 : ");
		String author = scan.nextLine();
		System.out.print("출판사 : ");
		String publisher = scan.nextLine();
		System.out.print("가격 : ");

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
			System.out.println("[알림] 저장되었습니다.");
		} else {
			System.out.println("[알림] 저장에 실패하였습니다.");
		}

	}

	/**
	 * 전체 도서목록 출력 화면
	 */
	public void output() {
		System.out.println("[ 전체 도서목록 ]");
		System.out.println("번호" + "\t" + "제목" + "\t" + "저자" + "\t" + "출판사" + "\t" + "가격" + "\t" + "등록일");
		System.out.println("===============================================");
		ArrayList<BookVO> list = mgr.listAll();
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("[알림] 등록된 데이터가 없습니다.");
		}
	}

	/**
	 * 번호로 정보 삭제 화면
	 */
	public void delete() {
		System.out.println(" [도서정보 삭제 ]");
		System.out.print("삭제할 번호 : ");

		int bnum = 0;

		try {
			bnum = scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return;
		}

		boolean deleteResult = mgr.deleteBook(bnum);

		if (deleteResult) {
			System.out.println("[알림] 삭제되었습니다.");
		} else {
			System.out.println("[알림] 삭제할 데이터가 없습니다.");
		}
	}

	/**
	 * 도서정보 수정 화면
	 */
	public void update() {
		scan.nextLine();
		System.out.println("[ 도서정보 수정 ]");
		System.out.print("수정할 도서번호 : ");
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
			System.out.println("[알림] 수정 할 데이터가 없습니다.");
		} else if (bnum == vo.getBnum()) {
			System.out.println("* 기존 정보 ");
			System.out.println("번호 : " + vo.getBnum());
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("저자 : " + vo.getAuthor());
			System.out.println("출판사 : " + vo.getPublisher());
			System.out.println("가격 : " + vo.getPrice());
			System.out.println("======================");
			System.out.println("* 수정할 정보");
			scan.nextLine();
			System.out.print("제목 : ");
			String title = scan.nextLine();
			System.out.print("저자 : ");
			String author = scan.nextLine();
			System.out.print("출판사 : ");
			String publisher = scan.nextLine();
			System.out.print("가격 : ");
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
				System.out.println("[알림] 수정되었습니다.");
			}
		}

	}

	/**
	 * 검색 화면
	 */
	public void search() {
		scan.nextLine();
		System.out.println("[ 검색 ]");
		System.out.print("검색 할 제목 : ");
		String text = scan.nextLine();
		System.out.println("번호" + "\t" + "제목" + "\t" + "저자" + "\t" + "출판사" + "\t" + "가격" + "\t" + "등록일");
		System.out.println("===============================================");
		ArrayList<BookVO> list = mgr.searchBook(text);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("[알림] 검색 결과가 없습니다.");
		}

	}

	/**
	 * 출판사별 검색 화면
	 */
	public void search2() {
		System.out.println("[ 출판사별 최소 가격 검색 ]");
		System.out.println("출판사" + "\t" + "가격");
		System.out.println("=====================");
		ArrayList<BookVO> list = mgr.searchPublisher();
		if (list.size() == 0 || list == null) {
			System.out.println("[알림] 검색 결과가 없습니다.");
		} else {
			for (BookVO bookVO : list) {
				System.out.println(bookVO.getPublisher() + "\t" + bookVO.getPrice());
			}

		}
	}

}
