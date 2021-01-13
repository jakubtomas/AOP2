package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + " doing stuff doing membership account ");
    }

    public void  goToSleep() {
        System.out.println(getClass() + " I am going to sleep now .. oke z");
    }
}
