package 클래스;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * # 기억력 게임 : 클래스 + 변수
 * 1. front 배열 카드 10장을 섞는다.
 * 2. front 배열에서 같은 카드를 골라 카드의 위치를 입력한다.
 * 3. 선택한 2장의 카드가 같은 카드이면, back 배열에 표시한다.
 * 4. 모든 카드가 뒤집히면(back배열의 0이 사라지면) 게임은 종료된다. 
 */

class MemoryGame{
	String[] front = {"O", "O","□", "□", "■", "■", "☎", "☎", "♠", "♠"};
	String[] back = new String[10];
	
	int cnt = 0;		// 정답을 맞춘 횟수
}
public class 클래스04_기억력게임 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rd = new Random();
		MemoryGame game = new MemoryGame();
		
		for(int i = 0 ; i < 50 ; i++) {
			int num1 = rd.nextInt(game.front.length);
			int num2 = rd.nextInt(game.front.length);
			if(num1==num2) {
				i--;
				continue;
			}
			String temp =game.front[num1];
			game.front[num1] = game.front[num2];
			game.front[num2] = temp;
		}
		for(int i = 0 ; i < game.back.length;i++) {
			game.back[i]="X";
		}
		System.out.println(Arrays.toString(game.front));
		int cnt=0;
		
		while(cnt!=game.back.length/2) {
			System.out.println("'0  1  2  3  4  5  6  7  8  9'");
			System.out.println(Arrays.toString(game.back));
			System.out.print("인덱스 1 입력 : ");
			int input1 = scan.nextInt();
			System.out.print("인덱스 2 입력 : ");
			int input2 = scan.nextInt();
			if(input1==input2) {
				System.err.println("동일한 인덱스 입력불가");
				continue;
			}
			if(input1<0||input1>=game.back.length||input2<0||input2>=game.back.length) {
				System.err.println("인덱스 범위 오류");
				continue;
			}
			if(game.front[input1].equals(game.front[input2])) {
				game.back[input1]=game.front[input1];
				game.back[input2]=game.front[input2];
				cnt++;
			}
		}
		System.out.println("게임 종료");
		scan.close();
	}

}
