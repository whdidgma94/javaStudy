package 클래스배열;

class Student{
	int number;
	String id;
	String pw;
	String name="무명이";
	int score;
}

public class 클배_기본예제1 {

	public static void main(String[] args) {
		
		
		String data = "";
		data += "1001,qwer,1234,김철민,10\n";
		data += "1002,asdf,2345,우중현,3\n";
		data += "1003,zxcv,3456,이만수,30";
		
	    // stList 클래스배열에 데이터를 넣고 1등 출력 
		String[] temp = data.split("\n");
		Student[] stList = new Student[temp.length];
		for(int i = 0 ; i < stList.length;i++) {
			String[] temp1 = temp[i].split(",");
			Student s = new Student();
			s.number = Integer.parseInt(temp1[0]);
			s.id = temp1[1];
			s.pw = temp1[2];
			s.name = temp1[3];
			s.score = Integer.parseInt(temp1[4]);
			stList[i]=s;
		}
		int max=stList[0].score;
		int idx=0;
		for(int i = 0 ; i < stList.length;i++) {
			if(stList[i].score>max) {
				max=stList[i].score;
				idx=i;
			}			
		}
		System.out.println(stList[idx].number);
		System.out.println(stList[idx].id);
		System.out.println(stList[idx].pw);
		System.out.println(stList[idx].name);
		System.out.println(stList[idx].score);
		
	}

}