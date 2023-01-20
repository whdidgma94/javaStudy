package 클래스배열;

import java.util.Random;

class Player {
	String name;
	Card c1 = new Card();
	Card c2 = new Card();
	int score = c1.num + c2.num;
	int max = c1.num > c2.num ? c1.num : c2.num;
	boolean win;

	void showCard() {
		System.out.println(c1.shape + c1.num + " " + c2.shape + c2.num);
	}
}

class Card {
	String shape;
	int num;
}

class CardGame {
	Random rd = new Random();
	Card deck[] = new Card[40];
	String shapes[] = { "◇", "♡", "♣", "♠" };
	Player[] play = new Player[2];

	void init() {
		int num = 1;
		int idx = 0;
		for (int i = 0; i < deck.length; i++) {
			deck[i] = new Card();
			deck[i].shape = shapes[idx];
			deck[i].num = num;
			num++;
			if (num == 11) {
				num = 1;
				idx++;
			}
		}

	}

	void giveCard() {
		for (int i = 0; i < play.length; i++) {
			play[i] = new Player();
			int card = rd.nextInt(deck.length);
			play[i].c1 = deck[card];
			card = rd.nextInt(deck.length);
			play[i].c2 = deck[card];
		}
	}

	void showCard() {
		System.out.print("player1 : ");
		play[0].showCard();
		System.out.print("player2 : ");
		play[1].showCard();
	}

	void checkWin() {
		if (play[0].score > play[1].score)
			play[0].win = true;
		else if (play[0].score < play[1].score)
			play[1].win = true;
		else {
			if (play[0].max > play[1].max)
				play[0].win = true;
			else if (play[0].max < play[1].max)
				play[1].win = true;
		}
		System.out.println(play[0].win ? "p1승리" : "p2승리");
	}

	void run() {
		init();
		giveCard();
		showCard();
		checkWin();
	}

}

public class 클래스배열_카드게임 {

	public static void main(String[] args) {
		CardGame c = new CardGame();
		c.run();

	}

}
