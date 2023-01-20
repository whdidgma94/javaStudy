package 클래스배열;

class Subject1 {
	String name;
	String stuNo;
	int score;

	String getInfo() {
		return name + "\t" + score + "\t\n";
	}
}

class Student1 {
	String stuNo;
	Subject1[] subjects;
	String name;

	String getData() {
		String data = name + " \n";
		for (Subject1 sub : subjects) {
			if (sub == null)
				return data;
			data += sub.getInfo();
		}
		return data;
	}

	void printInfo() {
		System.out.println(getData());
	}

	void createSub(String[] subject) {
		int cnt = 0;
		for (int i = 0; i < subject.length; i++) {
			String[] temp = subject[i].split("/");
			if (temp[0].equals(stuNo)) {
				cnt++;
			}
		}
		subjects = new Subject1[cnt];
		for (int i = 0; i < subjects.length; i++) {
			subjects[i] = new Subject1();
		}
		int idx = 0;
		for (int i = 0; i < subject.length; i++) {
			String[] temp = subject[i].split("/");
			if (temp[0].equals(stuNo)) {
				subjects[idx].name = temp[1];
				subjects[idx].score = Integer.parseInt(temp[2]);
				idx++;
			}
		}
	}

}

class StudentDAO {
	Student1[] list;

	void printAllStudent() {
		for (Student1 stu : list) {
			stu.printInfo();
		}
	}

	void init() {
		String stuData = "1001/이만수\n";
		stuData += "1002/김철만\n";
		stuData += "1003/오수정\n";
		String subData = "";
		subData += "1001/국어/10\n";
		subData += "1001/수학/32\n";
		subData += "1002/국어/23\n";
		subData += "1002/수학/35\n";
		subData += "1002/영어/46\n";
		subData += "1003/수학/60\n";
		subData += "1003/영어/100\n";
		String[] students = stuData.split("\n");
		String[] subjects = subData.split("\n");
		list = new Student1[students.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = new Student1();
			String[] temp = students[i].split("/");
			list[i].stuNo = temp[0];
			list[i].name = temp[1];
			list[i].createSub(subjects);
		}
	}

	void run() {
		init();
		printAllStudent();
	}
}

public class 학생컨트롤러3단계 {

	public static void main(String[] args) {

		StudentDAO dao = new StudentDAO();
		dao.run();
	}

}
