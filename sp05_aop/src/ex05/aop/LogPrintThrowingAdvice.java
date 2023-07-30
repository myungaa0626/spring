package ex05.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class LogPrintThrowingAdvice implements ThrowsAdvice {
	
	public void afterThrowing(IllegalArgumentException e) {
		
	
		Log log = LogFactory.getLog(this.getClass());
		log.info("[afterThrowing 예외 발생]: "+ e.getMessage());
		
	}
	

}
