package Test6;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectDAO {

	private Scanner scan = new Scanner(System.in);
	private static ArrayList<Subject> subjectList = new ArrayList<Subject>();

	public static ArrayList<Subject> getSubjectList() {
		return subjectList;
	}


	private int getIdx(String msg) {
		int input = 0;
		int idx = -1;
		while (true) {
			System.out.printf("과목을 %s할 학번 입력 : ", msg);
			input = scan.nextInt();
			for (int i = 0; i < StudentDAO.getStudentList().size(); i++) {
				if (input == StudentDAO.getStudentList().get(i).getStudentNum()) {
					idx = i;
				}
			}

			break;
		}
		return idx;
	}

	String getSubName(int idx) {
		String subName = scan.next();
		boolean check = false;
		for (int i = 0; i < subjectList.size(); i++) {
			if (subName.equals(subjectList.get(i).getSubject())
					&& subjectList.get(i).getStudentNum() == StudentDAO.getStudentList().get(idx).getStudentNum()) {
				check = true;
			}
		}
		if (check) {
			System.err.println("이미 존재하는 과목 입니다.");
			return "";
		}

		return subName;
	}

	void insertSubject() {
		if (StudentDAO.getStudentList().size() == 0) {
			System.err.println("과목 추가할 학생이 없습니다.");
		} else {
			int idx = getIdx( "추가");
			if (idx == -1) {
				System.err.println("없는 학번 입니다.");
			} else {
				System.out.print("과목 이름 입력 : ");

				String subName = getSubName(idx);
				if (subName.equals("")) {
					return;
				}
				int score = 0;
				while (true) {
					System.out.print("점수 입력 : ");
					score = scan.nextInt();
					if (score < 0 || score > 100) {
						System.err.println("점수가 잘못 되었습니다.");
						continue;
					}
					break;
				}
				subjectList.add(new Subject(StudentDAO.getStudentList().get(idx).getStudentNum(), subName, score));

			}
		}
	}

	void deleteSubject() {
		if (StudentDAO.getStudentList().size() == 0) {
			System.err.println("과목 삭제할 학생이 없습니다.");
		} else {
			int idx = getIdx("삭제");
			if (idx == -1) {
				System.err.println("없는 학번 입니다.");
			} else {
				System.out.print("과목 이름 입력 : ");
				String subName = scan.next();
				boolean check = false;
				for (int i = 0; i < subjectList.size(); i++) {
					if (subjectList.get(i).getStudentNum() == StudentDAO.getStudentList().get(idx).getStudentNum()
							&& subName.equals(subjectList.get(i).getSubject())) {
						subjectList.remove(i);
						i--;
						check = true;
					}
				}
				System.out.println("삭제 완료");
				if (!check)
					System.err.println("없는 과목 입니다.");
			}
		}

	}
}