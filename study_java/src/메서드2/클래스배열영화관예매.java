package 메서드2;

import java.util.Scanner;

class SeatVO {
	boolean check;

	void showData() {
		if (check == true) {
			System.out.print("■ ");
		} else {
			System.out.print("□ ");
		}
	}
}

class SeatDAO {
	SeatVO[] seatList = new SeatVO[8];
	String name = "";
	Scanner scan = new Scanner(System.in);
	int cnt;
	int money;

	void init() {
		name = "메가박스";
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = new SeatVO();
		}
	}

	void printMenu() {
		System.out.println("[1]예매하기");
		System.out.println("[2]종료");
	}

	int getInput() {
		int input = scan.nextInt();
		return input;
	}

	void bookSeat() {
		System.out.println("0 1 2 3 4 5 6 7");
		while (true) {
			for (int i = 0; i < seatList.length; i++) {
				seatList[i].showData();
			}
			System.out.println();
			System.out.printf("자리 선택 ([8]종료): ");
			int input = getInput();
			if (input == 8) {
				break;
			}
			if (input < 0 || input > seatList.length) {
				System.err.println("범위오류");
				continue;
			}
			if (seatList[input].check == true) {
				System.out.println("이미 선택된 자리 입니다.");
				continue;
			}
			seatList[input].check = true;
			money += 12000;
		}
	}

	void run() {
		init();
		// 메뉴 출력
		while (true) {
			printMenu();
			// 메뉴 선택
			int input = getInput();
			if (input == 1)// 예매하기
				bookSeat();
			else if (input == 2) {// 종료 -> 매출액 출력
				System.out.println("총 매출액 : " + money);
				break;
			} else
				System.err.println("입력오류");
		}
	}
}

public class 클래스배열영화관예매 {

	public static void main(String[] args) {

		SeatDAO dao = new SeatDAO();
		dao.run();

	}

}
