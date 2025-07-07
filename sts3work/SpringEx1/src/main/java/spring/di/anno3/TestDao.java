package spring.di.anno3;

import org.springframework.stereotype.Component;

@Component
public class TestDao {

	public void insert(String name)
	{
		System.out.println(name+"님 추가됨!!!");
	}
	
	public void select(String name)
	{
		System.out.println(name+"님은 쌍용교육센터 학생입니다");
	}
	
	public void delete(String num)
	{
		System.out.println(num+"번 데이타 삭제완료!!!");
	}
}
