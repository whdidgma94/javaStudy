package 클래스배열;

class Item1 {
	int itemNumber;
	String itemName;

	Item1(int itemNumber, String itemName) {
		this.itemNumber = itemNumber;
		this.itemName = itemName;
	}
}

class ItemDAO1 {
	Item1[] itemList;

	void creatArr(int num, String[] items) {
		itemList = new Item1[num];
		for (int i = 0; i < num; i++) {
			String[] temp = items[i].split("/");
			itemList[i] = new Item1(Integer.parseInt(temp[0]), temp[1]);
		}
	}
}

class User2 {
	int userNumber;
	String userName;

	User2(int userNumber, String userName) {
		this.userNumber = userNumber;
		this.userName = userName;
	}

}

class UserDAO1 {
	User2[] userList;

	void creatArr(int num, String[] users) {
		userList = new User2[num];
		for (int i = 0; i < num; i++) {
			String[] temp = users[i].split("/");
			userList[i] = new User2(Integer.parseInt(temp[0]), temp[1]);
		}
	}
}

class Cart1 {
	int userNumber;
	int itemNumber;

	Cart1(int userNumber, int itemNumber) {
		this.userNumber = userNumber;
		this.itemNumber = itemNumber;
	}
}

class CartDAO1 {
	Cart1[] cartList;

	void creatArr(int num, String[] carts) {
		cartList = new Cart1[num];
		for (int i = 0; i < num; i++) {
			String[] temp = carts[i].split("/");
			cartList[i] = new Cart1(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		}
	}
}

public class J2_장바구니_문제 {
	public static void main(String[] args) {

		String itemData = "1001/고래밥,1002/새우깡,1003/칸쵸";
		String userData = "3001/이만수,3002/김철민,3003/이영희";
		String[] items = itemData.split(",");
		ItemDAO1 it = new ItemDAO1();
		it.creatArr(items.length, items);

		String[] users = userData.split(",");
		UserDAO1 us = new UserDAO1();
		us.creatArr(users.length, users);

		String cartData = "";
		cartData += "3001/1001\n";
		cartData += "3001/1001\n";
		cartData += "3003/1002\n";
		cartData += "3001/1001\n";
		cartData += "3001/1003\n";
		cartData += "3003/1002\n";
		cartData += "3003/1001\n";
		cartData += "3002/1001";
		String[] carts = cartData.split("\n");
		CartDAO1 ca = new CartDAO1();
		ca.creatArr(carts.length, carts);
		// [문제1] 회원별 아이템 구매목록 출력
		// [정답1] 이만수==> 고래밥3,칸쵸1 / 김철민 ==> 고래밥1 / 이영희 ==> 고래밥1,새우깡2
		for (int i = 0; i < us.userList.length; i++) {
			System.out.print(us.userList[i].userName + "==>");
			int[] temp = new int[it.itemList.length];
			for (int k = 0; k < ca.cartList.length; k++) {
				if (ca.cartList[k].userNumber == us.userList[i].userNumber) {
					for (int j = 0; j < it.itemList.length; j++) {
						if (ca.cartList[k].itemNumber == it.itemList[j].itemNumber) {
							temp[j]++;
						}
					}
				}
			}
			for (int k = 0; k < temp.length; k++) {
				if (temp[k] != 0) {
					System.out.print(it.itemList[k].itemName + " " + temp[k] + "개 ");
				}
			}
			System.out.println();
		}
		// [문제2] 아이템별로 구입한 회원이름 출력
		// [정답2] 고래밥==> 이만수,김철민,이영희 / 새우깡==> 이영희 / 칸쵸==> 이만수
		System.out.println("===========================================");
		for (int i = 0; i < it.itemList.length; i++) {
			System.out.print(it.itemList[i].itemName + "==>");
			int[] temp = new int[us.userList.length];
			for (int k = 0; k < ca.cartList.length; k++) {
				if (it.itemList[i].itemNumber == ca.cartList[k].itemNumber) {
					for (int j = 0; j < us.userList.length; j++) {
						if (us.userList[j].userNumber == ca.cartList[k].userNumber) {
							temp[j]++;
						}
					}
				}
			}
			for (int k = 0; k < temp.length; k++) {
				if (temp[k] != 0) {
					System.out.print(us.userList[k].userName + " ");
				}
			}
			System.out.println();
		}

	}
}