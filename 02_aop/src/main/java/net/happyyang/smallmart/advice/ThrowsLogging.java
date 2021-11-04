package net.happyyang.smallmart.advice;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsLogging implements ThrowsAdvice{
	public void afterThrowing(Throwable throwalbe){
		System.out.println();
	}
}
