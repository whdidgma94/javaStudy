package 메서드2;

import java.util.Scanner;

class VendingMachine {
	Scanner scan = new Scanner(System.in);
	int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
	int[] changes = { 1, 1, 1, 1, 5, 10 };

	int tickets = 5; // 식권 개수
	int price = 3200; // 식권 가격

	void printSelectUser() {
		System.out.println("[1]관리자");
		System.out.println("[2]사용자");
		System.out.println("[0]종료");
	}

	void addTicket() {
		while (true) {
			System.out.print("식권 충전 개수 입력 : ");
			int input = scan.nextInt();
			if (input <= 0) {
				System.err.println("입력 오류");
				continue;
			}
			tickets += input;
			break;
		}
	}

	void addChange() {

		while (true) {
			System.out.print("충전할 잔돈 단위 입력 : ");
			int input = scan.nextInt();
			int idx = -1;
			for (int i = 0; i < money.length; i++) {
				if (input == money[i]) {
					idx = i;
				}
			}
			if (idx == -1) {
				System.err.println("단위가 잘 못 되었습니다.");
				continue;
			}
			System.out.printf("%d원권 충전 개수 입력 : ", money[idx]);
			input = scan.nextInt();
			if (input <= 0) {
				System.err.println("입력 오류");
				continue;
			}
			changes[idx] += input;
			break;
		}
	}
	
	void printAdminMenu() {		
		System.out.println("1)식권충전");
		System.out.println("2)잔돈충전");
		System.out.println("0)뒤로가기");
		System.out.print("메뉴 선택 : ");		
	}
	
	void admin() {

		while (true) {
			 printAdminMenu();
			int choice = scan.nextInt();
			if (choice == 1) {
				addTicket();
			} else if (choice == 2) {
				addChange();
			} else if (choice == 0) {
				break;
			} else {
				System.err.println("입력 오류");
				continue;
			}
		}

	}

	void showUserMenu() {

		System.out.println("식권 : " + tickets);

		for (int i = 0; i < money.length; i++) {
			System.out.printf("%5d원 : %2d매   ", money[i], changes[i]);
			if (i % 3 == 2) {
				System.out.println();
			}
		}
		System.out.print("구매할 식권 개수 입력 : ");

	}

	void buyTicket() {

		while (true) {

			System.out.println("식권 가격 : " + price);
			if (tickets <= 0) {
				System.out.println("식권 : 매진");
				return;
			}
			showUserMenu();
			int input = scan.nextInt();
			if (input <= 0) {
				System.err.println("입력 오류 : 0이상 입력");
				continue;
			}
			if (input > tickets) {
				System.err.println("남은 식권이 부족합니다.");
				return;
			}
			System.out.println("총 금액 : " + price * input);
			System.out.print("현금 입력 : ");
			int cash = scan.nextInt();
			if (cash % 100 != 0) {
				System.err.println("입력 오류 : 100원단위 이상 입력 해주세요.");
			}
			if (price * input > cash) {
				System.err.println("현금이 부족 합니다.");
				return;
			}
			int penny = cash - price * input;
			int result = 0;
			for (int i = 0; i < money.length; i++) {
				if (money[i] <= penny && changes[i] != 0) {
					while (changes[i] != 0 && penny != 0) {
						if (penny - money[i] < 0) {
							break;
						}
						changes[i]--;
						penny -= money[i];
						result += money[i];
					}
				}
			}
			tickets-=input;
			System.out.println("거스름돈 : " + result);
			break;
		}

	}

	void user() {

		while (true) {
			System.out.println("1)구입");
			System.out.println("0)뒤로가기");
			System.out.print("메뉴 선택 : ");
			int choice = scan.nextInt();
			if (choice == 1) {
				buyTicket();
			} else if (choice == 0) {
				break;
			}
		}

	}

	void run() {

		while (true) {
			printSelectUser();
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			if (sel == 1) {
				admin();
			} else if (sel == 2) {
				user();
			} else if (sel == 0) {
				System.out.println("시스템 종료");
				break;
			} else {
				System.err.println("입력오류");
			}
		}

	}
}

public class 메서드식권자판기 {

	public static void main(String[] args) {

		VendingMachine v = new VendingMachine();
		v.run();

	}

}
