package day0225;

import java.util.Scanner;

public class ArrayStringIndex_02 {

	public static void main(String[] args) {
		//이름을 입력하여 몇번째에 있는지, 아니면 우리반 학생이 아닌지 검색해 볼것
		//반복해서 검색하다가 끝 이라고 하면 프로그램 종료할것
		String [] stu = {"손현정","박호준","유혜지","원주희","김기범","이창연","박용희","김민규","조태민","공찬혁"};
		
		boolean b;
		Scanner sc=new Scanner(System.in);
		String stuName;
		
		while(true)
		{
			System.out.println("이름을 검색해주세요");
			stuName = sc.nextLine();
			
			if(stuName.equals("끝"))
			{
				System.out.println("종료합니다");
				break;
			}
			
			b = false;
			
			for(int i=0;i<stu.length;i++)
			{
				if(stuName.equals(stu[i]))
				{
					b = true;
					System.out.println(i+"번지에 검색됨");
				}
			}
			if(!b)
			{
				System.out.println(stuName+"님은 데이타에 없습니다.");
			}
			
		}
		

	}

}
