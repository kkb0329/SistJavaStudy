package spring.mvc.dao;

import java.util.List;

import spring.mvc.dto.BoardDto;

public interface BoardDaoInter {
    
	public int getTotalCount();
	public int getMaxNum();
	public void updateRestep(int regroup,int restep);
	public void insertBoard(BoardDto dto);
	public List<BoardDto> getList(int start,int perpage);
	public void updateReadcount(int num);
	public BoardDto getData(int num);
	public void updateBoard(BoardDto dto);
	public void deleteBoard(int num);
	
	//페이징없을때의 전체리스트
	public List<BoardDto> getAllList();
}
