package 문자열;

public class 주민등록분석 {

	public static void main(String[] args) {
		
		//String jumin1 = "890101-2012932";
		String jumin2 = "040101-3012932";
		String jumin =jumin2;
		String result =""; // 여성 33세(성인)
		
		// 문제1) 주민1 성별 출력 -> 여성
		// 문제2) 주민1 나이 출력 -> 34세(성인)
		// 문제3) 주민2 성별 출력 -> 남성		
		// 문제4) 주민2 나이 출력 -> 18세(청소년)
		
		int mf = Integer.parseInt(jumin.charAt(7)+"");
		if(mf%2==0)
			result+="여성 ";
		else
			result+="남성 ";
		int age = Integer.parseInt(jumin.charAt(0)+"")*10+Integer.parseInt(jumin.charAt(1)+"");
		age = (2022-(1900+age));
		if(mf>2)
			age-=100;
		result+=age+"세";
		if(age>=20)
			result+="(성인)";
		else
			result+="(청소년)";
	
		System.out.println(result);
		
	}

}
