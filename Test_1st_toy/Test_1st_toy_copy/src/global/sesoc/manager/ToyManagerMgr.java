package global.sesoc.manager;

import java.util.ArrayList;

import global.sesoc.vo.Toy;

public class ToyManagerMgr implements ToyManager {
	private ArrayList<Toy> toList;

	/**
	 * 생성자
	 */

	public ToyManagerMgr() {
//		새로운 리스트를 생성한다
		toList = new ArrayList<Toy>();

	}

	/**
	 * 제품의 일련 번호를 이용해 해당하는 제품이 있는지 찾는다.
	 * 
	 * @param serialNum 제품번호
	 * @return 제품번호에 의해 검색된 제품 정보, 검색된 내용이 없을 경우 null이 리턴된다.
	 */

	@Override
	public Toy searchToy(String serialNum) {
		Toy result = new Toy();
		for (Toy toy : toList) {
			if (serialNum.equals(toy.getSerialNum())) {
				result = toy;
			}

		}
		return result;
	}

	/**
	 * 전달받은 Toy 객체를 List에 추가
	 * 
	 * @param list에 추가할 Toy객체
	 * @return boolean 추가여부(추가 성공 시 true, 추가 실패시 false)
	 */

	@Override
	public boolean insertToy(Toy toy) {
		boolean result = false;

		int before = toList.size();
		toList.add(toy);
		int after = toList.size();
		if (before < after) {
			result = true;
		}
		return result;
	}

	/**
	 * 제품 번호를 이용해 해당 제품을 찾았을 경우 제품을 목록에서 삭제하고 true를 리턴한다. 제품번호를 찾지 못했을 경우 false를
	 * 리턴한다.
	 * 
	 * @param serialNum
	 * @return boolean 삭제 여부 리턴 (삭제 완료 시 true, 삭제 실패 시 false)
	 */

	@Override
	public boolean deleteToy(String serialNum) {
		boolean result = false;
//		for (int i = 0; i < toList.size(); i++) {
//			if (serialNum.equals(serialNum)) {
//				toList.remove(i);
//				result = true;
//			}
//
//		}

		int i = 0;
		for (Toy toy : toList) {
			if (serialNum.equals(toy.getSerialNum())) {
				toList.remove(i);
				result = true;
			}
			i++;

		}
		return result;
	}

	/**
	 * 제품 번호와 가격이 포함된 Toy객체를 전달받아 리스트에서 찾아 가격을 수정한다.
	 * 
	 * @param toy 수정할 정보가 포함된 객체
	 * @return 수정 완료 여부
	 */

	@Override
	public boolean updateToy(Toy toy) {

		return false;
	}

	/**
	 * 최소금액과, 최대금액을 전달받아 해당하는 값을 전달받아 그 영역사이의 가격인 장난감을 리턴한다.
	 * 
	 * @param 최소값, 최대값
	 * @return 지정한 금액 안에 존재하는 장난감의 목록
	 */

	@Override
	public ArrayList<Toy> toyListForPrice(int minPrice, int maxPrice) {
		ArrayList<Toy> result = null;
		for (Toy toy : toList) {
			if ((toy.getPrice() >= minPrice) && (toy.getPrice() <= maxPrice)) {
				result = toList;

			} else {
				System.out.println("[알림] 조건에 맞는 물품이 없습니다.");
			}
		}

		return result;
	}

	/**
	 * 전달된 타입의 장난감 목록을 출력한다.
	 * 
	 * @param 장난감 타입
	 * @return List<Toy> 검색된 장난감 목록
	 */

	@Override
	public ArrayList<Toy> printToyInfo(int type) {
		// TODO Auto-generated method stub
		return null;
	}

}
