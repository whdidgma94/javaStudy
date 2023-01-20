package 자바프로젝트;

import java.util.Random;
import java.util.Scanner;

public class 테트리스 {

	public static void main(String[] args) {
		int sy = 20;
		int sx = 10;
		int[][] map = new int[sy][sx];
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);		
		int tList [][][] = {
					{
						{0,2,0},
					    {0,2,0},	
					    {0,2,0},
					},
					{				
					    {3,3},	
					    {0,3},				
					},
					{				
					    {4,0},	
					    {4,4},
					},
					{				
					    {5,5},	
					    {5,5},				
					},										
		};			
		int [][] tetris = 
					{
					 {0,0,0},
				     {0,0,0},	
				     {0,0,0}
		};	
		boolean blockNew = true;
		int y = 0;
		int x = 4;
		int size = 0;
		int block = -1;
		int score = 0;
		boolean fail = false;
		while (true) {
			while (true) {
				int cnt = 0;
				int idx = -1;
				boolean check = false;
				for (int i = 0; i < sy; i++) {
					cnt = 0;
					for (int k = 0; k < sx; k++) {
						if (map[i][k] == 1) {
							cnt++;
						}
					}
					if (cnt == sx) {
						idx = i;
						check = true;
						break;
					}
				}
				if (check) {
					for (int i = idx - 1; i >= 0; i--) {
						map[i + 1] = map[i];
					}
					map[0] = new int[sx];
					for (int i = 0; i < tetris.length; i++) {
						for (int k = 0; k < tetris[i].length; k++) {
							tetris[i][k] = 0;
						}
					}
					score++;
					continue;
				}
				break;
			}
			if (blockNew) {
				int r = ran.nextInt(tList.length);
				block = r;
				size = tList[r].length;
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (map[y + i][x + j] != 0) {
							fail = true;
						}
						tetris[i][j] = tList[r][i][j];
						map[y + i][x + j] = tetris[i][j];
					}
				}
				blockNew = false;
			}
			for (int i = 0; i < sy; i++) {
				for (int j = 0; j < sx; j++) {
					if (map[i][j] == 1) {
						System.out.print("[■]");
					} else if (map[i][j] == 0) {
						System.out.print("[□]");
					} else {
						System.out.printf("[▦]");
					}
				}
				System.out.println();
			}
			if (fail) {
				System.out.println("패배");
				break;
			}
			System.out.println("현재 점수 : " + score);
			if (score == 10) {
				System.out.println("10점 달성 승리!");
				break;
			}
			System.out.println("-------------------------------");
			System.out.println("[1.left][2.right][3.down][4.turn]");
			int sel = scan.nextInt();
			if (sel == 1) {

				if (x == 0 && block != 0) {
					System.err.println("이동불가");
					continue;
				} else if (x == -1 && block == 0) {
					System.err.println("이동불가");
					continue;
				} else if (x == 0 && block == 0 && tetris[2][0] == 2) {
					System.err.println("이동불가");
					continue;
				}

				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (tetris[i][j] > 1) {
							map[y + i][x + j] = 0;
						}
					}
				}
				x -= 1;
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (tetris[i][j] > 1) {
							map[y + i][x + j] = tetris[i][j];
						}
					}
				}
			} else if (sel == 2) {
				if (x == sx - 2) {
					System.err.println("이동불가");
					continue;
				} else if (x == sx - 3 && block == 0 && tetris[2][0] == 2) {
					System.err.println("이동불가");
					continue;
				}
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (tetris[i][j] > 1) {
							map[y + i][x + j] = 0;
						}
					}
				}
				x += 1;
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (tetris[i][j] > 1) {
							map[y + i][x + j] = tetris[i][j];
						}
					}
				}
			} else if (sel == 3) {
				while (true) {
					boolean check = false;
					int mx = x;
					int my = y;
					my += size;
					for (int i = 0; i < size; i++) {

						if (my >= sy) {
							check = true;
						}
					}

					if (check == true) {
						for (int i = 0; i < size; i++) {
							for (int j = 0; j < size; j++) {
								if (j < 0 || j >= sx)
									continue;
								if (tetris[i][j] > 1) {
									map[y + i][x + j] = 1;
								}
							}
						}
						y = 0;
						x = 4;
						blockNew = true;
						break;
					}

					check = false;
					mx = x;
					my = y;
					my += 1;
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							if (j < 0 || j >= sx)
								continue;
							if (mx + j < 0 || mx + j >= sx)
								continue;
							if (map[my + i][mx + j] == 1 && tetris[i][j] > 1) {
								check = true;
								break;
							}
						}
						if (check == true) {
							break;
						}
					}
					if (check == true) {
						for (int i = 0; i < size; i++) {
							for (int j = 0; j < size; j++) {

								if (tetris[i][j] > 1) {
									map[y + i][x + j] = 1;
								}
							}
						}
						y = 0;
						x = 4;
						blockNew = true;
						break;
					}
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {

							if (tetris[i][j] > 1) {
								map[y + i][x + j] = 0;
							}
						}
					}
					y += 1;
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {

							if (tetris[i][j] > 1) {
								map[y + i][x + j] = tetris[i][j];
							}
						}
					}
				}
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						tetris[i][j] = 0;
					}
				}
			} else if (sel == 4) {
				if (block == 0) {
					if (tetris[0][1] == 2) {
						tetris[0][1] = 0;
						tetris[1][1] = 0;
						tetris[2][0] = 2;
						tetris[2][2] = 2;
					} else {
						tetris[0][1] = 2;
						tetris[1][1] = 2;
						tetris[2][0] = 0;
						tetris[2][2] = 0;
					}
				} else if (block == 1 || block == 2) {
					int tempx = -1;
					int tempy = -1;
					for (int i = 0; i < 2; i++) {
						for (int k = 0; k < 2; k++) {
							if (tetris[i][k] == 0) {
								tempy = i;
								tempx = k;
							}
						}
					}
					if (tempx == 0 && tempy == 0) {
						tetris[0][0] = tetris[0][1];
						tetris[0][1] = 0;
					} else if (tempx == 1 && tempy == 0) {
						tetris[0][1] = tetris[0][0];
						tetris[1][1] = 0;
					} else if (tempx == 0 && tempy == 1) {
						tetris[1][0] = tetris[0][0];
						tetris[0][0] = 0;
					} else {
						tetris[1][1] = tetris[0][1];
						tetris[1][0] = 0;
					}
				}
				if (block == 0) {
					if (x == 8) {
						x--;
					} else if (x == -1) {
						x++;
					}
				}
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						map[y + i][x + j] = tetris[i][j];
					}
				}
			} else {
				System.err.println("입력 오류");
			}
		}
		scan.close();
	}

}
