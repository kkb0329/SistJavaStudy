package day0319;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class DBCrudTest {
	DBConnect db = new DBConnect();
	String sql="";
	public void insert() {
		
		Scanner sc=new Scanner(System.in);
		
		String name,addr;
		
		
		System.out.println("name");
		name=sc.nextLine();
		
		System.out.println("addr");
		addr=sc.nextLine();
		
		
		//sql=" inser into hellow values(seq_test.nextval '"+name+"' , '"+addr+"',+sysdate )";
		sql = "INSERT INTO hello VALUES (seq_test.NEXTVAL, '" + name + "', '" + addr + "', SYSDATE)";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getConnection();
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
	}
	
	public void select() {
		
		
		Connection conn=db.getConnection();
		sql = "SELECT * FROM hello";
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");	
				Date sdate=rs.getDate("sdate");
				System.out.println("번호\t이름\t주소\t\t구입날짜");
				System.out.println("=".repeat(60));
				
				System.out.println(num+ "\t" + name + "\t" + addr +"\t" + sdate+"\t");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,stmt, conn);
		}
	}
	
	
	public void delete() {
		
		Scanner sc=new Scanner(System.in);
		
		int num;
		System.out.println("d num");
		num=Integer.parseInt(sc.nextLine()) ;
		
		sql="DELETE FROM hello WHERE num ="+num;
		
		Connection conn=db.getConnection();
		
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			int a=stmt.executeUpdate(sql);
			
			if (a==0) {
				System.out.println("no data");
			} else {
				System.out.println("삭제 되었습니다.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        db.dbClose(stmt, conn);  // DB 연결 닫기
	    }
		
	}
	
	
	public boolean isData(int num) {
		
		boolean flag=false;
		
		sql="select * from hello where num="+num;
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			if (rs.next()) {
				
				flag= true;
				
			} else {

				flag=false;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
				
		return flag;
	}
	
	
	public void update() {
		Scanner sc=new Scanner(System.in);
		
		String name,addr;
		int num;
		
		
		
		
		System.out.println("번호입력");
		num=Integer.parseInt(sc.nextLine());
		
		
		if (!isData(num)) {
			
			System.out.println("nonodata");
			return;
			
		} 
		
		System.out.println("이름");
		name=sc.nextLine();
		System.out.println("주소");
		addr=sc.nextLine();
		
		
		
		
		String sql = "UPDATE hello SET name='" + name + "', addr='" + addr + "' WHERE num=" + num;



		Connection conn=db.getConnection();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			int a=stmt.executeUpdate(sql);
			
			if (a==0) {
				System.out.println("no data");
			} else {
				System.out.println("sucess");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		DBCrudTest db=new DBCrudTest();
		
		Scanner sc= new Scanner(System.in);
		int n;
		
		while (true) {
			System.out.println("1.i  2.s  3.u  4.d 9.e");
			n=Integer.parseInt(sc.nextLine());
			
			
			if (n==1) {
				db.insert();
			} else if(n==9){
				
				System.out.println("exit");
				break;

			}
			
			 else if(n==2){
					
					db.select();

				}
			
			 else if(n==4){
					
					db.delete();

				}
			
			 else if(n==3){
					
					db.update();

				}
			
		}
		
		
		
		
		
	}

}
