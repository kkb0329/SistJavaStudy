package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BtnArrayEvent7 extends JFrame implements ActionListener{

	Container cp;
	JButton [] btn=new JButton[5];
	String [] btnLabel = {"Red","Yellow","Blue","Green","White"};
	Color [] btnColor = {Color.red,Color.yellow,Color.blue,Color.green,Color.white};
	
	public BtnArrayEvent7(String title) {
		super(title);  //JFrame 부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(1400, 100, 600, 800);
		
		
		cp=this.getContentPane();
		cp.setBackground(new Color(127, 255, 212));
		initDesign();
		this.setVisible(true);
	}

	public void initDesign()
	{
		//panel 은 기본이 FlowLAyout
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1)); //7행 1열
		panel.setBackground(Color.orange);
		
		//패널을 상단에 배치
		//this.add(panel, BorderLayout.NORTH);
		//this.add("North", panel);
		this.add(panel, BorderLayout.WEST);
		
		//버튼생성
		for(int i=0;i<btn.length;i++)
		{
			btn[i] = new JButton(btnLabel[i]);
			
			//버튼의 색상을 각각의 색상으로 변경
			btn[i].setBackground(btnColor[i]);
			//panel에 버튼추가
			panel.add(btn[i]);
			//버튼에 이벤트 추가
			btn[i].addActionListener(this);

		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob =e.getSource();
		
		//각각의 버튼을 누르면 배경색이 해당제목으로 변경된다
		for(int i=0;i<btn.length;i++)
		{
			//프레임의 배경색 변경
			if(ob==btn[i])
			{
			//프레임의 배경색 변경
			cp.setBackground(btnColor[i]);
			
			//창제목도 변경
			this.setTitle("Color: "+btnLabel[i]);
			}
		}
		
	}
	public static void main(String[] args) {
		
		new BtnArrayEvent7("스윙배열이벤트 #7");
		
		
		
	}

	
}
