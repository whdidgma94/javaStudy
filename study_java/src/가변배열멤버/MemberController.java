package 가변배열멤버;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberController {
	MemberDAO memberDAO;
	Scanner scan;

	MemberController() {
		memberDAO = new MemberDAO();
		scan = new Scanner(System.in);
	}

	int getValue(String msg, int start, int end) {
		// 예외처리 적용해보세요 : 숫자 아닌값, 숫자 범위 오류
		System.out.println(msg + " > ");
		while (true) {
			try {
				int num = scan.nextInt();
				if(num<start||num>end) {
					throw new Exception();
				}
				return num;
			} catch (InputMismatchException e) {
				System.err.println("숫자를 입력 하세요");
				continue;
			}catch(Exception e) {
				System.err.println(start+"-"+end+" 사이값을 입력 하세요");
				continue;
			}
		}
	}

	void mainMenu() {
		while (true) {
			System.out.println("[1]추가");
			System.out.println("[2]수정");
			System.out.println("[3]삭제");
			System.out.println("[4]전체출력");
			System.out.println("[5]파일저장");
			System.out.println("[6]파일로드");
			System.out.println("[0]종료");

			int sel = getValue("메뉴 ", 0, 6);

			if (sel == 0) {
				break;
			} else if (sel == 1) {
				memberDAO.join();
			} else if (sel == 2) {
				memberDAO.update();
			} else if (sel == 3) {
				memberDAO.remove();
			} else if (sel == 4) {
				memberDAO.printMember();
			} else if (sel == 5) {
				memberDAO.saveData();
			} else if (sel == 6) {
				memberDAO.loadData();
			}
		}

	}
}