package 블랙잭;

import java.util.Random;

public class DeckDAO {
	private static Deck deck;
	private static int idx;
	
	DeckDAO (){
		deck = Deck.getInstance();
		makeDeck();
		suffleDeck();
	}
	
	private void makeDeck() {
		int cnt = 0;
		for (int i = 0; i < deck.deck.length; i++) {
			if (cnt / 13 == 0)
				deck.deck[i] = "♠";
			else if (cnt / 13 == 1)
				deck.deck[i] = "♥";
			else if (cnt / 13 == 2)
				deck.deck[i] = "♣";
			else
				deck.deck[i] = "◆";

			if (i % 13 == 0)
				deck.deck[i] += "A";
			else if (i % 13 == 10)
				deck.deck[i] += "J";
			else if (i % 13 == 11)
				deck.deck[i] += "Q";
			else if (i % 13 == 12)
				deck.deck[i] += "K";
			else
				deck.deck[i] += i % 13 + 1;
			cnt++;
		}

	}

	public static void addIdx(int idx) {
		DeckDAO.idx += idx;
	}
	
	public static int getIdx() {
		return idx;
	}

	private void suffleDeck() {
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
			int num1 = rd.nextInt(deck.deck.length);
			int num2 = rd.nextInt(deck.deck.length);
			if (num1 == num2)
				i--;
			String temp = deck.deck[num1];
			deck.deck[num1] = deck.deck[num2];
			deck.deck[num2] = temp;
		}

	}

	void printDeck() {
		for (int i = 0; i < getDeck().deck.length; i++) {
			if (i % 7 == 0)
				System.out.println();
			System.out.print(getDeck().deck[i] + " ");
		}
	}

	




	public static Deck getDeck() {
		return deck;
	}

	public static void setDeck(Deck deck) {
		DeckDAO.deck = deck;
	}
	
	
}
