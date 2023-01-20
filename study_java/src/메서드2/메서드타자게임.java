package 메서드2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class WordGame {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	String[] wordList = { "java", "spring", "jsp", "android", "php" };
	boolean[] checkList = new boolean[wordList.length];
	int count;
	String res = "";

	void reset() {
		res = "";
		count = 0;
	}

	String getWord() {
		res = wordList[count];
		int num = ran.nextInt(res.length());
		String ret = "";
		for (int i = 0; i < res.length(); i++) {
			if (i != num)
				ret += res.charAt(i);
			else
				ret += "*";
		}
		return ret;
	}

	void checkWord(String word) {
		if (word.equals(wordList[count]))
			checkList[count] = true;
		count++;
	}

	boolean getGameEnd() {
		return count == wordList.length ? true : false;
	}

	void printGameEnd() {
		System.out.println("게임 종료");
		System.out.println("결과");
		System.out.println(Arrays.toString(checkList));
	}

	void run() {

		while (true) {
			System.out.println("타자연습게임");
			System.out.println("1)게임 0)종료");
			int sel = scan.nextInt();
			if (sel == 1) {
				reset();
				while (true) {
					System.out.println(count + ") 단어를 맞춰보세요.");
					System.out.println(getWord());
					String word = scan.next();
					checkWord(word);
					if (getGameEnd()) {
						printGameEnd();
						break;
					}
				}
			} else if (sel == 0) {
				
				break;
			} else {
				System.err.println("입력오류");
			}

		}

	}
}

public class 메서드타자게임 {

	public static void main(String[] args) {

		WordGame wordGame = new WordGame();
		wordGame.run();

	}

}
