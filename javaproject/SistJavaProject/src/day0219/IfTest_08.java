package day0219;

public class IfTest_08 {

	public static void main(String[] args) {
		// 점수를 통해서 학점 구하기(A,B,C,D,F)
		
		int score=88;
		char grade;
		
		//if~else if~else 사용하여 구하기
		if(score>=90)
			grade='A';
		else if(score>=80)
			grade='b';
		else if (score>=70)
			grade='c';
		else 
			grade='f';
		
		System.out.println("학점은"+grade+"입니다");
		
			
		
			
		

	}

}
