package day0319;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTestEx3 {
	
	
	static final String URL="jdbc:oracle:thin:@localhost:1521:XE";

	public void connectShop () {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="SELECT \r\n"
				+ "    c.idx, \r\n"
				
				+ "    s.sanpum, \r\n"
				+ "    s.color, \r\n"
				+ "    c.cnt, \r\n"
				+ "    c.guipday\r\n"
				+ "FROM \r\n"
				+ "    (\r\n"
				+ "        SELECT idx, num, cnt, guipday FROM cart1\r\n"
				+ "        UNION\r\n"
				+ "        SELECT idx, num, cnt, guipday FROM cart2\r\n"
				+ "    ) c\r\n"
				+ "JOIN shop s\r\n"
				+ "    ON c.num = s.num ";
		
		try {
			conn=DriverManager.getConnection(URL,"taelim" ,"a1234" );
			
			System.out.println("success");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("게시판 댓글 리스트");
			
			
			while (rs.next()) {
				int idx=rs.getInt("idx");
				String sanpum=rs.getString("sanpum");
				String color=rs.getString("color");
				int cnt=rs.getInt("cnt");
				
				Date guipday=rs.getDate("guipday");
				
				
				
				System.out.println("번호: " + idx+ ", 상품명 : " + sanpum + ", 색: " + color + ", 개수: " + cnt + ", "
						+ "구입날짜: " + guipday);
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

		ConnectTestEx3 ct=new ConnectTestEx3();
		ct.connectShop();
		
		
	}

}
