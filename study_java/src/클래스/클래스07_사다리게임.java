package 클래스;

import java.util.Scanner;

class GameLadder {
	int ladder[][] = {
			{ 0, 0, 0, 0, 0 }, 
			{ 1, 1, 0, 1, 1 }, 
			{ 0, 0, 0, 0, 0 }, 
			{ 0, 0, 1, 1, 0 }, 
			{ 1, 1, 0, 1, 1 },
			{ 0, 1, 1, 0, 0 }, 
			{ 0, 0, 1, 1, 0 },
			{ 0, 0, 0, 1, 1 }, 
			{ 0, 0, 0, 0, 0 }};
	
	int x = 0;
	int y = 0;
	String[] menu = { "죠스떡볶이", "CU편의점라면", "마라탕", "김밥천국", "명인만두" };
}
public class 클래스07_사다리게임 {

	public static void main(String[] args) {
		
		GameLadder go = new GameLadder();
		Scanner scan = new Scanner(System.in);
		System.out.println(" 1  2  3  4  5");
		for(int i = 0 ; i < go.ladder.length;i++) {
			for(int k =0;k<go.ladder[i].length;k++) {
				if(go.ladder[i][k]==0)
					System.out.print(" │ ");
				else if(go.ladder[i][k]==1){
					if(k!=go.ladder[i].length-1&&go.ladder[i][k+1]==1)
						System.out.print(" ├─");
					else
						System.out.print("─┤ ");
				}
			}
			System.out.println();
		}
		int input=0;
		while(true) {			
			System.out.println("번호 입력");
			input = scan.nextInt();
			if(input<1||input>5) {
				System.err.println("입력오류");
				continue;
			}
			break;
		}
		go.x=input-1;
		for(int i = 0 ; i < go.ladder.length-1;i++) {
			go.ladder[i][go.x]=2;
			if(go.ladder[i+1][go.x]==1) {
				go.ladder[i+1][go.x]=2;
				if(go.x!=go.ladder[i].length-1&&go.ladder[i+1][go.x+1]==1)
					go.x=go.x+1;
				else
					go.x=go.x-1;
			}			
		}
		go.ladder[go.ladder.length-1][go.x]=2;
		for(int i = 0 ; i < go.ladder.length;i++) {
			for(int k =0;k<go.ladder[i].length;k++) {
				if(go.ladder[i][k]==0)
					System.out.print(" │ ");
				else if(go.ladder[i][k]==1){
					if(k!=go.ladder[i].length-1&&go.ladder[i][k+1]==1)
						System.out.print(" ├─");
					else
						System.out.print("─┤ ");
				}else {
					System.out.print(" * ");
				}
			}
			System.out.println();
		}
		for(int i = 0 ; i < 7 ; i++) {
			for(int k = 0 ; k < go.menu.length;k++) {
				if(go.menu[k].length()>i)
					System.out.printf("%-2s ",go.menu[k].charAt(i));
				else
					System.out.print("   ");
			}
			System.out.println();
		}		
		
		System.out.printf("오늘의 메뉴 : %s",go.menu[go.x]);
		
		scan.close();
	}
}
