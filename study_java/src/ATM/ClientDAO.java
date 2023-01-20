package ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientDAO {
	static ArrayList<Client> clientList = new ArrayList<>();
	int num = 1001+clientList.size();	
	Scanner scan;
	ClientDAO() {
		scan= new Scanner(System.in);
	}
	
	void fixClient(int idx) {
		
		String id = getString("아이디");
		for(int i = 0 ; i < clientList.size();i++) {
			if(id.equals(clientList.get(i).id)) {
				System.err.println("이미 존재하는 아이디 입니다.");
				return;
			}
		}
		String pw = getString("비밀번호");
		String name = getString("이름");
		clientList.get(idx).id=id;
		clientList.get(idx).pw=pw;
		clientList.get(idx).name=name;
		System.out.println("[수정 완료]");		
	}
	
	
	
	void dataSetting(String clientData) {
		String[] temp = clientData.split("\n");
		for(int i = 0 ; i<temp.length;i++) {
			clientList.add(new Client());
			String[] temp1 = temp[i].split("/");
			clientList.get(i).clientNo=num;
			num++;
			clientList.get(i).id=temp1[0];
			clientList.get(i).pw=temp1[1];
			clientList.get(i).name=temp1[2];
		}
		
	}
	String getString(String msg) {
		System.out.print(msg+" 입력 : ");
		String input = scan.next();
		return input;
		
	}
	
	int login() {
		String id = getString("아이디");
		for(int i = 0 ; i < clientList.size();i++) {
			if(id.equals(clientList.get(i).id)) {
				String pw = getString("비밀번호");
				if(pw.equals(clientList.get(i).pw)) {
					System.out.println(clientList.get(i).name+" 님 로그인 완료");
					return i;
				}else {
					System.err.println("비밀번호 입력 오류");
					return -2;
				}
			}
		}
		System.err.println("존재하지 않는 아이디 입니다.");
		return -2;
	}

	void join() {
		String id = getString("아이디");
		for(int i = 0 ; i < clientList.size();i++) {
			if(id.equals(clientList.get(i).id)) {
				System.err.println("이미 존재하는 아이디 입니다.");
				return;
			}
		}
		String pw = getString("비밀번호");
		String name = getString("이름");
		clientList.add(new Client());
		clientList.get(clientList.size()-1).clientNo=num;
		num++;
		clientList.get(clientList.size()-1).id=id;
		clientList.get(clientList.size()-1).pw=pw;
		clientList.get(clientList.size()-1).name=name;
		System.out.println("[가입 완료]");
	}
	void removeClient(int num) {
		AccountDAO.removeAllAcount(clientList.get(num).clientNo);
		clientList.remove(num);
		System.out.println("[탈퇴 완료]");
	}
	void printMyPage(int num) {
		System.out.println("[1]계좌 조회");
		System.out.println("[2]비밀번호 수정");
		System.out.print("번호 입력");
		int input=scan.nextInt();
		if (input == 1) {
			AccountDAO.printAccountList(num);
		} else if (input == 2) {
			String pw = getString("비밀번호");
			clientList.get(num).pw=pw;
			System.out.println("수정 완료");
		} else {
			System.err.println("입력 오류");
		}
	}
}
