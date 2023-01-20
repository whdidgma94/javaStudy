package 문자열;

import java.util.Scanner;

public class 콘솔게시판 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 14; // 전체 게시글 수
		int pageSize = 0;
		while (true) {
			System.out.print("한페이지에 보여줄 게시글 숫자 >> ");
			pageSize = sc.nextInt(); // 한 페이지에 보여줄 게시글 수
			if (pageSize <= 0) {
				System.err.println("입력오류 0이상 입력");
				continue;
			}
			break;
		}
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1; // 전체 페이지 개수
		int startRow = 1; // 현재 페이지의 게시글 시작 번호
		int endRow = startRow + pageSize - 1; // 현재 페이지의 게시글 마지막 번호

		while (true) {

			System.out.println("전체 게시글 숫자 : " + count);
			System.out.printf("(인덱스 %d ~%d) 페이지(%d/%d)", startRow, endRow, curPageNum, pageCount);
			System.out.println("게시글번호");
			for (int i = 0; i < pageSize; i++) {
				if (startRow + i <= count) {
					System.out.printf("(%d)\n", startRow + i);
				} else {
					System.out.println();
				}
			}

			System.out.println("[이전 1]"); // 페이지 이동
			System.out.println("[이후 2]");
			System.out.println("[종료 0]");
			System.out.println("선택 >> ");
			int choice = sc.nextInt();
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
			} else if (choice == 0) {
				System.out.println("종료");
				break;
			} else {
				System.err.println("입력오류");
			}
			endRow = startRow + pageSize - 1;
		}
		sc.close();
	}

}
