package global.sesoc.baseball.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import global.sesoc.baseball.manager.BaseballManager;
import global.sesoc.baseball.vo.Batter;
import global.sesoc.baseball.vo.Pitcher;
import global.sesoc.baseball.vo.Player;

/**
 * 사용자 인터페이스
 */
public class BaseballUI {
	Scanner input = new Scanner(System.in);
	BaseballManager manager = new BaseballManager();

	/**
	 * 생성자
	 */
	public BaseballUI() {
		int menuNum = 0;

		// 프로그램 종료시까지 무한 반복
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
					System.out.println("[오류] 다시 선택하세요.");
				}
				System.out.println("[오류] 입력형식이 잘못되었습니다.");
			}

		}
	}

	/**
	 * 메인 메뉴 출력
	 */
	public void printMainMenu() {
		System.out.println("[야구 선수 정보 관리]");
		System.out.println("1. 선수 정보 입력");
		System.out.println("2. 선수 정보 삭제");
		System.out.println("3. 선수 정보 수정");
		System.out.println("4. 검색");
		System.out.println("0. 프로그램 종료");
		System.out.print("** 번호 선택 >");

	}

	/**
	 * 선수 정보 입력
	 */
	public void add() {
		System.out.println("1. 투수");
		System.out.println("2. 타자");
		System.out.print("** 선수 구분 선택 >");
		int menuNum = input.nextInt();
		if (menuNum == 1) {
			input.nextLine();
			System.out.print("선수 고유 번호 >");
			String id = input.nextLine();
			Player p = manager.searchId(id);
			if (p == null) {
				System.out.print("선수 이름 >");
				String name = input.nextLine();
				System.out.print("소속팀 >");
				String team = input.nextLine();
				System.out.print("연봉 >");
				int salary = input.nextInt();
				System.out.print("war >");
				double war = input.nextFloat();
				System.out.print("평균 자책 >");
				int era = input.nextInt();
				System.out.println("이닝 >");
				int inning = input.nextInt();
				System.out.print("승 >");
				int wins = input.nextInt();
				System.out.print("패 >");
				int losses = input.nextInt();
				System.out.print("세이브 >");
				int save = input.nextInt();
				System.out.print("홀드 >");
				int hold = input.nextInt();

//				입력된 정보를 등록하는 기능을 실행
				Pitcher param = new Pitcher(id, name, team, salary, war, era, inning, wins, losses, save, hold);
				manager.insertPlayer(param);
				System.out.println("[정보] 저장되었습니다.");
			} else {

				System.out.println("[오류] 이미 존재하는 번호입니다.");
			}
		} else if (menuNum == 2) {
			input.nextLine();
			System.out.print("선수 고유 번호 >");
			String id = input.nextLine();
			Player p = manager.searchId(id);
			if (p == null) {
				System.out.print("선수 이름 >");
				String name = input.nextLine();
				System.out.print("소속팀 >");
				String team = input.nextLine();
				System.out.print("연봉 >");
				int salary = input.nextInt();
				System.out.print("war >");
				double war = input.nextFloat();
				System.out.print("평균 자책 >");
				int era = input.nextInt();
				System.out.print("이닝 >");
				int inning = input.nextInt();
				System.out.print("승 >");
				int wins = input.nextInt();
				System.out.print("패 >");
				int losses = input.nextInt();
				System.out.print("세이브 >");
				int save = input.nextInt();
				System.out.print("홀드 >");
				int hold = input.nextInt();

//				입력된 정보를 등록하는 기능
				Pitcher param = new Pitcher(id, name, team, salary, war, era, inning, wins, losses, save, hold);
				manager.insertPlayer(param);
				System.out.println("[정보] 저장되었습니다.");
			} else {
				System.out.println("[오류] 이미 존재하는 번호입니다.");
			}

		} else {
			System.out.println("[정보] 잘못 입력하셨습니다.");
		}

	}

	/**
	 * 선수 정보 삭제
	 */
	public void delete() {
		input.nextLine();
		System.out.print("[ 선수 삭제 ]");
		System.out.print("** 삭제할 선수 번호 > ");
		String id = input.nextLine();
		Player p = manager.searchId(id);
		if (p == null) {
			System.out.println("[정보] 삭제 대상이 존재하지 않습니다.");
		} else {
			manager.deletePlayer(id);
			System.out.println("[정보] 삭제되었습니다.");
		}

	}

	/**
	 * 선수 정보 수정
	 */
	public void update() {
		input.nextLine();
		System.out.println("[ 선수 삭제 ]");
		System.out.print("** 수정할 선수 번호 > ");
		String pNum = input.nextLine();
		Player p = manager.searchId(pNum);
		if (p == null) {
			System.out.println("[오류] 해당 번호의 선수 정보가 없습니다.");
		} else {
			System.out.print("** 수정할 선수 연봉> ");
			int salary = input.nextInt();
			manager.updatePlayer(p);
			System.out.println("[정보] 수정되었습니다.");
			System.out.println(p);

		}

	}

	/**
	 * 선수 정보 검색
	 */
	public void search() {

	}

	// 목록 출력
	public void print(ArrayList<Player> list) {

	}

	/**
	 * 프로그램 종료
	 */
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}

}
