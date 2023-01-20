package movie;

import java.util.Scanner;

public class UserDAO {
	Scanner scan;
	int userCount;
	int max;
	User[] userList;
	int log = -1;

	void init(int size) {
		scan = new Scanner(System.in);
		userList = new User[size];
		max = size;
	}

	void login() {
		String id = getString("아이디");
		String pw = getString("비밀번호");
		for (int i = 0; i < userCount; i++) {
			if (userList[i].checkLog(id, pw))
				log = i;
		}
		if (log == -1) {
			System.err.println("로그인 실패");
			return;
		}
		System.out.println(userList[log].id + "님 로그인 완료");
	}

	void logout() {
		System.out.println("로그아웃 완료");
		log = -1;
	}

	String getString(String msg) {
		System.out.print(msg + " 입력 : ");
		String input = scan.next();
		return input;
	}

	boolean checkDuplicate(String id) {
		for (int i = 0; i < userCount; i++) {
			if (id.equals(userList[i].id)) {
				return false;
			}
		}
		return true;
	}

	void addUser() {
		if (userCount == max) {
			System.err.println("회원 추가 불가");
			return;
		}
		String id = getString("아이디");
		if (!checkDuplicate(id)) {
			System.out.println("중복된 아이디가 있습니다.");
			return;
		}
		userList[userCount] = new User();
		userList[userCount].id = id;
		userList[userCount].pw = getString("비밀번호");
		userCount++;
	}

}
