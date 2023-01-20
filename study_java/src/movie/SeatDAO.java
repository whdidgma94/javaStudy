package movie;

import java.util.Scanner;

public class SeatDAO {
	Scanner scan;
	Seat[] seatList;

	void init(int size) {
		scan = new Scanner(System.in);
		seatList = new Seat[size];

		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = new Seat();
			seatList[i].number = i + 1;
		}
	}

	void bookSeat(UserDAO userDAO) {
		for (int i = 0; i < seatList.length; i++) {
			seatList[i].showNum();
			seatList[i].showData();
		}
		System.out.println();
		System.out.print("예매 할 좌석 번호 입력 : ");
		int input = scan.nextInt() - 1;
		if (input < 0 || input >= seatList.length) {
			System.err.println("입력 오류");
			return;
		}
		if (seatList[input].check) {
			System.err.println("이미 선택된 좌석 입니다.");
		} else {
			seatList[input].check = true;
			seatList[input].userID = userDAO.userList[userDAO.log].id;
		}
	}

	void cancelSeat(UserDAO userDAO) {
		checkSeat(userDAO);
		System.out.println("취소할 좌석 선택");
		int input = scan.nextInt() - 1;
		if (input < 0 || input >= seatList.length) {
			System.err.println("입력 오류");
			return;
		}
		if (seatList[input].userID.equals(userDAO.userList[userDAO.log].id)) {
			seatList[input] = new Seat();
			seatList[input].number = input + 1;
			System.out.println("취소 완료");
		} else {
			System.err.println("해당좌석을 예매하지 않았습니다");
		}
	}

	void checkSeat(UserDAO userDAO) {
		System.out.println(userDAO.userList[userDAO.log].id + "님이 예매하신 좌석");
		for (int i = 0; i < seatList.length; i++) {
			seatList[i].showNum();
			if (seatList[i].userID.equals(userDAO.userList[userDAO.log].id)) {
				System.out.print("■ ");
			} else {
				System.out.print("□ ");
			}
		}
		System.out.println();

	}

}
