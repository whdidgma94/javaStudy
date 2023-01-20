package 예외처리;

import java.io.FileWriter;
import java.io.IOException;

public class 파일쓰기 {

	public static void main(String[] args) {
		// 기존에 같은 이름으로 파일이 있으면 덮어쓰기 아니면 새롭게 생성
		// 기본 디폴트 경로는 현재 워크스페이스의 프로젝트
		// 파일 이름에 폴더 경로 넣어서 저장하면 해당 폴더에 파일 저장 할 수 있다.

		String fileName = "src/예외처리/file01.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write("김철수,10\n박영희,34\n유재석,55\n");
			fw.write("아이유,10\n박영희,34\n유재석,55\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("파일" + fileName + " 생성 완료");
		}

	}

}
