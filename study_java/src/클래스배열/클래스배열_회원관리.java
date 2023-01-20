package 클래스배열;

import java.util.Scanner;

//가변배열로 만들기 

class User1 {
	String id;
	String pw;
	int money;

	void printInfo() {
		System.out.printf("id : %s \t pw : %s  잔액 : %d \t \n", id, pw, money);
	}
}

class UserDAO {
	Scanner scan = new Scanner(System.in);
	User1 list[];
	int cnt;
	int log = -1;

	String getString() {
		return scan.next();
	}

	void addUser() {
		if (list == null) {
			list = new User1[1];
			list[0] = new User1();
		} else {
			User1[] temp = list;
			list = new User1[cnt + 1];
			for (int i = 0; i < temp.length; i++) {
				list[i] = temp[i];
			}
			list[cnt] = new User1();
		}
		System.out.println("===회원가입===");
		while (true) {
			boolean check = false;
			System.out.print("아이디 : ");
			String id = getString();
			for (int i = 0; i < list.length; i++) {
				if (id.equals(list[i].id)) {
					check = true;
				}
			}
			if (check) {
				System.err.println("이미 존재하는 아이디 입니다.");
				continue;
			}
			list[cnt].id = id;
			break;
		}
		System.out.print("비밀번호 : ");
		list[cnt].pw = getString();
		while (true) {
			System.out.print("충전금액 : ");
			int input = scan.nextInt();
			if (input < 1000 || input > 1000000) {
				System.err.println("1000~1000000 입력");
				continue;
			}
			if (input % 1000 != 0) {
				System.err.println("1000원 단위 입력");
				continue;
			}
			list[cnt].money = input;
			break;
		}
		cnt++;
	}

	void printMenu() {
		System.out.println("0.종료");
		if (log == -1) {
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.전체 회원 목록");
		} else {
			System.out.println("1.탈퇴");
			System.out.println("2.수정");
			System.out.println("3.로그아웃");
		}
		System.out.println("입력 : ");
	}

	void login() {
		if (cnt == 0)
			System.err.println("회원 정보 없음");
		else {
			System.out.println("===로그인===");
			int idx = -1;
			System.out.print("아이디 : ");
			String id = getString();
			for (int i = 0; i < cnt; i++) {
				if (id.equals(list[i].id))
					idx = i;
			}
			if (idx == -1) {
				System.err.println("존재하지 않는 아이디 입니다.");
				return;
			}
			System.out.print("비밀번호 : ");
			String pw = getString();
			if (!pw.equals(list[idx].pw)) {
				System.err.println("비밀번호가 틀렸습니다.");
				return;
			}
			System.out.println("로그인 성공");
			log = idx;
		}
	}

	void showUserList() {
		for (int i = 0; i < cnt; i++)
			list[i].printInfo();
	}

	void delUser() {

		System.out.print("비밀번호 입력 : ");
		String input = getString();
		if (input.equals(list[log].pw)) {
			User1[] temp = new User1[cnt - 1];
			int idx = 0;
			for (int i = 0; i < cnt; i++) {
				if (i != log) {
					temp[idx] = list[i];
					idx++;
				}
			}
			cnt--;
			list = temp;
			log = -1;
			System.out.println("탈퇴 완료");
		} else {
			System.err.println("비밀번호가 틀렸습니다.");
		}
	}

	void changeMoney() {
		System.out.printf("%s 님의 금액 수정", list[log].id);
		while (true) {
			System.out.print("금액 : ");
			int input = scan.nextInt();
			if (input < 1000 || input > 1000000) {
				System.err.println("1000~1000000 입력");
				continue;
			}
			if (input % 1000 != 0) {
				System.err.println("1000원 단위 입력");
				continue;
			}
			list[log].money = input;
			break;
		}

	}

	void logout() {
		log = -1;
		System.out.println("로그아웃 완료");
	}

	void selMenu(int input) {
		if (log == -1) {
			if (input == 1)
				addUser();
			else if (input == 2)
				login();
			else
				showUserList();
		} else {
			if (input == 1)
				delUser();
			else if (input == 2)
				changeMoney();
			else
				logout();
		}

	}

	void run() {
		while (true) {
			printMenu();
			int input = scan.nextInt();
			if (input == 0) {
				break;
			}
			if (input < 0 || input > 3) {
				System.err.println("입력오류");
				continue;
			}
			selMenu(input);
		}
		System.out.println("시스템 종료");
	}
}

public class 클래스배열_회원관리 {

	public static void main(String[] args) {
		UserDAO s = new UserDAO();
		s.run();
	}

}
