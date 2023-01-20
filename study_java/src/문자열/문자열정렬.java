package 문자열;

import java.util.Arrays;

public class 문자열정렬 {

	public static void main(String[] args) {
		
		// 문제 ) 사전 순으로 이름 정렬
				
		String[] names = { "홍길동", "김유신", "마동석", "자바킹", "서동요" };
		
		for(int i = 0 ; i < names.length ; i++) {
			for(int k = i ; k <names.length ; k++) {
				if(names[i].compareTo(names[k])>0) {
					String temp = names[i];
					names[i]=names[k];
					names[k]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(names));
	}

}
