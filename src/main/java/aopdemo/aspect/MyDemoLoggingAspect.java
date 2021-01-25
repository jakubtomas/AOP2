package aopdemo.aspect;
/*
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;*/
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//@Before("execution(public void updateAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* add*(aopdemo.Account, ..))")
	//@Before("execution(* add*(..))")
	@Pointcut("execution(* aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Pointcut("execution(* aopdemo.dao.*.get*(..))")
	private void getter() {}

	@Pointcut("execution(* aopdemo.dao.*.set*(..))")
	private void setter() {}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}



	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}


	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");
	}

	/*@Before("execution(* aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on Method ");
		
	}*/
}










