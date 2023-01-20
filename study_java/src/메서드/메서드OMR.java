package 메서드;

import java.util.Arrays;

/*
		[문제]
			1. 배열 answer는 시험문제의 정답지이다.
			2. 배열 hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다.
			3. answer와 hgd 값을 비교해 정오표를 출력한다.
			4. 한 문제당 20점이다.
			
			예)
			answer = {1, 3, 4, 2, 5}
			hgd    = {1, 1, 4, 4, 3}
			정오표   = {O, X, O, X, X}
			성적        = 40점
 */

import java.util.Random;

class OMRMng{
	
	Random ran = new Random();
	
	int[] omr = {1, 4, 3, 2, 2};		// 모범답안
	int[] me = new int[5];				// 학생답안
	
	int cnt = 0;						// 정답 맞춘 개수
	int score = 0;						// 성적
	// 1.me 답안 완성하기
	void makeAnswer() {
		for(int i = 0 ; i < me.length ; i++)
			me[i]=ran.nextInt(5)+1;
	}

	// 2.정답 출력하기
	void showAnswer() {
		System.out.println("모범답안"+Arrays.toString(omr));
		System.out.println("학생답안"+Arrays.toString(me));
	}

	// 3.정답 비교하기
	void checkAnswer() {
		System.out.print("정답체크[");
		for(int i = 0 ; i < me.length ; i++) {
			if(me[i]==omr[i]) {
				cnt++;
				score+=20;
				System.out.print("O");
			}else {
				System.out.print("X");
			}
			if(i!=me.length-1)
				System.out.print(", ");
		}
		System.out.println("]");
		System.out.println("성적 : "+score+"점");
	}
}

public class 메서드OMR {

	public static void main(String[] args) {
		
		OMRMng sm = new OMRMng();
		sm.makeAnswer();
		sm.showAnswer();
		sm.checkAnswer();
	}

}