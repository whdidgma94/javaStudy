package 문자열;

import java.util.Random;
import java.util.Scanner;

public class 타자게임 {

	public static void main(String[] args) {
		/*
		 * # 타자연습 게임[1단계]
		 * 1. 문제를 섞는다.(shuffle)
		 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
		 * 예)
		 * 문제 : mysql
		 * 입력 : mydb
		 * 문제 : mysql
		 * 입력 : mysql	<--- 정답을 맞추면, 다음 문제 제시
		 * 문제 : jsp
		 */
		Random rd = new Random();
		Scanner scan = new Scanner(System.in);
		String[] words = {"java", "mysql", "jsp", "spring"};
		for(int i = 0 ; i < 100 ; i++) {
			int suf1 = rd.nextInt(words.length);
			int suf2 = rd.nextInt(words.length);
			String temp = words[suf1];
			words[suf1]	= words[suf2];
			words[suf2] = temp;
		}
		for(int i = 0 ; i < words.length ; i++) {
			System.out.println("제시어 : "+words[i]);
			System.out.print("입력 : ");
			String input = scan.next();
			if(input.length()!=words[i].length()) {
				System.err.println("오답!");
				i--;
				continue;
			}
			boolean check = true;
			for(int k = 0 ; k < words[i].length();k++) {
				if(words[i].charAt(k)!=input.charAt(k)) {
					check=false;
					break;
				}
			}
			if(!check) {
				System.err.println("오답!");
				i--;
				continue;
			}
		}
		System.out.println("게임 종료");
		scan.close();
	}

}
