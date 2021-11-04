package net.happyyang.smallmart;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import net.happyyang.smallmart.advice.AfterLogging;
import net.happyyang.smallmart.advice.AroundLogging;
import net.happyyang.smallmart.advice.BeforeLogging;
import net.happyyang.smallmart.advice.ThrowsLogging;

public class SmallMartEx {
	public static void main(String[] args) {
		SmallMart mart = new SmallMartImpl();
		
		ProxyFactory factory = new ProxyFactory();
		
		factory.addAdvisor(new DefaultPointcutAdvisor(new StaticMethodMatcherPointcut() {

			@Override
			public boolean matches(Method arg0, Class<?> arg1) {
				// TODO Auto-generated method stub
				return arg0.getName().endsWith("2");
			}
		}, new MethodBeforeAdvice() {
			
			@Override
			public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
				// TODO Auto-generated method stub
				
			}
		}));
		
//		factory.addAdvice(new BeforeLogging());
//		factory.addAdvice(new BeforeLogging());
//		factory.addAdvice(new AfterLogging());
//		factory.addAdvice(new AroundLogging());
//		factory.addAdvice(new ThrowsLogging());
		
		factory.setTarget(mart);
		
		SmallMart proxy = (SmallMart)factory.getProxy();
		
		try {
//			mart.getProduct("커피");
//			mart.getProduct(null);
			proxy.getProduct(null);
//			proxy.getProduct(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
