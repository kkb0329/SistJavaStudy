package day0219;

import java.util.Scanner;

public class Quiz0219_13 {

	public static void main(String[] args) {
		/*
		 * 입고된 상품명은? 아이폰16
           수량은? 6
           단가는? 1100000
           ============================
           아이폰 6개는 총 6600000 입니다 
           (단 5개 이상은 10프로 DC 됩니다)
           ============================
           dc된 최종금액: 5940000원
*/ 
		Scanner sc = new Scanner(System.in);
		
		String name;
		int money,amount,tot,dc;
		
		System.out.println("입고된 상품명은?");
		name = sc.nextLine();
		System.out.println("수량은?");
		amount = sc.nextInt();
		System.out.println("단가는?");
		money = sc.nextInt();
		System.out.println("===============");
		
		tot = amount*money;
		System.out.printf("아이폰 6개는 총 %d 입니다\n(단 5개 이상은 10프로 DC 됩니다)",tot);
		System.out.println("===============");
		
		
	    System.out.println("dc된 최종금액:"+(amount>=5?tot*0.9:tot));
		
		
		
		

	}

}
