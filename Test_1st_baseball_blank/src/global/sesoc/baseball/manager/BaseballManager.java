package global.sesoc.baseball.manager;

import java.util.ArrayList;

import global.sesoc.baseball.vo.Player;

/**
 * �������� ó���� ���
 */
public class BaseballManager implements AbstractBaseballManager {
	/**
	 * ���� ������ ������ ����Ʈ
	 */
	private ArrayList<Player> playerList;

	/**
	 * ������
	 */
	public BaseballManager() {
		// ���� ����� ������ ������ ��� �д´�.
		// ����� ������ ������ ���ο� ����Ʈ�� �����Ѵ�.

		playerList = new ArrayList<Player>();

	}

//	���޹��� ��ȣ�� ����Ʈ���� �˻�
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

//	���޹��� Player��ü�� ����Ʈ�� �߰�����
	@Override
	public boolean insertPlayer(Player player) {
		playerList.add(player);
		return false;
	}

//	���� ��ȣ�� �̿��� �ش� ���� ������ ����Ʈ���� �����ϰ� true�� ����
	@Override
	public boolean deletePlayer(String id) {
		playerList.remove(id);
		return true;
	}

//	���� ��ȣ�� ������ ���޹޾� �ش� ������ ������ ����
	@Override
	public boolean updatePlayer(Player player) {
		player.getSalary();
		
		return false;
	}

//	�ּұݾװ�, �ִ�ݾ��� ���޹޾� �� ���������� ������ �޴� ���� ����� ����
	@Override
	public ArrayList<Player> playerListForSalary(int minSalary, int maxSalary) {

		return null;
	}

//	war�������� ���� ���� ���� ����� ���, ���� ���� ���� ���� ��쿡�� ���
	@Override
	public ArrayList<Player> bestPlayers() {

		return null;
	}

//	���޵� Ÿ���� ��������� ����
	@Override
	public ArrayList<Player> playerListForType(int type) {

		return null;
	}

}
