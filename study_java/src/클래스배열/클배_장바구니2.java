package 클래스배열;


import java.util.Scanner;


public class 클배_장바구니2 {
	public static void main(String[] args) {
		
		String[] userIdList = {"aaa" , "bbb" , "ccc"};
		
		String[] itemNameList = {"사과" , "칸초" , "귤" , "감"};
		int [] itemPriceList = {10000, 2000, 6500, 3300};
		
		String[] cartUserIdList = {"aaa" , "ccc" , "aaa" , "bbb" , "aaa" ,"ccc"};
		String[] cartItemNameList = {"칸초" , "귤" , "칸초" , "사과" , "감" ,"사과"};
		
		User[] userList = new User[userIdList.length];
		for(int i =0; i < userList.length; i++) {
			userList[i] = new User();
			userList[i].id = userIdList[i];
		}
		Item[] itemList = new Item[itemNameList.length];
		for(int i =0; i < itemList.length; i++) {
			itemList[i] = new Item();
			itemList[i].name = itemNameList[i];
			itemList[i].price = itemPriceList[i];
		}
		Cart[] cartList = new Cart[cartUserIdList.length];
		for(int i =0; i < cartList.length; i++) {
			cartList[i] = new Cart();
			cartList[i].userId = cartUserIdList[i];
			cartList[i].itemName = cartItemNameList[i];
		}
		Scanner scan = new Scanner(System.in);	
		while(true) {
			System.out.println("[0] 종료\n"
					+ "[1] 전체출력\n"
					+ "[2] 회원 aaa가 주문한 각 아이템이름과 가격들을 출력 \n"
					+ "[3] 카트내용을 전부출력(회원 별 아이템 전체와 아이템 가격을 출력)\n"
					+ "[4] 주문한 아이템 갯수가 가장많은 회원출력\n"
					+ "[5] 주문한 아이템 총액이 가장큰 회원출력");
			int sel = scan.nextInt();
			if(sel == 0) {
				break;
			} else if(sel == 1) {
				for(int i = 0 ; i < userList.length;i++)
					System.out.print(userList[i].id+"  ");
				System.out.println();
				for(int i = 0 ; i < itemList.length;i++)
					System.out.println(itemList[i].name+" "+itemList[i].price+"  ");
				for(int i = 0 ; i < cartList.length;i++)
					System.out.println(cartList[i].userId+" "+cartList[i].itemName+"  ");
			} else if(sel == 2) {
				int[] cntArr = new int[itemList.length];
				for(int i = 0 ; i < cartList.length;i++) {
					if(cartList[i].userId.equals(userList[0].id)) {
						for(int k = 0 ; k < itemList.length;k++) {
							if(cartList[i].itemName.equals(itemList[k].name)) {
								cntArr[k]++;
							}
						}
					}
				}
				for(int i = 0 ; i < cntArr.length ; i++) {
					if(cntArr[i]>0) {
						System.out.printf("%s %d개 : %d원\n",itemList[i].name,cntArr[i],itemList[i].price*cntArr[i]);
					}
				}
			} else if(sel == 3) {
				for(int i = 0 ; i < userList.length;i++) {
					System.out.printf("%s회원 주문 내역\n",userList[i].id);
					for(int k = 0 ; k < cartList.length;k++) {
						if(userList[i].id.equals(cartList[k].userId)) {
							System.out.print(cartList[k].itemName+" ");
							for(int j = 0 ; j < itemList.length;j++) {
								if(cartList[k].itemName.equals(itemList[j].name)) {
									System.out.println(itemList[j].price+"원");
								}
							}
						}
					}
				}									
			} else if(sel == 4) {
				int[] cntArr = new int [userList.length];
				for(int i = 0 ; i < cartList.length;i++)
					for(int k = 0 ; k < userList.length;k++)
						if(cartList[i].userId.equals(userList[k].id))
							cntArr[k]++;
				int max = cntArr[0];
				int idx=0;
				for(int i = 0 ; i < cntArr.length;i++) {
					if(max<cntArr[i]) {
						max=cntArr[i];
						idx=i;
					}
				}
				System.out.println("가장 주문한 아이템이 많은 회원 : "+userList[idx].id);
			} else if(sel == 5) {
				int[] cntArr = new int [userList.length];
				for(int i = 0 ; i < cartList.length;i++)
					for(int k = 0 ; k < userList.length;k++)
						if(cartList[i].userId.equals(userList[k].id))
							for(int j = 0 ; j < itemList.length;j++)
								if(cartList[i].itemName.equals(itemList[j].name))
									cntArr[k]+=itemList[j].price;
				int max = cntArr[0];
				int idx=0;
				for(int i = 0 ; i < cntArr.length;i++) {
					if(max<cntArr[i]) {
						max=cntArr[i];
						idx=i;
					}
				}
				System.out.println("아이템 총액이 가장 큰 회원 : "+userList[idx].id);
			}
		}
		scan.close();
	}
}
