package global.sesoc.manager;

import java.util.ArrayList;

import global.sesoc.vo.Toy;

public class ToyManagerMgr implements ToyManager {
	private ArrayList<Toy> toList;

	/**
	 * ������
	 */

	public ToyManagerMgr() {
//		���ο� ����Ʈ�� �����Ѵ�
		toList = new ArrayList<Toy>();

	}

	/**
	 * ��ǰ�� �Ϸ� ��ȣ�� �̿��� �ش��ϴ� ��ǰ�� �ִ��� ã�´�.
	 * 
	 * @param serialNum ��ǰ��ȣ
	 * @return ��ǰ��ȣ�� ���� �˻��� ��ǰ ����, �˻��� ������ ���� ��� null�� ���ϵȴ�.
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
	 * ���޹��� Toy ��ü�� List�� �߰�
	 * 
	 * @param list�� �߰��� Toy��ü
	 * @return boolean �߰�����(�߰� ���� �� true, �߰� ���н� false)
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
	 * ��ǰ ��ȣ�� �̿��� �ش� ��ǰ�� ã���� ��� ��ǰ�� ��Ͽ��� �����ϰ� true�� �����Ѵ�. ��ǰ��ȣ�� ã�� ������ ��� false��
	 * �����Ѵ�.
	 * 
	 * @param serialNum
	 * @return boolean ���� ���� ���� (���� �Ϸ� �� true, ���� ���� �� false)
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
	 * ��ǰ ��ȣ�� ������ ���Ե� Toy��ü�� ���޹޾� ����Ʈ���� ã�� ������ �����Ѵ�.
	 * 
	 * @param toy ������ ������ ���Ե� ��ü
	 * @return ���� �Ϸ� ����
	 */

	@Override
	public boolean updateToy(Toy toy) {

		return false;
	}

	/**
	 * �ּұݾװ�, �ִ�ݾ��� ���޹޾� �ش��ϴ� ���� ���޹޾� �� ���������� ������ �峭���� �����Ѵ�.
	 * 
	 * @param �ּҰ�, �ִ밪
	 * @return ������ �ݾ� �ȿ� �����ϴ� �峭���� ���
	 */

	@Override
	public ArrayList<Toy> toyListForPrice(int minPrice, int maxPrice) {
		ArrayList<Toy> result = null;
		for (Toy toy : toList) {
			if ((toy.getPrice() >= minPrice) && (toy.getPrice() <= maxPrice)) {
				result = toList;

			} else {
				System.out.println("[�˸�] ���ǿ� �´� ��ǰ�� �����ϴ�.");
			}
		}

		return result;
	}

	/**
	 * ���޵� Ÿ���� �峭�� ����� ����Ѵ�.
	 * 
	 * @param �峭�� Ÿ��
	 * @return List<Toy> �˻��� �峭�� ���
	 */

	@Override
	public ArrayList<Toy> printToyInfo(int type) {
		// TODO Auto-generated method stub
		return null;
	}

}
