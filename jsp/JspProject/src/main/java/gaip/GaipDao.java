package gaip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracle.db.DbConnect;

public class GaipDao {

	DbConnect db=new DbConnect();
	
	//insert
	public void insertGaip(GaipDto dto)
	{
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		
		String sql="insert into gaip values(seq_hello.nextval,?,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getLang());
			pstmt.setString(5, dto.getBirth());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//전체출력
	public Vector<GaipDto> getAllGaips()
	{
		Vector<GaipDto> list=new Vector<GaipDto>();
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from gaip order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				GaipDto dto=new GaipDto();
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setBirth(rs.getString("birth"));
				dto.setHp(rs.getString("hp"));
				dto.setLang(rs.getString("lang"));
				dto.setGaipday(rs.getTimestamp("gaipday"));
				
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
	
	//num에 해당하는 dto반환
	public GaipDto getData(String num)
	{
		GaipDto dto=new GaipDto();
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from gaip where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setBirth(rs.getString("birth"));
				dto.setHp(rs.getString("hp"));
				dto.setLang(rs.getString("lang"));
				dto.setGaipday(rs.getTimestamp("gaipday"));
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
	public void updateGaip(GaipDto dto)
	{
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		
		String sql="update gaip set name=?,age=?,hp=?,lang=?,birth=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//?바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getLang());
			pstmt.setString(5, dto.getBirth());
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
	public void deleteGaip(String num)
	{
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		
		String sql="delete from gaip where num=?";
		
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
