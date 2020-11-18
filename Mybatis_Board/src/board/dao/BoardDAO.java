package board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;

public class BoardDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	// 글 저장
	public int insertBoard(Board board) {
		int count = 0;
		SqlSession ss = null;
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			count = mapper.insertBoard(board);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}

		return count;

	}

	// 글 목록
	public ArrayList<Board> listBoard() {
		ArrayList<Board> list = null;
		SqlSession ss = null;
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			list = mapper.listBoard();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return list;
	}

	// 1개의 글 읽고 조회수 증가
	public Board readBoard(int boardnum) {
		SqlSession ss = null;
		Board board = null;
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			mapper.increaseHit(boardnum);
			board = mapper.readBoard(boardnum);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return board;
	}

	// 1개의 글삭제
	public int deleteBoard(int boardnum) {
		SqlSession ss = null;
		int count = 0;
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			count = mapper.deleteBoard(boardnum);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return count;
	}

	// 글 검색
	public ArrayList<Board> searchBoard(String title) {
		ArrayList<Board> list = null;
		SqlSession ss = null;
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			list = mapper.searchBoard(title);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}

		return list;
	}

}
