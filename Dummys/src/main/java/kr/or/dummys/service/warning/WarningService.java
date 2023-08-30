package kr.or.dummys.service.warning;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dummys.dao.WarningDao;
import kr.or.dummys.dto.Warning;

@Service
public class WarningService {
	
	//Mybatis 작업
	@Autowired	
	private SqlSession sqlsession;
	
	//신고 리스트
	public List<Warning> listWarning(String warning_type, String pg, String f, String q) {	
		//default 값 설정
		int page = 1;
		String field = "TITLE";
		String query = "%%";
		
		if(pg !=null && ! pg.contentEquals("")) {
			page = Integer.parseInt(pg);
		}
		
		if(f != null && ! f.contentEquals("")) {
			field = f;
		}
		
		if(q !=null && ! q.contentEquals("")) {
			query = q;
		}
		
		List<Warning> warningList = null;
		try {
			WarningDao warningDao = sqlsession.getMapper(WarningDao.class);
			warningList = warningDao.listWarning(warning_type, page, field, query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return warningList;
	}
	
	//신고 받은 회원별 신고 카운트
	public List<Warning> getWarningCnt(){
		List<Warning> getWarningCnt = null;
		try {
			WarningDao warningDao = sqlsession.getMapper(WarningDao.class);
			getWarningCnt =warningDao.getWarningCnt();
		} catch (Exception e) {
			e.getStackTrace();
		}		
		return getWarningCnt;
	}
	
	//정지된 회원 리스트
	public List<String> getBlockUsers(){
		List<String> getBlockUsers = null;
		try {
			WarningDao warningDao = sqlsession.getMapper(WarningDao.class);
			getBlockUsers = warningDao.getBlockUsers();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return getBlockUsers;
	}
	
	
	
	//신고 insert	
	public String reportWarning(Warning warning, Principal principal) {
		int result = 0;
		try {
			WarningDao warningDao = sqlsession.getMapper(WarningDao.class);
			warning.setSend_id(principal.getName());
				
			result = warningDao.reportWarning(warning);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return(result>=1) ? "success":"fail";
	}
	
	//신고 중복 체크
	public String checkWarning(Warning warning, Principal principal) {

		int result = 0;
		try {
			WarningDao warningDao = sqlsession.getMapper(WarningDao.class);
			warning.setSend_id(principal.getName());
			
			result = warningDao.checkWarning(warning);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return (result==0)? "성공" : "실패";
	}

}
