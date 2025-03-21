package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class QuizSwing extends JFrame implements ActionListener{
	
	Container cp;
	JLabel lblnum1,lblnum2,lblResult;
	JTextField tfSu1,tfSu2;
	JButton su1,su2,su3,su4;

	public QuizSwing(String title) {
		super(title);  //JFrame 부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(500, 100, 500, 800);
		
		cp=this.getContentPane();
		cp.setBackground(new Color(127, 255, 212));
		initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void initDesign()
	{

		JPanel panel1 =new JPanel();	
		panel1.setBounds(0, 220, 100, 30);
		panel1.setBackground(Color.WHITE);
		this.add(panel1);
		
		JPanel panel2 =new JPanel();	
		panel2.setBounds(0, 340, 100, 30);
		panel2.setBackground(Color.WHITE);
		this.add(panel2);
		
		this.setLayout(null);
		
		su1 = new JButton("더하기");
		su1.setBounds(0, 460, 500, 40);
		su1.addActionListener(this);
		this.add(su1);
		su2 = new JButton("빼기");
		su2.setBounds(0, 520, 500, 40);
		su2.addActionListener(this);
		this.add(su2);
		su3 = new JButton("곱하기");
		su3.setBounds(0, 580, 500, 40);
		su3.addActionListener(this);
		this.add(su3);
		su4 = new JButton("나누기");
		su4.setBounds(0, 640, 500, 40);
		su4.addActionListener(this);
		this.add(su4);
		
		tfSu1=new JTextField();
		tfSu1.setBounds(0, 250, 500, 40);
		this.add(tfSu1);
		
		tfSu2=new JTextField();
		tfSu2.setBounds(0, 370, 500, 40);
		this.add(tfSu2);
		
		lblnum1 = new JLabel("숫자1");
		panel1.add(lblnum1);
		lblnum2 = new JLabel("숫자2");
		panel2.add(lblnum2);
		
		lblResult = new JLabel("결과 나오는곳");
		lblResult.setBounds(0, 680, 300, 80);
		lblResult.setBorder(new TitledBorder("결과확인"));
		lblResult.setFont(new Font("", Font.BOLD, 20));
		this.add(lblResult);
		
	}
	

	public static void main(String[] args) {
		
		QuizSwing sw1 = new QuizSwing("스윙 사칙연산 #10");
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		try {
			// 입력값 가져오기
			double num1 = Double.parseDouble(tfSu1.getText());
			double num2 = Double.parseDouble(tfSu2.getText());
			double result = 0;

			// 연산처리
			if (e.getSource() == su1) 
			{
				result = num1 + num2;
			} 
			else if (e.getSource() == su2) 
			{
				result = num1 - num2;
			} 
			else if (e.getSource() == su3) 
			{
				result = num1 * num2;
			} 
			else if (e.getSource() == su4) 
			{
				result = num1 / num2; 
			}

			// 결과 표시
			lblResult.setText("결과: " + result);

		} catch (NumberFormatException ex) {
			lblResult.setText("숫자를 입력해주세요!");
		}

	} 
	        
	    
}

