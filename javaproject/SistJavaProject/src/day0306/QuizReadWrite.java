package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuizReadWrite {
	
	static String fileName = "C:\\sist0217\\work\\sangpumInfo";
	
	FileWriter fw;
	BufferedReader br;
	FileReader fr;
	
	Scanner sc = new Scanner(System.in);
	
	public int getMenu()
	{
		
		//1.상품추가 2.상품전체입고현황 9.종료
		
		int num = 0;	
		System.out.println("1.상품추가\t2.상품전체입고현황\t9.종료");
		num = Integer.parseInt(sc.nextLine());
		
		return num;
	}
	
	//입력후 파일에 저장 sangpumAdd()
	//fw.write(상품명+","+수량+","+단가","+"\n")
	public void sangpumAdd()
	{
		
		System.out.println("상품명?");
		String sName = sc.nextLine();
		System.out.println("수량?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("단가?");
		int price = Integer.parseInt(sc.nextLine());
		
		try {
			fw = new FileWriter(fileName);
			
			fw.write(sName+","+su+","+price+","+"\n");
			
			System.out.println("상품정보가 저장됨");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	//전체출력 sangpumAllDatas()
	
	public void sangpumAllDatas()
	{
		QuizReadWrite q1 = new QuizReadWrite();
		
		System.out.println("상품명\t수량\t단가\t금액\t할인\t총금액");
		System.out.println("=========================================================");
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			
			while(true)
			{
				String name = br.readLine();
				if (name == null);
					break;
					
					
					
				
				int su = Integer.parseInt(br.readLine());
				Double avg = getAvg(su, price);
				System.out.println(name+"\t"+"\t"+price+"\t"+price+"\t"+avg+"\t"); 
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	//수량이 10개 이상이면 총금액의 10프로 할인
	public double getAvg(int su,int price)
	{
		double sale =0; 
		int tot = su*price;
		if(su>=10)
			sale = (tot*0.1);
		else
			sale = 0;
		return sale;
	}
	
	//번호    상품명    수량    단가    금액    할인    총금액

	public static void main(String[] args) {
		
		//1번이면 입력메서드 호출 ...2번이면 출력메소드 9번이면 종료
		QuizReadWrite q1 = new QuizReadWrite();
		
		
	}

}
