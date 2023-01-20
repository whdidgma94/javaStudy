package 클래스배열;

import java.util.Random;
import java.util.Scanner;

public class 학생컨트롤러1단계 {

	public static void main(String[] args) {
		int max = 10;
		Student[] stList = new Student[max];
		int cnt = 0; // 현재 생성한 학생 숫자

		Scanner scan = new Scanner(System.in);
		Random rd  = new Random();

		while (true) {
			
			System.out.println("[1]학생추가 [2]학생 삭제 [3]수정 [4]검색 [5] 전체출력 [0]종료");

			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				// 추가
				if (cnt == max) {
					System.err.println("더이상 학생을 추가할 수 없습니다.");
					continue;
				}
				Student s = new Student();
				while (true) {
					System.out.print("id : ");
					String id = scan.next();
					boolean check = false;
					for (int i = 0; i < cnt; i++) {
						if (id.equals(stList[i].id)) {
							check = true;
						}
					}
					if (check) {
						System.err.println("중복된 아이디가 있습니다");
						continue;
					}
					s.id=id;
					break;
				}
				System.out.print("pw : ");
				s.pw = scan.next();
				System.out.print("이름 : ");
				s.name = scan.next();				
				s.score = rd.nextInt(100-30+1)+30;
				// 맨처음 학번은 1001
				if(cnt==0)
					s.number=1001;
				else {
					int maxNum = 1001;
					for(int i = 0 ; i < cnt ; i++) {
						if(maxNum<stList[i].number)
							maxNum=stList[i].number;
					}
					s.number=maxNum+1;
				}
				stList[cnt]=s;
				cnt++;
				// 최대학번 + 1 로 자동으로 학번값 넣어주기 : 학번은 입력받지 않는다
				// 이름 아이디(중복 금지) 비번 점수(30-100 랜덤하게 가져오기 )

			} else if (sel == 2) {
				// 삭제 아이디 검색해서 삭제
				System.out.print("삭제할 아이디 입력 : ");
				String delId = scan.next();
				boolean check = false;
				int idx = -1;
				for(int i = 0 ; i < cnt ; i++) {
					if(delId.equals(stList[i].id)) { 
						check=true;
						idx=i;
					}
				}
				if(!check) {
					System.err.println("삭제할 아이디가 존재하지 않습니다.");
					continue;
				}
				for (int i = idx; i < cnt - 1; i++) 
					stList[i] = stList[i + 1];				
				stList[cnt - 1] = null;
				cnt--;
			} else if (sel == 3) {
				// 수정 학번으로 검색 => 점수 수정
				System.out.print("점수 수정할 학번 입력 : ");
				int inputNum = scan.nextInt();
				boolean check = false;
				int idx = -1;
				for(int i = 0 ; i < cnt ; i++) {
					if(inputNum==stList[i].number) { 
						check=true;
						idx=i;
					}
				}
				if(!check) {
					System.err.println("해당 학번은 존재하지 않습니다.");
					continue;
				}
				while (true) {
					System.out.print("수정할 점수를 입력 하세요 : ");
					int inputScore = scan.nextInt();
					if (inputScore < 0 || inputScore > 100) {
						System.err.println("올바르지 않은 점수 입니다.");
						continue;
					}
					stList[idx].score=inputScore;
				}
			} else if (sel == 4) {
				// 검색 -> 이름으로 검색 , 학번 점수 출력 (동명이인 일경우까지 생각)
				System.out.print("검색할 이름 입력 : ");
				String input = scan.next();
				boolean check = false;
				for(int i = 0 ; i < cnt ; i++) {
					if(input.equals(stList[i].name)) {
						System.out.printf("%s 의 학번 %d ==> %d점\n",stList[i].name,stList[i].number,stList[i].score);
						check = true;
					}
				}
				if(!check)
					System.err.println("해당 이름이 존재 하지 않습니다.");
			} else if (sel == 5) {
				if (cnt > 0) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s \n", "학번", "id", "pw", "이름", "점수");
					for (Student s : stList) {
						if (s == null) {
							break;
						}
						System.out.printf("%-10d %-10s %-10s %-13s %-10d \n", s.number, s.id, s.pw, s.name, s.score);
					}
				}
			}else {
				System.err.println("입력 오류");
			}
		}
		scan.close();
	}

}
