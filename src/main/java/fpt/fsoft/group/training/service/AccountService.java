package fpt.fsoft.group.training.service;

import java.util.List;
import java.util.Set;

import fpt.fsoft.group.training.model.Account;

/**
 * @author DuongBN
 *
 */
public interface AccountService {

	void saveAccount(String account, Float salary, List<Long> projectIds);
	
	List<Account> searchAccount(String account);
	
	Account getAccountbyAccount(String accountString);
	
	List<Account> findAllAccount();
	
	boolean updateAcount(long id, String account, float salary, Set<Long> projectIds);
	
	void deleteAcount(long id);
	
	Boolean checkAccountExist(String accountString);

	void deleteAllAcount();
}
