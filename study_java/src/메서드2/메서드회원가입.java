package 메서드2;

import java.util.Arrays;
import java.util.Scanner;

// 메서드 생성원칙 : 1. 영어로 동사로 시작 , 리턴값이 boolean 값이면 is 
// 메서드는 기능 1개만 구현한다 

class MemberManager {
	// 추가 삭제 수정
	Scanner sc = new Scanner(System.in);
	int maxSize = 10;
	int initNum = 1001; // 맨 처음 추가 회원 번호
	int cnt; // 현재 추가된 회원 수

	// [0]번호 [1]아이디 [2]비밀번호 [3]이름
	String[][] memberList = new String[maxSize][4];

	// 회원 추가 => 중복아이디 값이 없어야한다
	void addMember() {
		if (cnt == maxSize) {
			System.err.println("회원수 초과");
		} else {
			System.out.println("[ 회원 추가 ]");
			while (true) {
				String id = getInputString("아이디");
				if (!checkId(id)) {
					System.err.println("중복된 아이디가 있습니다.");
					continue;
				}
				String pw = getInputString("비밀번호");
				String name = getInputString("이름");
				memberList[cnt][0] = createMemNum();
				memberList[cnt][1] = id;
				memberList[cnt][2] = pw;
				memberList[cnt][3] = name;
				plusInitNum();
				cnt++;
				break;
			}
		}
	}

	// 아이디 체크
	boolean checkId(String input) {
		boolean check = true;
		for (int i = 0; i < memberList.length; i++) {
			if (input.equals(memberList[i][1])) {
				check = false;
			}
		}
		return check;
	}

	// 회원 삭제 => 아이디 입력 받아서 아이디가 있으면 회원삭제
	void delMember() {

		String id = getInputString("삭제할 아이디");
		for (int i = 0; i < cnt; i++) {
			if (memberList[i][1].equals(id)) {
				for (int k = i; k < cnt - 1; k++) {
					memberList[k] = memberList[k + 1];
				}
			}
		}
		cnt--;
		memberList[cnt] = new String[4];
		System.out.println("삭제 완료");
	}

	// 회원 수정 => 회원 번호 입력 받아서 아이디 수정하기
	void changeMember() {
		boolean check = false;
		while (!check) {
			String num = getInputString("수정할 회원 번호");
			for (int i = 0; i < cnt; i++) {
				if (memberList[i][0].equals(num)) {
					while (true) {
						String id = getInputString("아이디");
						if (!checkId(id)) {
							System.err.println("중복된 아이디가 있습니다.");
							continue;
						}
						String pw = getInputString("비밀번호");
						String name = getInputString("이름");
						memberList[i][1] = id;
						memberList[i][2] = pw;
						memberList[i][3] = name;
						check = true;
						break;
					}
				}
			}
			if (!check) {
				System.err.println("존재하지않는 번호 입니다.");
				continue;
			}
		}
	}

	// 전체 회원 출력
	void printMember() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(Arrays.toString(memberList[i]));
		}
	}
	// 회원 번호 체크

	String createMemNum() {
		if (cnt == 0) {
			return initNum + "";
		}
		int max = 0;
		for (int i = 0; i < cnt; i++) {
			if (max < Integer.parseInt(memberList[i][0]))
				max = Integer.parseInt(memberList[i][0]);
		}
		return max + 1 + "";
	}

	// 회원 번호 자동으로 생성 : 자동으로 1 증가하게
	void plusInitNum() {
		int max = 0;
		for (int i = 0; i < cnt; i++) {
			if (max < Integer.parseInt(memberList[i][0]))
				max = Integer.parseInt(memberList[i][0]);
		}
		initNum = max + 1;
	}

	// 메뉴출력
	void printMenu() {
		String menu = "==== 메가 회원 === \n";
		menu += "[1] 회원 추가 \n";
		menu += "[2] 회원 출력 \n";
		menu += "[3] 회원 삭제 \n";
		menu += "[4] 회원 수정 \n";
		menu += "[0] 종    료 \n";

		System.out.println(menu);
	}

	// 사용자에게 입력 받아오는 기능
	int getInputInt(String msg) {
		System.out.println(msg);
		System.out.print("입력 >> ");
		int ret = sc.nextInt();
		return ret;
	}

	String getInputString(String msg) {
		System.out.println(msg);
		System.out.print("입력 >> ");
		String ret = sc.next();
		return ret;
	}

	void run() {

		while (true) {
			printMenu();
			int sel = getInputInt("메뉴 선택하시오");

			if (sel == 0) {
				sc.close();
				return;
			} else if (sel == 1) {
				System.out.println("=== 회원 추가 ===");
				addMember();
			} else if (sel == 2) {
				System.out.println("=== 회원 출력 ===");
				printMember();
			} else if (sel == 3) {
				if (cnt == 0) {
					System.err.println("삭제할 아이디가 없습니다.");
				} else {
					System.out.println("=== 회원 삭제 ===");
					delMember();
				}
			} else if (sel == 4) {
				if (cnt == 0) {
					System.err.println("수정할 아이디가 없습니다.");
				} else {
					System.out.println("=== 회원 수정 ===");
					changeMember();
				}
			} else {
				System.out.println("번호 입력 오류 ");
			}
		}

	}

}

public class 메서드회원가입 {

	public static void main(String[] args) {

		MemberManager mg = new MemberManager();
		mg.run();

		System.out.println("=== 프로그램 종료 ===");
	}

}