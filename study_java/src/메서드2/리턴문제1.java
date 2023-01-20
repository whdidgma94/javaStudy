package 메서드2;

import java.util.Arrays;

class Return1 {
	int cnt;
	int[] ret(String[] data, int[] res) {
		int temp[] = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			if (Integer.parseInt(data[i]) >= 60) {
				this.cnt++;
				temp[i] = Integer.parseInt(data[i]);
			}
		}
		res = new int[this.cnt];
		int idx = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				res[idx] = temp[i];
				idx++;
			}
		}
		return res;
	}
}

public class 리턴문제1 {

	public static void main(String[] args) {

		/*
		 * [문제] main() 메서드 안에 data배열은 학생 점수를 문자열로 타입으로 저장한 것이다. 점수는 0~100점 사이이고, 60점
		 * 이상이면 합격생이다. 오로지 합격생의 점수만 result배열에 담아서 리턴하는 run메서드를 구현하시오.
		 */
		Return1 re = new Return1();

		String[] data = { "34", "43", "76", "12", "64" };
		int result[] = null;
		result = re.ret(data, result);
		System.out.println(Arrays.toString(result));


	}

}