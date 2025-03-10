package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuizSwing extends JFrame{
	
	Container cp;
	JLabel lblnum1,lblnum2;
	JTextField tfSu1,tfSu2;
	JButton su1,su2,su3,su4;

	public QuizSwing(String title) {
		super(title);  //JFrame 부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(500, 100, 500, 800);
		
		cp=this.getContentPane();
		cp.setBackground(new Color(127, 255, 212));
		initDesign();
		this.setVisible(true);
	}
	public void initDesign()
	{
		JPanel pCenter = new JPanel(new GridLayout(1, 2));
		this.add(pCenter);
		
		this.setLayout(null);
		
		su1 = new JButton("더하기");
		su1.setBounds(0, 500, 500, 40);
		this.add(su1);
		su2 = new JButton("빼기");
		su2.setBounds(0, 580, 500, 40);
		this.add(su2);
		su3 = new JButton("곱하기");
		su3.setBounds(0, 650, 500, 40);
		this.add(su3);
		su4 = new JButton("나누기");
		su4.setBounds(0, 720, 500, 40);
		this.add(su4);
		
		tfSu1=new JTextField();
		tfSu1.setBounds(0, 450, 500, 40);
		this.add(tfSu1);
		
		tfSu2=new JTextField();
		tfSu2.setBounds(0, 400, 500, 40);
		this.add(tfSu2);
		
		lblnum1 = new JLabel("숫자1");
		lblnum1.setBounds(0, 450, 500, 40);
		lblnum2 = new JLabel("숫자2");
		lblnum2.setBounds(0, 400, 500, 40);
		
	}
	

	public static void main(String[] args) {
		
		QuizSwing sw1 = new QuizSwing("스윙 #10");
		
		
		
	}
}
