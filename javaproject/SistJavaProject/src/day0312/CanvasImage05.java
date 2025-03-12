package day0312;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CanvasImage05 extends JFrame{

	Container cp;
	JButton btnImage;
	Image image;
	Mycanvas mycan;  //캔버스를 상속받은 내부클래스
	
	public CanvasImage05(String title) {
		super(title);  //JFrame 부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(1500, 100, 400, 800);
				
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		
		initDesgin();
		this.setVisible(true);
	}
	
	public void initDesgin()
	{
		//처음나타낼 초기이미지 지정
		this.setLayout(null);
		
		image = new ImageIcon("C:\\sist0217\\image\\logoImg\\a04.png").getImage();
		mycan=new Mycanvas(); //paint메서드 자동호출
		mycan.setBounds(20, 100, 400, 500);
		this.add(mycan);
		
		
		//버튼
		btnImage = new JButton("이미지 불러오기");
		btnImage.setBounds(100, 650, 150, 40);
		this.add(btnImage);
		
		//익면내부클래스 이벤트
		btnImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//취소시 메서드 종료
				FileDialog dlg = new FileDialog(CanvasImage05.this, "이미지가져오기", FileDialog.LOAD);
				dlg.setVisible(true);
				
				if(dlg.getDirectory()==null)
					return;
				
				String imageFileName=dlg.getDirectory()+dlg.getFile();
				
				//이미지 생성
				image=new ImageIcon(imageFileName).getImage();
				
				//캔버스클래스의 paint메서드 호출
				mycan.repaint();
			}
		});
	}
	
	//canvas를 상속받는 클래스
	class Mycanvas extends Canvas{
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			//이미지 출력
			g.drawImage(image, 30, 30, this);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		CanvasImage05 sw1 = new CanvasImage05("캔버스 이미지 #5");
		
		
		
	}
}
