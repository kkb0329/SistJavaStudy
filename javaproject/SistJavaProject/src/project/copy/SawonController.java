package project.copy;

import java.awt.GridLayout;
import java.sql.*;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.SawonMember.PayUtil;

public class SawonController {

	private SawonGUI view;
	private SawonDAO dao;

	public SawonController(SawonGUI view) {
		this.view = view;
		this.dao = new SawonDAO();
	}

	// 전체 회원 출력
	public void selectAll() {
		try {
			List<SawonMember> members = dao.selectAll();
			view.displayMembers(members);
		} catch (SQLException e) {
			view.showMessage("회원 조회 실패: " + e.getMessage());
		}
	}

	// 회원 등록
	public void registerMember(String name, String gender, String buseo, String pay) {
		try {
			String parsedPay = PayUtil.parsePay(pay);
			SawonMember member = new SawonMember(0, name, gender, buseo, parsedPay, null);
			dao.register(member);
			view.showMessage("사원 등록 성공");
			selectAll(); // 등록 후 전체 회원을 갱신
		} catch (NumberFormatException e) {
			view.showMessage("급여 형식 오류: " + e.getMessage());
		} catch (SQLException e) {
			view.showMessage("입력 오류: " + e.getMessage());
		}
	}

	public void updateMember(int num, String name, String gender, String buseo, String pay) {
		try {
			String parsedPay = PayUtil.parsePay(pay);
			SawonMember updatedMember = new SawonMember(num, name, gender, buseo, parsedPay, null);
			dao.update(updatedMember);
			view.showMessage("회원 정보 수정 성공");
			selectAll(); // 수정 후 전체 회원을 갱신
		} catch (NumberFormatException e) {
			view.showMessage("급여 형식 오류: " + e.getMessage());
		} catch (SQLException e) {
			view.showMessage("수정 오류: " + e.getMessage());
		}
	}

	// 회원 삭제
	public void deleteMember() {
		try {
			int selectedRow = view.table.getSelectedRow();
			if (selectedRow != -1) {
				int memberId = (int) view.table.getValueAt(selectedRow, 0);
				dao.delete(memberId);
				view.showMessage("회원 삭제 성공");
				selectAll(); // 삭제 후 전체 회원을 갱신
			} else {
				view.showMessage("삭제할 회원을 선택해주세요.");
			}
		} catch (SQLException e) {
			view.showMessage("삭제 오류: " + e.getMessage());
		}
	}

	// 검색

	// 검색 처리
	void searchMember(String keyword) {
		try {
			List<SawonMember> members = dao.searchByName(keyword);
			view.displayMembers(members);
		} catch (SQLException e) {
			view.showMessage("검색 오류: " + e.getMessage());
		}
	}

	// 종료
	public void exit() {
		System.exit(0);
	}
}
