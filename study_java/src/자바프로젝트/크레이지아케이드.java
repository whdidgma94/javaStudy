package 자바프로젝트;

import java.util.Random;
import java.util.Scanner;

public class 크레이지아케이드 {

	public static void main(String[] args) {
		/*
		 * # 크레이지 아케이드
		 * 1. 맵의 크기는 7 x 7 이다. 
		 * 2. 상(1)하(2)좌(3)우(4)로 이동이 가능하며,
		 *    폭탄설치(5), 폭파(6)로 설정한다. 
		 * 3. 벽(3), 플레이어(2), 폭탄(9), 아이템(4)로 설정한다.
		 * 4. 단, 폭탄이 설치된 순서대로 터져야 하며,
		 *    폭파 시 십자가 형태로 터진다.
		 * 5. 벽 파괴시 아이템이 랜덤하게 생성되어,
		 *    아이템을 먹으면 설치할 수 있는 폭탄의 개수가 증가된다.
		 */
		Random rd = new Random();
		Scanner scan = new Scanner(System.in);
		int size=7;
		int[][] map = new int[size][size];
		
		for(int i = 0 ; i < 10;i++) {
			int num1=rd.nextInt(size);
			int num2=rd.nextInt(size);
			if(map[num1][num2]!=0)
				i--;
			map[num1][num2]=3;
		}
		
		
		while(true) {
			for(int i = 0 ; i < size;i++) {
				for(int k = 0 ; k < size;k++) {
					if(map[i][k]==0)
						System.out.print("[ ]");
					else if(map[i][k]==3)
						System.out.print("[■]");
					else if(map[i][k]==2)
						System.out.print("[♣]");
					else if(map[i][k]==9)
						System.out.print("[●]");
					else if(map[i][k]==4)
						System.out.print("[★]");
				}
				System.out.println();
			}
			break;
		}
		scan.close();
	}

}
