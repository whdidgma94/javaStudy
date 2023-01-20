package 가변배열멤버;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MemberDAO {
	int num; // 학번 1001 시작
	int cnt;
	Member[] memberList;
	Scanner scan;
	FileWriter fw;
	FileReader fr;
	String fileName = "src/가변배열멤버/memberList.text";

	MemberDAO() {
		num = 1001;
		scan = new Scanner(System.in);
	}

	String getValue(String msg) {
		// id 입력 받을 때 숫자값만 입력받으면 id 는 적어도 한개 문자값 포함이라는
		// 예외처리 적용해보세요
		String val = "";
		while (true) {
			System.out.println(msg + " > ");
			boolean check = false;
			val = scan.next();
			for (int i = 0; i < val.length(); i++) {
				if ((int) val.charAt(i) < 48 || (int) val.charAt(i) > 57) {
					check = true;
				}
			}
			if (!check) {
				System.err.println("문자 1개 이상 포함");
				continue;
			}
			for (int i = 0; i < cnt; i++) {
				if (val.equals(memberList[i].id)) {
					check = false;
				}
			}
			if (!check) {
				System.err.println("이미 존재하는 아이디 입니다.");
				continue;
			}
			break;
		}
		return val;
	}

	int getIdx(String msg) {
		System.out.print(msg + "입력 : ");
		int input = scan.nextInt();
		int idx = -1;
		for (int i = 0; i < cnt; i++) {
			if (input == memberList[i].num) {
				idx = i;
			}
		}
		System.out.println(idx);
		return idx;
	}

	void join() {
		String name = getValue("아이디 입력 ");
		if (cnt == 0) {
			memberList = new Member[1];
			memberList[0] = new Member(name, num);
		} else {
			Member[] temp = memberList;
			memberList = new Member[cnt + 1];
			for (int i = 0; i < cnt; i++) {
				memberList[i] = temp[i];
			}
			memberList[cnt] = new Member(name, num);
		}
		num = memberList[cnt].num + 1;

		cnt++;
	}

	void remove() {
		if (cnt == 0) {
			System.err.println("회원이 존재하지 않습니다");
			return;
		}
		int idx = getIdx("학번");// 1
		if (idx == -1) {
			System.err.println("없는 학번 입니다.");
			return;
		}
		Member[] temp = memberList;
		memberList = new Member[cnt - 1];
		int tIdx = 0;
		for (int i = 0; i < cnt; i++) {
			if (i != idx) {
				memberList[tIdx] = temp[i];
				tIdx++;
			}
		}
		cnt--;
	} // 삭제하고자 하는 학번 입력

	void update() {
		if (cnt == 0) {
			System.err.println("회원이 존재하지 않습니다");
			return;
		}
		int idx = getIdx("학번");
		if (idx == -1) {
			System.err.println("없는 학번 입니다.");
			return;
		}
		memberList[idx].id = getValue("수정할 아이디 입력 ");
	} // 수정 하고자 하는 학번입력하면 아이디 수정

	void printMember() {
		for (int i = 0; i < cnt; i++) {
			memberList[i].printMember();

		}
	}

	void saveData() {

		// 저장패턴 memberList.text
		// 아이디,학번\n 이렇게 한줄로 저장
		try {
			fw = new FileWriter(fileName);
			for (int i = 0; i < cnt; i++) {
				fw.write(memberList[i].id + "," + memberList[i].num);
				if (i != cnt - 1) {
					fw.write("\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					System.out.println("저장 완료");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 저장예시
		// 1001,test1\nl002,test2

	}

	void loadData() {
		try {
			fr = new FileReader(fileName);
			String data = "";
			int read = 0;
			while (read != -1) {
				read = fr.read();
				if (read != -1) {
					data += (char) read;
				}
			}
			String[] temp = data.split("\n");
			cnt = temp.length;
			memberList = new Member[cnt];
			for (int i = 0; i < cnt; i++) {
				String[] temp1 = temp[i].split(",");
				memberList[i] = new Member(temp1[0], Integer.parseInt(temp1[1]));
			}
			num = memberList[cnt - 1].num + 1;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}