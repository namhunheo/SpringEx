package chapter06;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출 전 : LogginAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전");
		
		Object object = invocation.proceed(); // 주기능
		
		System.out.println("[메서드 호출 후 : logginAdvice");
		System.out.println(invocation.getMethod()+"메서드 호출 후");
		return object;
	}

}
