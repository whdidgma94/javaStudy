package 오늘의도전;

import java.util.Scanner;

public class 미로찾기 {

	public static void main(String[] args) {
		
    // 미로찾기 
	// 0 -> 빈칸
	// 1-> 벽
	// 2-> 캐릭터
	// 3 -> 도착지점  
	// 2가 3을 만날 때까지 게임 종료
	// 값을 변경해서 만약 2가 3을 만나지 못하면 => "탈출구 도착할 수 없습니다 " 하고 나오기 
//	  final int MAPSIZE = 5;
	    int map[][] = {
					{1,2,0,0,1},
					{1,1,0,1,1},
					{0,1,0,0,0},
					{0,0,0,1,1},
					{3,1,0,0,0}
	    };

	/*
	    int map[][] = {
					{1,2,0,0,1},
					{1,1,0,1,1},
					{0,1,0,0,0},
					{1,0,0,1,1},
					{3,1,0,0,0}
		};
	*/
	    Scanner scan = new Scanner(System.in);
//		int mark[][] = new int[MAPSIZE][MAPSIZE];
//		int y = -1;
//		int x = -1;

		while (true) {
			for (int i = 0; i < map.length; i++) {
				for (int k = 0; k < map[i].length; k++) {
					if (map[i][k] == 0) {
						System.out.print("□ ");
					} else if (map[i][k] == 1) {
						System.out.print("■ ");
					} else if (map[i][k] == 2) {
						System.out.print("♣ ");
//						y=i;
//						x=k;
					} else {
						System.out.print("◎ ");
					}
				}
				System.out.println();
			}
	
			break;
		}
		
		scan.close();
	}

}
