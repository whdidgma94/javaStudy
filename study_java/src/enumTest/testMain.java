package enumTest;

/*
// enum클래스 상속 전
class Color{
	//상수 빨간색 초록색 파란색 rgb 컬러 
	public static final int RED = 1; 
	public static final int GREEN = 2; 
	public static final int BLUE = 3; 
	private int rgb;
	public void setValue(int value) {
		rgb = value;
	}
	public String getValue() {
	
		switch(rgb) {
		case 1 : return "빨강";
		case 2 : return "초록";
		case 3 : return "파랑";
		default : return "";
		}
	
	}
}
 */

/*
// 열겨형 클래스 : 상수 모음 클래스 
enum Color{
	RED,GREEN,BLUE
}

class ColorTable{
	Color rgb;
	public void setValue(Color value) {
		rgb = value;
	}
	public String getValue() {
	
		switch(rgb) {
		case RED : return "빨강";
		case GREEN : return "초록";
		default : return "파랑";
		}
	
	}
}
*/


class ColorTable{
	// 내부 클래스 
	Color rgb;
	enum Color{
		RED("빨강"),GREEN("초록"),BLUE("파랑");
		private String value;
		Color(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}
	}
}

public class testMain {

	public static void main(String[] args) {
/*
		Color c = new Color();
		c.setValue(1000); // 코드상 문제없지만 논리상 문제가 발생 
		System.out.println(c.getValue());
	*/
		
		/*
		ColorTable t = new ColorTable();
		
		t.setValue(Color.RED);
		
		System.out.println(t.getValue());
		t.setValue(Color.GRAY);
		System.out.println(t.getValue());
		*/
		ColorTable c = new ColorTable();
		c.rgb = ColorTable.Color.BLUE;
		System.out.println(c.rgb);
		
		System.out.println("===========");
		ColorTable.Color[] array= ColorTable.Color.values();
		for(ColorTable.Color color : array ) {
			System.out.println(color);
		}
		
		
	}

}