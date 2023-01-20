package 클래스배열;


class Members {
	int no;
	int point;
	String name;
	boolean best;
}

public class 클배_문자열3_문제 {
	
	public static void main(String[] args) {

		String data1 = "1001/3,1002/1,1001/3,1003/5,1004/1,1002/2";
		String data2 = "1001/이만수,1002/김철수,1003/신민아,1004/박상아";
		String[] temp1 = data1.split(",");
		String[] temp2 = data2.split(",");
		Members[] memberList = new Members[temp1.length];
		for(int i = 0 ; i < memberList.length;i++) {
			Members s = new Members();
			String[] temp = temp1[i].split("/");
			s.no = Integer.parseInt(temp[0]);
			s.point = Integer.parseInt(temp[1]);
			for(int k = 0 ; k < temp2.length ; k++) {
				String[] ktemp = temp2[k].split("/");
				if(s.no==Integer.parseInt(ktemp[0])) {
					s.name = ktemp[1];
				}
			}
			memberList[i]=s;
		}
		// data1 은 사원번호와 판매실적이다.
		// data2 는 사원번호와 이름이다.
		// 판매실적이 4이상인사원은 best를 true로 저장하세요.
		for(int i = 0 ; i < memberList.length;i++) 
			if(memberList[i].point>=4)
				memberList[i].best=true;					
		
		
		// 문제1) 위데이터를 참고해서 Member 클래스 배열을 완성후 전체출력해보세요.
		// 문제2) 판매실적이 best 인회원 이름출력
		for(int i = 0 ; i < memberList.length;i++) 
			if(memberList[i].best)
				System.out.println(memberList[i].name);

	}
}
