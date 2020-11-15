package test.dao;

import test.vo.Person;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface PersonMapper {
	// Person객체 저장
	// DAO에서 여기로 넘어오고 구현은 personMapper.xml 에서 됨
	public int insertPerson(Person p);

}
