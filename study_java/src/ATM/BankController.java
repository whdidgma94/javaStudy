package ATM;

import java.util.Scanner;

public class BankController {
	
	String name="우리은행";
	Scanner scan;
	AccountDAO accountDAO;
	ClientDAO clientDAO;
	int stat=-1;
	
	
	BankController() {
		scan = new Scanner(System.in);
		accountDAO = new AccountDAO();
		clientDAO = new ClientDAO();
	}
	
	void setSampleData() {
		String clientData = "test01/1111/김철수\n";
		clientData += "test02/2222/이영희\n";
		clientData += "test03/3333/신민수\n";
		clientData += "test04/4444/최상민";
				
		String accountdata = "test01/1111-1111-1111/8000\n";
		accountdata += "test02/2222-2222-2222/5000\n";
		accountdata += "test01/3333-3333-3333/11000\n";
		accountdata += "test03/4444-4444-4444/9000\n";
		accountdata += "test01/5555-5555-5555/5400\n";
		accountdata += "test02/6666-6666-6666/1000\n";
		accountdata += "test03/7777-7777-7777/1000\n";
		accountdata += "test04/8888-8888-8888/1000";		
		// 1) test01 김철수는 계좌를 3개 가지고있다.
		// 2) test02 이영희는 계좌를 2개 가지고있다.
		// 3) test03 신민수는 계좌를 2개 가지고있다.
		// 4) test04 최상민은 계좌를 1개 가지고있다. 
		
		clientDAO.dataSetting(clientData);
		accountDAO.dataSetting(accountdata);		
	}
	
	void printMainMenu() {
		System.out.println("[메인 화면]");
		System.out.println("[1] 관리자");
		System.out.println("[2] 사용자");
		System.out.println("[0] 종료");
	}
	
	void printUserMenu() {
		System.out.println("[사용자 화면]");
		System.out.println("[1] 회원가입");
		System.out.println("[2] 로그인");
		System.out.println("[0] 뒤로가기");
	}

	int getInput() {
		System.out.print("번호 입력 : ");
		int input = scan.nextInt();
		return input;
	}
	
	void printLoginMenu() {
		System.out.printf("[1] 계좌 추가\n"
				+ "[2] 계좌 삭제\n"
				+ "[3] 입금\n"
				+ "[4] 출금\n"
				+ "[5] 이체\n"
				+ "[6] 탈퇴 \n"
				+ "[7] 마이페이지: 전체 계좌, 금액 (회원정보: 비밀번호 수정)\n"
				+ "[0] 뒤로가기\n");
	}
	void printAdminMenu() {
		System.out.println("[1] 회원목록 - 전체회원 목록\n"
				+ "[2] 회원정보 수정\n"
				+ "[3] 회원정보 삭제\n"
				+ "[4] 회원정보 저장\n"
				+ "[5] 회원정보 불러오기\n"
				+ "[0] 뒤로가기\n");
	}
	int getNum() {
		System.out.println("회원 번호 입력");
		int input=scan.nextInt();
		int idx=-1;
		for(int i = 0 ; i < ClientDAO.clientList.size();i++) {
			if(input==ClientDAO.clientList.get(i).clientNo)
				idx=i;
		}
		return idx;
	}
	void run() {
		setSampleData();
		while (true) {
			if (stat == -1) {
				printMainMenu();
				int input = getInput();
				if (input == 1) {
					System.out.println("관리자 선택");
					stat=AccountDAO.accountList.size();
				} else if (input == 2) {
					System.out.println("사용자 선택");
					stat=-2;
				} else if (input == 0) {
					System.out.println("종료");
					break;
				} else {
					System.err.println("입력 오류");
				}
			} else {
				if (stat == -2) {
					printUserMenu();
					int input = getInput();
					if (input == 1) {
						clientDAO.join();
					} else if (input == 2) {
						stat=clientDAO.login();
					} else if (input == 0) {
						stat=-1;
					} else {
						System.err.println("입력 오류");
					}

				} else if (stat == AccountDAO.accountList.size()) {
					printAdminMenu();
					int input = getInput();
					if (input == 1) {
						for(int i = 0 ; i < ClientDAO.clientList.size();i++) {
							System.out.println(ClientDAO.clientList.get(i));
						}
					} else if (input == 2) {
						input=getNum();
						clientDAO.fixClient(input);
					} else if (input == 3) {
						input=getNum();
						clientDAO.removeClient(input);
						stat = AccountDAO.accountList.size();
					} else if (input == 4) {
						
					} else if (input == 5) {
						
					} else if (input == 0) {
						stat=-1;
					} else {
						System.err.println("입력 오류");
					}
				} else {
					printLoginMenu();
					int input = getInput();
					if (input == 1) {
						accountDAO.addAccount(stat);
					} else if (input == 2) {
						accountDAO.removeAccount(stat);
					} else if (input == 3) {
						accountDAO.addMoney(stat);
					} else if (input == 4) {
						accountDAO.minusMoney(stat);
					} else if (input == 5) {
						accountDAO.transferMoney(stat);
					} else if (input == 6) {
						clientDAO.removeClient(stat);
						stat=-1;
					} else if (input == 7) {
						clientDAO.printMyPage(stat);
					} else if (input == 0) {
						stat=-2;
					} else {
						System.err.println("입력오류");
					}
				}
			}
		}
	}
}
