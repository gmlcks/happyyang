package net.happyyang.smallmart.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterLogging implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(arg1.getName() +"::"+arg2[0]+"::사후");
	}
	
}
