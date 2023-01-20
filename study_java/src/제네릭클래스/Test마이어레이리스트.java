package 제네릭클래스;

public class Test마이어레이리스트 {

	public static void main(String[] args) {

		MyArrayListG<User> list = new MyArrayListG<User>();
		
		list.add(new User("박연미",30));
		list.add(new User("아이유",33));
		list.add(new User("홍길동",13));
		
		System.out.println(list);
		
		list.remove(0);
		System.out.println(list);
		list.set(0, new User("테스트",35));
		System.out.println(list);
	}

}
