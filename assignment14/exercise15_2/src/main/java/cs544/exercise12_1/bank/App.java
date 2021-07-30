package cs544.exercise12_1.bank;

import java.util.Collection;

import cs544.exercise12_1.bank.domain.Account;
import cs544.exercise12_1.bank.domain.AccountEntry;
import cs544.exercise12_1.bank.domain.Customer;
import cs544.exercise12_1.bank.service.AccountService;
import cs544.exercise12_1.bank.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		AccountService accountService = context.getBean("accountService", AccountService.class);
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdrawEuros(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.depositEuros(4253892, 200);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
	}

}


