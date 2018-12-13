package fpt.fsoft.group.training.dao.Impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fpt.fsoft.group.training.dao.AccountDao;
import fpt.fsoft.group.training.model.Account;
import fpt.fsoft.group.training.model.Project;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

	/**
	 * Inject SessionFactory
	 */
	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * create and save account
	 */
	@Override
	public void saveAccount(Account account) {
		getSession().merge(account);
	}

	/**
	 * search account by account
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Account> searchAccount(String account) {
		StringBuilder queryStb = new StringBuilder("from Account where account like :account ");
		Query query = getSession().createQuery(queryStb.toString());
		query.setParameter("account", "%" + account + "%");
		return query.list();
	}
	
	/**
	 * show all account
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Account> findAllAccount() {
		Query query = getSession().createQuery("from Account order by id desc");
		return query.getResultList();
	}
	
	/**
	 * get Account by account
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Account getAccount(String accountString) {
		Query query = getSession().createQuery("from Account where account = :accountString ");
		query.setParameter("accountString", accountString);
		return (Account) query.getSingleResult();
	}
	
	/**
	 * get account by id
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Account getAccountById(Long accountId) {
		Query query = getSession().createQuery("from Account where id = :accountId");
		query.setParameter("accountId", accountId);
		return (Account) query.getSingleResult();
	}
	
	/**
	 * Modify account
	 */
	@Override
	public boolean updateAccount(long id, String account, float salary, Set<Project> projects) {
		Account account2 = getSession().byId(Account.class).load(id);
		if (account2.getAccount().equals(account)) {
			account2.setSalary(salary);
			account2.setProjects(projects);
			return true;
		} else {
			if (checkAccountExist(account)) {
				return false;
			} else {
				account2.setSalary(salary);
				account2.setAccount(account);
				account2.setProjects(projects);
				return true;
			}
		}
	}

	/**
	 * delete account
	 */
	@Override
	public void deleteAcount(long id) {
		Account account = getSession().byId(Account.class).load(id);
		getSession().delete(account);
	}
	
	/**
	 * delete all account
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void deleteAllAcount() {
		Query query = getSession().createQuery("DELETE FROM Account");
		query.executeUpdate();
	}

	/**
	 * Check account exist
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Boolean checkAccountExist(String accountString) {
		Query query = getSession().createQuery("select count(account) from Account where account = :accountString");
		query.setParameter("accountString", accountString);
		Long result = (Long) query.getSingleResult();
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}
}
