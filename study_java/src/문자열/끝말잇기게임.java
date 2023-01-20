package 문자열;

import java.util.Scanner;

public class 끝말잇기게임 {

	public static void main(String[] args) {
		
		/*
		 * # 끝말잇기 게임을 만들어보세요.
		 * 
		 * 제시어 : 자전거
		 * 입력 : 거미
		 * 제시어 : 거미
		 * 입력 : 미술
		 * ...
		 
		 1. 한자리 단어 안되요 
		 2. 기러기 -> 기러기 하면안됨 
		 3. 끝을 입력 받으면 반복문 종료 
		 
		 */
		
		Scanner sc = new Scanner(System.in);
		String start ="자전거";
		while(true) {
			System.out.println("제시어 : " + start );
			System.out.print("입력 : ");
			String input = sc.next();
			
			if (input.equals("끝")) {
				System.out.println("게임 종료");
				break;
			}

			if(input.charAt(0)!=start.charAt(start.length()-1)) {
				System.err.println("틀렸습니다!");
				continue;
			}
			if(input.length()==1) {
				System.err.println("한자리 이상 입력하세요");
				continue;
			}
			if(input.charAt(0)==input.charAt(input.length()-1)) {
				System.err.println("앞뒤 글자를 다르게 주세요");
				continue;
			}				
			start=input;	
		}
		sc.close();
	}

}
