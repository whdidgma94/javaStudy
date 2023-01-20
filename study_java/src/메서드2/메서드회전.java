package 메서드2;

import java.util.Scanner;

class Spin {
	Scanner scan = new Scanner(System.in);
	int block[][] = {
            { 1, 2, 3, 4},
            { 5, 6, 7, 8},
            { 9,10,11,12},
            {13,14,15,16},
	};
	int dir = 0;
	int size = block.length;
	int num = 1;

	void showArr() {

		for (int i = 0; i < block.length; i++) {
			for (int k = 0; k < size; k++) {
				System.out.printf("[%2d]", block[i][k]);
			}
			System.out.println();
		}

	}

	int getInput() {

		System.out.println("[1.left_turn] [2.right_turn] [0.종료]");
		System.out.print("입력 : ");
		int input = scan.nextInt();

		return input;
	}

	void spinArr() {
		if (dir == 0) {
			for (int i = 0; i < size; i++) {
				for (int k = 0; k < size; k++) {
					block[i][k] = num;
					num++;
				}
			}
		} else if (dir == 1) {
			for (int i = size - 1; i >= 0; i--) {
				for (int k = 0; k < size; k++) {
					block[k][i] = num;
					num++;
				}
			}
		} else if (dir == 2) {
			for (int i = size - 1; i >= 0; i--) {
				for (int k = size - 1; k >= 0; k--) {
					block[i][k] = num;
					num++;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				for (int k = size - 1; k >= 0; k--) {
					block[k][i] = num;
					num++;
				}
			}
		}
		num=1;
	}

	void run() {
		while (true) {
			showArr();
			int input = getInput();
			if (input == 1) {
				dir--;
				if (dir == -1) {
					dir = 3;
				}
			} else if (input == 2) {
				dir++;
				if (dir == 4) {
					dir = 0;
				}
			} else if (input == 0) {
				System.out.println("==종료==");
				break;
			} else {
				System.out.println("입력 오류");
				continue;
			}
			spinArr();
		}

	}

}

public class 메서드회전 {

	public static void main(String[] args) {
		Spin s = new Spin();
		s.run();
	}

}
