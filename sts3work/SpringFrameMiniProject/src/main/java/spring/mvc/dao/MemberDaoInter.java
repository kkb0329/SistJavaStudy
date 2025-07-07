package spring.mvc.dao;

import java.util.List;

import spring.mvc.dto.MemberDto;

public interface MemberDaoInter {

	public int getIdCount(String id);
	public void insertMember(MemberDto dto);
	public List<MemberDto> getAllMembers();
	public int loginCheck(String id,String pass);
	public MemberDto getMember(String num);
	public int passCheck(String num,String pass);
	public void updateMember(MemberDto dto);
	public void deleteMember(String num);
	
}
