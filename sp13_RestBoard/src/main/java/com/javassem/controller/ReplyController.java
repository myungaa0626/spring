package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyServiceImpl;

@RestController
public class ReplyController {

	@Autowired
	ReplyServiceImpl replyService;
	
	 // selectAll
	   @GetMapping("/reply/getReply.do")
	   public List<ReplyVO> selectAll(){
	      List<ReplyVO> list = replyService.selectAllReply();
	      return list;
	   }
	   
	   // insert
	   @PostMapping("/reply/insertReply.do")
	   public ReplyVO insert(@RequestBody ReplyVO vo) {
	      replyService.insertReply(vo);
	      return vo;
	   }
	   
	   // delete
	   @DeleteMapping("reply/deleteReply.do/{rno}")
	   public void delete(@PathVariable String rno) {
	      replyService.deleteReply(rno);
	   }

	
	
}
