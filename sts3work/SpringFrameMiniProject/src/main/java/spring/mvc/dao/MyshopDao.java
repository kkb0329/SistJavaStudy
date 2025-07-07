package spring.mvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.dto.MyshopDto;

@Repository
public class MyshopDao implements MyshopDaoInter {

	@Autowired
	SqlSession session;
	
	@Override
	public List<MyshopDto> getAllSangpums() {
		// TODO Auto-generated method stub
		return session.selectList("getAllOfMyshop");
	}

}
