package com.kosa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;
import org.springframework.stereotype.Component;

import com.kosa.config.SqlSessionFactoryService;
import com.kosa.model.BoardVO;

@Component
public class BoardDAO {

	private SqlSessionFactory sqlSessionFactory;

	private SqlSession sqlSession = null; // DML 처리 함수를 갖고 있다.

	// selectAll

	public List<BoardVO> selectAll() {
		try {

			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(); // app와 db 연결

			return sqlSession.selectList("dao.selectAll");

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public int insert(BoardVO vo) {

		sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(true);

		try {
			return sqlSession.insert("dao.insert", vo);

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	// detail list
	public BoardVO detailList(int seq) {
		
		
		try {
			
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession();
			BoardVO vo = sqlSession.selectOne("dao.detailList", seq );
			return vo;
			
		} catch (Exception e) {
			
			return null;
		
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();	
			}
		}
	} // end detail
	
	
	// update
	
	public int update(BoardVO vo) {

		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(true);
			int rowcount = sqlSession.update("dao.update",vo);
			return rowcount;
			
		} catch (Exception e) {
			return 0;
			
		}finally {
			if(sqlSession != null) {sqlSession.close();}
			
		}			
	} // end update
	
	// delete
	
	public int delete(int seq) {

		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(true);
			int deleteContent = sqlSession.delete("dao.delete", seq);
			return deleteContent;
			
		} catch (Exception e) {
			return 0;
			
		}finally {
			if(sqlSession != null) {sqlSession.close();}
			
		}			
	} // end delete
	
	// 전체 검색 조회 - 1
	 public List<BoardVO> selectSearchList(Map <String, String> map){
		 try {
		
//			 for(Map.entry<String, String> m: map.entrySet(){
//				 
//				 System.out.println();
				 
				 sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession();
				 return sqlSession.selectList("dao.selectList", map);
				 
		} catch (Exception e) {
			return null;
		
		}finally {
			
			
		}
		  
	 }
	
	// 전체 검색 조회 - 2
	
	 public List<BoardVO> selectSearchList2(Map<String, String> map){
		 try {
				 
				 sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession();
				 return sqlSession.selectList("dao.search2", map); // dao.selectList
				 
		} catch (Exception e) {
			return null;
		
		}finally {
			
			
		}
	 }
}
