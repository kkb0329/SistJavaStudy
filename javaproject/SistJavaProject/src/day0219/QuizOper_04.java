package day0219;

import java.util.Scanner;

public class QuizOper_04 {

	public static void main(String[] args) {
		// 현재 지갑에 있는 돈을 입력하여 만원,천원,백원,일원 객수를 출력하시오
		/*
		 * 금액을 입력하시오
		 * 752543
		 * 만원 : 75
		 * 천원 : 2
		 * 백원 : 5
		 * 십원 : 4
		 * 일원 : 3
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int won,mwon,twon,hwon,ten,one;
		
		System.out.println("금액을 입력하시오");
		won = sc.nextInt();
		
		mwon = (won/10000);
		twon = (won%10000/1000);
		hwon = (won%1000/100);
		ten  = (won%100/10);
		one  = (won%10);
		
		System.out.println("만원 :"+mwon);
		System.out.println("천원 :"+twon);
		System.out.println("백원 :"+hwon);
		System.out.println("십원 :"+ten);
		System.out.println("일원 :"+one);
		
		

	}

}
