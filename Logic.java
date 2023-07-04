package yacht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Logic {
	public final static int DICE = 5;
	public int diceCnt = 0;
	ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

	public void start(Player player) {
		String select = "";
		player.resetBoard();
		System.out.println("시작합니다");


		while (!(player.boardCnt >= 13)) {
			System.out.println("남은 횟수 : " + (12 - player.boardCnt));
			Scanner sc = new Scanner(System.in);

			while (!(diceCnt >= 3)) {
				select = diceSelect(sc);
				if(select.equals("s")) {
					break;
				}
				player.dices = diceroll(select);
				player.calcScore();
				player.printScoreBoard();
				System.out.println(player.dices);
			}

			diceCnt = 0; // 초기화

		}

	}

	private String diceSelect(Scanner sc) {
		// TODO Auto-generated method stub
		if (diceCnt == 0) { // 첫번째 주사위인 경우
			System.out.println("주사위를 굴립니다.");
			diceCnt++;
			return "0";
		}
		System.out.println("굴리지 않을 주사위 선택 (,) | 멈춤 (s) | " + "남은 기회 : " + (3 - diceCnt));
		String result = sc.nextLine(); // 아래 선택 로직 짜야함

		diceCnt++;

		return result;

	}

	public ArrayList<Integer> diceroll(String list) {

		StringTokenizer st = new StringTokenizer(list, ",");

		ArrayList<Integer> diceList = new ArrayList<Integer>();

		while (st.hasMoreTokens()) {
			diceList.add(Integer.parseInt(st.nextToken()));
		}

		loop1: for (int i = 0; i < DICE; i++) {
			for (int j = 0; j < diceList.size(); j++) {
				if (i == diceList.get(j) - 1) {
					continue loop1;
				}
			}
			int dice = (int) ((Math.random() * 6) + 1);

			result.set(i, dice);
		}

		return result;
	}

}
