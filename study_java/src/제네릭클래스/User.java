package 제네릭클래스;

public class User {
	String id;
	int age;

	public User(String id, int age) {
		super();
		this.id = id;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + "]";
	}

}