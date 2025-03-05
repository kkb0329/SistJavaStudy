package day0305;

import java.io.IOException;
import java.io.InputStream;
//	
public class Ex12IoException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputStream is = System.in;
		int a=0;
		
		System.out.println("한글자를 입력: ");
		
		try {
			a=is.read();  //read()는 1바이트이므로 한글못읽음
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("***3초 뒤에 출력합니다***");
		
		try {
			Thread.sleep(3000);//3초
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("입력값: "+(int)a);
	}

}
