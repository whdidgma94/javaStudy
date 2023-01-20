package 문자열;

import java.util.Scanner;

public class 쇼핑몰관리자프로젝트 {

	public static void main(String[] args) {

		/*
		 * # 쇼핑몰 [관리자] 
		 * 1. 카테고리와 아이템을 입력받아 아래의 예시와 같이 저장한다. 
		 * 2. 카테고리는 각 행의 첫번째 열에 저장한다. 
		 * 3. 아이템은 각 행의 두번째 열에 저장한다. 
		 *    단, 아이템은 여러개를 추가할 수 있도록 슬러시(/)를 구분자로 연결해준다. 
		 * 예) 
		 * { 
		 * {"과일", "사과/포도/"}, 
		 * {"과자", "홈런볼/쪼리퐁/"}, 
		 * {"음료", "콜라/"}, 
		 * {"육류", "소고기/"}
		 *  ... 
		 * }
		 */

		String data = "과일,사과/포도\n";
		data += "과자,홈런볼/조리퐁\n";
		data += "음료,콜라/사이다/나랑드\n";
		data += "육류,소고기/돼지고기/오리고기/닭고기\n";

		Scanner scan = new Scanner(System.in);

		String[][] items = new String[100][2];
		for (int i = 0; i < items.length; i++) {
			items[i][0] = "";
			items[i][1] = "";
		}

		int itemCount = 0;

		while (true) {
			String[] temp = data.split("\n");
			itemCount = temp.length;
			for (int i = 0; i < temp.length; i++) {
				items[i] = temp[i].split(",");
			}
			System.out.println("[관리자 모드]");
			System.out.println("[1]카테고리 관리"); // 카데고리 추가 삭제 구현
			System.out.println("[2]아 이 템  관리"); // 아이템 추가 삭제 구현
			System.out.println("[3]전체품목 출력");
			System.out.println("[0]종료");

			System.out.print(": ");
			int sel = scan.nextInt();

			if (sel == 1) {
				System.out.println("[카테고리 관리]");
				while (true) {
					for (int i = 0; i < itemCount; i++) {
						System.out.printf("[%d] %s\n", i + 1, items[i][0]);
					}
					System.out.print("(1)추가 (2)삭제 (3)뒤로 >>");
					int input = scan.nextInt();

					if (input > 3 || input < 1) {
						System.err.println("입력 오류");
						continue;
					}
					if (input == 1) {
						System.out.print("[추가] 카테고리 입력 : ");
						String add = scan.next();
						boolean check = true;
						for (int i = 0; i < itemCount; i++) {
							if (items[i][0].equals(add)) {
								check = false;
							}
						}
						if (!check) {
							System.err.println("[메세지] 카테고리 이름 중복");
							continue;
						} else {
							data += add + ",\n";
							itemCount++;
						}
					} else if (input == 2) {
						System.out.println("[삭제] 번호 입력");
						int del = scan.nextInt();
						if (del < 0 || del > itemCount) {
							System.err.println("[메세지] 번호 오류");
							continue;
						}
						for (int i = del - 1; i <= itemCount; i++) {
							items[i] = items[i + 1];
						}
						itemCount--;
						items[itemCount][0] = "";
						items[itemCount][1] = "";
						data = "";
						for (int i = 0; i < itemCount; i++) {
							data += items[i][0] + "," + items[i][1] + "\n";
						}
					} else if (input == 3) {
						break;
					} else {
						System.err.println("입력 오류");
					}
				}
			} else if (sel == 2) {
				System.out.println("[아이템 관리]");
				while (true) {
					for (int i = 0; i < itemCount; i++) {
						System.out.printf("[%d] %s\n", i + 1, items[i][0]);
					}
					System.out.print("카테고리 번호 입력 (0:뒤로): ");
					int input = scan.nextInt();
					if (input < 0 || input > itemCount) {
						System.err.println("입력 오류");
						continue;
					}
					if (input == 0) {
						break;
					}
					while (true) {
						System.out.print("(1)추가 (2)삭제 (3)뒤로 >>");
						int pick = scan.nextInt();
						if (pick > 3 || pick < 1) {
							System.err.println("입력오류");
							continue;
						}
						if (pick == 3) {
							break;
						}
						System.out.printf("[%s]\n", items[input - 1][0]);
						String[] menu = items[input - 1][1].split("/");
						for (int i = 0; i < menu.length; i++) {
							System.out.printf("(%2d) %s\n", i + 1, menu[i]);
						}
						if (pick == 1) {
							System.out.println("[추가] 아이템 입력");
							String add = scan.next();
							boolean check = true;
							for (int i = 0; i < menu.length; i++) {
								if (add.equals(menu[i])) {
									System.err.println("이미 있는 아이템 입니다.");
									check = false;
								}
							}
							if (check) {
								items[input - 1][1] = items[input - 1][1].substring(0, items[input - 1][1].length());
								items[input - 1][1] += "/" + add + "\n";
							}
						} else if (pick == 2) {
							System.out.println("[삭제] 아이템 번호 입력");
							int del = scan.nextInt();
							data = data.replaceAll(menu[del - 1], "");
						} else {
							System.err.println("입력 오류");
						}
					}
				}
			} else if (sel == 3) {
				System.out.println("[전체 품목 출력]");
				for (int i = 0; i < itemCount; i++) {
					System.out.printf("[%2d] %s (%s)\n", i + 1, items[i][0], items[i][1]);

				}
			} else if (sel == 0) {
				System.out.println("시스템 종료");
				break;
			} else {
				System.out.println("입력 오류");
			}
		}
		scan.close();
	}

}
