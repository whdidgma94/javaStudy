package ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AccountDAO {
	static ArrayList<Account> accountList = new ArrayList<>();
	Random rd;
	Scanner scan;

	AccountDAO() {
		rd = new Random();
		scan = new Scanner(System.in);
	}

	void dataSetting(String accountdata) {
		String temp[] = accountdata.split("\n");
		for (int i = 0; i < temp.length; i++) {
			accountList.add(new Account());
			String temp1[] = temp[i].split("/");
			for (int k = 0; k < ClientDAO.clientList.size(); k++) {
				if (temp1[0].equals(ClientDAO.clientList.get(k).id)) {
					accountList.get(i).clientNo = ClientDAO.clientList.get(k).clientNo;
					ClientDAO.clientList.get(k).count++;
					break;
				}
			}
			accountList.get(i).accountNumber = temp1[1];
			accountList.get(i).money = Integer.parseInt(temp1[2]);
		}

	}

	void addAccount(int num) {
		accountList.add(new Account());
		accountList.get(accountList.size() - 1).clientNo = ClientDAO.clientList.get(num).clientNo;
		accountList.get(accountList.size() - 1).money = 0;
		String temp = "";
		for (int i = 0; i < 12; i++) {
			int rdNum = rd.nextInt(10);
			temp += rdNum;
			if (i % 4 == 3 && i != 11)
				temp += "-";
		}
		accountList.get(accountList.size() - 1).accountNumber = temp;
		ClientDAO.clientList.get(num).count++;
		System.out.println("[계좌 추가 완료]");
	}

	int getAccountIdx(int num, String msg) {
		System.out.print(msg + "할 계좌의 번호 입력 : ");
		int input = scan.nextInt();
		if (input < 1 || input > ClientDAO.clientList.get(num).count) {
			System.err.println("입력 오류");
			return -1;
		}
		if (ClientDAO.clientList.get(num).count == 0) {
			System.err.println(msg + "할 계좌가 없습니다");
			return -1;
		}

		return input;
	}

	void removeAccount(int num) {
		printAccountList(num);
		int count = 0;
		int input = getAccountIdx(num, "삭제");
		if (input == -1) {
			return;
		}
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).clientNo == ClientDAO.clientList.get(num).clientNo) {
				count++;
				if (count == input) {
					accountList.remove(i);
					ClientDAO.clientList.get(num).count--;
					break;
				}
			}
		}

	}

	static void printAccountList(int num) {
		int sum = 0;
		int cnt = 1;
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).clientNo == ClientDAO.clientList.get(num).clientNo) {
				System.out
						.println(cnt + ". " + accountList.get(i).accountNumber + " " + accountList.get(i).money + "원");
				sum += accountList.get(i).money;
				cnt++;
			}
		}
		System.out.println("총 금액 : " + sum);
	}

	static void removeAllAcount(int num) {
		for (int i = 0; i < accountList.size(); i++) {
			if (num == accountList.get(i).clientNo) {
				accountList.remove(i);
			}
		}
	}

	void addMoney(int num) {
		printAccountList(num);
		int input=getAccountIdx(num, "입금");
		int count = 0;
		if(input==-1)
			return;
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).clientNo == ClientDAO.clientList.get(num).clientNo) {
				count++;
				if (count == input) {
					System.out.print("입금할 액수 입력 : ");
					int inputMon = scan.nextInt();
					accountList.get(i).money+=inputMon;
					break;
				}
			}
		}
	}

	void minusMoney(int num) {
		printAccountList(num);
		int input=getAccountIdx(num, "출금");
		int count = 0;
		if(input==-1)
			return;
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).clientNo == ClientDAO.clientList.get(num).clientNo) {
				count++;
				if (count == input) {
					System.out.print("출금할 액수 입력 : ");
					int inputMon = scan.nextInt();
					if(inputMon>accountList.get(i).money) {
						System.err.println("잔액 부족");
						return;
					}
					accountList.get(i).money-=inputMon;
					break;
				}
			}
		}
	}

	void transferMoney(int num) {
		printAccountList(num);
		int input=getAccountIdx(num, "이체");
		int count = 0;
		if(input==-1)
			return;
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).clientNo == ClientDAO.clientList.get(num).clientNo) {
				count++;
				if (count == input) {
					System.out.print("이체할 액수 입력 : ");
					int inputMon = scan.nextInt();
					if(inputMon>accountList.get(i).money) {
						System.err.println("잔액 부족");
						return;
					}
					System.out.println("이체 받을 계좌번호 입력(****-****-****)");
					String accNum=scan.next();
					for(int k = 0 ; k < accountList.size(); k++) {
						if(accNum.equals(accountList.get(k).accountNumber)) {
							accountList.get(i).money-=inputMon;
							accountList.get(k).money+=inputMon;
							break;
						}
					}
					System.out.println("이체 완료");
					break;
				}
			}
		}
		
	}

}
