package 예외처리;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 기본파일읽기쓰기예제 {

	public static void main(String[] args) {
		// ctrl + shift + o
		Scanner scan = new Scanner(System.in);

		String nameData = "김철수,이만수,이영희";
		String ageData = "20,30,40";
		String fileName = "src/예외처리/file03.txt";
		String data = "";

		String[] nameList = null;
		int[] ageList = null;

		FileWriter fw = null;
		FileReader fr = null;

		while (true) {
			System.out.println("[0] 종료 [1] 저장 [2] 로드");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
//						[저장] 김철수/20\n이만수/30\n이영희/40 이렇게 데이터를 만들어 파일 생성후 저장하시오. 
				String[] temp1 = nameData.split(",");
				String[] temp2 = ageData.split(",");
				for (int i = 0; i < temp1.length; i++) {
					data += temp1[i] + "/" + temp2[i];
					if (i != temp1.length - 1)
						data += "\n";
				}
				System.out.println("저장 완료");
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fw != null) {
						try {
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else if (sel == 2) {
//						[로드] 파일을 불러와서 nameList, ageList 배열에 저장하시오 
				try {
					fr = new FileReader(fileName);
					String temp = "";
					int read = 0;
					while (read != -1) {
						read = fr.read();
						if (read != -1) {
							temp += (char) read;
						}
					}
					String[] temp1 = temp.split("\n");
					nameList = new String[temp1.length];
					ageList = new int[temp1.length];
					for (int i = 0; i < temp1.length; i++) {
						String[] temp2 = temp1[i].split("/");
						nameList[i] = temp2[0];
						ageList[i] = Integer.parseInt(temp2[1]);
					}
					System.out.println(Arrays.toString(nameList));
					System.out.println(Arrays.toString(ageList));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fr != null) {
						try {
							fr.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

			} else {
				System.err.println("입력오류");
			}

		}

		scan.close();
	}

}
