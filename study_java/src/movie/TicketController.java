package movie;

import java.util.Scanner;

public class TicketController {
	UserDAO userDAO;
	SeatDAO seatDAO;
	Scanner scan;

	void init() {
		scan = new Scanner(System.in);
		userDAO = new UserDAO();
		seatDAO = new SeatDAO();
		userDAO.init(10);
		seatDAO.init(8);
	}

	void run() {
		while (true) {
			if (userDAO.log == -1) {
				System.out.println("1)로그인 2)가입 0)종료");
				int sel = scan.nextInt();
				if (sel == 1) {
					if (userDAO.userCount > 0) {
						userDAO.login();
					} else {
						System.err.println("가입자가 없습니다.");
					}
				} else if (sel == 2) {
					userDAO.addUser();
				} else if (sel == 0) {
					System.out.println("종료");
					break;
				} else {
					System.err.println("입력오류");
				}
			} else {
				System.out.println("1)영화예매 2)예매취소 3)예매확인 0)로그아웃");
				int sel = scan.nextInt();
				if (sel == 1) {
					seatDAO.bookSeat(userDAO);
				} else if (sel == 2) {
					seatDAO.cancelSeat(userDAO);
				} else if (sel == 3) {
					seatDAO.checkSeat(userDAO);
				} else if (sel == 0) {
					System.out.println("로그아웃");
					userDAO.logout();
				} else {
					System.err.println("입력오류");
				}
			}

		}
	}
}
