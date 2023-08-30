package com.javassem.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.ReplyVO;

@Repository("replyDAO")
public class ReplyDAOImpl implements ReplyDAO{
	@Autowired
	private SqlSessionTemplate mybatis;

	public Integer insertReply(ReplyVO vo) {
		System.out.println("===> Mybatis insertReply() 호출");	
		return mybatis.insert("ReplyDAO.insertReply", vo);
	}

	public List<ReplyVO> selectAllReply() {
		System.out.println("===> Mybatis selectAllReply() 호출");	
		return mybatis.selectList("ReplyDAO.selectAllReply");
	}

	@Override
	public int deleteReply(String rno) {
		System.out.println("===> Mybatis deleteReply() 호출");	
		return mybatis.delete("ReplyDAO.deleteReply", rno);
	}
}
