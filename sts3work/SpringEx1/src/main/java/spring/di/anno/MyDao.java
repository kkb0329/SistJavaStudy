package spring.di.anno;

import org.springframework.stereotype.Component;


//@Component : XML 설정없이 자동 빈 등록 @Component("name") 이름 지정 가능 
//()안의 네임을 생략하면 클래스명이고 맨앞한글자는 소문자로(myDao)
@Component
public class MyDao implements DaoInter {

	@Override
	public void insertData(String str) {
		// TODO Auto-generated method stub

		System.out.println(str+"_데이터를 db에 추가성공!!!");
	}

	@Override
	public void deleteData(String num) {
		// TODO Auto-generated method stub
       System.out.println(num+"에 해당하는 데이타 삭제성공!!");
	}

}
