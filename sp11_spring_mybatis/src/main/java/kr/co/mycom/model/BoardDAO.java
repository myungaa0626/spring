package kr.co.mycom.model;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	
	// 쓰기, 리스트, 읽기, 수정, 삭제, 조회수 증가, 글의 개수
	public void insertBoard(BoardDTO dto); // insert
	public List<BoardDTO> getBoardList(HashMap map); // select all
	public BoardDTO getBoard(int num); // selectByNum
	
}
