package cs544.exercise16_1.bank.dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cs544.exercise16_1.bank.domain.Account;

public class AccountDAO implements IAccountDAO {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void saveAccount(Account account) {
		System.out.println("From saveAcount " + account);
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		sf.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			sf.getCurrentSession().saveOrUpdate(account);
		}
	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
		return sf.getCurrentSession().get(Account.class, accountnumber);
	}

	public Collection<Account> getAccounts() {
		return sf.getCurrentSession().createQuery("from Account", Account.class).list();
	}

}
