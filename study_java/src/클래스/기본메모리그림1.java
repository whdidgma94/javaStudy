package 클래스;

class Sample01 {
	int a;
	int b;
}
public class 기본메모리그림1 {
	public static void main(String[] args) {
		Sample01 s1 = new Sample01();
		int num = 50;
		s1 = new Sample01();
		s1.a = 10;
		
		s1 = null;				
		// s1을 null로 저장하지 않아도
		// GC(Garbage Collector)가 알아서 메모리를 해제해준다.
		s1 = new Sample01();
		s1.b = num;
	}

}
