package yacht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Player {
	public int boardCnt = 0; // 종료 시점 계산 위한 카운트
	public ArrayList<Integer> dices = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)); // 굴린 dice값 저장

	// 1, 2, 3, 4, 5, 6, 1~6total, 초이스, ss, ls, fk, fh, yacht
	public int[] diceScore = new int[13];
	public int[] tempDiceScore = new int[13];

	public void calcScore() {

		for (int i = 0; i <= 5; i++) {
			tempDiceScore[i] = (Collections.frequency(dices, i + 1) * (i + 1));

			if (diceScore[i] >= 0) {
				tempDiceScore[6] += diceScore[i]; // 마지막 total 계산할때 if문 넣어야함
			}

		} // 1~6 값, total값

		for (int dice : dices) {
			tempDiceScore[7] += dice;
		} // 초이스

		if (dices.contains(1) && dices.contains(2) && dices.contains(3) && dices.contains(4)
				|| dices.contains(2) && dices.contains(3) && dices.contains(4) && dices.contains(5)
				|| dices.contains(3) && dices.contains(4) && dices.contains(5) && dices.contains(6)) {
			tempDiceScore[8] = 15;
		} // ss

		if (dices.contains(1) && dices.contains(2) && dices.contains(3) && dices.contains(4) && dices.contains(5)
				|| dices.contains(2) && dices.contains(3) && dices.contains(4) && dices.contains(5)
						&& dices.contains(6)) {
			tempDiceScore[9] = 25;
		} // ls

		for (int i = 0; i < dices.size(); i++) {
			if (Collections.frequency(dices, dices.get(i)) >= 4) {
				tempDiceScore[10] = dices.get(i) * 4;
			}
		} // fk

		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (int i = 0; i < dices.size(); i++) {
			if (Collections.frequency(dices, dices.get(i)) == 3) {
				for (int j = 0; j < dices.size(); j++) {
					if (!dices.get(i).equals(dices.get(j))) {
						temp.add(dices.get(j));
					}
				}

			}
		}
		if (temp.size() == 2) {
			if (temp.get(0) == temp.get(1)) {
				for (int dice : dices) {
					tempDiceScore[11] += dice;
				}
			} // fh
		}

		if (Collections.frequency(dices, dices.get(0)) == 5) {
			tempDiceScore[12] = 50;
		} // yac

	}

	public void printScoreBoard() {
		String score = "";
		String[] scoreBoard = { "1", "2", "3", "4", "5", "6", "1-6", "초이스", "ss", "ls", "fk", "fh", "yacht" };

		System.out.println("===========================================");
		for (int i = 0; i < 13; i++) {
			if (diceScore[i] == -1) {
				score = "(" + tempDiceScore[i] + ")"; // 값 임시 저장 배열을 만들어서 우선 배열에 임시로 다 넣어놓고 if로 임시/진짜 나눠서 출력
			} else {
				score = String.valueOf(diceScore[i]);
			}

			System.out.println(scoreBoard[i] + " : " + score);
		}
		System.out.println("===========================================");

		
	}

	public void resetBoard() {
		Arrays.fill(diceScore, -1); // 초기화
		boardCnt = 0; // 초기화
	}

}
