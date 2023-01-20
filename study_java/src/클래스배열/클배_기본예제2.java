package 클래스배열;

import java.util.Scanner;

class Subject{
	int stuNum; // 학번 Student 클래스의 number 랑 같은 값 
	String name;// 과목 이름 
	int score; // 과목 점수
	int rank;// 그 과목 등수 
}

public class 클배_기본예제2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	
		
		// 기존에 있는 Student 클래스 학번 이름 점수(총합 )
		String studentSample = "1001/이만수\n";
		studentSample += "1002/김철만\n";		
		studentSample += "1003/오수정\n";
		
		String subjectSample = "";
		subjectSample += "1001/국어/100/0\n";
		subjectSample += "1001/수학/32/0\n";
		subjectSample += "1002/국어/23/0\n";
		subjectSample += "1002/수학/35/0\n";
		subjectSample += "1002/영어/46/0\n";
		subjectSample += "1003/수학/60/0";	
		String[] temp1 = studentSample.split("\n");
		String[] temp2 = subjectSample.split("\n");
		//문제1) 위 샘플문자열들을 각각 해당 클래스배열에 저장후 출력
		Student[] stu = new Student[temp1.length];
		for(int i = 0 ; i < stu.length;i++) {
			Student s = new Student();
			String[] temp = temp1[i].split("/");
			s.number=Integer.parseInt(temp[0]);
			s.name=temp[1];
			stu[i]=s;
			System.out.printf("%d %s\n",s.number,s.name);
		}
		System.out.println("=======================");
		Subject[] sub = new Subject[temp2.length];
		for(int i = 0 ; i < sub.length;i++) {
			Subject s = new Subject();
			String[] temp = temp2[i].split("/");
			s.stuNum = Integer.parseInt(temp[0]);
			s.name = temp[1];
			s.score = Integer.parseInt(temp[2]);
			s.rank = Integer.parseInt(temp[3]);
			sub[i]=s;
			System.out.printf("%d %s %d\n",s.stuNum,s.name,s.score);
		}
		System.out.println("======================");
		//문제1) 점수가 59점이하인 과목은 전부 삭제후 다시 문자열로 저장후 출력 
		int size = sub.length;
		for(int i = 0; i < size;i++) {
			if(sub[i].score<=59) {
				for(int k = i ; k < size-1 ; k++) {
					sub[k]=sub[k+1];
				}
				size--;
				i--;
				sub[size]=null;
			}
		}
		for(int i = 0; i < size;i++) {
			System.out.printf("%d %s %d\n",sub[i].stuNum,sub[i].name,sub[i].score);
		}
		sc.close();
	}

}