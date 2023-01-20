package 클래스;

import java.util.Arrays;

class Sample03 {
	int[] hakbun = {1001, 1002, 1003, 1004, 1005};
	int[] score  = {  92,   38,   87,  100,   11};
}

public class 기본메모리그림3 {
	public static void main(String[] args) {

		int arr[] = new int[3];

		Sample03 s3;

		s3 = new Sample03();

		arr = s3.score;
		arr[1] = 100;

		System.out.println(Arrays.toString(s3.score));

		Sample03 s4 = s3;

		s4.score[2] = 100;

		System.out.println(Arrays.toString(s4.score));

	}
}