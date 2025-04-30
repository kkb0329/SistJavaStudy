package booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.db.DbConnect;

public class BookingDao {
  DbConnect db=new DbConnect();
  
  public void insertBooking(BookingDto dto)
  {
	  Connection conn=db.getConnecton();
	  PreparedStatement pstmt=null;
	  
	  String sql="insert into booking values (seq_hello.nextval,?,?,?,?,?,?,?,sysdate)";
	  
	  try {
		pstmt=conn.prepareStatement(sql);
		//바인딩
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getGender());
		pstmt.setString(3, dto.getBookday());
		pstmt.setInt(4, dto.getInwon());
		pstmt.setString(5, dto.getFoodphoto());
		pstmt.setString(6, dto.getFoodprice());
		pstmt.setString(7, dto.getMessage());
		
		pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(pstmt, conn);
	}
	  
  }
}
