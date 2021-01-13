package aopdemo.aspect;
/*
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;*/
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//@Before("execution(public void updateAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* add*(aopdemo.Account, ..))")
	//@Before("execution(* add*(..))")
	@Before("execution(* aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on Method ");
		
	}
}










