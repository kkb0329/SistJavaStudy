package day0319;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTestEx2 {
	
	
	static final String URL="jdbc:oracle:thin:@localhost:1521:XE";

	public void connectBordAnswer () {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="SELECT b.bno, writer, subject, nickname, content FROM board b, answer a WHERE b.bno = a.bno";
		
		try {
			conn=DriverManager.getConnection(URL,"taelim" ,"a1234" );
			
			System.out.println("success");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("게시판 댓글 리스트");
			
			
			while (rs.next()) {
				int bno=rs.getInt("bno");
				String writer=rs.getString("writer");
				String subject=rs.getString("subject");
				String nickname=rs.getString("nickname");
				String content=rs.getString("content");
				//String writeday=rs.getString("writeday");
				
				
				System.out.println("번호: " + bno+ ", 글쓴이 : " + writer + ", 제목: " + subject + ", 닉네임: " + nickname + ", "
						+ "내용: " + content);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("failed");
		}finally {
			
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
	
public void connectSawon () {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql = "SELECT buseo, "
				+ "TO_CHAR(AVG(pay), 'L999,999,999') AS avg_pay, "
				+ "TO_CHAR(MAX(pay), 'L999,999,999') AS max_pay, "
				+ "TO_CHAR(MIN(pay), 'L"
				+ ""
				+ ""
				+ ""
				+ "999,999,999') AS min_pay "
				+ "FROM sawon GROUP BY buseo";
		
		try {
			conn=DriverManager.getConnection(URL,"taelim" ,"a1234" );
			
			System.out.println("success");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("게시판 댓글 리스트");
			
			
			while (rs.next()) {
				String buseo=rs.getString("buseo");
				String avg_pay=rs.getString("avg_pay");
				String max_pay=rs.getString("max_pay");
				String min_pay=rs.getString("min_pay");
				
				
				System.out.println("부서: " + buseo + ", 평균: " + avg_pay+ ", 최대: " + max_pay + ",  최소: " + min_pay);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("failed");
		}finally {
			
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
	
	
		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConnectTestEx2 ct=new ConnectTestEx2();
		ct.connectSawon();
		
		
	}

}
