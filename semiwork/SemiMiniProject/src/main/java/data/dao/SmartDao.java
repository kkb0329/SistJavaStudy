package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.BoardDto;
import data.dto.SmartDto;
import mysql.db.DbConnect;

public class SmartDao {

	DbConnect db=new DbConnect();
	
	//insert
	public void insertSmart(SmartDto dto)
	{
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		
		String sql="insert into smartboard(writer,subject,content,pass,writeday) values(?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩 
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPass());
						
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//List
	public List<SmartDto> getAllDatas()
	{
		List<SmartDto> list=new Vector<SmartDto>();
		
		//그룹변수 내림차순 같은그룹인경우 step의 오름차순 정렬
		String sql="select * from smartboard order by num desc";
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				SmartDto dto=new SmartDto();
				
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	//dto반환
	public SmartDto getData(String num)
	{
		SmartDto dto=new SmartDto();
		
		String sql="select * from smartboard where num=?";
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
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
	
	//가장최신에 추가된 글의 num얻기_getMaxNum
	public int getMaxNum()
	{
		int max=0;
		
		String sql="select ifnull(max(num),0) max from smartboard";
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next())
				max=rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return max;
	}
	
	//readcount증가
	//디테일페이지에서 조회수1 증가해야 하므로
		public void updateReadCount(String num)
		{
			String sql="update smartboard set readcount=readcount+1 where num=?";
			
			Connection conn=db.getConnecton();
			PreparedStatement pstmt=null;
			
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
		
	
	//비밀번호비교
	
	//update
	
	//delete
		public void deleteSmart(String num)
		{
			Connection conn=db.getConnecton();
			PreparedStatement pstmt=null;
			
			String sql="delete from smartboard where num="+num;
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
}
