package mymall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class MymallDao {

	DbConnect db=new DbConnect();
	
	//전체데이타조회
	public List<MymallDto> getAllSangPums()
	{
		List<MymallDto> list=new Vector<MymallDto>();
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from mymall order by num asc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				//db에서 가져와서 dto담기
				MymallDto dto=new MymallDto();
				
				dto.setNum(rs.getString("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPhoto(rs.getString("photo"));
				dto.setColor(rs.getString("color"));
				dto.setPrice(rs.getInt("price"));
				dto.setIpgoday(rs.getString("ipgoday"));
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
	
	//insert
	public void insertMall(MymallDto dto)
	{
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		
		String sql="insert into mymall values(null,?,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setString(3, dto.getColor());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setString(5, dto.getIpgoday());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//num에 해당하는 dto반환
			public MymallDto getSangpum(String num)
			{
				MymallDto dto = new MymallDto();
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				String sql = "select * from mymall where num=?";

				//db연결
				conn=db.getConnecton();

				//pstmt생성
				try {
					pstmt=conn.prepareStatement(sql);
					//바인딩
					pstmt.setString(1, num);
					rs=pstmt.executeQuery();
					if(rs.next())
					{
						//db에서 가져와서 dto에 담기
						dto.setNum(rs.getString("num"));
						dto.setSangpum(rs.getString("sangpum"));
						dto.setPhoto(rs.getString("photo"));
						dto.setColor(rs.getString("color"));
						dto.setPrice(rs.getInt("price"));
						dto.setIpgoday(rs.getString("ipgoday"));
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
			
			//수정
			public void updateMall(MymallDto dto)
			{
				Connection conn=db.getConnecton();
				PreparedStatement pstmt=null;
				
				String sql="update mymall set sangpum=?,photo=?,color=?,price=?,ipgoday=? where num=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					pstmt.setString(1, dto.getSangpum());
					pstmt.setString(2, dto.getPhoto());
					pstmt.setString(3, dto.getColor());
					pstmt.setInt(4, dto.getPrice());
					pstmt.setString(5, dto.getIpgoday());
					pstmt.setString(6, dto.getNum());
					
					pstmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}
				
			}
			
			//삭제
			public void deleteMall(String num)
			{
				Connection conn=db.getConnecton();
				PreparedStatement pstmt=null;
				
				String sql="delete from mymall where num=?";
				
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

	
}
