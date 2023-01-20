package 메서드2;

import java.util.Scanner;

class LadderGame {

	Scanner scan = new Scanner(System.in);

	int[][] ladder = { 
			{ 0, 0, 0, 0, 0 }, 
			{ 1, 2, 0, 1, 2 }, 
			{ 0, 1, 2, 0, 0 }, 
			{ 0, 0, 0, 1, 2 }, 
			{ 0, 1, 2, 0, 0 },
			{ 1, 2, 0, 0, 0 }, 
			{ 0, 0, 0, 1, 2 }, 
			{ 0, 0, 0, 0, 0 } 
	};

	int xIdx = 0;
	String menu;
	String[] menuList;
	void showLadder() {
		System.out.println(" 1  2  3  4  5");
		for(int i = 0 ; i < ladder.length;i++) {
			for(int k = 0 ; k < ladder[i].length;k++) {
				if(ladder[i][k]==0)
					System.out.print(" │ ");
				else if (ladder[i][k]==1)
					System.out.print(" ├─");
				else if (ladder[i][k]==2)
					System.out.print("─┤ ");
				else
					System.out.print(" * ");
			}
			System.out.println();
		}
		
		for(int i = 0 ; i < 4 ; i++) {	
			for(int k = 0 ; k < menuList.length;k++) {
				if(menuList[k].length()>i)
					System.out.printf("%-2s ",menuList[k].charAt(i));
				else
					System.out.print("   ");
			}
			System.out.println();
		}		
	}

	void moveLadder() {
		for(int i = 0 ; i < ladder.length;i++) {
			if (ladder[i][xIdx] == 0) {
				ladder[i][xIdx] = 3;
			}else if (ladder[i][xIdx]==1) {
				ladder[i][xIdx] = 3;
				ladder[i][xIdx+1] = 3;
				xIdx++;
			}else if (ladder[i][xIdx]==2) {
				ladder[i][xIdx] = 3;
				ladder[i][xIdx-1] = 3;
				xIdx--;
			}
		}
		menu=menuList[xIdx];
	}
	
	void setMenu() {
		menuList = new String[ladder[0].length];
		menuList[0]="스테이크";
		menuList[1]="짜장면";
		menuList[2]="삼겹살";
		menuList[3]="치킨";
		menuList[4]="피자";		
	}

	void run() {

		setMenu(); // 메뉴설정하기 : 메뉴는 본인이 먹고싶은걸로 정하세요
		showLadder();
		xIdx = 0;
		// 사다리 선택하기
		while (true) {
			System.out.print("번호를 선택하세요(1~5) : ");
			xIdx = scan.nextInt() - 1;
			if (xIdx < 0 || xIdx >= ladder[0].length) {
				System.err.println("입력 오류");
				continue;
			}
			break;
		}
		// 사다리 이동하기
		moveLadder();
		showLadder();
		System.out.println("오늘의 점심 메뉴는 " + menu + " 입니다~!!!");

	}
}
public class 메서드사다리게임 {

	public static void main(String[] args) {

		LadderGame lg = new LadderGame();
		lg.run();

	}

}
