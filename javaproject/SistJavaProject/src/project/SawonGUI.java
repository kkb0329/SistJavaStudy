package project;

import javax.swing.*;
import javax.swing.table.*;

import project.SawonMember.PayUtil;

import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;
import java.util.List;

public class SawonGUI extends JFrame {

	JTable table;
	private DefaultTableModel tableModel;
	private SawonController controller;

	// 전역 변수 선언
	private JTextField nameField;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JComboBox<String> buseoComboBox;
	private JTextField payField;
	private String[] departments = { "개발부", "교육부", "디자인부" }; // 부서 배열 전역 변수로 선언

	public SawonGUI() {
		controller = new SawonController(this);
		setTitle("사원 관리");
		setBounds(500, 200, 800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		String[] columnNames = { "번호", "사원이름", "성별", "부서", "급여", "입사일" };
		tableModel = new DefaultTableModel(null, columnNames);
		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		
		Font tableFont = new Font("맑은 고딕", Font.PLAIN, 14);
		table.setFont(tableFont);
		table.setRowHeight(25); // 행 높이 조정

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}


		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50); 
		
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(2).setMaxWidth(50); 
		

		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
		table.setRowSorter(sorter);

		// 정렬 기준 설정
		sorter.setComparator(0, Comparator.comparingInt(o -> (Integer) o)); // 사원번호
		sorter.setComparator(4, Comparator.comparingInt(o -> Integer.parseInt(PayUtil.parsePay((String) o)))); // 급여

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		JPanel buttonPanel = createButtonPanel();
		add(buttonPanel, BorderLayout.SOUTH);
	}

	// 버튼 패널 생성
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		buttonPanel.add(createButton("사원 추가", e -> showInputDialog()));
		buttonPanel.add(createButton("전체 출력", e -> controller.selectAll()));
		buttonPanel.add(createButton("정보 수정", e -> showUpdateDialog()));
		buttonPanel.add(createButton("정보 삭제", e -> controller.deleteMember()));
		buttonPanel.add(createButton("검색", e -> showSearchDialog()));
		buttonPanel.add(createButton("종료", e -> controller.exit()));

		return buttonPanel;
	}

	// 버튼 생성
	private JButton createButton(String text, ActionListener action) {
		JButton button = new JButton(text);
		button.addActionListener(action);
		return button;
	}

	// 사원 리스트를 테이블에 표시
	public void displayMembers(List<SawonMember> members) {
		tableModel.setRowCount(0); // 기존 데이터 초기화
		for (SawonMember member : members) {
			tableModel.addRow(new Object[] { member.getNum(), member.getName(), member.getGender(), member.getBuseo(),
					member.getPay(), member.getHireday() });
		}
	}

	// 메시지 표시
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public void showInputDialog() {
		initializeFields();
		JPanel panel = createInputPanel();

		int result = JOptionPane.showConfirmDialog(this, panel, "사원 추가", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			String gender = getSelectedGender();
			controller.registerMember(nameField.getText(), gender, (String) buseoComboBox.getSelectedItem(),
					payField.getText());
		}
	}

	public void showUpdateDialog() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			showMessage("수정할 사원을 선택하세요.");
			return;
		}

		// 선택된 사원 정보 가져오기
		int num = (Integer) tableModel.getValueAt(selectedRow, 0);
		String name = (String) tableModel.getValueAt(selectedRow, 1);
		String gender = (String) tableModel.getValueAt(selectedRow, 2);
		String buseo = (String) tableModel.getValueAt(selectedRow, 3);
		String pay = (String) tableModel.getValueAt(selectedRow, 4);

		initializeFields();
		nameField.setText(name);
		if (gender.equals("남자")) {
			maleRadioButton.setSelected(true);
		} else if (gender.equals("여자")) {
			femaleRadioButton.setSelected(true);
		}
		buseoComboBox.setSelectedItem(buseo);
		payField.setText(pay);

		JPanel panel = createInputPanel();

		int result = JOptionPane.showConfirmDialog(this, panel, "사원 정보 수정", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			String updatedGender = getSelectedGender();
			controller.updateMember(num, nameField.getText(), updatedGender, (String) buseoComboBox.getSelectedItem(),
					payField.getText());
		}
	}

	// 입력 패널 생성
	private JPanel createInputPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 2));		
		panel.add(new JLabel("이름:"));
		panel.add(nameField);
		panel.add(new JLabel("성별:"));

		// 성별 라디오버튼 추가
		JPanel genderPanel = new JPanel();
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(maleRadioButton);
		genderGroup.add(femaleRadioButton);
		genderPanel.add(maleRadioButton);
		genderPanel.add(femaleRadioButton);
		panel.add(genderPanel);

		panel.add(new JLabel("부서:"));
		panel.add(buseoComboBox);
		panel.add(new JLabel("급여:"));
		panel.add(payField);

		return panel;
	}

	// 입력 필드 초기화
	private void initializeFields() {
		nameField = new JTextField();
		maleRadioButton = new JRadioButton("남자");
		femaleRadioButton = new JRadioButton("여자");
		buseoComboBox = new JComboBox<>(departments);
		payField = new JTextField("1200000"); // 기본값
	}

	// 선택된 성별 반환
	private String getSelectedGender() {
		return maleRadioButton.isSelected() ? "남자" : femaleRadioButton.isSelected() ? "여자" : "";
	}

	public void showSearchDialog() {
		// 검색 UI 다이얼로그 처리
		JTextField searchField = new JTextField();
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(new JLabel("검색:"));
		panel.add(searchField);

		int result = JOptionPane.showConfirmDialog(this, panel, "사원 검색", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			String keyword = searchField.getText();
			controller.searchMember(keyword);
		}
	}
}
