package Test6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDAO {
	private Scanner scan = new Scanner(System.in);
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private int num = 1001;
	
	public static ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	private String getName() {
		String name = "";
		while (true) {
			System.out.print("이름 입력 : ");
			name = scan.next();
			boolean check = true;
			for (int i = 0; i < studentList.size(); i++) {
				if (name.equals(studentList.get(i).getStudentId())) {
					check = false;
				}
			}
			if (!check) {
				System.err.println("이미 존재하는 이름 입니다.");
				continue;
			}
			break;
		}
		return name;
	}

	void join() {
		if(studentList.size()!=0) {
			num = studentList.get(studentList.size() - 1).getStudentNum() + 1;
		}
		String name = getName();
		studentList.add(new Student(num, name));
		num = studentList.get(studentList.size() - 1).getStudentNum() + 1;
	}

	void deleteStudent() {
		int input=0;
		try {
			System.out.print("학번 입력 : ");
			input = scan.nextInt();
			boolean check = false;
			for (int i = 0; i < studentList.size(); i++) {
				if (input == studentList.get(i).getStudentNum()) {
					studentList.remove(i);
					check = true;
				}
			}
			if (check) {
				for (int i = 0; i < SubjectDAO.getSubjectList().size(); i++) {
					if (input == SubjectDAO.getSubjectList().get(i).getStudentNum()) {
						SubjectDAO.getSubjectList().remove(i);
					}
				}
				System.out.println("삭제 완료");
			} else
				System.err.println("없는 학번 입니다.");
		} catch (InputMismatchException e) {
			System.err.println("숫자만 입력 하세요");
		}

		num = studentList.get(studentList.size() - 1).getStudentNum() + 1;
	}

	void printStudentList() {
		Student[] temp = new Student[studentList.size()];
		for(int i = 0 ; i < temp.length;i++) {
			temp[i]=studentList.get(i);
			}
		for(int i = 0 ; i < temp.length;i++) {
			for(int k = i ; k < temp.length;k++) {
				if(temp[i].getStudentId().compareTo(temp[k].getStudentId())>0) {
					Student tempS = temp[i];
					temp[i]=temp[k];
					temp[k]=tempS;
				}
			}
		}
		for(int i = 0 ; i < temp.length;i++) {
			System.out.println(temp[i].getStudentId() + " " + temp[i].getStudentNum());
			for (int k = 0; k < SubjectDAO.getSubjectList().size(); k++) {
				if (SubjectDAO.getSubjectList().get(k).getStudentNum() == temp[i].getStudentNum()) {		
					System.out.println(
							SubjectDAO.getSubjectList().get(k).getSubject() + " : " + SubjectDAO.getSubjectList().get(k).getScore());
				}
			}
		}
		
	}

	

}
