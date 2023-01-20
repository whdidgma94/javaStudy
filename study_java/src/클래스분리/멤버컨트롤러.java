package 클래스분리;

import java.util.Scanner;

class Member {
	String id;
	String pw;
	String name;

	void printMember() {
		System.out.println(id + " : " + pw + " : " + name);
	}
}

class MemberDAO {

	Scanner scan;
	int max;
	int memberCount;
	Member[] memberList;

	void init(int size) {
		scan = new Scanner(System.in);
		memberList = new Member[size];
		max = size;
	}

	String getString(String msg) {
		System.out.print(msg + " 입력 : ");
		String input = scan.next();
		return input;
	}

	boolean checkDuplicate(String id) {

		for (int i = 0; i < memberCount; i++) {
			if (id.equals(memberList[i].id)) {
				return false;
			}
		}
		return true;
	}

	int checkId(String id) {
		int idx = -1;
		for (int i = 0; i < memberCount; i++) {
			if (id.equals(memberList[i].id)) {
				idx = i;
			}
		}
		return idx;
	}

	void join() {
		if (memberCount == max) {
			System.err.println("회원 추가 불가");
			return;
		}
		String id = getString("아이디");
		if (!checkDuplicate(id)) {
			System.out.println("중복된 아이디가 있습니다.");
			return;
		}
		memberList[memberCount] = new Member();
		memberList[memberCount].id = id;
		memberList[memberCount].pw = getString("비밀번호");
		memberList[memberCount].name = getString("이름");
		memberCount++;
	}

	void delete() {
		String id = getString("삭제할 아이디");
		int idx = checkId(id);
		if (idx == -1) {
			System.err.println("존재하지 않는 아이디 입니다.");
			return;
		}
		for (int i = idx; i < memberCount - 1; i++) {
			memberList[i] = memberList[i + 1];
		}
		System.out.println("삭제 완료");
		memberCount--;
	}

	void update() {
		String id = getString("수정할 아이디");
		int idx = checkId(id);
		if (idx == -1) {
			System.err.println("존재하지 않는 아이디 입니다.");
			return;
		}
		System.out.println("===" + memberList[idx].id + "님 회원 정보 수정===");
		memberList[idx].pw = getString("수정할 비밀번호");
		memberList[idx].name = getString("수정할 이름");
		System.out.println("수정 완료");
		memberList[idx].printMember();
	}

	void printAll() {
		for (int i = 0; i < memberCount; i++) {
			memberList[i].printMember();
		}
	}
}

class MemberController {

	Scanner scan;
	MemberDAO memberDAO;

	void init() {
		scan = new Scanner(System.in);
		memberDAO = new MemberDAO();
		memberDAO.init(100);
	}

	void run() {
		while (true) {
			System.out.println("[1]추가 [2]삭제 [3]수정 [4]출력  [0]종료");
			int sel = scan.nextInt();
			if (sel == 1) {
				memberDAO.join();
			} else if (sel == 2) {
				memberDAO.delete();
			} else if (sel == 3) {
				memberDAO.update();
			} else if (sel == 4) {
				memberDAO.printAll();
			} else if (sel == 0) {
				System.out.println("[종료]");
				break;
			}
		}
	}
}

public class 멤버컨트롤러 {

	public static void main(String[] args) {

		MemberController controller = new MemberController();
		controller.init();
		controller.run();
	}

}
