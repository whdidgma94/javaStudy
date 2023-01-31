package 함수형프로그래밍;

@FunctionalInterface
interface Type1 {
	void call();
}

@FunctionalInterface
interface Type2 {
	void call(int num, String msg);
}

@FunctionalInterface
interface Type3 {
	int call();
}

@FunctionalInterface
interface Type4 {
	boolean call(int num);
}

public class 람다연습 {

	public static void main(String[] args) {

		Type1 t1 = () -> System.out.println("type1 호출");
		t1.call();
		Type2 t2 = (int num, String msg) -> System.out.printf("type%d %s\n", num, msg);
		t2.call(2, "호출");
		Type3 t3 = () -> {
			System.out.print("type3 호출으로 받은 숫자 : ");
			return 3;
		};
		int num = t3.call();
		System.out.println(num);
		Type4 t4 = num4 -> {
			System.out.printf("type%d 호출\n", num4);
			return true;
		};
		if (t4.call(4)) {
			System.out.println("type4 호출 성공");
		}
	}

}