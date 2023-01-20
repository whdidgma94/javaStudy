package 자바프로젝트;

import java.util.Random;
import java.util.Scanner;

class BlackJack {
	Scanner scan = new Scanner(System.in);
	String[] deck = new String[52];
	int idx = 0;
	int dealer = 0;
	int player = 0;
	String dHand = "";
	String pHand = "";

	void makeDeck() {
		int cnt = 0;
		for (int i = 0; i < deck.length; i++) {
			if (cnt / 13 == 0)
				deck[i] = "♠";
			else if (cnt / 13 == 1)
				deck[i] = "♥";
			else if (cnt / 13 == 2)
				deck[i] = "♣";
			else
				deck[i] = "◆";
			
			if (i % 13 == 0)
				deck[i] += "A";
			else if (i % 13 == 10)
				deck[i] += "J";
			else if (i % 13 == 11)
				deck[i] += "Q";
			else if (i % 13 == 12)
				deck[i] += "K";
			else
				deck[i] += i % 13 + 1;
			cnt++;
		}

	}

	void suffleDeck() {
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
			int num1 = rd.nextInt(deck.length);
			int num2 = rd.nextInt(deck.length);
			if (num1 == num2)
				i--;
			String temp = deck[num1];
			deck[num1] = deck[num2];
			deck[num2] = temp;
		}

	}

	void printDeck() {
		for (int i = 0; i < deck.length; i++) {
			if (i % 7 == 0)
				System.out.println();
			System.out.print(deck[i] + " ");
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
	
	void getFirstHand() {

		for (int i = 0; i < 4; i += 2) {
			dHand += deck[i] + " ";
			dealer += addNum(deck[i]);

			pHand += deck[i + 1] + " ";
			player += addNum(deck[i + 1]);

			idx += 2;
		}
	}
	
	void showHand() {
		System.out.println("딜러의 패 ■■ " + dHand.substring(3, dHand.length()));
		System.out.println("당신의 패 " + pHand);
		System.out.println();
		System.out.println("현재 플레이어 점수 : " + player);
		
	}
	
	int getInput() {		
		while (true) {
			System.out.println("패를 더 받으시겠습니까? [1. O] [2. X]");
			int input = scan.nextInt();
			if (input > 2 || input < 1) {
				System.err.println("입력오류");
				continue;
			}
			return input;
		}
	}
	
	void checkWinner(){
		if (player > dealer)
			System.out.println("플레이어 승!");
		else if (player < dealer)
			System.out.println("딜러 승!");
		else
			System.out.println("무승부");
	}
	
	void addPlayerHand() {
		pHand += deck[idx] + " ";
		player += addNum(deck[idx]);
		idx++;
	}
	
	void addDealerHand() {
		while (dealer <= 16) {
			dHand += deck[idx] + " ";
			dealer += addNum(deck[idx]);
			idx++;
		}
	}
	
	void printResult() {
		System.out.println("딜러의 패 " + dHand);
		System.out.println("당신의 패 " + pHand);
		System.out.println("딜러 점수 : " + dealer);
		System.out.println("플레이어 점수 : " + player);	
		
	}
	
	void run() {
		
		makeDeck();
		suffleDeck();
//		printDeck();  //덱이 잘 섞였는지 확인
//		System.out.println();
		getFirstHand();
		while (true) {
			showHand();
			if (player > 21) {
				System.out.println("플레이어 버스트!");
				break;
			}
			int input = getInput();		
			if (input == 1) {
				addPlayerHand();
			} else {
				addDealerHand();
				if (dealer > 21) {
					printResult();
					System.out.println("딜러 버스트!");
					break;
				}
				printResult();
				checkWinner();
				break;
			}
		}
		scan.close();
	}
}

public class 블랙잭 {

	public static void main(String[] args) {

		BlackJack game = new BlackJack();
		
		game.run();

		
	}
}
