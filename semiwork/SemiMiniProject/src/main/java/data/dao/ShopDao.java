package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import data.dto.CartDto;
import data.dto.ShopDto;
import mysql.db.DbConnect;

public class ShopDao {

	DbConnect db=new DbConnect();
	
	//insert
	public void insertShop(ShopDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into shop values (null,"
				+ "?,?,?,?,?)";
		conn=db.getConnecton();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getSangpum());
			pstmt.setString(3, dto.getPhoto());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setString(5, dto.getIpgoday());
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//List
	public List<ShopDto> getAllSangpums()
	{
		List<ShopDto> list=new ArrayList<ShopDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from shop order by shopnum desc";
		conn=db.getConnecton();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ShopDto dto=new ShopDto();
				dto.setShopnum(rs.getString("shopnum"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPhoto(rs.getString("photo"));
				dto.setCategory(rs.getString("category"));
				dto.setIpgoday(rs.getString("ipgoday"));
				dto.setPrice(rs.getInt("price"));				
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

	//num ==> dto
	public ShopDto getData(String shopnum)
	{
		ShopDto dto=new ShopDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from shop where shopnum=?";
		conn=db.getConnecton();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, shopnum);
			rs=pstmt.executeQuery();
			if(rs.next())
			{				
				dto.setShopnum(rs.getString("shopnum"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPhoto(rs.getString("photo"));
				dto.setCategory(rs.getString("category"));
				dto.setIpgoday(rs.getString("ipgoday"));
				dto.setPrice(rs.getInt("price"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}

	
	//update
	
	
	//delete
	
	//cart insert
	public void insertCart(CartDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into cart values (null,"
				+ "?,?,?,now())";
		conn=db.getConnecton();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getShopnum());
			pstmt.setString(2, dto.getNum());
			pstmt.setInt(3, dto.getCnt());
			
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//장바구니 출력
	public List<HashMap<String, String>> getCartList(String id)
	{
		String sql="select c.idx,s.sangpum,s.shopnum,s.photo,s.price,c.cnt,c.cartday\r\n"
				+ "from cart c,shop s,member m\r\n"
				+ "where c.shopnum=s.shopnum and c.num=m.num and m.id=?";
		
		List<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
		
		Connection conn=db.getConnecton();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				HashMap<String, String> map=new HashMap<String, String>();
				
				map.put("idx", rs.getString("idx"));
				map.put("sangpum", rs.getString("sangpum"));
				map.put("shopnum", rs.getString("shopnum"));
				map.put("photo", rs.getString("photo"));
				map.put("price", rs.getString("price"));
				map.put("cnt", rs.getString("cnt"));
				map.put("cartday", rs.getString("cartday"));
				
				//list에 추가
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return list;
	}
	
	
	
}
