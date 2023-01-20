package 문자열;

public class 채팅 {

	public static void main(String[] args) {
		/*
		[문제]
			다음은 철수와 영희의 채팅 내용이다.
			철수는 왼쪽 정렬, 영희는 오른쪽 정렬로 출력하시오.
			대화의 한 줄 길이는 20칸이다.
		[정답]	
			영희야 안녕              
			              철수야 안녕
			오늘 점심같이 먹을래?        
			            아니 약속있어.
			             다음에 먹자.
			그래 다음에 먹자.          
	 */
		String[][] wordList = {
				{"철수", "영희야 안녕"} , 
				{"영희", "철수야 안녕"} ,  
				{"철수", "오늘 점심같이 먹을래?"}, 
				{"영희", "아니 약속있어."} ,
				{"영희", "다음에 먹자."},
				{"철수", "그래 다음에 먹자."}
		};
		
		for(int i = 0 ; i < wordList.length;i++) {
			if(wordList[i][0].equals("철수")) {
				System.out.printf("%-20s",wordList[i][1]);
			}else {
				System.out.printf("%20s",wordList[i][1]);
			}
			System.out.println();
		}
		
			
			
			
			
			
	}

}
