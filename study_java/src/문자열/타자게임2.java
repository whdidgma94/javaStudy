package 문자열;

import java.util.Random;
import java.util.Scanner;

public class 타자게임2 {

	public static void main(String[] args) {
		/*
		 * # 타자연습 게임[2단계]
		 * 1. 문제를 섞는다.(shuffle)
		 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
		 * 3. 단 문제를 출제할 때, 단어의 랜덤한 위치 한 곳만 *(랜덤 위치 )로 출력 
		 * 예)
		 * 문제 : mys*l
		 * 입력 : mysql	<--- 정답을 맞추면, 다음 문제 제시
		 * 문제 : *sp
		 * 입력 : jap
		 * 문제 : j*p (x) : 문제 틀릴시 별 고정 
		 * 문제 : *sp (0)
		 */
		String[] words = {"java", "mysql", "jsp", "spring"};
		Random rd = new Random();
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < 100; i++) {
			int suf1 = rd.nextInt(words.length);
			int suf2 = rd.nextInt(words.length);
			String temp = words[suf1];
			words[suf1] = words[suf2];
			words[suf2] = temp;
		}
		int block = rd.nextInt(words[0].length());
		for (int i = 0; i < words.length; i++) {
			
			System.out.print("제시어 : ");
			for(int k = 0 ; k < words[i].length();k++) {
				if(k!=block) {
					System.out.print(words[i].charAt(k));
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
			System.out.print("입력 : ");
			String input = scan.next();
			if (input.equals(words[i])) {
				System.out.println("정답!");
				if(i<words.length-1)
				block=rd.nextInt(words[i+1].length());
			} else {
				System.err.println("오답!");
				i--;
			}

		}
		System.out.println("게임 종료");
		scan.close();
	}
}
