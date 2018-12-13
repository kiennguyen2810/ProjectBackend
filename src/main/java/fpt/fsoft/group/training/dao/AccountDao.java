package fpt.fsoft.group.training.dao;

import java.util.List;
import java.util.Set;

import fpt.fsoft.group.training.model.Account;
import fpt.fsoft.group.training.model.Project;

/**
 * @author DuongBN
 *
 */
public interface AccountDao {

	void saveAccount(Account account);

	List<Account> searchAccount(String account);

	List<Account> findAllAccount();

	Account getAccount(String accountString);

	Account getAccountById(Long accountId);

	boolean updateAccount(long id, String account, float salary, Set<Project> projectIds);

	void deleteAcount(long id);

	void deleteAllAcount();

	Boolean checkAccountExist(String accountString);
}
