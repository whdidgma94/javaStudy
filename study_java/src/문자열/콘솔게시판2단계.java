package 문자열;

import java.util.Scanner;

public class 콘솔게시판2단계 {

	public static void main(String[] args) {
		/*
		 * # 콘솔 게시판
		 *  1. [이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다. 
		 *    // 이전 버튼은 이전페이지가 있을때만 보여주고 
		 *    // 이후 버튼은 이후페이지가 있을때만 보여준다 
		 *  2. 현재 페이지 번호에 해당되는 게시글만 볼 수있다.
		 *  3. 2차원 배열 board에 0열에는 제목을 1열에는 게시글의 내용을 저장한다. 
		 *  4. 게시글을 추가하고 삭제할 때마다 실제 배열의 길이가 변한다 
		 *  
		 */
		
		Scanner scan = new Scanner(System.in);

		String[][] board = null;
		int count = 0; // 전체 게시글 수
		int pageSize = 3; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1; // 전체 페이지 개수
		int startRow = 1; // 현재 페이지의 게시글 시작 번호
		int endRow = startRow + pageSize - 1; // 현재 페이지의 게시글 마지막 번호
		
		while (true) {
			pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
			System.out.println("전체 게시글 숫자 : " + count);
			System.out.printf("(인덱스 %d ~%d) 페이지(%d/%d)", startRow, endRow, curPageNum, pageCount);
			System.out.println("게시글번호");
			for (int i = 0; i < pageSize; i++) {
				if (startRow + i <= count&&count>0) {
					System.out.printf("(%2d) %s\n",startRow + i, board[startRow + i-1][0]);
				} else {
					System.out.println();
				}
			}
			if (curPageNum <= pageCount&&curPageNum!=1) {
				System.out.println("[이전 1]");
			}
			if (curPageNum < pageCount&&pageCount!=0) {
				System.out.println("[이후 2]");
			}
			System.out.println("[작성 3]");
			System.out.println("[삭제 4]");
			System.out.println("[확인 5]");
			System.out.println("[종료 0]");
			System.out.println("선택 >> ");
			int choice = scan.nextInt();
			scan.nextLine();
			if (choice == 1) {
				if (curPageNum == 1) {
					System.err.println("이전 페이지가 없습니다.");
					continue;
				}
				curPageNum--;
				startRow -= pageSize;
			} else if (choice == 2) {
				if (curPageNum == pageCount) {
					System.err.println("이후 페이지가 없습니다.");
					continue;
				}
				curPageNum++;
				startRow += pageSize;
				if (endRow > count) {
					endRow = count;
				}
			} else if (choice == 3) {
				String[][] temp = new String[count + 1][2];
				for (int i = 0; i < count; i++) {
					temp[i] = board[i];
				}
				System.out.print("게시글 제목 : ");
				String title = scan.next();
				System.out.print("게시글 내용 : ");
				String input = scan.next();
				temp[count][0] = title;
				temp[count][1] = input;
				board = temp;
				count++;
			} else if (choice == 4) {
				if(count==0) {
					System.err.println("삭제할 게시글이 없습니다.");
					continue;
				}
				System.out.print("삭제할 게시글 번호 입력 : ");
				int input = scan.nextInt();
				if(input<startRow||input>endRow) {
					System.err.println("게시글 번호가 잘 못 되었습니다");
					continue;
				}
				for(int i = input-1 ; i < count-1;i++) {
					board[i]=board[i+1];
				}
				count--;
			} else if (choice == 5) {
				if(count==0) {
					System.err.println("확인할 게시글이 없습니다.");
					continue;
				}
				System.out.print("확인할 게시글 번호 입력 : ");
				int input = scan.nextInt();
				if(input<startRow||input>endRow) {
					System.err.println("게시글 번호가 잘 못 되었습니다");
					continue;
				}
				System.out.printf("===게시글 %s 내용===\n",board[input-1][0]);
				System.out.println(board[input-1][1]);
			} else if (choice == 0) {
				System.out.println("종료");
				break;
			} else {
				System.err.println("입력오류");
			}
			endRow = startRow + pageSize - 1;

		}
		scan.close();

	}

}
