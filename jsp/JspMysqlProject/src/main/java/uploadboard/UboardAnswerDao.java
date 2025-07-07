package uploadboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.db.DbConnect;

public class UboardAnswerDao {

	DbConnect db=new DbConnect();
	
	//insert
	public void insertAnswer(UboardAnswerDto dto)
	{
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		
		String sql="insert into uboardanswer (num,nickname,content,writeday) values (?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNum());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getContent());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//전체목록
	public List<UboardAnswerDto> getAnswerList(String num)
	{
		List<UboardAnswerDto> list=new ArrayList<UboardAnswerDto>();
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from uboardanswer where num=? order by idx desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				UboardAnswerDto dto=new UboardAnswerDto();
				
				dto.setNum(rs.getString("num"));
				dto.setIdx(rs.getString("idx"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return list;
	}
	
	//삭제
}
