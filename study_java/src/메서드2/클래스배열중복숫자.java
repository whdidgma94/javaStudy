package 메서드2;

import java.util.Random;

class RanNum {
	int num;
	boolean check;
}

class RanBNumManger {
	RanNum[] arr = new RanNum[5];

	// 랜덤 숫자 생성
	void getRanNum() {
		Random rd = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new RanNum();
			arr[i].num = rd.nextInt(5) + 1;
		}
	}

	// 중복체크
	void checkNum() {
		while (true) {
			boolean check = false;
			for (int i = 0; i < arr.length; i++)
				for (int k = 0; k < arr.length; k++)
					if (i != k && arr[i].num == arr[k].num) {
						arr[i].check = true;
						check = true;
					}

			for (int i = 0; i < arr.length; i++)
				if (arr[i].check) {
					getRanNum();
					for (int k = 0; k < arr.length; k++)
						arr[k].check = false;
				}
			if (!check)
				break;
		}
	}

	// 랜덤 숫자 출력
	void run() {
		getRanNum();
		checkNum();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].num + " ");
		}
	}
}

public class 클래스배열중복숫자 {

	public static void main(String[] args) {
		RanBNumManger r = new RanBNumManger();
		r.run();

	}

}
