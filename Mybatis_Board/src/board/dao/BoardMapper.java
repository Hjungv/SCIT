package board.dao;

import java.util.ArrayList;

import board.vo.Board;

/**
 * Mapper XML의 SQL문 사용 메서드
 */
public interface BoardMapper {
	// 글 저장
	public int insertBoard(Board board);
	// 글 목록
	public ArrayList<Board> listBoard();
	// 글 읽기
	public Board readBoard(int boardnum);
	// 글의 조회수 증가
	public void increaseHit(int boardnum);
	// 글 삭제
	public int deleteBoard(int boardnum);
	// 글 검색
	public ArrayList<Board> searchBoard(String title);
}
