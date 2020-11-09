package manager;

import java.util.ArrayList;
import vo.AddressVO;

/**
 * �ּ� ���� ó�� Ŭ����. ���, �˻�, ���� ����� ���� ����� ����
 */
public class AddressManager {
//	��ϵ� ȸ�� ������ ������ �ִ� list��ü
	ArrayList<AddressVO> list;

	/**
	 * �⺻ ������ - �� ����Ʈ�� ����
	 */
	public AddressManager() {

		list = new ArrayList<AddressVO>();

	}

	/**
	 * ���޵� �� �ּҸ� ����Ʈ�� ����Ѵ�.
	 *
	 * @param vo ����� ������ ���� ��ü
	 */
	public void addAddress(AddressVO vo) {
		list.add(vo);
	}

	/**
	 * ��ü �ּ� ���� ����Ʈ�� �����Ѵ�.
	 *
	 * @return �ּ����� ��ü���� ����� ����Ʈ
	 */
	public ArrayList<AddressVO> getList() {

		return list;
	}

	/**
	 * �̸����� �ּ� ���� �˻�
	 *
	 * @param name �˻��� �̸�
	 * @return �˻��� ��ü �Ǵ� ������ null
	 */
	public AddressVO getAddress(String name) {
		AddressVO vo = null;
//		for (int i = 0; i < list.size(); i++) {
////			����� ����Ʈ�� ��ü ���� �� �̸��� ������ �Էµ� �̸��� �������� ���ϴ� ����
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
	 * �׷����� �ּ� ���� �˻�
	 *
	 * @param group �˻��� �׷�
	 * @return �˻��� ��ü���� ���� ����Ʈ
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
	 * �̸����� �ּ� ���� ����
	 *
	 * @param name ������ �̸�
	 * @return ���� ���� ����
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
