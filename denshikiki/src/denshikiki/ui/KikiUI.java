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

// 생성자
	public KikiUI() {
		input = new Scanner(System.in);
		manager = new KikiManager();

		while (true) {
			int inputNum = menu();
			if (inputNum == 1) {
				// 등록하기
				registerResult();
			} else if (inputNum == 2) {
				// 수정하기
				updateResult();
			} else if (inputNum == 3) {
				// 삭제하기
				deleteResult();
			} else if (inputNum == 4) {
				// 출력하기
				printResult();
			} else if (inputNum == 5) {
				// 종료

			} else {
				System.out.println("[알림] 오류");

			}

		}

	}

	public int inputNum() {
		int i = 0;
		try {
			i = input.nextInt();
		} catch (Exception e) {
			System.out.println("[오류] ");
		} finally {
			input.nextLine();

		}
		return i;

	}

	public int menu() {
		System.out.println("=============");
		System.out.println("1. 등록");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 출력");
		System.out.println("0. 시스템 종료");
		System.out.println("=============");
		System.out.println("> 번호를 선택하세요: ");
		return inputNum();
	}

	public void registerResult() {
		System.out.println("전자기기 종류 > 1. PC 2. 세탁기");
		int kikiType = inputNum();

		System.out.println("========");
		System.out.print("제품번호 :");
		int serialNum = inputNum();
		System.out.print("브랜드명 : ");
		String brandName = input.nextLine();
		System.out.print("가격 : ");
		int price = inputNum();

		boolean result = false;
		if (kikiType == 1) {
			// PC 정보 등록
			System.out.print("PC 종류 > (노트북 / 데스크탑) : ");
			String typeSelect = input.nextLine();

			PCVO pcvo = new PCVO();
			pcvo.setSerialNo(serialNum);
			pcvo.setBrand(brandName);
			pcvo.setPrice(price);
			pcvo.setType(typeSelect);
			result = manager.register(pcvo);

		} else if (kikiType == 2) {
			// 세탁기 정보 입력
			System.out.println("세탁기 건조기능> (Y / N)");
			String dry = input.nextLine();

			SentakuVO vo = new SentakuVO();
			vo.setSerialNo(serialNum);
			vo.setBrand(brandName);
			vo.setPrice(price);
			vo.setDry(dry);

			result = manager.register(vo);

		}

		if (result == true) {
			System.out.println("[알림] 등록되었습니다.");
		} else {
			System.out.println("[알림] 등록되지 않았습니다.");
		}
	}

	public void updateResult() {
		System.out.println("=====");
		System.out.print("수정할 제품번호 : ");
		int modifyNo = inputNum();
		KikiVO result = manager.checkSerialNum(modifyNo);
		if (result != null) {

			System.out.println("변경할 정보를 입력하시오");
			System.out.print("제품번호 : ");
			int serialNo = inputNum();
			System.out.println("브랜드명 : ");
			String brandName = input.nextLine();
			System.out.println("가격 : ");
			int price = inputNum();
			boolean updateResult = false;
			if (result instanceof PCVO) {
				System.out.println("PC 종류 > (노트북 / 데스크탑) : ");
				String type = input.nextLine();

				PCVO pcvo = new PCVO();
				pcvo.setSerialNo(serialNo);
				pcvo.setBrand(brandName);
				pcvo.setPrice(price);
				pcvo.setType(type);

				updateResult = manager.update(pcvo, modifyNo);

			} else if (result instanceof SentakuVO) {
				System.out.println("건조기 기능 > (Y / N) : ");
				String dry = input.nextLine();

				SentakuVO sentakuvo = new SentakuVO();
				sentakuvo.setSerialNo(serialNo);
				sentakuvo.setBrand(brandName);
				sentakuvo.setPrice(price);
				sentakuvo.setDry(dry);

				updateResult = manager.update(sentakuvo, modifyNo);
			}

			if (updateResult == true) {
				System.out.println("[알림] 업데이트 되었습니다.");
			} else {
				System.out.println("[알림] 업데이트에 실패하였습니다.");
			}

		} else {
			System.out.println("[알림] 검색 결과가 없습니다.");

		}
	}

	public void deleteResult() {
		System.out.println("삭제할 제품의 제품번호를 입력 : ");
		int serialNum = inputNum();
		boolean result = manager.delete(serialNum);
		if (result == true) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제실패");
		}
	}

	public void printResult() {
		System.out.println("1. 전체출력 ");
		System.out.println("2. PC 출력");
		System.out.println("3. 세탁기 출력");
		System.out.println("번호를 입력");
		int printInput = inputNum();
		ArrayList<KikiVO> result = manager.print(printInput);
		for(int i=0; i<result.size(); i++) {
			
			System.out.println(result.get(i));
		}

	}
}
