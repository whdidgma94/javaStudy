package 클래스배열;

import java.util.Scanner;

class Member{
	int number;
	String id;
	String name;
}

class Account{
	String accountNumber;
	String password;
	int money;
	String memberId;
}
public class 클배_ATM {
	public static void main(String[] args) {
	String[][] memberData = {
			{"1001" , "qwer" , "김철수"},
			{"1002" , "mmkk11" , "이영희"},
			{"1003" , "javaking123" , "최민수"}			
		};	
		String[][] accountData = {
			{"111111111" , "1234" ,"100000" , "qwer"},
			{"222222222" , "1234" ,"200000" , "mmkk11"},
			{"333333333" , "1234" ,"300000" , "mmkk11"},
			{"444444444" , "1234" ,"400000" , "javaking123"},
			{"555555555" , "1234" ,"500000" , "qwer"},
			{"666666666" , "1234" ,"600000" , "qwer"},
		};
		
		Account[] accountList = new Account[accountData.length];
		Member[] memberList = new Member[memberData.length];
		
		Scanner scan = new Scanner(System.in);

		while (true) {
			String menu = "";
			menu += "[0] 종료 \n";
			menu += "[1] 위data배열들의 값들을 클래스배열에 저장후 출력 \n";
			menu += "[2] 회원아이디를 입력받고 계좌별 잔액출력  \n";
			menu += "[3] 222222222 계좌에서 444444444 계좌로 5000원송금후 전체출력 \n";
			System.out.println(menu);

			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				System.out.println("계정 데이터");
				System.out.println("--------------------------------------");
				System.out.println("회원번호   아이디          이름");
				for(int i = 0 ; i < memberData.length;i++) {
					Member s = new Member();
					s.number = Integer.parseInt(memberData[i][0]);
					s.id=memberData[i][1];
					s.name=memberData[i][2];
					memberList[i]=s;
					System.out.printf("%d   %-12s   %s\n",memberList[i].number,memberList[i].id,memberList[i].name);
				}
				for(int i = 0 ; i < accountData.length;i++) {
					Account s = new Account();
					s.accountNumber = accountData[i][0];
					s.password=accountData[i][1];
					s.money=Integer.parseInt(accountData[i][2]);
					s.memberId=accountData[i][3];
					accountList[i]=s;
				}
			} else if (sel == 2) {
				System.out.print("회원 아이디 입력 : ");
				String input = scan.next();
				String tempId = "";
				boolean check = false;
				for(int i = 0 ; i < memberList.length;i++) {
					if(input.equals(memberList[i].id)) {
						tempId=memberList[i].id;
						check = true;
					}
				}
				if(!check) {
					System.err.println("없는 아이디 입니다.");
					continue;
				}
				for(int i = 0 ; i < accountList.length;i++) {
					if(accountList[i].memberId.equals(tempId)) {
						System.out.printf("계좌 : %s 잔액 : %d\n",accountList[i].accountNumber,accountList[i].money);
					}
				}
			} else if (sel == 3) {
				for(int i = 0 ; i < accountList.length ; i++) {
					if(accountList[i].accountNumber.equals("222222222"))
						accountList[i].money-=5000;
					else if(accountList[i].accountNumber.equals("444444444"))
						accountList[i].money+=5000;
					System.out.printf("계좌 : %s 잔액 : %d\n",accountList[i].accountNumber,accountList[i].money);
				}
			}

		}
		scan.close();
	}
}