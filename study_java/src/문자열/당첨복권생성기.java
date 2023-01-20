package 문자열;

import java.util.Arrays;
import java.util.Random;

public class 당첨복권생성기 {

	public static void main(String[] args) {
		/*
		 * # 당첨복권 1셋트
		 * 1. 3이 연속으로 3번 등장하면 당첨복권이다.
		 * 2. 랜덤으로 5개의 복권을 생성하되,
		 *    당첨복권은 한 개만 생성되도록 설정한다.

	    // 3030333 => 당첨 
	    // 0303030 => 꽝 
		 */
		Random rd = new Random();
		int[][] lottoSet = new int[5][7];
		int idx=0;
		while (true) {
			for (int i = 0; i < lottoSet.length; i++) {
				for (int k = 0; k < lottoSet[i].length; k++) {
					int rand = rd.nextInt(2);
					lottoSet[i][k] = rand * 3;
				}
			}
			int cnt1 = 0;
			for (int i = 0; i < lottoSet.length; i++) {
				int cnt2 = 0;
				for (int k = 0; k < lottoSet[i].length; k++) {
					if (lottoSet[i][k] == 3) {
						cnt2++;
					} else {
						cnt2 = 0;
					}
					if (cnt2 == 3) {
						cnt1++;
						idx=i;
						break;
					}					
				}
			}
			if (cnt1 > 1||cnt1==0) {
				idx=0;
				continue;
			} else {
				break;
			}
		}
		for (int i = 0; i < lottoSet.length; i++) {
			System.out.print(Arrays.toString(lottoSet[i]));
			if(idx==i)
				System.out.print("당첨");
			else
				System.out.print("꽝");
			System.out.println();
		}
	}

}
