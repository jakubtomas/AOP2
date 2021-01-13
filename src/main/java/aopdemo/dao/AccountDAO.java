package aopdemo.dao;

import aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": doing mz db work adding an account ");
	}

	public  boolean doWork() {
		System.out.println(getClass() + " doing my work adding an ccount ");
		return false;
	}
}
