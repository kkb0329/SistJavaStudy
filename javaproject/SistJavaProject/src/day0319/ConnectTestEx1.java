package day0319;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTestEx1 {
	
	
	static final String URL="jdbc:oracle:thin:@localhost:1521:XE";

	public void connectSawon () {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM sawon ORDER BY num";
		
		try {
			conn=DriverManager.getConnection(URL,"taelim" ,"a1234" );
			
			System.out.println("success");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while (rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				int pay=rs.getInt("pay");
				
				System.out.println("번호: " + num + ", 이름: " + name + ", 성별: " + gender + ", 부서: " + buseo + ", 급여: " + pay);
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

		ConnectTestEx1 ct=new ConnectTestEx1();
		ct.connectSawon();
		
	}

}
