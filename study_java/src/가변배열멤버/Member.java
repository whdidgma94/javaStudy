package 가변배열멤버;

public class Member {

	String id;
	int num;

	public Member(String id, int num) {
		super();
		this.id = id;
		this.num = num;
	}
	
	void printMember() {
		System.out.println(id + ":"+ num);
	}
	
	
	@Override
	public String toString() {
		return "num : " + num + ", id : " + id;
	}

}