package board.mgr;

import java.util.ArrayList;

import board.dao.BoardDAO;
import board.vo.Board;

public class BoardManager {

	private BoardDAO dao = new BoardDAO();

	// 글 저장
	public boolean insertBoard(Board board) {
		boolean result = false;
		int count = dao.insertBoard(board);
		if (count > 0) {
			result = true;

		}
		return result;
	}

	// 글 목록
	public ArrayList<Board> listBoard() {
		ArrayList<Board> list = new ArrayList<Board>();
		list = dao.listBoard();
		return list;

	}

	// 1개의 글 읽고 조회수 증가
	public Board readBoard(int boardnum) {
		Board board = new Board();
		board = dao.readBoard(boardnum);

		return board;
	}

	// 1개의 글삭제
	public boolean deleteBoard(int boardnum) {
		boolean result = false;
		int board = dao.deleteBoard(boardnum);
		if (board > 0) {
			result = true;
		}
		return result;
	}

	//글 검색
	public ArrayList<Board> searchBoard(String title) {
		ArrayList<Board> list = new ArrayList<Board>();
				list = dao.searchBoard(title);
		return list;


	}
}
