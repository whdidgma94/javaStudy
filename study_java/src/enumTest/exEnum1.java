package enumTest;

enum DAY {
	// 0 1 2 3
	// public static int SUNDAY = 0;
	SUNDAY("일요일"), MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"), THURSDAY("목요일"), FRIDAY("금요일"), SATURDAY("토요일");

	private String value;

	DAY(String day) {
		this.value = day;
	}

	public String toString() {
		return value;
	}
}

public class exEnum1 {

	public static void main(String[] args) {
		// 요일 출력 "월요일"~ "일요일"
		System.out.println(DAY.SUNDAY); // 일요일
	}

}