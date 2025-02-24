package day0224;

import java.util.Scanner;

public class ArrayScanSum_10 {

	public static void main(String[] args) {
		/* 입력한값이 배열의 초기값으로 된다
		 * 1번째 값: 55
		 * 2번째 값: 88
		 * 3번째 값: 78
		 * 4번째 값: 99
		 * 5번째 값: 48
		 * 입력값 확인
		 * 0==>55
		 * 1==>88
		 * 2==>78
		 * 3==>99
		 * 4==>48
		 * */
		
		Scanner sc = new Scanner(System.in);
	    int [] data;
	    data = new int[5];
	    int sum=0;
	    
	    // 값입력
		for (int i=0;i<data.length;i++)
		{
			System.out.print((i+1)+"번째 값: ");
			data[i]=sc.nextInt();
			//입력한 값 sum에 누적
            sum+=data[i]; 		
		}   System.out.println("입력값 확인");
		
		// 값출력
		for (int i=0;i<data.length;i++)
		{
			System.out.println(i+"==>"+data[i]);
		}
		System.out.println("총합계: "+sum);
		

	}

}
