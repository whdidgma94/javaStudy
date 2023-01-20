package 클래스배열;

import java.util.Random;
import java.util.Scanner;

class Word {
	String word;
	int ranPos;

	void setRandomWordPos(String sample, int rIdx) {
		word = sample;
		ranPos = rIdx;
	}

	void printWord() {
		for (int i = 0; i < word.length(); i++) {
			if (i == ranPos) {
				System.out.print("*");
			} else {
				System.out.print(word.charAt(i));
			}
		}
		System.out.println();
	}
}

class WordDAO {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	String[] wordSampleList = { "java", "jsp", "python", "android", "spring" };
	boolean[] checkList = new boolean[wordSampleList.length]; // 이미선택한단어 체크용
	Word[] list = new Word[wordSampleList.length];
	int count = wordSampleList.length; // 단어 개수(게임종료용카운트)

// 셔플 말고 checkList 배열 사용해서 랜덤 word 값 가져오기 
	void init() {
		for (int i = 0; i < list.length; i++) {
			list[i] = new Word();
			list[i].setRandomWordPos(wordSampleList[i], ran.nextInt(wordSampleList[i].length()));
		}
	}

	void checkWord(int idx) {
		while (true) {
			list[idx].printWord();
			System.out.print("입력 : ");
			if (wordSampleList[idx].equals(scan.next())) {
				checkList[idx] = true;
				count--;
				System.out.println("정답");
				break;
			} else {
				System.out.println("땡");
			}

		}
	}

	void run() {
		init();
		long beforeTime = System.currentTimeMillis();
		while (count != 0) {
			int idx = ran.nextInt(checkList.length);

			if (!checkList[idx]) {
				checkWord(idx);
			}
		}
		long afterTime = System.currentTimeMillis();
		double secDiffTime = (afterTime - beforeTime) / 1000.0;
		System.out.println("게임종료 " + secDiffTime + "초");
	}
}

public class 클래스배열_타자게임 {

	public static void main(String[] args) {
		WordDAO w = new WordDAO();
		w.run();

	}

}
