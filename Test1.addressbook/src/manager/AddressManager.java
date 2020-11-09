package manager;

import java.util.ArrayList;
import vo.AddressVO;

/**
 * 주소 정보 처리 클래스. 등록, 검색, 파일 입출력 등의 기능을 수행
 */
public class AddressManager {
//	등록된 회원 정보를 가지고 있는 list객체
	ArrayList<AddressVO> list;

	/**
	 * 기본 생성자 - 빈 리스트를 생성
	 */
	public AddressManager() {

		list = new ArrayList<AddressVO>();

	}

	/**
	 * 전달된 새 주소를 리스트에 등록한다.
	 *
	 * @param vo 등록할 정보를 담은 객체
	 */
	public void addAddress(AddressVO vo) {
		list.add(vo);
	}

	/**
	 * 전체 주소 정보 리스트를 리턴한다.
	 *
	 * @return 주소정보 객체들이 저장된 리스트
	 */
	public ArrayList<AddressVO> getList() {

		return list;
	}

	/**
	 * 이름으로 주소 정보 검색
	 *
	 * @param name 검색할 이름
	 * @return 검색된 객체 또는 없으면 null
	 */
	public AddressVO getAddress(String name) {
		AddressVO vo = null;
//		for (int i = 0; i < list.size(); i++) {
////			저장된 리스트의 객체 정보 중 이름을 꺼내서 입력된 이름과 같은지를 비교하는 구문
//			//vo = list.get(i);
////			String savedName = list.get(i).getName();
//			if (name.equals(list.get(i).getName())) {
//				vo = list.get(i);
//				break;
//
//			}
//		}

		for (AddressVO addressVO : list) {
//			String savedName = addressVO.getName();
			if (name.equals(addressVO.getName())) {
				vo = addressVO;
				break;
			}
		}
		return vo;
	}

	/**
	 * 그룹으로 주소 정보 검색
	 *
	 * @param group 검색할 그룹
	 * @return 검색된 객체들을 담은 리스트
	 */
	public ArrayList<AddressVO> getGroupList(String group) {

		ArrayList<AddressVO> result = new ArrayList<AddressVO>();

//		for (int i = 0; i < list.size(); i++) {
//			String savedGroup = list.get(i).getGroup();
//			if (group.equals(savedGroup)) {
//				result.add(list.get(i));
//			}
		for (AddressVO addressVO : list) {
			if (group.equals(addressVO.getGroup())) {
				result.add(addressVO);

			}
		}
		return result;
	}
//	}

	/**
	 * 이름으로 주소 정보 삭제
	 *
	 * @param name 삭제할 이름
	 * @return 삭제 성공 여부
	 */
	public boolean removeAddress(String name) {
		boolean result = false;

//		for (int i = 0; i < list.size(); i++) {
////			AddressVO vo = list.get(i);
////			String savedName = vo.getName();
//
//			if (name.equals(list.get(i).getName())) {
//				list.remove(list.get(i));
//				result = true;
//
//			}
//		}

		int count = 0;
		for (AddressVO addressVO : list) {
			if(name.equals(addressVO.getName())) {
				//list.remove(addressVO);
				list.remove(count);
				//list.re
				result = true;
			}
			count++;
		}
		return result;
	}

}
