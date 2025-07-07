package spring.test.quiz;

import org.springframework.stereotype.Component;

@Component
public class ShopDao implements ShopDaoInter {

	@Override
	public void insertShop(String sangpum, int price, String color) {
		// TODO Auto-generated method stub
        System.out.println(sangpum+":"+price+":"+color);
	}

	@Override
	public void deleteShop(String num) {
		// TODO Auto-generated method stub
        System.out.println(num+"번 삭제됨!!!");
	}

	@Override
	public void selectShop(String sangpum, int price, String color) {
		// TODO Auto-generated method stub
         System.out.println("***상품재고현황***");
         System.out.println("========================");
         System.out.println("상품명: "+sangpum);
         System.out.println("가격: "+price);
         System.out.println("색상: "+color);
	}

}
