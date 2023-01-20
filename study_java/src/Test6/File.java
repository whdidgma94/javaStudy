package Test6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {
	private FileWriter fw;
	private FileReader fr;
	void test() {
		System.out.println("asd");
	}
	void saveStudentList() {
		String data = "";
		for (int i = 0; i < StudentDAO.getStudentList().size(); i++) {
			data+=StudentDAO.getStudentList().get(i).getStudentId() + " : " + StudentDAO.getStudentList().get(i).getStudentNum();
			if(i!=StudentDAO.getStudentList().size()-1) {
				data+="\n";
			}
		}
		try {
			fw = new FileWriter("src/Test6/studentList.txt");
			fw.write(data);		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
			
		}
		
		
		data = "";
		for (int i = 0; i < StudentDAO.getStudentList().size(); i++) {
			for (int k = 0; k < SubjectDAO.getSubjectList().size(); k++) {
				if (StudentDAO.getStudentList().get(i).getStudentNum() == SubjectDAO.getSubjectList().get(k).getStudentNum())
					data += StudentDAO.getStudentList().get(i).getStudentNum() + " : " + SubjectDAO.getSubjectList().get(k).getSubject() + " : "
							+ SubjectDAO.getSubjectList().get(k).getScore() + "\n";
			}
		}
		
		try {
			fw = new FileWriter("src/Test6/subjectList.txt");
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
	}

	void loadStudentList() {
		try {
			fr = new FileReader("src/Test6/studentList.txt");
			String data = "";
			int read = 0;
			while (read != -1) {
				read = fr.read();
				if (read != -1) {
					data += (char) read;
				}
			}
			StudentDAO.getStudentList().clear();
			String[] temp = data.split("\n");
			for (int i = 0; i < temp.length; i++) {
				String[] temp1 = temp[i].split(" : ");
				StudentDAO.getStudentList().add(new Student(Integer.parseInt(temp1[1]), temp1[0]));
			}
		} catch (FileNotFoundException e) {
			System.err.println("파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fr = new FileReader("src/Test6/subjectList.txt");
			String data = "";
			int read = 0;
			while (read != -1) {
				read = fr.read();
				if (read != -1) {
					data += (char) read;
				}
			}
			SubjectDAO.getSubjectList().clear();
			
			String[] temp = data.split("\n");

			for (int i = 0; i < temp.length; i++) {
				String[] temp1 = temp[i].split(" : ");
				SubjectDAO.getSubjectList().add(new Subject(Integer.parseInt(temp1[0]),temp1[1],Integer.parseInt(temp1[2])));
			}
		} catch (FileNotFoundException e) {
			System.err.println("파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
