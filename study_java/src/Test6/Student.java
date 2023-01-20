package Test6;

public class Student {
	private int studentNum; // 1씩 자동증가 1001~  
	private String studentId; // 중복금지 
	public Student(int studentNum, String studentId) {
		super();
		setStudentNum(studentNum);
		setStudentId(studentId);
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
}