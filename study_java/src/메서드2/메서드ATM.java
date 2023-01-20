package 메서드2;

import java.util.Scanner;

class BankNoReturn {

	Scanner scan = new Scanner(System.in);

	String name = "";

	String[] arAcc = { "1111", "2222", "3333", "", "" };
	String[] arPw = { "1234", "2345", "3456", "", "" };
	int[] arMoney = { 87000, 34000, 17500, 0, 0 };

	int count = 3;
	int loginCheck = -1;

	// 리턴안쓰므로 해서 생긴변수
	int checkDelete;
	int checkAccount;
	int checkPassword;

	void showMember() {
		System.out.println("==전체 회원 정보==");
		for (int i = 0; i < count; i++) {
			System.out.printf("[%d](아이디) %s  (계좌) %d원\n", i + 1, arAcc[i], arMoney[i]);
		}
	}

	void showMenu() {
		System.out.println("[1] 회원가입");
		System.out.println("[2] 회원탈퇴");
		if (loginCheck == -1) {
			System.out.println("[3] 로그인");
		} else {
			System.out.println("[4] 로그아웃");
			System.out.println("[5] 입금");
			System.out.println("[6] 이체");
		}
		System.out.println("[0] 종료");
	}

	void joinMember() {
		if (count == arAcc.length) {
			System.err.println("가입가능 인원 초과");
			return;
		}
		while (true) {
			System.out.print("아이디 입력 : ");
			String id = scan.next();
			boolean check = true;
			for (int i = 0; i < arAcc.length; i++) {
				if (arAcc[i].equals(id)) {
					check = false;
				}
			}
			if (!check) {
				System.err.println("중복된 아이디가 있습니다.");
				continue;
			}
			System.out.print("비밀번호 입력 : ");
			String pw = scan.next();
			arAcc[count] = id;
			arPw[count] = pw;
			count++;
			break;
		}
	}

	void delMember() {
		if (count == 0) {
			System.err.println("삭제할 아이디가 없습니다.");
			return;
		}
		while (true) {
			System.out.print("삭제할 아이디 입력 : ");
			String id = scan.next();

			int idx = -1;
			for (int i = 0; i < arAcc.length; i++) {
				if (arAcc[i].equals(id)) {
					idx = i;
				}
			}
			if (idx == -1) {
				System.err.println("아이디가 존재하지 않습니다.");
				continue;
			}
			for (int i = idx; i < count - 1; i++) {
				arAcc[i] = arAcc[i + 1];
				arPw[i] = arPw[i + 1];
				arMoney[i] = arMoney[i + 1];
			}
			count--;
			arAcc[count] = "";
			arPw[count] = "";
			arMoney[count] = 0;
			break;
		}
	}

	void login() {
		if (loginCheck != -1) {
			System.err.println("이미 로그인 상태 입니다.");
			return;
		}
		while (true) {
			System.out.print("아이디 입력 : ");
			String id = scan.next();
			int idx = -1;
			for (int i = 0; i < arAcc.length; i++) {
				if (arAcc[i].equals(id)) {
					idx = i;
				}
			}
			if (idx == -1) {
				System.err.println("아이디가 없습니다.");
				continue;
			}
			System.out.print("비밀번호 입력 : ");
			String pw = scan.next();
			if (pw.equals(arPw[idx])) {
				System.out.println(arAcc[idx] + "님 로그인 성공");
				loginCheck = idx;
			}
			break;
		}
	}

	void logOut() {
		if (loginCheck == -1) {
			System.err.println("이미 로그아웃 상태 입니다.");
			return;
		}
		System.out.println("로그아웃 완료");
		loginCheck = -1;
	}

	void income() {
		if (loginCheck == -1) {
			System.err.println("로그인 후 이용 가능합니다.");
			return;
		}
		while (true) {
			System.out.print("입금 금액 입력 : ");
			int input = scan.nextInt();
			if (input % 100 != 0) {
				System.err.println("100원단위로 입력 하세요.");
				continue;
			}
			arMoney[loginCheck] += input;
			System.out.println("입금 완료");
			break;
		}
	}

	void trans() {
		if (loginCheck == -1) {
			System.err.println("로그인 후 이용 가능합니다.");
			return;
		}
		while (true) {
			System.out.print("이체 할 계좌 입력");
			String inputId = scan.next();
			int idx = -1;
			for (int i = 0; i < count; i++) {
				if (inputId.equals(arAcc[i]))
					idx = i;
			}
			if (idx == -1) {
				System.err.println("존재하지 않는 계좌 입니다.");
				continue;
			}
			System.out.print("이체 금액 입력 : ");
			int input = scan.nextInt();
			if (input % 100 != 0) {
				System.err.println("100원단위로 입력 하세요.");
				continue;
			}
			if (input > arMoney[loginCheck]) {
				System.err.println("잔액이 부족합니다.");
				continue;
			}
			arMoney[loginCheck] -= input;
			arMoney[idx] += input;
			System.out.println("이체 완료");
			break;
		}
	}

}

public class 메서드ATM {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		BankNoReturn woori = new BankNoReturn();

		woori.name = "우리은행";

		while (true) {
			// 전체 회원정보 출력
			woori.showMember();
			// 메뉴 출력
			woori.showMenu();
			// 메뉴 선택
			System.out.print("메뉴를 선택해주세요 : ");
			int choice = scan.nextInt();
			if (choice == 0) {
				System.out.println("시스템 종료");
				break;
			}
			// 회원가입
			else if (choice == 1) {
				woori.joinMember();
			}
			// 회원탈퇴
			else if (choice == 2) {
				woori.delMember();
			}
			// 로그인
			else if (choice == 3) {
				woori.login();
			}
			// 로그아웃
			else if (choice == 4) {
				woori.logOut();
			}
			// 입금
			else if (choice == 5) {
				woori.income();
			}
			// 이체
			else if (choice == 6) {
				woori.trans();
			} else {
				System.err.println("입력 오류");
			}
		}
		scan.close();
	}
}
