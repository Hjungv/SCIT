package global.sesoc.ui;

import java.util.ArrayList;
import java.util.Scanner;

import global.sesoc.manager.ToyManagerMgr;
import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

/**
 * 사용자 인터페이스
 */
public class ToyManagerUI {
	Scanner input = new Scanner(System.in);
	ToyManagerMgr manager = new ToyManagerMgr();

	/**
	 * 생성자
	 */

	public ToyManagerUI() {
		int mNum = 0;

		while (true) {
			try {
				mainMenu();
				mNum = inputNum();

				switch (mNum) {
				case 1:
					// 장난감 등록
					insertToy();
					break;
				case 2:
					// 장난감 검색
					selectToy();
					break;
				case 3:
					//장난감 삭제
					deleteToy();
					break;
				case 4:
					// 장난감 수정

				case 5:
					searchByPrice();
					break;
				case 6:
					// 장난감 정보 출력
				case 0:
					System.out.println("데이터 저장 후 프로그램 종료합니다.");
				default:
					System.out.println("오류 >>> 다시 입력해 주세요.");
				}

			} catch (Exception e) {
				System.out.println("오류>>> 다시 입력해 주세요.");
				input.nextLine();
				continue;
			}
		}
	}

	public int inputNum() {
		int result = 0;
		try {
			result = input.nextInt();
		} catch (Exception e) {
			System.out.println("잘못 입력 하셨습니다.");
		} finally {
			input.nextLine();
		}

		return result;

	}

	/**
	 * 주메뉴를 화면에 출력한다.
	 */

	public void mainMenu() {
		System.out.println("\n===== Toy Manager =====");
		System.out.println("1. 장난감 등록");
		System.out.println("2. 장난감 검색");
		System.out.println("3. 장난감 삭제");
		System.out.println("4. 장난감 수정");
		System.out.println("5. 가격대 검색");
		System.out.println("6. 장난감 정보 출력");
		System.out.println("0. 종료");
		System.out.println("======================");
		System.out.println("[ 메뉴 선택 ]");
	}

	/**
	 * 장난감 객체를 저장하기 위해 Toy 객체를 생성한다. 장난감의 종류에 따라 자전거(1. 도로용, 2. 산악용), 드론(날개 갯수),
	 * 게임기(휴대가능 여부)를 입력받는다.
	 *
	 * @param toyType 장난감 종류
	 * @return 생성된 장난감 객체
	 */

	public void insertToy() {

		while (true) {
			System.out.println("===== 장난감 등록 메뉴 =====");
			System.out.println("1. 자전거");
			System.out.println("2. 드론");
			System.out.println("3. 게임기");
			System.out.println("9. 상위메뉴");
			System.out.println("[ 장난감 선택 ]");
			int selectToy = inputNum();

			System.out.println("> 고유번호 : ");
			String serialNum = input.nextLine();

			System.out.println("> 이름 : ");
			String name = input.nextLine();
			System.out.println("> 가격 : ");
			int price = inputNum();

			Toy toy = new Toy();

			if (selectToy == 9) {
				// 상위메뉴로 돌아가기
			} else if (selectToy >= 1 || selectToy <= 3) {
				boolean result = false;
				if (selectToy == 1) {
//					자전거등록
					Bicycle bicycle = new Bicycle();
					System.out.println("> 자전거종류(1. 도로용, 2. 산악용) => ");
					int sc = input.nextInt();
					String type = null;
					if (sc == 1) {
						type = "road";
					} else if (sc == 2) {
						type = "mountain";
					}

					bicycle.setSerialNum(serialNum);
					bicycle.setName(name);
					bicycle.setPrice(price);
					bicycle.setType(type);

					result = manager.insertToy(bicycle);

				} else if (selectToy == 2) {
//					드론등록
					System.out.println(">날개 수 :");
					int wingCount = input.nextInt();

					Drone drone = new Drone();
					drone.setSerialNum(serialNum);
					drone.setName(name);
					drone.setPrice(price);
					drone.setWingCount(wingCount);

					result = manager.insertToy(drone);

				} else if (selectToy == 3) {
//					게임기등록
					System.out.print("> 휴대가능 (미입력시 아니오 > 1. 네 2. 아니오) : ");
					int portableInput = input.nextInt();

					GameConsole console = new GameConsole();
					console.setSerialNum(serialNum);
					console.setName(name);
					console.setPrice(price);

					boolean portableresult = false;
					if (portableInput == 1) {
						portableresult = true;
					} else if (portableInput == 2) {
						portableresult = false;

					}
					console.setPortable(portableresult);

				}

				if (result == true) {
					System.out.println("[알림] 등록 되었습니다.");
					break;
				} else {
					System.out.println("[알림] 등록되지 않았습니다.");
				}

			} else {
				System.out.println("잘못입력");

			}
		}

	}

	/**
	 * 장난감 객체를 등록하기 위한 메뉴를 화면에 출력
	 */

	public void insertMenu() {
		System.out.println("\n ===== 장난감 등록 메뉴 =====");
		System.out.println("1. 자전거");
		System.out.println("2. 드론");
		System.out.println("3. 게임기");
		System.out.println("9. 상위메뉴");
		System.out.println("[ 장난감 종류 선택 ]");
	}

	/**
	 * 고유번호에 해당하는 장난감을 검색하여 화면에 출력한다. 검색이 되지 않을 경우 메시지 출력
	 */
	public void selectToy() {
		System.out.print("> 장난감 고유번호 : ");
		String serialNum = input.nextLine();
		/*
		 * parmater :장난감고유번호 retrun : Toy - 고유번호에 대한 toy값
		 */
		Toy result = manager.searchToy(serialNum);
		System.out.println(result);
	}

	/**
	 * 장난감의 시리얼번호를 입력받아 해당하는 장난감 정보를 삭제한다.
	 */
	public void deleteToy() {
		System.out.println("===== 장난감 삭제 메뉴 =====");
		System.out.print("> 장난감 고유 번호 : ");
		String serialNum = input.nextLine();
		boolean result = manager.deleteToy(serialNum);

		if (result) {
			System.out.println("[ 삭제 성공 ]");
		} else {
			System.out.println("[알림] 삭제되지 않았습니다.");
		}

	}

	public void searchByPrice() {
		System.out.print("> 최소가격 : ");
		int minPrice = inputNum();
		System.out.print("> 최대가격 : ");
		int maxPrice = inputNum();

		ArrayList<Toy> result = manager.toyListForPrice(minPrice, maxPrice);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

//		count = result.size();
//		System.out.println(result.size());
	}

	/**
	 * 장난감 정보를 화면에 출력
	 * 장난감 정보를 출력하고 난 후 검색한 장난감의 개수 출력
	 * 검색이 되지 않을 경우 등록된 장난감이 없다는 메시지 출력
	 */

}
