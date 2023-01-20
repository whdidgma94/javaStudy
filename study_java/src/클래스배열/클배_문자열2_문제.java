package 클래스배열;

import java.util.Arrays;

class Test{
	int num; 
	int size;
	char[] data;
	
}

public class 클배_문자열2_문제 {
	
	public static void main(String[] args) {

		String data = "";
		// num/size/data[]
		// num = 0, size =2; data = {a,b}
		data += "0/2/a/b\n";
		data += "1/3/a/b/c\n";
		data += "2/5/a/b/c/d/e\n";
		data += "3/4/a/b/c/d\n";
		data += "4/3/a/b/c\n";
		data += "5/1/a";
		System.out.println(data);
		
		// data의 정보를 클래스배열에 저장.
		String[] temp = data.split("\n");
		Test[] t = new Test[temp.length];
		for(int i = 0 ; i < t.length ; i++) {
			Test s = new Test();
			String[] temp1 = temp[i].split("/");
			s.num = Integer.parseInt(temp1[0]);
			s.size = Integer.parseInt(temp1[1]);
			s.data = new char[s.size];
			for(int k = 0 ; k < s.size;k++) {
				s.data[k]=temp1[2+k].charAt(0);
			}
			t[i]=s;
		}
		for(int i = 0 ; i < t.length ; i++) {
			System.out.printf("%d , %d ",t[i].num,t[i].size);
			System.out.println(Arrays.toString(t[i].data));
		}
		

	}
}