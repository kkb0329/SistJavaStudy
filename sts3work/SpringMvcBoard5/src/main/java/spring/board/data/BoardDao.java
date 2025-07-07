package spring.board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//dao를 자동으로 xml에 bean등록
@Repository 
public class BoardDao implements BoardDaoInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("selectCountOfBoard");
	}

	@Override
	public void insertBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfBoard", dto);
	}

	@Override
	public List<BoardDto> getAllDatas() {
		// TODO Auto-generated method stub
		return session.selectList("selectAllOfBoard");
	}

	@Override
	public BoardDto getData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfBoard", num);
	}

	@Override
	public void updateBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfBoard", dto);
	}

	@Override
	public void deleteBoard(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfBoard", num);
	}
	
	
	
	

}
