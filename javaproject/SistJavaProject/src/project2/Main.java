package project2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // DBConnect와 다른 관련 객체들을 초기화
        SawonGUI view = new SawonGUI();
        SawonController controller = new SawonController(view);
        controller.loadAllMembers();
        
        // GUI 창을 보이게 하기
        view.setVisible(true);
    }
}

