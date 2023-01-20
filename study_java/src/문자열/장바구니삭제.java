package 문자열;

public class 장바구니삭제 {

	public static void main(String[] args) {
		/*
		[문제]
			cart데이터는 현재 장바구니 상황이다.			
			input데이터는 삭제를 요청한 데이터이다.
			qwer은 아이디이고, 3은 삭제할 위치이다.
			qwer 입장에서는 본인 아이템은 3개 밖에 없으니
			칸쵸를 지우기 위해 3을 선택했지만 전체 데이터에서는 5번째 아이템이다.
			
			마찬가지로 abcd는 콜라와 사이다를 구입했고,
			콜라를 지우기 위해 1번을 선택했지만
			실제로는 3번 아이템이 삭제되어야 한다.
			
			삭제 후 cart배열의 정보를 출력하시오.
		[정답]
			qwer/고래밥
			qwer/새우깡
			java/칸쵸
			java/고래밥
			abcd/사이다		
	 */
//
//		String item = "칸초/새우깡/고래밥/콜라/사이다";
//		String id = "qwer/abcd/java";

		String cart = "";
		cart += "qwer/고래밥\n";
		cart += "qwer/새우깡\n";
		cart += "abcd/콜라\n"; // 삭제 2
		cart += "java/칸쵸\n";
		cart += "qwer/칸쵸\n"; // 삭제 1
		cart += "java/고래밥\n";
		cart += "abcd/사이다";
			
		String[][] input = {
				{"qwer" , "3"}, 
				{"abcd" , "1"}
		};
		String[] temp = cart.split("\n");		
		String[][] temp2 = new String[temp.length][2];
		for(int i = 0 ; i < temp2.length;i++) {
			temp2[i]=temp[i].split("/");
		}
		for(int i = 0 ; i < input.length;i++) {
			int cnt = 0;
			for(int k = 0 ; k<temp2.length;k++) {
				if(input[i][0].equals(temp2[k][0])) {
					cnt++;
					if(cnt==Integer.parseInt(input[i][1])) {
						temp2[k][0]="";
						temp2[k][1]="";
					}
				}				
			}
		}
		cart = "";
		for(int i = 0 ; i < temp2.length;i++) {
			if(!temp2[i][0].equals("")) {
			cart+=temp2[i][0]+"/"+temp2[i][1]+"\n";
			}
		}
		System.out.println(cart);
		
	}

}
