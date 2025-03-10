package day0310;

public class ThreadEx3 implements Runnable{
	
	String name;
	int num;
	
	public ThreadEx3(String name, int num) {
		this.name=name;
		this.num=num;
	}

	@Override
	public void run() {
		for(int i=1;i<=num;i++)
		{
			System.out.println(name+"==>"+i);
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		
		//Runnable 인터페이스 구현한 클래스 생성
		ThreadEx3 th1=new ThreadEx3("하나", 300);
		ThreadEx3 th2=new ThreadEx3("둘", 300);
		ThreadEx3 th3=new ThreadEx3("셋", 300);
		
		//Thread생성
		Thread ex1 = new Thread(th1);
		Thread ex2 = new Thread(th2);
		Thread ex3 = new Thread(th3);
		
		//run메서드 호출_start
		ex1.start();
		ex2.start();
		ex3.start();
		
		

	}

	
}
