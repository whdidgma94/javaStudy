package 블랙잭;

import java.util.InputMismatchException;
import java.util.Scanner;

class BlackJack {
	private Scanner scan = new Scanner(System.in);
	private DeckDAO deckDAO = new DeckDAO();
	private HandDAO handDAO = new HandDAO();


	int getInput() {
		//Scanner sc = new Scanner(System.in);
		int input=0;
		System.out.println("Would you like to take more card? [1. O] [2. X]");
		try {
			//input = sc.nextInt();  
			input = scan.nextInt();
			if (input > 2 || input < 1) {
				throw new Exception();
			}
			return input;
		} catch (InputMismatchException e) {
			System.err.println("input error");

		} catch (Exception e) {
			input=0;
			System.err.println("input error");
		}
		
		return input;

	}

	void checkWinner() {
		System.out.println("===============");
		if (handDAO.hand.get(1).getScore() > handDAO.hand.get(0).getScore())
			System.out.println("player win!");
		else if (handDAO.hand.get(1).getScore() < handDAO.hand.get(0).getScore())
			System.out.println("dealer win!");
		else
			System.out.println("draw");
	}




	void printResult() {
		System.out.println("dealer's hand " + handDAO.hand.get(0).getHand());
		System.out.println("player's hand " + handDAO.hand.get(1).getHand());
		System.out.println("dealer score : " + handDAO.hand.get(0).getScore());
		System.out.println("player score : " + handDAO.hand.get(1).getScore());

	}

	void run() {
		
//		deckDAO.printDeck();    //Make sure deck is well shuffled
//		System.out.println();
		handDAO.getFirstHand();
		while (true) {
			handDAO.showHand();
			if (handDAO.hand.get(1).getScore() > 21) {
				System.out.println("player burst!");
				break;
			}
			int input = 0;
			while (input == 0) {
				input = getInput();
			}
			if (input == 1) {
				handDAO.addHand(1);
			} else {
				handDAO.addDealerHand();
				if (handDAO.hand.get(0).getScore() > 21) {
					printResult();
					System.out.println("dealer burst!");
					break;
				}
				printResult();
				checkWinner();
				break;
			}
		}
		scan.close();
	}

	public DeckDAO getDeckDAO() {
		return deckDAO;
	}

	public void setDeckDAO(DeckDAO deckDAO) {
		this.deckDAO = deckDAO;
	}
}
