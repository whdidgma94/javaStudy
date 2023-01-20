package 클래스;

import java.util.Scanner;

class Tictactoe{
	
	String[][] game = new String[3][3];
	
	int turn = 1;
	int win = 0;		
}

public class 클래스05_틱택토 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Tictactoe e = new Tictactoe();

		for (int i = 0; i < e.game.length; i++) {
			for (int j = 0; j < e.game[i].length; j++) {
				e.game[i][j] = "[ ]";
			}
		}
		while (e.win == 0) {
			for (int i = 0; i < e.game.length; i++) {
				for (int j = 0; j < e.game[i].length; j++) {
					System.out.print(e.game[i][j]);
				}
				System.out.println();
			}
			System.out.println(e.turn+"번 플레이어 인덱스1 입력:");
			int input1 = scan.nextInt();
			System.out.println(e.turn+"번 플레이어 인덱스2 입력:");
			int input2 = scan.nextInt();
			if (input1 < 0 || input1 >= e.game.length || input2 < 0 || input2 >= e.game.length) {
				System.err.println("인덱스 범위 오류");
				continue;
			}
			if(!e.game[input1][input2].equals("[ ]")) {
				System.err.println("이미 선택된 자리 입니다.");
				continue;
			}
			if (e.turn == 1)
				e.game[input1][input2] = "[★]";
			else
				e.game[input1][input2] = "[♡]";
			
			String temp = "";
			for(int i = 0 ; i < e.game.length;i++) {
				if(e.game[i][0].equals(e.game[i][1])&&e.game[i][1].equals(e.game[i][2])&&!e.game[i][0].equals("[ ]")) {
					temp=e.game[i][0];				
				}
				if(e.game[0][i].equals(e.game[1][i])&&e.game[1][i].equals(e.game[2][i])&&!e.game[i][0].equals("[ ]")) {
					temp=e.game[0][i];				
				}
			}
			if(e.game[0][0].equals(e.game[1][1])&&e.game[1][1].equals(e.game[2][2])&&!e.game[0][0].equals("[ ]")) {
				temp=e.game[0][0];
			}
			if(e.game[2][0].equals(e.game[1][1])&&e.game[1][1].equals(e.game[0][2])&&!e.game[2][0].equals("[ ]")) {
				temp=e.game[0][0];
			}
			if(temp.equals("[★]"))
				e.win=1;
			else if(temp.equals("[♡]"))
				e.win=2;
			if(e.turn==1)
				e.turn=2;
			else
				e.turn=1;
		}
		for (int i = 0; i < e.game.length; i++) {
			for (int j = 0; j < e.game[i].length; j++) {
				System.out.print(e.game[i][j]);
			}
			System.out.println();
		}
		System.out.println(e.win+"번 플레이어 승리!");
		scan.close();
	}
}