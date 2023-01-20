package 클래스;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class AddingGame{
	int[] game = new int[6];
	int[] idx = new int[3];
	int[] myIdx = new int[3];	
	int total = 0;
}
public class 클래스08_더하기게임 {

	public static void main(String[] args) {
		/*
		 * # 더하기 게임
		 * 1. 1부터 10 사이의 랜덤한 값을 중복 없이 game 배열에 6개 저장한다.
		 * 2. 6개의 배열의 인덱스를 0부터 5사이의 랜덤 값 3개를 중복 없이 선택해 
		       그 인덱스의 값 의 합을 출력한다. 
		 * 3. 사용자는 중복없이 3개의 인덱스를 골라 그 합을 맞추는 게임이다.
		*  예)  4, 7, 5, 3, 2, 9  //   문제:  14   ==> 인덱스 3개를 골라서 합을 맞추면된다.  
		    정답)  3,4,5 (여러가지 경우의 수가 나올수는있다)
		 */
		Random rd = new Random();
		Scanner scan = new Scanner(System.in);
		AddingGame add = new AddingGame();
		boolean check = false;
		while (!check) {
			for (int i = 0; i < add.game.length; i++) {
				int num = rd.nextInt(10) + 1;
				add.game[i] = num;
				for (int k = 0; k < i; k++)
					if (add.game[i] == add.game[k])
						i--;
			}
			for (int i = 0; i < add.game.length; i++) {
				for (int k = 0; k < add.game.length; k++) {
					if (i != k)
						for (int j = 0; j < add.game.length; j++) {
							if (i != j && i != k && j!=k) {
								int sum = 0;
								sum += add.game[i] + add.game[k] + add.game[j];
								if (sum == 14) {
									check = true;
								}
							}
						}
				}
			}
		}
		System.out.println(Arrays.toString(add.game));
		for(int i = 0 ; i < add.idx.length;i++) {
			add.idx[i]=-1;
			add.myIdx[i]=-1;
		}
		while (true) {
			int idx=0;
			while (idx != add.myIdx.length) {
				System.out.println(idx + 1 + ". 인덱스 입력");
				add.idx[idx] = scan.nextInt();
				add.myIdx[idx] = add.idx[idx];
				for (int i = 0; i < idx; i++) {
					if (add.idx[idx] == add.myIdx[i])
						idx--;
				}
				idx++;
			}
			for(int i =0;i<add.myIdx.length;i++) {
				add.total+=add.game[add.myIdx[i]];
			}
			if(add.total==14) {
				System.out.println("정답!");
				break;
			}else {
				System.err.println("오답!");	
				add.total=0;
			}
		}
		scan.close();
	}

}
