package 메서드2;

import java.util.Scanner;


class NumberGame {
	// 심화는 격파까지 구현하시오
	Scanner scan = new Scanner(System.in);

	int[] move = { 2, 0, 3, 0, 8, 0, 0, 0, 0, 1 };
	int pidx = 4;
	
	void printPlay() {
		for(int i = 0 ; i < move.length ;i++) {
			if(move[i]==8)
				System.out.print("♣ ");
			else if(move[i]==0) 
				System.out.print("  ");
			else
				System.out.print("□ ");
		}
		System.out.println();
	}

	void showMenu() {
		System.out.println("[1]왼쪽 [2]오른쪽 [3]종료");
	}

	void moveLeft() {
		move[pidx]=0;
		pidx--;
		if (pidx == -1)
			pidx = move.length - 1;
		if (move[pidx] == 0)
			move[pidx] = 8;
		else {
			if(crashWall())
				move[pidx] = 8;
			else {
				pidx++;
				if(pidx==move.length)
					pidx=0;
				move[pidx]=8;
			}
			
		}	
	}
	void moveRight() {
		move[pidx]=0;
		pidx++;
		if(pidx==move.length)
			pidx=0;
		if (move[pidx] == 0)
			move[pidx]=8;
		else {
			if(crashWall())
				move[pidx] = 8;
			else {
				pidx--;
				if(pidx==-1)
					pidx=move.length-1;
				move[pidx]=8;
			}
		}
	}

	boolean crashWall() {
		int input = 0;
		while (true) {
			System.out.println("[1]격파 [2]돌아가기");
			input = scan.nextInt();
			if (input != 1 && input != 2) {
				System.err.println("입력 오류");
				continue;
			}

			break;
		}
		return input == 1 ? true : false;
	}

	void run() {
		while (true) {
			// 게임화면 출력
			printPlay();
			// 메뉴 출력
			showMenu();
			// 메뉴 선택
			System.out.print(": ");
			int choice = scan.nextInt();

			// 좌로 이동
			if (choice == 1) {
				moveLeft();
			}
			// 우로 이동
			else if (choice == 2) {
				moveRight();
			}
			// 종료
			else if (choice == 3) {
				System.out.println("게임 종료");
				break;
			}else {
				System.err.println("입력오류");
			}
		}
	}
}

public class 메서드숫자이동 {

	public static void main(String[] args) {
		NumberGame g = new NumberGame();
		g.run();

	}

}
