package 자바프로젝트;

import java.util.Random;
import java.util.Scanner;

public class 소코반 {

	public static void main(String[] args) {
		/*
		 * # 소코반
		 * 1. 캐릭터가 공을 움직여 골대에 넣으면 종료되는 게임이다.
		 * 2. 벽의 개수를 입력받아 벽을 설치한다.
		 * 3. 공과 골대 그리고 캐릭터의 위치 값을 입력받아 설치한다.
		 * 4. 벽(9), 공(3), 캐릭터(2) 그리고 골대(7)의 설치가 끝나면 본격적으로 게임이 시작된다.
		 * 5. 캐릭터튼 상하좌우로 이동이 가능해 이동하면서 공을 밀어내어 골대에 넣어야 한다.
		 * 
		 * 0 0 0 0 0 0 0 
		 * 0 0 0 9 9 0 0 
		 * 0 0 0 0 0 0 9 
		 * 0 0 0 0 0 0 0  
		 * 0 0 2 3 7 9 0 
		 * 0 0 0 0 0 0 0  
		 * 9 0 0 0 0 0 0
		 * 
		 * 상(1)하(2)좌(3)우(4) 입력 : 4
		 * 
		 * 0 0 0 0 0 0 0 
		 * 0 0 0 9 9 0 0 
		 * 0 0 0 0 0 0 9 
		 * 0 0 0 0 0 0 0  
		 * 0 0 0 2 3 9 0 
		 * 0 0 0 0 0 0 0  
		 * 9 0 0 0 0 0 0
		 * 
		 * 게임종료
		 */
		Scanner scan = new Scanner(System.in);
		Random rd = new Random();
		int[][] map = new int[7][7];
		int wall = 0;
		while (true) {
			System.out.print("벽 개수 입력 : ");
			wall = scan.nextInt();
			if (wall < 0 || wall > 15) {
				System.err.println("벽개수를 0이상 15이하로 입력하세요");
				continue;
			}
			break;
		}
		for (int i = 0; i < wall + 3; i++) {
			int num1 = rd.nextInt(7);
			int num2 = rd.nextInt(7);
			if (map[num1][num2] == 0) {
				map[num1][num2] = 9;
			} else {
				i--;
			}
		}
		for (int i = 0; i < 3; i++) {
			int num1 = rd.nextInt(7);
			int num2 = rd.nextInt(7);
			if (map[num1][num2] == 9) {
				map[num1][num2] = i + 2;
			} else {
				i--;
			}
		}
		int x = -1;
		int y = -1;

		for (int i = 0; i < 7; i++) {
			for (int k = 0; k < 7; k++) {
				if (map[i][k] == 4) {
					map[i][k] = 7;
				}
				if (map[i][k] == 3) {
					if (i == 0) {
						map[i][k] = 0;
						map[i + 1][k] = 3;
					} else if (i == map.length - 1) {
						map[i][k] = 0;
						map[i - 1][k] = 3;
					}
					if (k == 0) {
						map[i][k] = 0;
						map[i][k + 1] = 3;
					} else if (k == map[i].length - 1) {
						map[i][k] = 0;
						map[i][k - 1] = 3;
					}
				}
				if (map[i][k] == 2) {
					y = i;
					x = k;
				}
			}
		}

		while (true) {

			for (int i = 0; i < map.length; i++) {
				for (int k = 0; k < map[i].length; k++) {
					if (map[i][k] == 0) {
						System.out.print("□ ");
					} else if (map[i][k] == 9) {
						System.out.print("■ ");
					} else if (map[i][k] == 2) {
						System.out.print("♣ ");
					} else if (map[i][k] == 3) {
						System.out.print("● ");
					} else {
						System.out.print("★ ");
					}
				}
				System.out.println();
			}
			System.out.print("상(1)하(2)좌(3)우(4) 입력 : ");
			int input = scan.nextInt();
			if (input < 1 || input > 4) {
				System.err.println("입력오류");
				continue;
			}
			int tempy = y;
			int tempx = x;
			if (input == 1) {
				y--;
			} else if (input == 2) {
				y++;
			} else if (input == 3) {
				x--;
			} else {
				x++;
			}
			if (y == -1 || y == map.length || x == -1 || x == map[y].length || map[y][x] == 9 || map[y][x] == 7) {
				System.err.println("이동 할 수 없습니다");
				y = tempy;
				x = tempx;
				continue;
			}
			map[tempy][tempx] = 0;
			boolean check = false;
			if (map[y][x] == 3) {
				if (input == 1 && y - 1 != -1) {
					map[y - 1][x] += 3;
				} else if (input == 2 && y + 1 != map.length) {
					map[y + 1][x] += 3;
				} else if (input == 3 && x - 1 != -1) {
					map[y][x - 1] += 3;
				} else if (input == 4 && x + 1 != map[y].length) {
					map[y][x + 1] += 3;
				} else {
					System.err.println("공이 갈 수 없는 지점입니다.");
					check = true;
				}
			}
			map[y][x] = 2;
			if (check) {
				map[y][x] = 3;
				map[tempy][tempx] = 2;
			}
			boolean goal = false;
			for (int i = 0; i < map.length; i++) {
				for (int k = 0; k < map[i].length; k++) {
					if (map[i][k] == 10) {
						System.out.println("골인!");
						goal = true;
					}
				}
			}
			if (goal) {
				break;
			}

		}
		scan.close();
	}

}
