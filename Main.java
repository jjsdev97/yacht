package yacht;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logic logic = new Logic();
		Player p1 = new Player();

		p1.dices = logic.diceroll("2");
		
		System.out.println(p1.dices);

	}

}
