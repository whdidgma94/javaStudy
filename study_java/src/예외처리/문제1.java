package 예외처리;

//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//class Ex001 {
//	int getValue(String msg, int start, int end) {
//		Scanner sc = new Scanner(System.in);
//		int num = 0;
//		System.out.printf("%s[%d-%d] 입력: ", msg, start, end);
//		try {
//			num = sc.nextInt();
//
//			if (num < start || num > end) {
//				throw new Exception(start + " ~ " + end + " 값 입력해주세요");
//			}
//			return num;
//		} catch (InputMismatchException e) {
//			System.err.println("숫자 값을 입력하세요");
//		} catch (Exception e) { // 모든 예외클래스들은 exception 클래스를 상속받기 때문에
//			// excpeiton catch 구문이 맨 마지막에 해줘야한다 
//			num = 0;
//			System.err.println(e.getMessage());
//		}
//		
//		return num;
//	}
//}

public class 문제1 {

	public static void main(String[] args) {

//		Ex001 e1 = new Ex001();
//		int num = 0;
//		while (num == 0) {
//			num = e1.getValue("숫자값 입력 ", 1, 100);
//		}
//
//		System.out.println(num);
	}

}