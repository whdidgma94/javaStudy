package 메서드2;

import java.util.Arrays;

class Return3{
	
	String[][] run(String[][] student ,String[][] score){
		String[][] res = new String[student.length][8];
		for(int i = 0 ; i < res.length;i++) {
			res[i][0]=student[i][2];
			res[i][1]=student[i][0];
			res[i][2]=student[i][1];
			int sum = 0;
			double avg = 0.0;
			for(int k = 0 ; k < score.length;k++) {
				if(score[k][0].equals(res[i][0])) {
					if (score[k][1].equals("국어")) {
						res[i][3]=score[k][2];
					} else if (score[k][1].equals("수학")) {
						res[i][4]=score[k][2];
					} else {
						res[i][5]=score[k][2];
					}
					sum+=Integer.parseInt(score[k][2]);
				}
			}
			avg = sum*1.0/3;
			String temp = avg+"";
			String[] temp1 = temp.split("[.]");
			temp1[1]=temp1[1].substring(0,2);
			if(temp1[1].charAt(1)=='6')
				temp1[1]="67";
			temp = temp1[0]+"."+temp1[1];

//			String temp = String.format("%.2f", avg);
			res[i][6]=sum+"";
			res[i][7]=temp;
		}
		
		return res;
	}
	
}
public class 리턴문제3 {

	public static void main(String[] args) {
	
		
	  Return3 re = new Return3();
		
		String [][] student = {
				{"김철만","신촌","1001"}, 
				{"오상덕","강남","1002"},
				{"민철이","대치","1003"} ,
				{"유재석","강동","1004"}};
		String[][] score = {
				{"1001" ,"국어","20"},
				{"1002" ,"국어","50"},
				{"1003" ,"국어","60"},
				{"1004" ,"국어","17"},
				{"1001" ,"수학","65"},
				{"1002" ,"수학","15"},
				{"1003" ,"수학","80"},
				{"1004" ,"수학","70"},
				{"1001" ,"영어","43"},
				{"1002" ,"영어","90"},
				{"1003" ,"영어","30"},
				{"1004" ,"영어","70"}
		};
		
		String[][] result = re.run(student,score);
		

		for(int i = 0 ; i < result.length ; i++)
			System.out.println(Arrays.toString(result[i]));
	}

}