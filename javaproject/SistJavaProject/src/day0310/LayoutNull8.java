package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//두개의 라벨과 텍스트필드 그리고 버튼을 만든후
//각각숫자를 넣고 버튼을 클릭하면 라벨에  22+44=66 출력할 예정
public class LayoutNull8 extends JFrame{
	
	Container cp;
	JLabel lblrResult,lblnum1,lblnum2;
	JTextField tfSu1,tfSu2;
	JButton btnAdd;
	
	public LayoutNull8 (String title) {
		super(title);  //JFrame 부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(500, 100, 800, 500);
	
		
		cp=this.getContentPane();
		cp.setBackground(new Color(127, 255, 212));
		initDesign();
		this.setVisible(true);
	}
	public void initDesign()
	{
		//기본레이아웃 업애고 직접 지정
		this.setLayout(null);
		lblnum1=new JLabel("숫자1: ");
		lblnum2=new JLabel("숫자2: ");
		
		lblnum1.setBounds(50, 30, 80, 50);
		this.add(lblnum1);
		
		lblnum2.setBounds(50, 80, 80, 50);
		this.add(lblnum2);
		
		tfSu1=new JTextField();
		tfSu1.setBounds(110, 40, 80, 30);
		this.add(tfSu1);
		
		tfSu2=new JTextField();
		tfSu2.setBounds(110, 90, 80, 30);
		this.add(tfSu2);
		
		btnAdd=new JButton("숫자더하기");
		btnAdd.setBounds(210, 60, 100, 50);
		this.add(btnAdd);
		
		//결과나오는곳
		lblrResult = new JLabel("결과 나오는곳");
		lblrResult.setBounds(50, 140, 240, 80);
		lblrResult.setBorder(new TitledBorder("결과확인"));
		lblrResult.setFont(new Font("", Font.BOLD, 20));
		this.add(lblrResult);
		
		//버튼이벤트_익명내부클래스
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int su1=Integer.parseInt(tfSu1.getText().trim());  //앞뒤공백제거후 숫자로변환
				int su2=Integer.parseInt(tfSu2.getText().trim());
				
				int sum=su1+su2;
				
				String s =su1+"+"+su2+"="+sum;
				
				lblrResult.setText(s);
			}
		});
		
	}

	public static void main(String[] args) {
		
		LayoutNull8 sw1 = new LayoutNull8("스윙레이아웃 Null#8");
		
		
		
	}
}
