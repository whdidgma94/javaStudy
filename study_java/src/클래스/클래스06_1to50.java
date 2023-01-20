package 클래스;

import java.util.Random;
import java.util.Scanner;

class Game1to50{
	final int SIZE = 25;	
	int[] front = new int[SIZE];
	int[] back  = new int[SIZE];	
}
public class 클래스06_1to50 {

	public static void main(String[] args) {
		
		Game1to50 game = new Game1to50();
		Scanner scan = new Scanner(System.in);
		Random rd = new Random();
		
		for (int i = 0; i < game.SIZE; i++) {
			game.front[i] = i + 1;
			game.back[i] = i + 26;
		}
		for(int i = 0 ; i < 50 ; i++) {
			int num1 = rd.nextInt(game.front.length);
			int num2 = rd.nextInt(game.front.length);
			if(num1==num2) {
				i--;
				continue;
			}
			int temp =game.front[num1];
			game.front[num1] = game.front[num2];
			game.front[num2] = temp;
		}
		for(int i = 0 ; i < 50 ; i++) {
			int num1 = rd.nextInt(game.back.length);
			int num2 = rd.nextInt(game.back.length);
			if(num1==num2) {
				i--;
				continue;
			}
			int temp =game.back[num1];
			game.back[num1] = game.back[num2];
			game.back[num2] = temp;
		}
		int cnt = 0;
		while(cnt!=game.SIZE*2) {
			int min =51;
			int idx=-1;
			for(int i = 0 ; i<game.SIZE ; i++) {				
				System.out.printf(game.front[i]==0?"[  ]":"[%2d]",game.front[i]);
				if(min>game.front[i]&&game.front[i]!=0) {
					min=game.front[i];
					idx=i;
				}
				if(i%5==4)
					System.out.println();
			}
			System.out.print("인덱스 입력 : ");
			int input = scan.nextInt();
			if(input==idx) {
				game.front[idx]=game.back[idx];
				game.back[idx]=0;
				cnt++;
			}
		}
		System.out.println("게임 종료");
		scan.close();
	}
}
