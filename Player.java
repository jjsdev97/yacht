package yacht;

import java.util.ArrayList;

public class Player {

	public ArrayList<Integer> dices = null;

	// 1, 2, 3, 4, 5, 6, 1~6total, 초이스, ss, ls, fk, fh, yacht
	public int[] diceScore = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	public void printScoreBoard() {
		String[] scoreBoard = { "1", "2", "3", "4", "5", "6", "1-6", "초이스", "ss", "ls", "fk", "fh", "yacht" };

		for (int i = 0; i < 13; i++) {
			System.out.println(scoreBoard[i] + " : " + diceScore[i]);
		}
	}
}
