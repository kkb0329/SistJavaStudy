package project;

import javax.swing.*;
import day0319.DBConnect;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class MyClubCrudGUI_ver2 extends JFrame {
	private DBConnect db = new DBConnect();
	private JTable table;
	private DefaultTableModel tableModel;

	// SQL 상수
	private static final String INSERT_SQL = "INSERT INTO myclub (cno, cname, caddress, cposition, cph, fee, gaipday) VALUES (seq_club.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
	private static final String SELECT_SQL = "SELECT cno, cname, caddress, cposition, cph, TO_CHAR(fee, 'L999,999,999') fee, gaipday FROM myclub ORDER BY cno";
	private static final String UPDATE_SQL = "UPDATE myclub SET cname = ?, caddress = ?, cposition = ?, cph = ?, fee = ? WHERE cno = ?";
	private static final String DELETE_SQL = "DELETE FROM myclub WHERE cno = ?";
	private static final String SEARCH_SQL = "SELECT cno, cname, caddress, cposition, cph, TO_CHAR(fee, 'L999,999,999') fee, gaipday FROM myclub WHERE cname LIKE ?";

	public MyClubCrudGUI_ver2() {
		setTitle("클럽 회원 관리_2");
		setBounds(500, 200, 800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		String[] columnNames = { "회원번호", "회원이름", "주소", "직급", "전화번호", "회비", "가입일" };
		
		
		// 테이블 모델 설정
		tableModel = new DefaultTableModel(null,columnNames);
		

		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false); 
		
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		JPanel buttonPanel = createButtonPanel();
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // 여백 추가

		// 버튼 추가
		buttonPanel.add(createButton("회원가입", e -> showInputDialog("회원가입")));
		buttonPanel.add(createButton("전체회원출력", e -> select()));
		buttonPanel.add(createButton("회원정보수정", e -> showUpdateDialog()));
		buttonPanel.add(createButton("회원삭제", e -> deleteMember()));
		buttonPanel.add(createButton("검색", e -> showSearchDialog()));
		buttonPanel.add(createButton("종료", e -> exit()));

		return buttonPanel;
	}

	private JButton createButton(String text, ActionListener action) {
		JButton button = new JButton(text);
		button.addActionListener(action);
		return button;
	}

	private void showInputDialog(String action) {
		JTextField cnameField = new JTextField();
		JTextField caddressField = new JTextField();
		JTextField cpositionField = new JTextField();
		JTextField cphField = new JTextField();
		JTextField feeField = new JTextField();

		JPanel panel = createInputPanel(cnameField, caddressField, cpositionField, cphField, feeField);
		int result = JOptionPane.showConfirmDialog(this, panel, action, JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			register(cnameField.getText(), caddressField.getText(), cpositionField.getText(), cphField.getText(),
					feeField.getText());
		}
	}

	private JPanel createInputPanel(JTextField... fields) {
		JPanel panel = new JPanel(new GridLayout(0, 2));
		String[] labels = { "회원이름:", "주소:", "직급:", "전화번호:", "회비:" };
		for (int i = 0; i < labels.length; i++) {
			panel.add(new JLabel(labels[i]));
			panel.add(fields[i]);
		}
		return panel;
	}

	private void showUpdateDialog() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			String cno = tableModel.getValueAt(selectedRow, 0).toString();
			String cname = tableModel.getValueAt(selectedRow, 1).toString();
			String caddress = tableModel.getValueAt(selectedRow, 2).toString();
			String cposition = tableModel.getValueAt(selectedRow, 3).toString();
			String cph = tableModel.getValueAt(selectedRow, 4).toString();
			String fee = tableModel.getValueAt(selectedRow, 5).toString();

			JTextField cnameField = new JTextField(cname);
			JTextField caddressField = new JTextField(caddress);
			JTextField cpositionField = new JTextField(cposition);
			JTextField cphField = new JTextField(cph);
			JTextField feeField = new JTextField(fee);

			JPanel panel = createInputPanel(cnameField, caddressField, cpositionField, cphField, feeField);
			panel.add(new JLabel("회원번호:"));
			panel.add(new JTextField(cno)); // 회원번호는 수정할 수 없게 JTextField 비활성화

			int result = JOptionPane.showConfirmDialog(this, panel, "회원정보수정", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				update(cno, cnameField.getText(), caddressField.getText(), cpositionField.getText(), cphField.getText(),
						feeField.getText());
			}
		} else {
			JOptionPane.showMessageDialog(this, "수정할 회원을 선택하세요.");
		}
	}

	private void deleteMember() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			String cno = tableModel.getValueAt(selectedRow, 0).toString();
			int response = JOptionPane.showConfirmDialog(this, "정말로 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
			if (response == JOptionPane.YES_OPTION) {
				delete(cno);
			}
		} else {
			JOptionPane.showMessageDialog(this, "삭제할 회원을 선택하세요.");
		}
	}

	private void showSearchDialog() {
		JTextField cnameField = new JTextField();
		JPanel panel = new JPanel(new GridLayout(0, 2));
		panel.add(new JLabel("회원이름:"));
		panel.add(cnameField);

		int result = JOptionPane.showConfirmDialog(this, panel, "회원검색", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			search(cnameField.getText());
		}
	}

	private void register(String cname, String caddress, String cposition, String cph, String feeStr) {
		try {
			int fee = Integer.parseInt(feeStr);
			try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
				pstmt.setString(1, cname);
				pstmt.setString(2, caddress);
				pstmt.setString(3, cposition);
				pstmt.setString(4, cph);
				pstmt.setInt(5, fee);

				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, "회원가입 성공");
				select();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "회비는 유효한 숫자여야 합니다.");
		} catch (SQLException e) {
			showErrorDialog(e);
		}
	}

	private void select() {
		try (Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_SQL);
				ResultSet rs = pstmt.executeQuery()) {
			tableModel.setRowCount(0); // 기존 데이터 초기화
			while (rs.next()) {
				int cno = rs.getInt("cno");
				String cname = rs.getString("cname");
				String caddress = rs.getString("caddress");
				String cposition = rs.getString("cposition");
				String cph = rs.getString("cph");
				String fee = rs.getString("fee");
				Date gaipday = rs.getDate("gaipday");

				// 테이블에 데이터 추가
				tableModel.addRow(new Object[] { cno, cname, caddress, cposition, cph, fee, gaipday });
			}
		} catch (SQLException e) {
			showErrorDialog(e);
		}
	}

	private void update(String cno, String cname, String caddress, String cposition, String cph, String feeStr) {
		try {
			feeStr = feeStr.replace("￦", "").replace(",", "").trim(); // "￦"와 쉼표 제거
			int fee = Integer.parseInt(feeStr);
			try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {

				pstmt.setString(1, cname);
				pstmt.setString(2, caddress);
				pstmt.setString(3, cposition);
				pstmt.setString(4, cph);
				pstmt.setInt(5, fee);
				pstmt.setString(6, cno);

				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, "회원 정보 수정 성공");
				select(); // 수정 후, 테이블 데이터 갱신
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "회비는 유효한 숫자여야 합니다.");
		} catch (SQLException e) {
			showErrorDialog(e);
		}
	}
	

	private void delete(String cno) {
		try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL)) {
			pstmt.setString(1, cno);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(this, "회원 삭제 성공");
			select(); // 삭제 후, 테이블 데이터 갱신
		} catch (SQLException e) {
			showErrorDialog(e);
		}
	}

	private void search(String cname) {
		try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SEARCH_SQL)) {
			pstmt.setString(1,"%"+ cname + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
				tableModel.setRowCount(0); // 기존 데이터 초기화
				while (rs.next()) {
					int cno = rs.getInt("cno");
					String cnameResult = rs.getString("cname");
					String caddress = rs.getString("caddress");
					String cposition = rs.getString("cposition");
					String cph = rs.getString("cph");
					String fee = rs.getString("fee");
					Date gaipday = rs.getDate("gaipday");

					// 테이블에 데이터 추가
					tableModel.addRow(new Object[] { cno, cnameResult, caddress, cposition, cph, fee, gaipday });
				}
			}
		} catch (SQLException e) {
			showErrorDialog(e);
		}
	}

	private void showErrorDialog(SQLException e) {
		JOptionPane.showMessageDialog(this, "SQL 오류: " + e.getMessage());
	}

	private void exit() {
		int response = JOptionPane.showConfirmDialog(this, "프로그램을 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MyClubCrudGUI_ver2 gui = new MyClubCrudGUI_ver2();
			gui.setVisible(true); // 화면에 표시
		});
	}

}
