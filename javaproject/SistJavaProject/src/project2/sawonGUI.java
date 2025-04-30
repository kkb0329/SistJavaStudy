package project2;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

class SawonGUI extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private SawonController controller;

    public SawonGUI() {
        controller = new SawonController(this);
        setupUI();
    }

    private void setupUI() {
        setTitle("사원 관리 시스템");
        setBounds(500, 200, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnNames = {"회원번호", "회원이름", "성별", "부서", "급여", "입사일"};
        tableModel = new DefaultTableModel(null, columnNames);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        buttonPanel.add(createButton("회원가입", e -> controller.addMember()));
        buttonPanel.add(createButton("전체회원출력", e -> controller.loadAllMembers()));
        buttonPanel.add(createButton("회원정보수정", e -> controller.updateMember()));
        buttonPanel.add(createButton("회원삭제", e -> controller.deleteMember()));
        buttonPanel.add(createButton("검색", e -> controller.searchMember()));
        buttonPanel.add(createButton("종료", e -> controller.exitApp()));

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }

    public void displayMembers(List<SawonMember> members) {
        tableModel.setRowCount(0);
        for (SawonMember member : members) {
            tableModel.addRow(new Object[]{member.getNum(), member.getName(), member.getGender(), member.getBuseo(), member.getPay(), member.getHireday()});
        }
    }

    public  SawonMember getMemberInput() {
        JTextField nameField = new JTextField();
        JTextField genderField = new JTextField();
        JTextField buseoField = new JTextField();
        JTextField payField = new JTextField("1200000");

        JPanel panel = createInputPanel(nameField, genderField, buseoField, payField);
        int result = JOptionPane.showConfirmDialog(this, panel, "회원가입", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return new SawonMember(0, nameField.getText(), genderField.getText(), buseoField.getText(), payField.getText(), null);
        }
        return null;
    }

    public SawonMember getUpdatedMember() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            JTextField nameField = new JTextField(table.getValueAt(selectedRow, 1).toString());
            JTextField genderField = new JTextField(table.getValueAt(selectedRow, 2).toString());
            JTextField buseoField = new JTextField(table.getValueAt(selectedRow, 3).toString());
            JTextField payField = new JTextField(table.getValueAt(selectedRow, 4).toString());

            JPanel panel = createInputPanel(nameField, genderField, buseoField, payField);
            int result = JOptionPane.showConfirmDialog(this, panel, "회원정보수정", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                return new SawonMember(Integer.parseInt(table.getValueAt(selectedRow, 0).toString()), nameField.getText(), genderField.getText(), buseoField.getText(), payField.getText(), null);
            }
        }
        return null;
    }

    private JPanel createInputPanel(JTextField... fields) {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        String[] labels = {"이름:", "성별:", "부서:", "급여:"};
        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(fields[i]);
        }
        return panel;
    }

    public int getSelectedMemberId() {
        int selectedRow = table.getSelectedRow();
        return (selectedRow != -1) ? Integer.parseInt(table.getValueAt(selectedRow, 0).toString()) : -1;
    }

    public String getSearchInput() {
        return JOptionPane.showInputDialog(this, "검색할 이름을 입력하세요:");
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
