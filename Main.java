package yacht;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logic logic = new Logic();
		Player p1 = new Player();
		Player p2 = new Player();

		p1.dices = logic.diceroll("0");
		p2.dices = logic.diceroll("0");
		
		p1.printScoreBoard();

	}

}
