package 클래스배열;

import java.util.Scanner;

public class 학생컨트롤러2단계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String studentSample = "1001/이만수\n";
		studentSample += "1002/김철만\n";
		studentSample += "1003/오수정\n";
		String[] temp1 = studentSample.split("\n");
		Student[] stu = new Student[temp1.length];
		for(int i = 0 ; i < stu.length;i++) {
			Student s = new Student();
			String[] temp = temp1[i].split("/");
			s.number= Integer.parseInt(temp[0]);
			s.name = temp[1];
			stu[i]=s;
		}
		String subjectSample = "";
		subjectSample += "1001/국어/10/0\n";
		subjectSample += "1001/수학/32/0\n";
		subjectSample += "1002/국어/23/0\n";
		subjectSample += "1002/수학/35/0\n";
		subjectSample += "1002/영어/46/0\n";
		subjectSample += "1003/수학/60/0\n";
		subjectSample += "1003/영어/100/0";
		String[] temp2 = subjectSample.split("\n");
		Subject[] sub = new Subject[temp2.length];
		for(int i = 0 ; i < sub.length;i++) {
			Subject s = new Subject();
			String[] temp = temp2[i].split("/");
			s.stuNum = Integer.parseInt(temp[0]);
			s.name = temp[1];
			s.score = Integer.parseInt(temp[2]);
			s.rank = Integer.parseInt(temp[3]);
			sub[i]=s;
		}
		for(int i = 0 ; i < stu.length;i++) {
			for(int k = 0 ; k < sub.length;k++) {
				if(sub[k].stuNum==stu[i].number) {
					stu[i].score+=sub[k].score;
				}
			}
		}
		while (true) {
			System.out.println("[0] 종료 ");
			System.out.println("[1] 학생 정보 출력 ");
			System.out.println("[2] 과목 정보 출력 ");
			System.out.println("[3] 과목별 랭킹 저장 ");
			System.out.println("[4] 과목별 랭킹 + 이름 출력");
			System.out.println("[5] 과목별 랭킹 1등의 이름 과목 점수 출력 ");
			System.out.println("[6] 학생별 평균 점수 높은순으로 이름 점수 출력 ");

			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("시스템 종료");
				break;
			} else if (sel == 1) {
				System.out.println("학번     이름     총점");
				System.out.println("----------------------------");
				for(int i = 0 ; i < stu.length;i++) {					
					System.out.printf("%d   %s    %d\n",stu[i].number,stu[i].name,stu[i].score);
				}
			} else if (sel == 2) {
				System.out.println("학번    과목    점수    랭킹");
				System.out.println("----------------------------");
				for(int i = 0 ; i < sub.length ; i++) {
					System.out.printf("%d   %s    %-3d    %d\n",sub[i].stuNum,sub[i].name,sub[i].score,sub[i].rank);
				}
			} else if (sel == 3) {
				for(int i = 0 ; i < sub.length;i++) {
					int cnt=1;
					for(int k = 0 ; k < sub.length;k++) {
						if(sub[i].score<sub[k].score&&sub[i].name.equals(sub[k].name)) {
							cnt++;
						}
					}
					sub[i].rank=cnt;
				}
				System.out.println("과목별 랭킹 저장 완료");
			} else if (sel == 4) {
				System.out.println("학번    과목    점수    랭킹    이름");
				System.out.println("----------------------------");
				for(int i = 0 ; i < sub.length ; i++) {
					String name = "";
					for(int k = 0 ; k < stu.length;k++) 
						if(sub[i].stuNum==stu[k].number)
							name=stu[k].name;					
					System.out.printf("%d   %s    %-3d    %d    %s\n",sub[i].stuNum,sub[i].name,sub[i].score,sub[i].rank,name);
				}
			} else if (sel == 5) {
				System.out.println("학번    과목    점수    랭킹    이름");
				System.out.println("----------------------------");
				for(int i = 0 ; i < sub.length ; i++) {
					String name = "";
					for(int k = 0 ; k < stu.length;k++) 
						if(sub[i].stuNum==stu[k].number)
							name=stu[k].name;				
					if(sub[i].rank==1) 
						System.out.printf("%d   %s    %-3d    %d    %s\n",sub[i].stuNum,sub[i].name,sub[i].score,sub[i].rank,name);
				}
			} else if (sel == 6) {
				System.out.println("학번    이름      총점   평균점수");
				System.out.println("----------------------------");
				double[] avr = new double[stu.length];				
				for(int i = 0 ; i < avr.length;i++) {
					double cnt = 0;
					for(int k = 0 ; k < sub.length;k++) {
						if(sub[k].stuNum==stu[i].number) {
							cnt++;
						}
					}
					avr[i]=stu[i].score/cnt*1.0;
				}
				int cnt=0;
				while(cnt!=stu.length) {
					double max = 0;
					int idx = -1;				
					for(int i = 0 ; i < avr.length ; i++) {
						if(max<avr[i]) {
							max=avr[i];
							idx=i;
						}
					}
					System.out.printf("%d   %s    %3d   %.2f\n",stu[idx].number,stu[idx].name,stu[idx].score,avr[idx]);
					avr[idx]=0;
					cnt++;
				}

			} else {
				System.err.println("입력 오류");
			}

		}
		sc.close();
	}

}
