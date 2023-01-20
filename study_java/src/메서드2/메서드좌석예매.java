package 메서드2;

import java.util.Scanner;

class Theater {

	int[] seat = new int[10];
	Scanner scan = new Scanner(System.in);
	String name = ""; // 영화관 이름
	int cnt = 0; // 예매 수
	int money = 0; // 매출액
	int price = 14000;//티켓가격

	void showSeat() {
		System.out.println(name+" 좌석 현황");
		System.out.println("0 1 2 3 4 5 6 7 8 9");
		for(int i = 0 ; i < seat.length;i++) {
			if(seat[i]==0)
				System.out.print("□ ");
			else
				System.out.print("■ ");
		}
		System.out.println();
	}

	void showMenu() {
		System.out.println(name);
		System.out.println("[1] 좌석 예매");
		System.out.println("[2] 종료");
	}

	void choiceSeat() {
		showSeat();
		if(cnt==seat.length) {
			System.err.println("예약 가능한 자리가 없습니다.");
			return;
		}
		while(true) {
		System.out.print("예약할 자리 입력 : ");
		int input = scan.nextInt();
		if(input<0||input>=seat.length) {
			System.err.println("존재하지 않는 좌석 입니다.");
			continue;
		}
		if(seat[input]!=0) {
			System.err.println("이미 선택된 좌석 입니다.");
			continue;
		}
		seat[input]=1;
		money+=price;	
		break;
		}
	}
	void showSales() {
		System.out.println("총 매출 : "+money);
	}
	void run() {
		name = "메가박스";

		while (true) {
			showSeat();
			// 메뉴 출력
			showMenu();

			// 메뉴 선택하기
			System.out.print("메뉴 선택 : ");
			int choice = scan.nextInt();

			// 예매하기
			if (choice == 1) {
				choiceSeat();
			}
			// 종료하기
			else if (choice == 2) {
				// 매출 현황 출력하기
				showSales();
				System.out.println("프로그램 종료");
				break;
			}else {
				System.err.println("입력오류");
			}

		}
		scan.close();
		
	}
}

public class 메서드좌석예매 {

	public static void main(String[] args) {
	
		Theater megabox = new Theater();
		megabox.run();

		
	}

}
