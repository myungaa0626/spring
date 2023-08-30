package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@RestController
public class BoardController {
	


	 @Autowired
	   private BoardService boardService;   
	   
	   
	   /*
	    * BoardMapper.xml에 추가
	    * 
	    <select id="getAllBoardList" resultType="board" >
	      SELECT *
	      FROM rest_BOARD
	      ORDER BY SEQ DESC
	   </select>
	    * 
	    */
	   
	   
	   // selectAll
	   @GetMapping("/board/getBoardList.do")     
	   public List<BoardVO> selectAll(BoardVO vo) {
	      List<BoardVO> list =  boardService.getBoardList(vo);
	      return list;
	   }
	   
	   
	   // insert - PostMapping     board/insertBoard.do
	   @PostMapping("/board/insertBoard.do")    
	   public BoardVO writePage(@RequestBody BoardVO vo) {
	      boardService.insertBoard(vo);
	      return vo;
	   }
	   
	   // delete - DeleteMapping
	   @DeleteMapping(path = "/board/delete.do/{seq}")
	   public void delete(@PathVariable int seq) {
	      BoardVO vo = new BoardVO();
	      vo.setSeq(seq);
	      boardService.deleteBoard(vo);
	   }
	   
//	   , @RequestBody BoardVO vo
	   // update - PutMapping
	   @PutMapping("/board/updateBoard.do/{seq}")
	   public void update(@PathVariable int seq, @RequestBody BoardVO vo){
	      vo.setSeq(seq);
	      boardService.updateBoard(vo);
	   }
	   
}
