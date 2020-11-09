package global.sesoc.baseball.manager;

import java.util.ArrayList;

import global.sesoc.baseball.vo.Player;

/**
 * 데이터의 처리를 담당
 */
public class BaseballManager implements AbstractBaseballManager {
	/**
	 * 선수 정보를 저장할 리스트
	 */
	private ArrayList<Player> playerList;

	/**
	 * 생성자
	 */
	public BaseballManager() {
		// 기존 저장된 파일이 있으면 열어서 읽는다.
		// 저장된 파일이 없으면 새로운 리스트를 생성한다.

		playerList = new ArrayList<Player>();

	}

//	전달받은 번호를 리스트에서 검색
	@Override
	public Player searchId(String id) {
		Player p = null;

		for (Player player : playerList) {
			if (id.equals(player.getId())) {
				p = player;
			}
		}
		return p;
	}

//	전달받은 Player객체를 리스트에 추가저장
	@Override
	public boolean insertPlayer(Player player) {
		playerList.add(player);
		return false;
	}

//	선수 번호를 이용해 해당 선수 정보를 리스트에서 삭제하고 true를 리턴
	@Override
	public boolean deletePlayer(String id) {
		playerList.remove(id);
		return true;
	}

//	선수 번호와 연봉을 전달받아 해당 선수의 연봉을 수정
	@Override
	public boolean updatePlayer(Player player) {
		player.getSalary();
		
		return false;
	}

//	최소금액과, 최대금액을 전달받아 그 영역사이의 연봉을 받는 선수 목록을 리턴
	@Override
	public ArrayList<Player> playerListForSalary(int minSalary, int maxSalary) {

		return null;
	}

//	war기준으로 가장 높은 선수 목록을 출력, 같은 값이 여려 명일 경우에는 모두
	@Override
	public ArrayList<Player> bestPlayers() {

		return null;
	}

//	전달된 타입의 선수목록을 리턴
	@Override
	public ArrayList<Player> playerListForType(int type) {

		return null;
	}

}
