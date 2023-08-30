package kr.or.dummys.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.dummys.service.admin.AdminService;

@RestController
@RequestMapping("/admin/*")
public class ajaxAdmin {
	
	@Autowired
	private AdminService adminservice;
	
	@PostMapping("/in_user.do")
	public ResponseEntity<Map<String, Object>> inUser(@RequestBody List<String> userid){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			int inuser_result = adminservice.inUser(userid);
			map.put("msg", inuser_result);
			map.put("result", "success");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/out_user.do")
	public ResponseEntity<Map<String, Object>> outUser(@RequestBody List<String> userid){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			int out_result = adminservice.outUser(userid);
			map.put("msg", out_result);
			map.put("result", "success");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/deleteTendinous.do")
	public ResponseEntity<Map<String, Object>> deleteTendinous(@RequestBody List<Integer> tendinous_no){
		Map<String, Object> map = new HashMap<String, Object>();
		int deleteTendinous = 0;
		try {
			for(int num : tendinous_no) {
				deleteTendinous = adminservice.deleteTendinous(num);
			}
			map.put("msg", deleteTendinous);
			map.put("result", "success");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
	}
	
	//정지
	@PostMapping("/blockUser.do")
	public String blockUser(@RequestParam String userid){
		int insertRoleBlock = 0;
		try {
			insertRoleBlock = adminservice.blockUser(userid);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return (insertRoleBlock==1) ? "성공":"실패";
	}
	
	//정지 해제
	@PostMapping("/releaseUser.do")
	public String releaseUser(@RequestParam String userid) {
		int deleteRoleBlock = 0;
		try {
			deleteRoleBlock = adminservice.releaseUser(userid);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return (deleteRoleBlock ==1) ? "성공" : " 실패";
	}
	
	//처리완료
	@PostMapping("/lead.do")
	public ResponseEntity<Map<String, Object>> lead(int tendinous_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		int re = 0;
		try {
			re = adminservice.lead(tendinous_no);
			if(re >= 1) {
				map.put("result", "success");
				map.put("msg", re);
				return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			}else {
				map.put("result", "fail");
				return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
		
	}
}
