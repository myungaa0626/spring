package kr.co.mycom.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.mycom.model.BoardDAO;
import kr.co.mycom.model.BoardDTO;


@Component		// bean create
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	private SqlSession sqlSession; // has-a
	
	
	@Override
	public void insertBoard(BoardDTO dto) {
		
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		
		BoardService dao = sqlSession.getMapper(BoardService.class);
		
		dao.insertBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList(HashMap map) {

		BoardService dao = sqlSession.getMapper(BoardService.class);
		
		return dao.getBoardList(map);
	}

	@Override
	public int getBoardCount() {
		
		BoardService dao = sqlSession.getMapper(BoardService.class);
		
		return dao.getBoardCount();
	}
	
	
	public BoardDTO getBoardDetail(int num){
		
		BoardService dao = sqlSession.getMapper(BoardService.class);
		
		return dao.getBoardDetail(num);
		
	}
	
	@Override
	public BoardDTO getBoard(int num) {
		System.out.println("getBoard");
		BoardService  dao = sqlSession.getMapper(BoardService.class);
		return dao.getBoard(num);
	}

	@Override
	public int updateHit(int num) { // 조회수 증가
		System.out.println("updateHit");
		BoardService dao = sqlSession.getMapper(BoardService.class);
		return dao.updateHit(num);
	}

	@Override
	public int updateBoard(BoardDTO dto) { // 수정
		BoardService dao = sqlSession.getMapper(BoardService.class);
		return dao.updateBoard(dto);
		
	}

	@Override
	public int deleteBoard(BoardDTO dto) { // 삭제
		BoardService dao = sqlSession.getMapper(BoardService.class);
		return dao.deleteBoard(dto);
		
	}

	@Override
	public void insertReply(BoardDTO dto) {
		BoardService dao = sqlSession.getMapper(BoardService.class);
		dao.updateSort(dto);
		dao.insertReply(dto);
		
	}

	@Override
	public void updateSort(BoardDTO dto) {
		
		System.out.println("updateSort");
		BoardService dao = sqlSession.getMapper(BoardService.class);
		dao.updateSort(dto);
		
		
		
	}


	
	
	
}
