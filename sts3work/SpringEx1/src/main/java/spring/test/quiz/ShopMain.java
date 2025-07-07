package spring.test.quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("anno.xml");
		
		OrderController order=(OrderController)app.getBean("orderController");
		
		order.orderInsert("요가매트", 35000, "핑크");
		order.orderDelete("9");
		order.orderSelect("덤벨", 45000, "블랙");
	}

}
