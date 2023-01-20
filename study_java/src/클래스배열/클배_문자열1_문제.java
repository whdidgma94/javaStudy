package 클래스배열;


public class 클배_문자열1_문제 {
	public static void main(String[] args) {
		
		String data = ""; 
		data +="김영희/30\n";
		data += "이만수/40\n";
		data += "이철민/60";
		
		
		System.out.println(data);
		String[] temp = data.split("\n");
		Student[] studentList= new Student[temp.length];
		//문제1)data에 있는 내용을 잘라서  studentList 에 저장후 전체출력 
		System.out.println("================================");
		for(int i = 0 ; i < studentList.length;i++) {
			Student s = new Student();
			String[] temp1 = temp[i].split("/");
			s.name=temp1[0];
			s.score=Integer.parseInt(temp1[1]);
			studentList[i]=s;
		}
		for(int i = 0 ; i < studentList.length;i++) {
			System.out.printf("%s %d\n",studentList[i].name,studentList[i].score);
		}
		//문제2)꼴등 삭제후 다시 data에 저장	
		System.out.println("================================");
		int min = studentList[0].score;
		int idx = 0;
		for(int i = 0 ; i < studentList.length;i++) {
			if(min>studentList[i].score) {
				min=studentList[i].score;
				idx=i;
			}
		}
		data="";
		studentList[idx]=null;
		for(int i = 0 ; i < studentList.length;i++) {
			if(studentList[i]!=null) {
				data+=studentList[i].name+"/"+studentList[i].score+"\n";
			}
		}
		System.out.println(data);
	}
}