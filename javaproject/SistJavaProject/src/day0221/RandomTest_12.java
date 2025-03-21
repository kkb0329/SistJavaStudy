package day0221;

public class RandomTest_12 {

	public static void main(String[] args) {
		// 자바에서 난수를 구하는 방법은 2가지
		//1.math.random() 메소드를 이용하는 방법
		//2.Random이라는 클래스를 생성하여 구하는 방법	
		
		System.out.println("[기본난수 5개 발생]");
		for(int i=1;i<=5;i++)
		{
			double a = Math.random();  //0.0XXXXXX~0.9XXXXXXXX 1미만의 실수
			System.out.print(a+" ");
		}
		System.out.println("\n--------------------------------");
		
		
		System.out.println("[[0~9사이의 난수 5개 발생]");
		for(int i=1;i<=5;i++)
		{
			int a = (int)(Math.random()*10); //0~9
			System.out.print(a+" ");
			
		}
		System.out.println("\n--------------------------------");
		
		System.out.println("[1~10사이의 난수 5개 발생]");
		for(int i=1;i<=5;i++)
		{
			int a = (int)(Math.random()*10)+1; //1~10
			System.out.print(a+" ");
		}
		System.out.println("\n--------------------------------");
		
		System.out.println("[1~100사이의 난수 5개 발생]");
		for(int i=1;i<=5;i++)	
		{
			int a = (int)(Math.random()*100)+1; //1~100
			System.out.print(a+" ");
		}
		System.out.println("\n--------------------------------");
		
	}

}
