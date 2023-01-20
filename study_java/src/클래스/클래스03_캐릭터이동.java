package 클래스;

import java.util.Scanner;

/*
 * # 숫자이동[3단계] : 클래스 + 변수
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 4. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 * 5. 좌우 끝에 도달해도 계속 반대편으로 이동이 가능하다.
 * 예) 
 *  0 0 0 0 0 0 0 2 
 *  왼쪽(1) 오른쪽(2) : 2
 *  
 *  2 0 0 0 0 0 0 0 
 */

class MovingGame{
	int[] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};
}


public class 클래스03_캐릭터이동 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MovingGame game = new MovingGame();
		while (true) {
			int idx = -1;
			for (int i = 0; i < game.game.length; i++) {
				if (game.game[i] == 0)
					System.out.print("_ ");
				else if (game.game[i] == 1)
					System.out.print("■ ");
				else {
					System.out.print("♣ ");
					idx = i;
				}
			}
			System.out.println();
			System.out.print("왼쪽(1) 오른쪽(2) 종료(0): ");
			int input = scan.nextInt();
			if (input > 2 || input < 0) {
				System.err.println("입력오류");
				continue;
			}
			int temp = idx;
			if (input == 0) {
				break;
			} else if (input == 1) {
				game.game[idx] = 0;
				idx--;
				if (idx == -1)
					idx = game.game.length - 1;
				if (game.game[idx] == 0) {
					game.game[idx] = 2;
				} else {
					System.out.print("3 입력 시 벽 파괴 : ");
					input = scan.nextInt();
					if (input == 3) {
						System.out.println("파괴!");
						game.game[idx] = 2;
					} else {
						System.out.println("파괴실패");
						game.game[temp] = 2;
					}
				}
			} else if (input == 2) {
				game.game[idx] = 0;
				idx++;
				if (idx == game.game.length)
					idx = 0;
				if (game.game[idx] == 0) {
					game.game[idx] = 2;
				} else {
					System.out.print("3 입력 시 벽 파괴 : ");
					input = scan.nextInt();
					if (input == 3) {
						System.out.println("파괴!");
						game.game[idx] = 2;
					} else {
						System.out.println("파괴실패");
						game.game[temp] = 2;
					}
				}
			}

		}
		scan.close();
	}

}
