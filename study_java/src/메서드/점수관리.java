package 메서드;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class ScoreMng {
	
	Random rd = new Random();
	Scanner scan = new Scanner(System.in);
	
	int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };	
	int[] scores = new int[5];
	void rdScore() {
		for(int i = 0 ; i < scores.length;i++)
			scores[i]=rd.nextInt(100)+1;
		System.out.println("학번"+Arrays.toString(hakbuns));
		System.out.print("점수[");
		for(int i = 0 ; i < scores.length;i++) {
			System.out.printf("%4d",scores[i]);
			if(i!=scores.length-1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
	void showScore() {
		int sum = 0;
		double avr = 0.0;
		for(int i = 0 ; i < scores.length ; i++) 
			sum+=scores[i];
		avr=sum*1.0/scores.length;
		System.out.println("총점 : "+sum);
		System.out.printf("평균 : %.1f\n",avr);
	}
	void countPass() {
		int cnt=0;
		for(int i = 0 ; i < scores.length ; i++) 
			if(scores[i]>=60)
				cnt++;
		System.out.println("합격생 : "+cnt+"명");
	}
	void showInputScore() {
		while(true) {
			System.out.print("인덱스 입력 : ");
			int input = scan.nextInt();
			if (input < 0 || input >= scores.length) {
				System.err.println("인덱스 범위 오류");
				continue;
			}
			System.out.println("성적 : "+scores[input]);
			break;
		}
	}
	void showInputIdx() {
		while(true) {
			System.out.print("성적 입력 : ");
			int input = scan.nextInt();
			int idx=-1;
			
			for(int i = 0 ; i < scores.length;i++) {
				if(input==scores[i])
					idx=i;
			}
			if(idx==-1) {
				System.err.println("없는 성적 입니다.");
				continue;
			}
			System.out.println("인덱스 : "+idx);
			break;
		}
	}
	void showHaktoScore() {
		while(true) {
			System.out.print("학번 입력 : ");
			int input = scan.nextInt();
			int idx=-1;
			
			for(int i = 0 ; i < hakbuns.length;i++) {
				if(input==hakbuns[i])
					idx=i;
			}
			if(idx==-1) {
				System.err.println("없는 학번 입니다.");
				continue;
			}
			System.out.println("성적 : "+scores[idx]);
			break;
		}
	}
	void showFirst() {
		int max=scores[0];
		int idx=0;
		for(int i = 0 ; i < scores.length;i++) {
			if(max<scores[i]) {
				idx=i;
				max=scores[i];
			}
		}
		System.out.println("1등학생 : "+hakbuns[idx]);
		System.out.println("1등성적 : "+scores[idx]);
	}
	
	
}
public class 점수관리 {

	public static void main(String[] args) {
		
		ScoreMng s = new ScoreMng();
		
		// 문제1) scores배열에 1~100점 사이의 랜덤 정수를 5개 저장
		// 예 1) 87, 11, 92, 14, 47
		s.rdScore();
		// 문제2) 전교생의 총점과 평균 출력
		// 예 2) 총점(251) 평균(50.2)
		s.showScore();
		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예 3) 2명
		s.countPass();
		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1 성적 : 11점
		s.showInputScore();
		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11 인덱스 : 1
		s.showInputIdx();
		// 문제6) 학번을 입력받아 성적 출력
		// 문제7) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리
		// 예 7)
		// 학번 입력 : 1002 성적 : 11점
		// 학번 입력 : 1000 해당학번은 존재하지 않습니다.
		s.showHaktoScore();			
		// 문제8) 1등학생의 학번과 성적 출력
		s.showFirst();
		
	}

}
