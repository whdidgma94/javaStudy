package 메서드2;

import java.util.Scanner;

class TicTacToe {

	Scanner scan = new Scanner(System.in);

	String[][] game = new String[3][3];

	int turn = 1;
	int win = 0; // 1[turn1승리] 2[turn2승리]

	void setGame() {
		for (int i = 0; i < game.length; i++)
			for (int k = 0; k < game[i].length; k++)
				game[i][k] = "";
	}

	void showGame() {
		for (int i = 0; i < game.length; i++) {
			for (int k = 0; k < game[i].length; k++) {
				if (game[i][k].equals(""))
					System.out.print("[ ]");
				else
					System.out.print("[" + game[i][k] + "]");
			}
			System.out.println();
		}
	}

	void choiceIdx() {
		while (true) {
			System.out.println("P" + turn + "님의 턴");
			System.out.print("인덱스 1 입력 : ");
			int input1 = getIdx();
			System.out.print("인덱스 2 입력 : ");
			int input2 = getIdx();
			if (!game[input1][input2].equals("")) {
				System.err.println("놓을 수 없습니다");
				continue;
			}
			if (turn == 1) {
				game[input1][input2] = "O";
				turn = 2;
			} else {
				game[input1][input2] = "X";
				turn = 1;
			}
			break;
		}
	}

	int getIdx() {
		int input = 0;
		while (true) {
			input = scan.nextInt();
			if (input < 0 || input >= 3) {
				System.err.println("입력 오류");
				continue;
			}
			break;
		}
		return input;
	}

	void exitWidth() {
		for (int i = 0; i < game.length; i++) {
			if (game[i][0].equals("O") && game[i][1].equals("O") && game[i][2].equals("O"))
				win = 1;
			else if (game[i][0].equals("X") && game[i][1].equals("X") && game[i][2].equals("X"))
				win = 2;
		}
	}

	void exitHeight() {
		for (int i = 0; i < game.length; i++) {
			if (game[0][i].equals("O") && game[1][i].equals("O") && game[2][i].equals("O"))
				win = 1;
			else if (game[0][i].equals("X") && game[1][i].equals("X") && game[2][i].equals("X"))
				win = 2;
		}
	}

	void exitCross() {
		if (game[1][1].equals("O") && game[0][0].equals("O") && game[2][2].equals("O"))
			win = 1;
		else if (game[1][1].equals("X") && game[0][0].equals("X") && game[2][2].equals("X"))
			win = 2;
		if (game[2][0].equals("O") && game[1][1].equals("O") && game[0][2].equals("O"))
			win = 1;
		else if (game[2][0].equals("X") && game[1][1].equals("X") && game[0][2].equals("X"))
			win = 2;
	}

	void run() {

		// game배열을 공백 문자열(" ")로 초기화
		setGame();

		while (true) {

			showGame();

			// 게임 종료
			if (win == 1) {
				System.out.println("P1 승리");
				break;
			} else if (win == 2) {
				System.out.println("P2 승리");
				break;
			}

			choiceIdx();

			exitWidth();
			exitHeight();
			exitCross();

		}
	}
}

public class 메서드틱택토 {

	public static void main(String[] args) {
		TicTacToe tic = new TicTacToe();
		tic.run();

	}

}
