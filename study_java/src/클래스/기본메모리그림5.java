package 클래스;

import java.util.Arrays;

class Sample06 {
	int[][] arr = new int[4][];
}

public class 기본메모리그림5 {
	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {6, 7, 8, 9, 10};
		
		Sample06 s6 = new Sample06();
		
		s6.arr[0] = arr1;
		s6.arr[1] = arr2;
		s6.arr[2] = arr1;
		s6.arr[3] = arr2;
		
		s6.arr[1][1] = 100;
		
		for(int i=0; i<s6.arr.length; i++) {
			System.out.println(Arrays.toString(s6.arr[i]));
		}
	}
}