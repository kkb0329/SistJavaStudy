package project;

import day0319.DBConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DBCrudTest2Swing {

    DBConnect db = new DBConnect();
    String sql = "";

    private JFrame frame;
    private JTextField nameField;
    private JTextField addrField;
    private JTextArea resultArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DBCrudTest2Swing window = new DBCrudTest2Swing();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public DBCrudTest2Swing() {
        initialize();
    }

    private void initialize() {
        // Create the frame
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Create a panel for input fields and buttons
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(3, 2));

        // Name label and text field
        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel);
        nameField = new JTextField();
        panel.add(nameField);

        // Address label and text field
        JLabel addrLabel = new JLabel("Address:");
        panel.add(addrLabel);
        addrField = new JTextField();
        panel.add(addrField);

        // Buttons for Insert, Select, Delete
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(e -> insert());
        buttonPanel.add(insertButton);

        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(e -> select());
        buttonPanel.add(selectButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> delete());
        buttonPanel.add(deleteButton);

        // Text area to display results
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        frame.getContentPane().add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    private void insert() {
        String name = nameField.getText();
        String addr = addrField.getText();

        sql = "INSERT INTO hellow VALUES (seq_test.NEXTVAL, '" + name + "', '" + addr + "', SYSDATE)";

        try (Connection conn = db.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            resultArea.setText("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private void select() {
        sql = "SELECT * FROM hellow";
        try (Connection conn = db.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            StringBuilder result = new StringBuilder();
            result.append("번호\t이름\t주소\t\t구입날짜\n");
            result.append("=".repeat(60));
            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                String addr = rs.getString("addr");
                Date sdate = rs.getDate("sdate");
                result.append(String.format("%d\t%s\t%s\t%s\n", num, name, addr, sdate));
            }
            resultArea.setText(result.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private void delete() {
        String numStr = JOptionPane.showInputDialog(frame, "Enter num to delete:");
        if (numStr != null && !numStr.trim().isEmpty()) {
            try {
                int num = Integer.parseInt(numStr);
                sql = "DELETE FROM hellow WHERE num = " + num;

                try (Connection conn = db.getConnection(); Statement stmt = conn.createStatement()) {
                    int rowsAffected = stmt.executeUpdate(sql);
                    if (rowsAffected == 0) {
                        resultArea.setText("No data found with num = " + num);
                    } else {
                        resultArea.setText(rowsAffected + " row(s) deleted.");
                    }
                }
            } catch (NumberFormatException e) {
                resultArea.setText("Invalid num entered.");
            } catch (SQLException e) {
                e.printStackTrace();
                resultArea.setText("Error: " + e.getMessage());
            }
        }
    }
}
