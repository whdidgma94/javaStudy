package ATM;

public class Client {
	int clientNo;
	String id;
	String pw;
	String name;
	int count;
	@Override
	public String toString() {
		return "회원번호 = " + clientNo + ", 아이디=" + id + ", 비밀번호=" + pw + ", 이름=" + name;
	}
}
