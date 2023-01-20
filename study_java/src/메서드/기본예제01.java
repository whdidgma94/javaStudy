package 메서드;

class Ex001{
	
	String test01 (int x) {
		boolean check = true;
		if(x%2==0)
			check=false;		
		return check ? "홀수":"짝수";
	}
	int test02 (int x, int y) {
		int answer=0;
		for(int i = x ; i <= y ; i++) {
			answer+=i;
		}		
		return answer;
	}
	void test03(int num) {
		for(int i = 2 ; i <= num ; i++) {
			int cnt=0;
			for(int k = 1 ; k < i ; k++) {
				if(i%k==0)
					cnt++;
			}
			if(cnt==1)
				System.out.print(i+" ");
		}
	}
}

public class 기본예제01 {

	public static void main(String[] args) {

		Ex001 e = new Ex001();

		// 문제 1) a 가 홀수인지 짝수인지 출력 
		int a = 19;
		System.out.println(e.test01(a));		
		//e.printEvenOrOdd(a);
		
		// 문제 2) x부터 y까지의 합을 출력하는 메서드
		int x = 1;
		int y = 10;
		//e.sumBetweenValues(x, y);
		System.out.println(e.test02(x, y));
		// 문제3) 숫자 1개를 인자로 사용해서 2부터 인자(20)까지의  소수 전부 출력 
		int primeNumber = 20;
		e.test03(primeNumber);
		// e.findPrimeNumbers(primeNumber);
		
	}

}