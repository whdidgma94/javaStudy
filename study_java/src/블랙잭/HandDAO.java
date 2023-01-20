package 블랙잭;

import java.util.ArrayList;

public class HandDAO {
	ArrayList<Hand> hand = new ArrayList<Hand>();

	void getFirstHand() {
		hand.add(new Hand());
		hand.add(new Hand());	
		for (int i = 0; i < 4; i += 2) {
			hand.get(0).addHand(DeckDAO.getDeck().deck[i] + " ");
			hand.get(0).addScore(addNum(DeckDAO.getDeck().deck[i]));
			hand.get(1).addHand(DeckDAO.getDeck().deck[i+1] + " ");
			hand.get(1).addScore(addNum(DeckDAO.getDeck().deck[i+1]));			
			DeckDAO.addIdx(2);
		}
	}
	
	void showHand() {
		System.out.println("dealer's hand ■■ " + hand.get(0).getHand().substring(3, hand.get(0).getHand().length()));
		System.out.println("player's hand " + hand.get(1).getHand());
		System.out.println();
		System.out.println("player score : " + hand.get(1).getScore());

	}


	void addHand(int idx) {
		hand.get(idx).addHand(DeckDAO.getDeck().deck[DeckDAO.getIdx()] + " ");
		hand.get(idx).addScore(addNum(DeckDAO.getDeck().deck[DeckDAO.getIdx()]));
		DeckDAO.addIdx(1);		
	}

	void addDealerHand() {
		while (hand.get(0).getScore() <= 16) {
			addHand(0);
		}
	}
	int addNum(String card) {
		int score = 0;
		if ((int) card.charAt(1) == 65)
			score += 1;
		else if ((int) card.charAt(1) == 74)
			score += 11;
		else if ((int) card.charAt(1) == 81)
			score += 12;
		else if ((int) card.charAt(1) == 75)
			score += 13;
		else
			score += Integer.parseInt(card.substring(1));
		return score;
	}
	
}
