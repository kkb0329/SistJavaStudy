package day0321;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import day0319.DBConnect;
import oracle.net.aso.m;

public class SawonDbSwing extends JFrame implements ItemListener,ActionListener{

	DBConnect db=new DBConnect();
	Container cp;
	JTable table;
	DefaultTableModel model;
	JRadioButton [] rb=new JRadioButton[6];
	JButton btnAdd,btnDel;

	//생성자
	public SawonDbSwing(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자

		//위치 너비
		this.setBounds(500, 100, 700, 500);

		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		initDesign();
		
		
		//테이블 생성후 db로부터 데이타 가져오기(1:전체출력)
		this.sawonTableSelect(1);
		
		this.setVisible(true);
	}

	//디자인
	public void initDesign()
	{
		this.setLayout(null);
		
		//table추가
		String [] title= {"번호","ID","사원명","성별","부서명","월급여"};
		model=new DefaultTableModel(title, 0); //제목만 일단 넣고 행갯수는 0으로 추가
		table=new JTable(model);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);//셀너비 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		
		JScrollPane js=new JScrollPane(table);
		js.setBounds(10, 100, 670, 350);
		this.add(js);
		
		//라디오버튼추가
		ButtonGroup bg=new ButtonGroup();
		//전체 남자 여자  홍보부 개발부 디자인부
		String [] rb_label= {"전체","남자","여자","홍보부","개발부","디자인부"};
		
		int xpos=10;
		for(int i=0;i<rb.length;i++)
		{
			//라디오버튼 생성
			rb[i]=new JRadioButton(rb_label[i], i==0?true:false);
			rb[i].setBounds(xpos, 50, 90, 30);
			rb[i].setOpaque(false);
			//이벤트 추가
			rb[i].addItemListener(this);
			
			bg.add(rb[i]);
			this.add(rb[i]);
			xpos+=100;
		}
		
		//삭제버튼
		btnDel=new JButton("사원삭제");
		btnDel.setBounds(10, 10, 100, 30);
		btnDel.addActionListener(this);  //이벤트 추가
		this.add(btnDel);
		
		btnAdd=new JButton("사원추가");
		btnAdd.setBounds(150, 10, 100, 30);
		btnAdd.addActionListener(this);
		this.add(btnAdd);
		
	}
	
	
	public void sawonTableSelect(int select)
	{
		String sql="";
		
		if(select==1)
			sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon";
		else if(select==2)
			sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
					+ "from sawon where gender='남자'";
		else if(select==3)
			sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
					+ "from sawon where gender='여자'";
		else if(select==4)
			sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
					+ "from sawon where buseo='홍보부'";
		else if(select==5)
			sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
					+ "from sawon where buseo='개발부'";
		else if(select==6)
			sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
					+ "from sawon where buseo='디자인부'";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//기존의 데이타 삭제후 가져오기
			model.setRowCount(0);
			
			while(rs.next())
			{
				//테이블에 추가할 벡터 선언후 데이터 추가
				Vector<String> data=new Vector<String>();
				data.add(rs.getString("no"));
				data.add(rs.getString("id"));
				data.add(rs.getString("name"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));
				data.add(rs.getString("pay"));
				
				//벡터의 데이타를 행으로 추가
				model.addRow(data);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SawonDbSwing("사원테이블 DB");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 추가버튼,삭제버튼
		Object ob=e.getSource();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql="";
		
		if(ob==btnDel)
		{
			 int selectedRow = table.getSelectedRow();

		        // 선택된 행이 없을 경우
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(this, "삭제할 사원을 선택하세요.");
		            return;
		        }

		        // 선택된 행의 ID 값 가져오기
		        String selectedId = (String) table.getValueAt(selectedRow, 1); // ID는 두 번째 열에 있다고 가정

		        // 삭제할 SQL 쿼리
		        sql = "DELETE FROM sawon WHERE num = ?";

		        try {
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, selectedId); // 선택된 ID를 바인딩

		            // 삭제 실행
		            int rowsAffected = pstmt.executeUpdate();

		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(this, "사원이 삭제되었습니다.");
		                // 테이블 새로고침
		                this.sawonTableSelect(1);
		            } else {
		                JOptionPane.showMessageDialog(this, "사원 삭제에 실패했습니다.");
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(this, "데이터베이스 오류 발생");
		        } finally {
		            db.dbClose(null, pstmt, conn);
		        }
			
			
			
			
		}else if(ob==btnAdd)
		{
			String name=JOptionPane.showInputDialog("사원명을 입력해주세요");
			String gender=JOptionPane.showInputDialog("성별 입력해주세요(남자/여자)");
			String buseo=JOptionPane.showInputDialog("부서를 입력해주세요(홍보부,개발부,디자인부)");
			String pay=JOptionPane.showInputDialog("급여 입력해주세요");
			
			sql="insert into sawon values (seq_sawon.nextval,?,?,?,?)";
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				//바인딩
				pstmt.setString(1, name);
				pstmt.setString(2, gender);
				pstmt.setString(3, buseo);
				pstmt.setString(4, pay);
				
				//실행
				pstmt.execute();
				
				//테이블 다시호출
				this.sawonTableSelect(1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 라디오버튼 제어
		Object ob=e.getSource();
		for(int i=0;i<rb.length;i++)
		{
			if(rb[i]==ob)
				this.sawonTableSelect(i+1);
		}
	}


}
