package board.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.BoardVO;
import config.SqlSessionFactoryBean;
import lombok.extern.java.Log;

public class BoardDAO {

	private SqlSession sqlSession;

	public BoardDAO() {
		sqlSession = SqlSessionFactoryBean.getSqlSessionInstance(); //
	}

	public List<BoardVO> selectAll() {
		return sqlSession.selectList("dao.selectAll");
	}

	public void update(BoardVO vo) {
		sqlSession.update("dao.update", vo);
//		sqlSession.commit();
	}

	public void insert(BoardVO vo) {
		
		sqlSession.insert("dao.insert", vo);

	}

	public void delete(BoardVO vo) {

		sqlSession.delete("dao.delete", vo);

	}

	public void delete2(int seq) {

		sqlSession.delete("dao.delete", seq);

	}
}
