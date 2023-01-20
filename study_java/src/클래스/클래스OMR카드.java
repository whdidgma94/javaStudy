package 클래스;

import java.util.Arrays;

class OMR {
	int[] answer = {1, 3, 4, 2, 5};		// 시험답안
	int[] hgd = new int[5];				// 홍길동 학생답안	
	int cnt = 0;						// 정답 맞춘 개수
	int score = 0;						// 성적
}

/*
[문제]
	1. 배열 answer는 시험문제의 정답지이다.
	2. 배열 hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다.
	3. answer와 hgd 값을 비교해 정오표를 출력한다.
	4. 한 문제당 20점이다.
	
	answer = {1, 3, 4, 2, 5}
	hgd    = {1, 1, 4, 4, 3}
	성적    = 40점		 
*/
public class 클래스OMR카드 {

	public static void main(String[] args) {
		int[] input = { 1, 1, 4, 4, 3 };
		OMR card = new OMR();
		card.hgd = input;

		for (int i = 0; i < card.answer.length; i++) {
			if (card.hgd[i] == card.answer[i]) {
				card.cnt++;
				card.score += 20;
			}
		}
		System.out.println("answer = " + Arrays.toString(card.answer));
		System.out.println("hgd    = " + Arrays.toString(card.hgd));
		System.out.println("성적    = " + card.score + "점");
	}

}