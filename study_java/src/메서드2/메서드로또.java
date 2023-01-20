package 메서드2;

import java.util.Random;
import java.util.Scanner;

class Lotto {
	int[] data = new int[8]; // 00303033 꽝 00300333 당첨
	boolean win = false;

	void print() {
		for (int i = 0; i < 8; i++) {
			System.out.print(data[i]);
		}
		if (win)
			System.out.println(" <<당첨");
		else
			System.out.println(" <<꽝");
	}
}

class LottoDAO {

	Lotto[] set;

	void init() {
		set = new Lotto[5];
		for (int i = 0; i < set.length; i++)
			set[i] = new Lotto();
	}

	int winner;

	// 로또 5개 생성 하되 딱 1개만 로또 당첨
	void getIdx() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("인덱스 입력 : ");
			winner = scan.nextInt();
			if (winner < 0 || winner >= set.length) {
				System.err.println("인덱스 범위 오류");
				continue;
			}
			break;
		}
		scan.close();
	}

	void getNum() {
		Random rd = new Random();
		for (int i = 0; i < set.length; i++) {
			int cnt = 0;
			for (int k = 0; k < set[i].data.length; k++) {
				int num = rd.nextInt(2);
				set[i].data[k] = num * 3;
				if (num == 0) {
					cnt = 0;
				} else {
					cnt++;
				}
				if (cnt == 3) {
					set[i].win = true;
				}
			}
		}
	}

	void checkWin() {
		while (true) {
			boolean check = false;
			init();
			getNum();

			for (int i = 0; i < set.length; i++) {
				if (i == winner) {
					if (!set[i].win)
						check = true;
				} else {
					if (set[i].win) {
						check = true;
					}
				}
			}
			if (check) {
				continue;
			}
			break;
		}
	}

	void run() {
		init();
		getIdx();
		checkWin();
		for (int i = 0; i < set.length; i++) {
			set[i].print();
		}
	}

}

public class 메서드로또 {

	public static void main(String[] args) {
		LottoDAO a = new LottoDAO();
		a.run();

	}

}
