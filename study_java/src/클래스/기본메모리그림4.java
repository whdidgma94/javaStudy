package 클래스;

import java.util.Arrays;

class Sample04 {
	int[] arr = {1, 2, 3, 4, 5};
}

class Sample05 {
	int[] arr = {5, 4, 3, 2, 1};
}

public class 기본메모리그림4{
	public static void main(String[] args) {
		
		Sample04 s4 = new Sample04();
		Sample05 s5 = new Sample05();
		
		int[] temp = null;
		temp = s4.arr;
		s4.arr = s5.arr;
		s5.arr = temp;

		System.out.println(Arrays.toString(s4.arr));
		System.out.println(Arrays.toString(s5.arr));
		
	}
}