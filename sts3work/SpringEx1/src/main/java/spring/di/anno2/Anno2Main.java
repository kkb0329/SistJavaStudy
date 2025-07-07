package spring.di.anno2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("anno.xml");
		
		Friut fruit=(Tmanggo)app.getBean("tmgo");
		fruit.writeFriutName();
		
		Friut fruit2=(PhiManggo)app.getBean("pmgo");
		fruit2.writeFriutName();
		
		MyFruit my=(MyFruit)app.getBean("myFruit");
		my.writeFruit();
		
		
	}

}
