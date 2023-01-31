package 함수형프로그래밍;

@FunctionalInterface
interface Calculate {
	public int result(int num1, int num2);
}

public class 람다연습2 {

	public static void main(String[] args) {

		// 덧셈
		Calculate add = (int num1, int num2) -> num1 + num2;
		System.out.println(add.result(1, 2));
		// 뺄셈
		Calculate minus = (int num1, int num2) -> num1 - num2;
		System.out.println(minus.result(5, 1));
		// 곱셈
		Calculate multi = (int num1, int num2) -> num1 * num2;
		System.out.println(multi.result(5, 2));
	}

}
