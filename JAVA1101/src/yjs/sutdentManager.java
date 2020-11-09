package yjs;

import java.util.ArrayList;
import java.util.List;

public class sutdentManager implements sutdentManagerInterface {
	List<studentVO> DBdata;

	public sutdentManager() {
		DBdata = new ArrayList<studentVO>();
	}

	public boolean insertStudentData(studentVO studentVO) {
		// 데이터가 저장되면 true
		return true;
	}

	public int insertStudentData(String name, int age) {
		// 데이터가 저장되면 1
		return 1;
	}

	public String searchStudentData(String name) {
		return null;
	}

}
