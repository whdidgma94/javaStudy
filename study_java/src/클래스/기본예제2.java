package 클래스;

import java.util.Arrays;
import java.util.Scanner;

// 기본메모리그림3 에 있는 sample03 클래스를 이용하세요 
//class Sample03 {
//	int[] hakbun = {1001, 1002, 1003, 1004, 1005};
//	int[] score  = {  92,   38,   87,  100,   11};
//}


public class 기본예제2 {

	public static void main(String[] args) {
		
		Sample03 ss = new Sample03();
		
		// 문제1) scores배열에 1~100점 사이의 정수를 5개 저장
		// 예 1) 87, 11, 92, 14, 47
		int scores[] = ss.score;
		System.out.println(Arrays.toString(scores));
		// 문제2) 전교생의 총점과 평균 출력
		// 예 2) 총점(251) 평균(50.2)
		int sum = 0;
		for(int num:ss.score)
			sum+=num;
		System.out.printf("총점(%d) 평균(%.1f)\n",sum,sum/ss.score.length*1.0);
		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예 3) 2명
		int cnt=0;
		for (int num : ss.score)
			if (num >= 60)
				cnt++;
		System.out.printf("%d명\n",cnt);
		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1 성적 : 11점
		Scanner scan = new Scanner(System.in);
		int input=-1;
		while (true) {
			System.out.print("인덱스 입력 : ");
			input = scan.nextInt();
			if (input < 0 || input >= ss.score.length) {
				System.err.println("인덱스범위 오류");
				continue;
			}
			break;
		}
		System.out.printf("성적 : %d\n",ss.score[input]);
		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11 인덱스 : 1
		input=-1;
		int idx=-1;
		while (true) {
			System.out.print("성적 입력 : ");
			input = scan.nextInt();
			boolean check = false;
			for(int i = 0 ; i < ss.score.length;i++) 
				if(input==ss.score[i]) {
					check=true;
					idx=i;
				}
			if (check)
				break;
			else
				System.err.println("없는 성적 입니다.");
		}
		System.out.println("인덱스 : "+idx);
	
		// 문제7) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리
		// 예 7)
		// 학번 입력 : 1002 성적 : 11점
		// 학번 입력 : 1000 해당학번은 존재하지 않습니다.
		int sco = 0;
		while (true) {
			System.out.print("학번 입력 : ");
			input = scan.nextInt();
			boolean check = false;
			for(int i = 0 ; i < ss.hakbun.length;i++) 
				if(input==ss.hakbun[i]) {
					check=true;
					sco=ss.score[i];
				}
			if (check)
				break;
			else
				System.err.println("해당 학번은 존재하지 않습니다");
		}
		System.out.println("성적 : "+sco);
		// 문제8) 1등학생의 학번과 성적 출력
		// 정답8) 1003번(92점)
		idx=-1;
		int max = 0;
		for(int i =0 ; i < ss.score.length;i++) {
			if(ss.score[i]>max) {
				idx=i;
				max=ss.score[i];
			}
		}
		System.out.printf("%d번(%d점)",ss.hakbun[idx],max);
		scan.close();
	}

}