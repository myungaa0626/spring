package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.ReplyDAO;
import com.javassem.domain.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl {
	@Autowired
	private ReplyDAO replyDAO;

	public Integer insertReply(ReplyVO vo) {
		return replyDAO.insertReply(vo);
	}
	
	public List<ReplyVO> selectAllReply(){
		return replyDAO.selectAllReply();
	}
	
	public int deleteReply(String rno) {
		return replyDAO.deleteReply(rno);
	}
}
