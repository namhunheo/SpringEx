package chapter06_1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TimerAdvice {

	@Pointcut("execution(public * chapter06_1.aop..*(..))")
	public void timerTarget() {}
	
	@Around("timerTarget()")
	public Object invoke(ProceedingJoinPoint point) throws Throwable{
		// 메서드 실행전
		System.out.println("메서드 실행전");
		long start = System.nanoTime();
		Object obj = point.proceed(); // 주기능
		// 메서드 실행후
		System.out.println("메서드 실행후");
		long end = System.nanoTime();
		System.out.println("소요시간:"+(end-start));
		return obj;
	}
}
