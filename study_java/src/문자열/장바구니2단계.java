package 문자열;

import java.util.Scanner;

public class 장바구니2단계 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] idList = { "qwer", "javaking", "abcd" };
		String[] pwList = { "1111", "2222", "3333" };

		int MAX_SIZE = 100;
		String[][] cartList = new String[MAX_SIZE][2];

		String[] items = { "사과", "바나나", "딸기" };

		int log = -1;
		int count = 0;
		while (true) {

			System.out.println("[MEGA MART]");
			if (log == -1) {
				System.out.println("[1]로 그 인");
				System.out.println("[0]종     료");
				System.out.print("메뉴 선택 : ");
				int sel = scan.nextInt();
				if (sel == 1) {
					System.out.print("아이디 입력 : ");
					String id = scan.next();
					int idx=-1;
					for(int i = 0 ; i < idList.length;i++) {
						if(id.equals(idList[i])) {
							idx=i;
						}
					}
					if(idx==-1) {
						System.err.println("존재하지 않는 아이디 입니다.");
						continue;
					}
					System.out.print("비밀번호 입력 : ");
					String pw = scan.next();
					if(pw.equals(pwList[idx])) {
						System.out.println("로그인 성공");
						log = idx;
					}else {
						System.err.println("비밀번호가 틀렸습니다.");
					}
				}
				 else if (sel == 0) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.err.println("입력 오류");					
				}
			} else {				
				System.out.println("[1]로그아웃");
				System.out.println("[2]쇼     핑");
				System.out.println("[3]장바구니");
				System.out.println("[0]종     료");
				System.out.print("메뉴 선택 : ");
				int sel = scan.nextInt();
				
				if (sel == 1) {
					System.out.println("로그아웃 성공");
					log=-1;
				} else if (sel == 2) {
					for(int i = 0 ; i <items.length;i++) {
						System.out.printf("(%d)%s",i+1,items[i]);
					}
					System.out.println("(0)종료");
					while (true) {
						int input = scan.nextInt();
						if (input >= 1 && input <= 3) {
							cartList[count][0] = idList[log];
							cartList[count][1] = items[input-1];
							System.out.printf("%s 구매 완료",items[input-1]);
						} else if (input == 0) {
							System.out.println("쇼핑 종료");
							break;
						} else {
							System.err.println("입력 오류");
							count--;
						}
						count++;
					}
				} else if (sel == 3) {
					// 장바구니
					System.out.printf("==== [%s 장바구니 ]==== \n", idList[log]);
					int itemCnt[] = new int[items.length];
					int total = 0;
					for (int i = 0; i < items.length; i++) {
						for (int k = 0; k < count; k++) {
							if (idList[log].equals(cartList[k][0]) && items[i].equals(cartList[k][1])) {
								itemCnt[i]++;
								total++;
							}
						}
					}
					if (total == 0) {
						System.err.println("[장바구니가 비었습니다]");
						continue;
					}
					System.out.printf("\t 총 장바구니[%d 개] \n", total);
					for (int i = 0; i < items.length; i++) {
						if (itemCnt[i] > 0) {
							System.out.printf("\t[%s][%3d개] \n", items[i], itemCnt[i]);
						}
					}				
					System.out.println("----------------");
					System.out.println("[1]아이템 삭제 [2] 전체 삭체 ");
					System.out.println("입력 >> ");
					int num = scan.nextInt();
					if (num == 1) {
						// 아이템 이름으로 삭제
						while (true) {
							boolean check = false;
							System.out.println("[삭제] 아이템 입력");
							String input = scan.next();
							for (int i = 0; i < count; i++) {
								if (input.equals(cartList[i][1])&&idList[log].equals(cartList[i][0])) {
									for (int k = i; k < cartList.length - 1; k++) {
										cartList[k] = cartList[k + 1];
									}
									check = true;
									count--;
									break;
								}
							}
							if (check) {
								System.out.printf("%s 1개 삭제 완료\n",input);
								break;
							}
							System.out.println("존재하지 않는 아이템 입니다.");
						}
					}else if(num == 2) {
						System.out.println("[전체 삭제 완료 ]");
						// 본인 아이디 전체 장바구니 비우기 
						for (int i = 0; i < count; i++) {
							if (idList[log].equals(cartList[i][0])) {
								cartList[i][0]="";
								cartList[i][1]="";
							}
						}
						for (int i = 0; i < count; i++) {
							if (cartList[i][0].equals("")) {
								for(int k= i ; k < count;k++) {
									if(!cartList[k][0].equals("")) {
										cartList[i]=cartList[k];
										break;
									}
								}
								count--;
							}
						}
					}	
					
				} else if (sel == 0) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.err.println("입력 오류");					
				}
			}
		}
		scan.close();

	}

}
