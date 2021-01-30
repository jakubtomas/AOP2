package aopdemo.aspect;
/*
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;*/
import aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	//@Before("execution(public void updateAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* add*(aopdemo.Account, ..))")
	//@Before("execution(* add*(..))")


/*
	@Before("aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}
*/



	@AfterReturning(
			pointcut="execution(* aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

		// print out the results of the method call
		System.out.println("\n=====>>> result is: " + result);

		// let's post-process the data ... let's modify it :-)

		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

		System.out.println("\n=====>>> result is: " + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts

		for (Account tempAccount : result) {

			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();

			// update the name on the account
			tempAccount.setName(theUpperName);
		}

	}



	/*@Pointcut("execution(* aopdemo.dao.*.*(..))")
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
*/
	/*@Before("execution(* aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on Method ");
		
	}*/
}










