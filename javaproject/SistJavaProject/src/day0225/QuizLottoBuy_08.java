package day0225;

import java.util.Scanner;

public class QuizLottoBuy_08 {

	public static void main(String[] args) {
		/*
		 * 로또 몇장드릴까요?
		 * 3
		 * 
		 * 1회: 2  13  22  32  44  45
		 * 2회: 3  12  15  16  18  22
		 * 3회: 4  5   11  22  33  36
		 * */

		Scanner sc = new Scanner(System.in);
		
		int su;
		int [] lotto = new int[5];
		
		System.out.println("로또 몇장드릴까요?");
		su = sc.nextInt();
		for(int a=0;a<su;a++)
		{
			 System.out.printf("%3d회: ",a+1);
		
	
		for(int i=0;i<lotto.length;i++)
		{
			
			lotto [i] = (int)((Math.random()*45)+1);
			
			
			for (int j=0;j<i;j++)
			{
				if(lotto[i]==lotto[j])
				{
					i--;
				    break;
				}	
			}
			
		}
		
		for(int i=0;i<lotto.length-1;i++)
		{
			for(int j=i+1;j<lotto.length;j++)
			{
				
				if(lotto[j]<lotto[i])
				{
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
							
				}
			}
		}
		for(int i=0;i<lotto.length;i++)
		{
			System.out.print(lotto[i]+" ");
		}
		System.out.println();
	
		}

	}

}
