package 문자열;

public class 레벨5테스트 {

	public static void main(String[] args) {
		//[부서정보]
		//[부서번호,부서명,지역]
		String[][] departmentData = { 
				{ "10", "ACCOUNTING", "NEW YORK" }, 
				{ "20", "RESEARCH", "DALLAS" },
				{ "30", "SALES", "CHICAGO" }, 
				{ "40", "OPERATIONS", "BOSTON" }, 
			};
		// [사원정보]
		// [번호,이름,직책,상사번호,입사일,급여,커미션,부서번호]
		String[][] employeeData = { 
				{ "7369", "SMITH", "CLERK", "7902", "17-12-1980", "800", "0", "20" },
				{ "7499", "ALLEN", "SALESMAN", "7698", "20-2-1981", "1600", "300", "30" },
				{ "7521", "WARD", "SALESMAN", "7698", "22-2-1981", "1250", "500", "30" },
				{ "7566", "JONES", "MANAGER", "7839", "2-4-1981", "2975", "0", "20" },
				{ "7654", "MARTIN", "SALESMAN", "7698", "28-9-1981", "1250", "1400", "30" },
				{ "7698", "BLAKE", "MANAGER", "7839", "1-5-1981", "2850", "0", "30" },
				{ "7782", "CLARK", "MANAGER", "7839", "9-6-1981", "2450", "0", "10" },
				{ "7788", "SCOTT", "ANALYST", "7566", "13-7-1987", "3000", "0", "20" },
				{ "7839", "KING", "PRESIDENT", "NULL", "17-11-1981", "5000", "0", "10" },
				{ "7844", "TURNER", "SALESMAN", "7698", "8-9-1981", "1500", "0", "30" },
				{ "7876", "ADAMS", "CLERK", "7788", "13-7-1987", "1100", "0", "20" },
				{ "7900", "JAMES", "CLERK", "7698", "3-12-1981", "950", "0", "30" },
				{ "7902", "FORD", "ANALYST", "7566", "3-12-1981", "3000", "0", "20" },
				{ "7934", "MILLER", "CLERK", "7782", "23-1-1982", "1300", "0", "10" }
				};	
		
		// 문제) # "DALLAS"에서 근무하는 사원의 이름,직급,부서번호,부서명을 조회하시오
		String search = "DALLAS";
		String check = "";
		int idx=-1;
		for(int i = 0 ; i < departmentData.length;i++) {
			if(departmentData[i][2].equals(search)) {
				check=departmentData[i][0];
				idx=i;
			}
		}
		System.out.printf("%s 에서 근무하는 사원\n",search);
		System.out.println("이름        직급        부서번호        부서명");
		for (int i = 0; i < employeeData.length; i++) {
			if (employeeData[i][7].equals(check)) {
				for (int k = 0; k < employeeData[i].length; k++) {
					if (k == 1||k==2||k==7) {
						System.out.printf("%-10s ",employeeData[i][k]);
					}
				}
				System.out.println(departmentData[idx][1]);
			}
		}
		System.out.println("=======================================");
		// 문제) # ALLEN과 같은 부서에 근무하는 사원의 이름, 부서번호를 조회하시오.
		search = "ALLEN";
		for(int i = 0 ; i < employeeData.length;i++) {
			if(employeeData[i][1].equals(search)) {
				check=employeeData[i][7];
			}
		}
		System.out.println("ALLEN과 같은 부서에 근무하는 사원");
		System.out.println("이름         부서번호");
		for(int i = 0 ; i < employeeData.length;i++) {
			if(employeeData[i][7].equals(check)) {
				for (int k = 0; k < employeeData[i].length; k++) {
					if (k == 1||k==7) {
						System.out.printf("%-10s ",employeeData[i][k]);
					}
				}
				System.out.println();
			}
		}
		System.out.println("=======================================");
		//# 부서별 최대 급여와 최소 급여를 구하시오.
		System.out.println("          최대급여    최소급여");
		for(int i = 0 ; i < departmentData.length;i++) {
			int max=0;
			int min=0;
			for(int k = 0 ; k < employeeData.length;k++) {
				if(employeeData[k][7].equals(departmentData[i][0])) {
					if (max == 0) {
						max = Integer.parseInt(employeeData[k][5]);
					} else if (max < Integer.parseInt(employeeData[k][5])) {
						max=Integer.parseInt(employeeData[k][5]);
					}
					if (min == 0) {
						min = Integer.parseInt(employeeData[k][5]);
					} else if (min > Integer.parseInt(employeeData[k][5])) {
						min=Integer.parseInt(employeeData[k][5]);
					}
				}
			}
			System.out.printf("%-10s%-10d%-10d\n",departmentData[i][2],max,min);
		}
		System.out.println("=======================================");
		//#부서별로 급여 평균 (단, 부서별 급여 평균이 2000 이상만)
		System.out.println("          급여평균");
		for(int i = 0 ; i < departmentData.length;i++) {			
			int cnt=0;
			int sum=0;
			for(int k = 0 ; k < employeeData.length;k++) {
				if(employeeData[k][7].equals(departmentData[i][0])) {
					sum+=Integer.parseInt(employeeData[k][5]);
					cnt++;
				}
			}
			int avg=0;
			if (cnt > 0) {
				avg = sum / cnt;
			}
			System.out.printf(avg>=2000 ? "%-10s%-10d\n":"" ,departmentData[i][2],avg);
		}
		System.out.println("=======================================");
		//#부서번호가 30번인 사원들의 이름, 직급, 부서번호, 부서위치를 조회하시오.		
		search="30";
		for(int i = 0 ; i < departmentData.length;i++) {
			if(departmentData[i][0].equals(search)) {
				check=departmentData[i][2];				
			}
		}
		System.out.printf("부서번호가 %s 인 사원\n",search);
		System.out.println("이름        직급       부서번호       부서위치");
		for(int i = 0 ; i < employeeData.length;i++) {
			if(employeeData[i][7].equals(search)) {
				System.out.printf("%-10s%-10s %-10s",employeeData[i][1],employeeData[i][2],employeeData[i][7]);
				System.out.println(check);
			}
		}
		System.out.println("=======================================");
		//# 이름에 A 가 들어가는 사원의 이름,부서명을 조회하시오.
		search="A";
		System.out.printf("이름에 %s 가 들어간 사원\n",search);
		System.out.println("이름        부서명");
		for(int i = 0 ; i < employeeData.length;i++) {
			if(employeeData[i][1].contains(search)) {
				System.out.printf("%-10s",employeeData[i][1]);
				String temp = employeeData[i][7];
				for(int k = 0 ; k < departmentData.length ; k++) {
					if(departmentData[k][0].equals(temp)) {
						System.out.println(departmentData[k][1]);
					}
				}
			}
		}
		System.out.println("=======================================");
		//# 사원명 'JONES'가 속한 부서명을 조회하시오.
		search="JONES";
		System.out.printf("%s 가 속한 부서명\n",search);
		for(int i = 0 ; i < employeeData.length;i++) {
			if(employeeData[i][1].equals(search)) {
				String temp = employeeData[i][7];
				for(int k = 0 ; k < departmentData.length ; k++) {
					if(departmentData[k][0].equals(temp)) {
						System.out.println(departmentData[k][1]);
					}
				}
			}
		}
		System.out.println("=======================================");
		//# 10번 부서에서 근무하는 사원의 이름과 10번 부서의 부서명을 조회하시오.
		search="10";
		System.out.printf("%s 번 부서명\n",search);
		for(int k = 0 ; k < departmentData.length ; k++) {
			if(departmentData[k][0].equals(search)) {
				System.out.println(departmentData[k][1]);
			}
		}
		System.out.printf("%s 번 부서에서 근무하는 사원\n",search);
		for(int i = 0 ; i < employeeData.length;i++) {
			if(employeeData[i][7].equals(search)) {
				System.out.printf("%-10s\n",employeeData[i][1]);
			}
		}	
	}

}
