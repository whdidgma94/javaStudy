package 스테틱;

class Monster{
	String name;
	int cnt;
	Monster(String name){
		this.name=name;
		cnt++;
	}
	
	void die() {
		System.out.println(name + "(이)가 죽었습니다.");
		cnt--;
	}
	
	
}

public class 기본이론1 {

	public static void main(String[] args) {
		Monster bat = new Monster("박쥐");
//		Monster wolf = new Monster("늑대");
//		Monster zombie = new Monster("좀비");
		System.out.println(bat.cnt);
	}

}
