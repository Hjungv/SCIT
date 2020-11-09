package denshikiki.manager;

import java.util.ArrayList;

import denshikiki.vo.KikiVO;
import denshikiki.vo.PCVO;
import denshikiki.vo.SentakuVO;

public class KikiManager {

	ArrayList<KikiVO> list = new ArrayList<KikiVO>();

	public boolean register(KikiVO kikivo) {
		boolean resultRegister = false;
		int before = list.size();
		list.add(kikivo);
		int after = list.size();

		if (after > before) {
			resultRegister = true;
		}
		return resultRegister;
	}

	public KikiVO checkSerialNum(int SerialNum) {
		KikiVO resultKikiVO = null;
		for (KikiVO kikiVO : list) {
			if (SerialNum == kikiVO.getSerialNo()) {
				resultKikiVO = kikiVO;
			}

		}
		return resultKikiVO;

	}

	public boolean update(KikiVO kikivo, int modifyNo) {
		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			KikiVO vo = list.get(i);
			if (modifyNo == vo.getSerialNo()) {
				list.set(i, kikivo);
				result = true;
			}
		}

		return result;

	}

	public boolean delete(int serialNum) {
		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			if (serialNum == list.get(i).getSerialNo()) {
				list.remove(i);
				result = true;
			}

		}
		return result;
	}

	public ArrayList<KikiVO> print(int printInput) {
		ArrayList<KikiVO> resultList = new ArrayList<KikiVO>();
		if (printInput == 1) {
			for (int i = 0; i < list.size(); i++) {
				KikiVO vo = list.get(i);
				resultList.add(vo);
			}
		} else if (printInput == 2) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof PCVO) {
					KikiVO vo = list.get(i);
					resultList.add(vo);
				}
			}

		} else if (printInput == 3) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof SentakuVO) {
					KikiVO vo = list.get(i);
					resultList.add(vo);
				}
			}

		}
		return resultList;
	}
}
