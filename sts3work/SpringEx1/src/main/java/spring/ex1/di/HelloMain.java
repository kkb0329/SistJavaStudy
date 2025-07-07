package spring.ex1.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		
		// 자바방식으로 Hello메서드 호출하기
		Hello hello1=new Hello();
		Hello hello2=new Hello();
		System.out.println(hello1.getMessage());
		
		//결과:false: 자바에서는 new로 생성시마다 새로운영역에 생성된다
		System.out.println(hello1==hello2);
		
		System.out.println("스프링방식으로 Hello메서드 호출하기");
		//설정xml파일가져오기
		//어플리케이션 실행시에만 필요하다
		//웹에서는 web.xml에 설정이 되어있으므로 필요없다
		ApplicationContext app1=new ClassPathXmlApplicationContext("helloContext.xml");
		
		Hello h1=(Hello)app1.getBean("hello"); //방법1
		System.out.println(h1.getMessage());
		
		Hello h2=app1.getBean("hello", Hello.class); //방법2
		System.out.println(h2.getMessage());
		
		//스프링에서는 기본이 싱글톤이다
		System.out.println(h1==h2);

	}

}
