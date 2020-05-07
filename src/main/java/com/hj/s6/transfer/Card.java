package com.hj.s6.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	@AfterReturning("execution(* com.hj.s6.transfer.Transfer.*())")
	public void cardAfter() {
		System.out.println("----------------------------");
		System.out.println("카드 결제");
	}
	
	
	@Around("execution(* com.hj.s6.transfer.Transfer.*(*,*))")
	public Object cardCheck(ProceedingJoinPoint join) throws Throwable {
		System.out.println("----------------------------");
		System.out.println("카드 check in");
		Object[] ar = join.getArgs();
		for(Object o : ar) {
			System.out.println(o);
		}
		Object obj = join.proceed();
		
		System.out.println("카드 check out");
		
		return obj;
	}
	
	public void taxi() {
		System.out.println("택시 타기");
	}
}
