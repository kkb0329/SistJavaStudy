package ajaxmemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import oracle.db.DbConnect;

public class MemoDao {
  
	DbConnect db=new DbConnect();
  
  
	//insert
	public void insertMemo(MemoDto dto)
	{
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="insert into ajaxmemo values(seq_hello.nextval,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getEmot());
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//전체출력
	public List<MemoDto> getAllMemos()
	{
		List<MemoDto> list=new Vector<MemoDto>();
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from ajaxmemo order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//while db 데이타를 읽어서 dto에 넣은후
			//다시 list에 추가한다
			while(rs.next()) {
				
				MemoDto dto=new MemoDto();
				
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setEmot(rs.getString("emot"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list에 추가
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
	public void deleteMemo(String num)
	{
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		
		String sql="delete from ajaxmemo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//num에 대한 데이타 리턴
	public MemoDto getData(String num)
	{
		MemoDto dto=new MemoDto();
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from ajaxmemo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setEmot(rs.getString("emot"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return dto;
	}
	
}
