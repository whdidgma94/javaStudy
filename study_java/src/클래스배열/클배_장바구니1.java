package 클래스배열;



class User{
	String id;
}

class Item{
	String name;
	int price;
}

class Cart{
	String userId;
	String itemName;
}

public class 클배_장바구니1 {
	public static void main(String[] args) {
		
		String data1 = "qwer/asdf/zxcv";
		String data2 = "새우깡,1200/감자깡,3200/고구마깡,2100";
		String data3 = "qwer,새우깡/qwer,고구마깡/asdf,감자깡/qwer,새우깡/zxcv,새우깡";
		String[] temp1 = data1.split("/"); 
		String[] temp2 = data2.split("/"); 
		String[] temp3 = data3.split("/"); 
		User[] userList = new User[temp1.length];
		for(int i = 0 ; i < userList.length;i++) {
			userList[i] = new User();
			userList[i].id=temp1[i];		
		}
		Item[] itemList = new Item[temp2.length];
		for(int i = 0 ; i < itemList.length;i++) {
			itemList[i]= new Item();
			String[] temp = temp2[i].split(",");
			itemList[i].name=temp[0];
			itemList[i].price=Integer.parseInt(temp[1]);
		}
		Cart[] cartList= new Cart[temp3.length];
		for(int i = 0 ; i < cartList.length;i++) {
			cartList[i]=new Cart();
			String[] temp = temp3[i].split(",");
			cartList[i].userId=temp[0];
			cartList[i].itemName=temp[1];
		}
		
		// [문제] 문자열을 각각의 클래스배열에 저장하고, 회원별로 구매한 상품 총 금액을 출력하시오.
		// [정답] qwer(4500), asdf(3200), zxcv(1200)
		for(int i = 0 ; i < userList.length;i++) {
			int sum = 0 ; 
			for(int k = 0 ; k < cartList.length;k++) {
				if(userList[i].id.equals(cartList[k].userId)) {
					for(int j = 0 ; j < itemList.length;j++) {
						if(cartList[k].itemName.equals(itemList[j].name)) {
							sum+=itemList[j].price;
						}
					}
				}
			}
			System.out.printf("%s(%d) ",userList[i].id,sum);
		}
		
	}
}