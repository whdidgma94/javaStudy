package 문자열;

import java.util.Scanner;

public class equals매서드구현 {

	public static void main(String[] args) {
		
		/*
		 * # 문자열 비교
		 * . equals() 메서드 사용없이 equals 직접구현 문자의 일치여부 비교
		 * 예)
		 * 코끼리
		 * 입력 = 티라노사우루스
		 * 출력 = false
		 */
		
		Scanner scan = new Scanner(System.in);
		String answer = "코끼리";
		boolean check = true;
		System.out.print("입력 : ");
		String input = scan.next();
		for(int i = 0 ; i < answer.length();i++) {
			if(answer.length()!=input.length()) {
				check=false;
				break;
			}
			if(answer.charAt(i)!=input.charAt(i))
				check=false;
		}
		System.out.println(check);
		scan.close();
		
	}

}
