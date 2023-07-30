package ex04.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;


//XML 기반 POJO방식의 AspectJ를 이용한 AOP 방법
public class LoggingAdvice {
	
	
	
//	Around 방식의 사전/사후 처리 AOP around 방식으로 할떄는 인수는 
//	ProceedingJoinPoint, 리턴 - Object 필수
	public Object around(ProceedingJoinPoint point) throws Throwable{
		String methodName= point.getKind();
		String methodName2 = point.getSignature().getName();
		
		
		System.out.println("[LOG] methodName= "+methodName+",methodName2= "
				+ methodName2+" 호출 되기 전... ");
		
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		
		/// 주관심 실행 코드 ///////////////////
		Object obj = point.proceed();
		//////////////////////////////////
		
		System.out.println("[LOG]"+ methodName2+"호출 완료 되었습니다.");
		System.out.println("[LOG] 실행 시간: "+ sw.getTotalTimeMillis()/1000+" 초");
		
		

		return obj;
		
	}
	
	
}
