package project2;

import java.sql.*;
import java.util.*;

import day0319.DBConnect;

public class SawonDAO {
	private DBConnect db = new DBConnect();

	// 회원 등록
	public void register(SawonMember member) throws SQLException {
		String query = "INSERT INTO sawon (num, name, gender, buseo, pay, hireday) "
				+ "VALUES (seq_sawon.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
		try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getGender());
			pstmt.setString(3, member.getBuseo());
			pstmt.setString(4, member.getPay());
			pstmt.executeUpdate();
		}
	}

	// 모든 회원 조회
	public List<SawonMember> selectAll() throws SQLException {
		String query = "SELECT num, name, gender, buseo, TO_CHAR(pay, 'L999,999,999') pay, hireday FROM sawon ORDER BY num";
		List<SawonMember> members = new ArrayList<>();
		try (Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				members.add(new SawonMember(rs.getInt("num"), rs.getString("name"), rs.getString("gender"),
						rs.getString("buseo"), rs.getString("pay"), rs.getDate("hireday")));
			}
		}
		return members;
	}

	// 회원 정보 수정
	public void update(SawonMember member) throws SQLException {
		String query = "UPDATE sawon SET name = ?, gender = ?, buseo = ?, pay = ? WHERE num = ?";
		try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, member.getName()); // NAME
			pstmt.setString(2, member.getGender()); // GENDER
			pstmt.setString(3, member.getBuseo()); // BUSEO
			pstmt.setString(4, member.getPay()); // PAY는 String으로 처리
			pstmt.setInt(5, member.getNum()); // NUM
			pstmt.executeUpdate();
		}
	}

	// 회원 삭제
	public void delete(int num) throws SQLException {
		String query = "DELETE FROM sawon WHERE num = ?";
		try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}
	}

	// 회원 이름으로 검색
	public List<SawonMember> searchByName(String name) throws SQLException {
		String query = "SELECT num, name, gender, buseo, pay, hireday FROM sawon WHERE name LIKE ? ORDER BY num";
		List<SawonMember> members = new ArrayList<>();
		try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, "%" + name + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					SawonMember member = new SawonMember(rs.getInt("num"), rs.getString("name"), rs.getString("gender"),
							rs.getString("buseo"), rs.getString("pay"),
							rs.getDate("hireday"));
					members.add(member);
				}
			}
		}
		return members;
	}
}
