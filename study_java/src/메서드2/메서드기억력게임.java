package 메서드2;

import java.util.Random;
import java.util.Scanner;

class MemoryGame{
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
	int[] back = new int[10];
	
	int cnt = 0;		// 정답을 맞춘 횟수
	void shuffle() {
		for(int i = 0 ; i < 100 ; i++) {
			int num1=ran.nextInt(front.length);
			int num2=ran.nextInt(front.length);
			if(num1==num2) 
				i--;			
			int temp = front[num1];
			front[num1]=front[num2];
			front[num2]=temp;
		}
	}
	void printCard() {
		System.out.println(" 0  1  2  3  4  5  6  7  8  9  ");
		for(int i = 0 ; i < back.length;i++) {
			if(back[i]==0) {
				System.out.print("[x]");
			}else {
				System.out.print("["+back[i]+"]");
			}
		}
		System.out.println();
	}
	void choiceCard() {
		while(true) {
			System.out.print("[1] 입력 : ");
			int input1 = getNum();
			System.out.print("[2] 입력 : ");
			int input2 = getNum();
			if(input1==input2) {
				System.err.println("서로 다른 번호 입력");
				continue;
			}
			if(front[input1]==front[input2]) {
				back[input1]=front[input1];
				back[input2]=front[input2];
				cnt++;
			}
			break;
		}
	}
	int getNum() {
		int num = 0;
		while (true) {
			num = scan.nextInt();
			if (num < 0 || num >= front.length) {
				System.err.println("범위 오류");
				continue;
			}
			break;
		}
		return num;
	}
	void run() {
		
		// 셔플(카드 섞기)
		shuffle();
		
		while(true) {
			// 카드 출력
			printCard();
			
			// 종료하기
			if(cnt == 5) {
				System.out.println("게임 종료");
				break;
			}			
			
			// 카드 선택하기
			choiceCard();
		}
	}
}
public class 메서드기억력게임 {
	
	public static void main(String[] args) {
		MemoryGame mg = new MemoryGame();
		mg.run();
		
	}
	
}
