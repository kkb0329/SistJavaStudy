package spring.di.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=
				new ClassPathXmlApplicationContext("appContext3.xml");
		
		//MyInfo생성후 확인
		MyInfo my=(MyInfo)context.getBean("my");
		//toString메서드는 생략시 자동호출되는 메서드
		System.out.println(my);
		System.out.println(my.toString());
		
		Moim m=(Moim)context.getBean("moim");
		m.writeData();
	}

}
