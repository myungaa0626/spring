package kr.or.dummys.ajax;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.dummys.dto.Reply;
import kr.or.dummys.service.reply.ReplyService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/reply/")
@AllArgsConstructor
public class ajaxReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@GetMapping(value="reply.do")	
	public ResponseEntity<List<Reply>> replyFunction(@RequestParam(value="pg", required=false, defaultValue="1") String pg,
			@RequestParam(value="ps", required=false, defaultValue="100") String ps, String board_no){
		List<Reply> replyList= replyService.replyList(pg, ps, board_no);
		
		return new ResponseEntity<List<Reply>>(replyList, HttpStatus.OK);
	}
	
	
	//댓글 달기(insert)
	@PostMapping(value="reply.do")
	  public ResponseEntity<Map<String, Object>> registerReply(String board_no, String reply_content, Principal principal) {
		  
		  Map<String, Object> result = new HashMap<String, Object>();
		  
			try {
				result.put("result",replyService.replyRegister(board_no, reply_content, principal.getName()));
			} catch (Exception e) {
				result.put("result","실패");
				e.printStackTrace();
			}
		  
		  return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	  }
	
	//댓글 삭제(delete)
	@DeleteMapping(value="reply.do")
	public ResponseEntity<Map<String, Object>> deleteReply(@RequestBody int reply_no){
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result.put("result", replyService.replyDelete(reply_no));
		} catch (Exception e) {
			result.put("result", "실패");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	} 
	
	//대댓글 달기(insert)
	@PostMapping(value="reReply.do")
	  public ResponseEntity<Map<String, Object>> registerReReply(int parent_reply_no, String reReply_content, Principal principal) {
		  
		  Map<String, Object> result = new HashMap<String, Object>();
		  
			try {
				Reply reply = replyService.reReplyRegister(parent_reply_no, reReply_content, principal.getName());
				replyService.reReplyInsert(reply);
				result.put("result","성공");
			} catch (Exception e) {
				result.put("result","실패");
				e.printStackTrace();
			}
		  return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	  }
	
	

}
