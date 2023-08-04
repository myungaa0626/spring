package kr.co.mycom.service;

import java.util.HashMap;
import java.util.List;

import kr.co.mycom.model.BoardDTO;

public interface BoardService {
	
	// 쓰기, 리스트, 읽기, 수정, 삭제, 조회수 증가, 글의 개수
	public void insertBoard(BoardDTO dto); // insert
	public List<BoardDTO> getBoardList(HashMap map); // select all
	public BoardDTO getBoard(int num); // selectByNum
	public int getBoardCount(); // 총 게시물 개수

	public BoardDTO getBoardDetail(int num); // 글의 전체 개수
	public int updateHit(int num); // 조회수 증가
		
	public int updateBoard(BoardDTO dto); // 수정
	public int deleteBoard(BoardDTO dto); // 삭제


	public void updateSort(BoardDTO dto);
	public void insertReply(BoardDTO dto);	// 답변 저장
	
	
	
}
