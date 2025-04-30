package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

// Controller
public class SawonController {
    private SawonGUI view;
    private SawonDAO dao;

    public SawonController(SawonGUI view) {
        this.view = view;
        this.dao = new SawonDAO();
    }

    public void addMember() {
        SawonMember member = view.getMemberInput();
        if (member != null) {
            try {
                dao.register(member);
                view.showMessage("사원 등록 성공");
                loadAllMembers();
            } catch (SQLException e) {
                view.showMessage("등록 오류: " + e.getMessage());
            }
        }
    }

    public void updateMember() {
        SawonMember member = view.getUpdatedMember();
        if (member != null) {
            try {
                dao.update(member);
                view.showMessage("사원 정보 수정 성공");
                loadAllMembers();
            } catch (SQLException e) {
                view.showMessage("수정 오류: " + e.getMessage());
            }
        }
    }

    public void deleteMember() {
        int memberId = view.getSelectedMemberId();
        if (memberId != -1) {
            try {
                dao.delete(memberId);
                view.showMessage("사원 삭제 성공");
                loadAllMembers();
            } catch (SQLException e) {
                view.showMessage("삭제 오류: " + e.getMessage());
            }
        }
    }

    public void searchMember() {
        String name = view.getSearchInput();
        if (name != null) {
            try {
                List<SawonMember> members = dao.searchByName(name);
                view.displayMembers(members);
            } catch (SQLException e) {
                view.showMessage("검색 오류: " + e.getMessage());
            }
        }
    }

    public void loadAllMembers() {
        try {
            List<SawonMember> members = dao.selectAll();
            view.displayMembers(members);
        } catch (SQLException e) {
            view.showMessage("조회 오류: " + e.getMessage());
        }
    }

    public void exitApp() {
        System.exit(0);
    }
}