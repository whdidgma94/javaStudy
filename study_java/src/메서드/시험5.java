package 메서드;

import java.util.Scanner;

class User{
	String id;
}
class Seat{
	int y;
	int x;
	String userId;
	boolean check;
	int price;
}

public class 시험5 {

	public static void main(String[] args) {
		int seatPrice = 12000;
		
		String[] userIdList = {"aaa" , "bbb" , "ccc"};
		String[][] seatUserIdList = {
			{null	,"aaa"	,"aaa"  ,null},
			{null   ,null 	,"bbb" 	,null},
			{"ccc" 	,"bbb" 	,null 	,"bbb"}
		};
		User[] userList = new User[userIdList.length];
		for(int i = 0 ; i < userList.length;i++) {
			userList[i]=new User();
			userList[i].id=userIdList[i];
			}
		int seatSize = 12;		
		Seat[] seatList = new Seat[seatSize];
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int cnt=0;
			for(int i = 0 ; i < seatUserIdList.length;i++) {
				for(int k = 0 ; k < seatUserIdList[i].length;k++) {
					seatList[cnt]=new Seat();
					if(seatUserIdList[i][k]!=null) {
						seatList[cnt].check=true;
						seatList[cnt].userId=seatUserIdList[i][k];
					}
					cnt++;
				}
			}
			System.out.println("[0] 종료\n"
					+ "[1] 전체출력\n"
					+ "[2] 회원 aaa가 예약한 자리와 요금출력\n"
					+ "[3] 예약가능한자리 위치출력 \n"
					+ "[4] 예약을 가장많이한 회원출력");
			int sel = scan.nextInt();
			if(sel == 0) {
				break;
			}else if(sel == 1) {
				System.out.println("===[좌석예매]===");
				for(int i = 0; i < seatSize; i++) {
					if(seatList[i].check) {
						System.out.printf("[%5s]", seatList[i].userId);
					}else {
						System.out.printf("[%5s]","");
					}
					if (i % 4 == 3) {
						System.out.println();
					}
				}
			} else if (sel == 2) {
				cnt=0;
				for (int i = 0; i < seatSize; i++) {
					if (seatList[i].check) {
						if (seatList[i].userId.equals("aaa")) {
							System.out.printf("[%5s]", seatList[i].userId);
							cnt++;
						} else {
							System.out.printf("[%5s]", "X");
						}
					} else {
						System.out.printf("[%5s]", "");
					}
					if (i % 4 == 3) {
						System.out.println();
					}
				}
				System.out.println("총 금액은 "+cnt*seatPrice+"원 입니다.");
			} else if (sel == 3) {				
				System.out.println("===[좌석예매]===");
				System.out.println("O(예매가능), X(예매불가)");
				for(int i = 0; i < seatSize; i++) {
					if(seatList[i].check) {
						System.out.printf("[%5s]","X");
					}else {
						System.out.printf("[%5s]","O");
					}
					if (i % 4 == 3) {
						System.out.println();
					}
				}
				System.out.print("예매가능한 좌석 번호 : ");
				String show = "";
				for(int i = 0; i < seatSize; i++)
					if(seatList[i].check==false)
						show+=i+1+", ";
				show=show.substring(0,show.length()-2);
				System.out.println(show);		
			} else if (sel == 4) {
				int[] temp = new int[userList.length];
				for(int i = 0; i < seatSize; i++) {
					if(seatList[i].check) {
						for(int k = 0 ; k < userList.length ;k++) {
							if(seatList[i].userId.equals(userList[k].id)) {
								temp[k]++;
							}
						}
					}
				}
				int max=temp[0];
				int idx=0;
				for(int i = 0 ; i < temp.length;i++) {
					if(max<temp[i]) {
						max=temp[i];
						idx=i;
					}
				}
				System.out.printf("가장 예약을 많이 한 회원 : %s\n",userList[idx].id);
			} else {
				System.err.println("입력오류");
			}
		}
		scan.close();
	}

}