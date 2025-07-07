package spring.di.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageMain {

	public static void main(String[] args) {
		// 스프링방식 생성후 메서드 호출
		ApplicationContext context=
				new ClassPathXmlApplicationContext("appContext1.xml");
		
		MessageInter m1=(Message1)context.getBean("msg1");
		m1.sayHello("미나");
		
		MessageInter m2=context.getBean("msg2", Message2.class);
		m2.sayHello("영돈");

	}

}
