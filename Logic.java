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
		player.resetBoard(); // 설정
		System.out.println("시작합니다");

		loop1:
		while (true) { // 시작 시점 cnt = 0
		
			
			Arrays.fill(player.tempDiceScore, 0); // 점수 구하는 로직때문에 초기화
			System.out.println("남은 횟수 : " + (12 - player.boardCnt));
			
		
			Scanner sc = new Scanner(System.in);

			while (!(diceCnt >= 3)) { // 시작시점 cnt 0
				select = diceSelect(sc, player); // diceSelect에서 dicecnt++ , 주사위 순서나 점수보드 순서 리턴함, 입력받음
				if (select.substring(select.length() - 1).equals("번")) { // 리턴값이 ~번이면 점수보드로 보내고 while탈출
					inputScore(select, player);
					break;
				}
				player.dices = diceroll(select); // 고정 주사위 갑을 받고 주사위를 돌림 ( 다이스 0일 경우 5개 전부, 첫 while문에서 5개돌리면서 현 cnt는 1
				player.calcScore(); // 5개 굴린 값 통해서 계산해주고 temp 배열 생성
				player.printScoreBoard(); // temp와 진짜 보드 값 나누어서 출력
				
				if(player.boardCnt == 12) {
					System.out.println("게임 종료");
					break loop1;
				}

				System.out.println(player.dices); // 이 while문에서 굴린 주사위 출력
				
			
				if (diceCnt == 3) { // 3번이 끝났을때 점수 넣는 부분
					System.out.println("기회 종료 | 1번 2번 3번 형식으로 선택(7번제외)");
					inputScore(sc.nextLine(), player);
				}
				
				

			}
			

			diceCnt = 0; // 초기화

		}

	}

	private void inputScore(String select, Player player) {
		// TODO Auto-generated method stub
		int selectNum = Integer.parseInt(select.replace("번", "")) - 1;

		player.diceScore[selectNum] = player.tempDiceScore[selectNum];

		player.boardCnt++;
	}

	private String diceSelect(Scanner sc, Player player) {
		// TODO Auto-generated method stub
		if (diceCnt == 0) { // 첫번째 주사위인 경우
			System.out.println("주사위를 굴립니다.");
			diceCnt++;
			return "0";
		}
		System.out.println("굴리지 않을 주사위 선택 (,) | 점수 입력 (1번,2번,3번)(7번제외) | " + "남은 기회 : " + (3 - diceCnt));
		String result = sc.nextLine(); // 아래 선택 로직 짜야함
		
		if(!result.contains("번")) { // 굴리지 않을 주사위 선택 <-- 할때만 하기위한 if문
			Arrays.fill(player.tempDiceScore, 0);
		}

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

	public void endGame() { // 점수 취합, 1~6계산해서 63점 이상일시 추가점수
		
	}

}
