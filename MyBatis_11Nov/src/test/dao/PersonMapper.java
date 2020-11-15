package test.dao;

import java.util.ArrayList;

import test.vo.PersonVO;

public interface PersonMapper {
//	실행한 sql 구문이 insert, udate, delete일 경우 실행된 횟수를 return 해준다
//	올바르게 실행된 횟수를 돌려줌
//	void 를 int 로 변경
	public int insertPerson(PersonVO person);
	public ArrayList<PersonVO> selectPerson();
	public PersonVO selectOnePerson(int num);
	public int deletePerson(int num);
}
