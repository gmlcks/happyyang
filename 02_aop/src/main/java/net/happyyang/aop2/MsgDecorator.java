package net.happyyang.aop2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MsgDecorator implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("전 처리");
		Object obj = arg0.proceed(); //원래 메서드 실행
		System.out.println("후 처리");
		return obj;
	}
}
