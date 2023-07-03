package yacht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Logic {
	public final static int DICE = 5;

	public ArrayList<Integer> diceroll(String list) {

		StringTokenizer st = new StringTokenizer(list, ",");

		ArrayList<Integer> diceList = new ArrayList<Integer>();

		while (st.hasMoreTokens()) {
			diceList.add(Integer.parseInt(st.nextToken()));
		}

		ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

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
