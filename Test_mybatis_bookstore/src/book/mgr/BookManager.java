package book.mgr;

import java.util.ArrayList;

import book.dao.BookDAO;
import book.vo.BookVO;

public class BookManager {

	BookDAO dao = new BookDAO();

	/**
	 * �������� ����
	 *
	 * @param vo ������ ���� ����
	 * @return ���� ���� ����
	 */
	public boolean insertBook(BookVO vo) {
		boolean check = false;
		int insertResult = dao.insertBook(vo);
		if (insertResult > 0) {
			check = true;
		}
		return check;
	}

	/**
	 * ��ü ���� ��� �б�
	 *
	 * @return ���� ���
	 */
	public ArrayList<BookVO> listAll() {
		return dao.listAll();
	}

//	/**
//	 * ��ȣ�� �������� �б�
//	 * @param bnum �˻��� ��ȣ
//	 * @return ���� ����
//	 */
	public BookVO getBook(int bnum) {
		return dao.getBook(bnum);
	}

//	/**
//	 * ��ȣ�� �����ϱ�
//	 * @param bnum ������ ��ȣ
//	 * @return ���� ���� ����
//	 */
	public boolean deleteBook(int bnum) {
		boolean check = false;
		int deleteResult = dao.deleteBook(bnum);
		if (deleteResult > 0) {
			check = true;
		}
		return check;
	}

//	/**
//	 * ��ȣ�� ���� ���� �����ϱ�
//	 * @param vo ������ ������ ��� ��ü
//	 * @return ���� ���� ����
//	 */
	public boolean updateBook(BookVO bookVo) {
		boolean updateResult = false;
		int updateCount = dao.updateBook(bookVo);
		if (updateCount > 0) {
			updateResult = true;
		}
		return updateResult;
	}

//	/**
//	 * �˻��ϱ�
//	 * @param text �˻���
//	 * @return �˻� ���
//	 */
	public ArrayList<BookVO> searchBook(String text) {
		return dao.searchBook(text);
	}

//	/**
//	 * ���ǻ纰 �˻��ϱ�
//	 * @return �˻� ���
//	 */
	public ArrayList<BookVO> searchPublisher(){
		return dao.searchPublisher();
	}
}
