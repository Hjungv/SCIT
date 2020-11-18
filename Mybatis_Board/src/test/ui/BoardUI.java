package test.ui;

import java.util.ArrayList;
import java.util.Scanner;

import board.mgr.BoardManager;
import board.vo.Board;

/**
 * 게시판 프로그램의 사용자 화면
 */
public class BoardUI {
	private BoardManager mgr = new BoardManager();
	private Scanner sc = new Scanner(System.in); // 키보드로부터 입력받기 위한 클래스의 객체

	/**
	 * 생성자. 메뉴화면을 띄우고 사용자의 입력을 받는다.
	 */
	public BoardUI() {
		while (true) {
			printMainMenu();
			int menu = sc.nextInt();

			if (menu == 1) {
				// 글쓰기
				insert();
			} else if (menu == 2) {
				// 글 전체 목록
				list();
			} else if (menu == 3) {
				// 글 읽기
				readBoard();
			} else if (menu == 4) {
				// 글 삭제
				delete();
			} else if (menu == 5) {
				// 글 검색
				search();
			} else if (menu == 9) {
				// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("다시입력하세요.");
			}
		}

	}

	/**
	 * 메인 메뉴를 출력한다.
	 */
	public void printMainMenu() {
		System.out.println("[ 게시판 연습 ]");
		System.out.println("1. 글 쓰기");
		System.out.println("2. 글 전체 목록");
		System.out.println("3. 글 읽기");
		System.out.println("4. 글 삭제");
		System.out.println("5. 글 검색");
		System.out.println("9. 프로그램 종료");
		System.out.print("* 메뉴 번호를 선택하세요 > ");

	}

	/**
	 * 글쓰기
	 */
	void insert() {
		Board board = new Board();

		sc.nextLine();
		System.out.println("[ 글쓰기 ] ");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();

		board.setName(name);
		board.setTitle(title);
		board.setContent(content);

		boolean insertResult = mgr.insertBoard(board);
		if (insertResult) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장에 실패하였습니다.");
		}

	}

	/**
	 * 전체 글 목록
	 */
	void list() {
		System.out.println("[ 글목록 ]");
		ArrayList<Board> list = mgr.listBoard();

		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("글이 없습니다.");
		}

	}

	/**
	 * 글 1개 읽기
	 */
	void readBoard() {
		System.out.println("[ 글읽기 ]");
		System.out.print("* 읽을 글 번호 : ");
		int boardnum = sc.nextInt();

		Board board = new Board();

		board = mgr.readBoard(boardnum);

		if (board != null) {
			System.out.println("번호 : " + board.getBoardnum());
			System.out.println("작성자 : " + board.getName());
			System.out.println("조회수 : " + board.getHits());
			System.out.println("작성날짜 :" + board.getIndate());
			System.out.println("제목 : " + board.getTitle());
			System.out.println("내용 : " + board.getContent());
		} else {
			System.out.println("해당번호의 글이 없습니다.");
		}

	}

	/**
	 * 글 1개 삭제
	 */
	void delete() {
		System.out.println(" [ 글삭제 ] ");
		System.out.print("* 삭제할 글 번호 : ");
		int boardnum = sc.nextInt();

		boolean deleteResult = mgr.deleteBoard(boardnum);

		if (deleteResult) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("해당 번호의 글이 없습니다.");
		}

	}

	/**
	 * 검색
	 */
	void search() {
		sc.nextLine();
		System.out.println("[ 글검색 ]");
		System.out.print("* 제목을 입력해주세요 > ");
		String title = sc.nextLine();

		ArrayList<Board> list = new ArrayList<Board>();
		list = mgr.searchBoard(title);

		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}

}
