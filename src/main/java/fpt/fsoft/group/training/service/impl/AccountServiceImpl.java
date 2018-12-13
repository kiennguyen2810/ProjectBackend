package fpt.fsoft.group.training.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fsoft.group.training.dao.AccountDao;
import fpt.fsoft.group.training.dao.ProjectDao;
import fpt.fsoft.group.training.model.Account;
import fpt.fsoft.group.training.model.Project;
import fpt.fsoft.group.training.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;
	
	@Autowired
	ProjectDao projectDao;

	@Override
	public void saveAccount(String account, Float salary, List<Long> projectIds) {
		Set<Project> projects = new HashSet<Project>();
		for (Long projectId : projectIds) {
			projects.add(projectDao.getProjects(projectId));
		}
		Account account2 = new Account();
		account2.setAccount(account);
		account2.setSalary(salary);
		account2.setProjects(projects);
		accountDao.saveAccount(account2);
	}

	@Override
	public List<Account> searchAccount(String account) {
		return accountDao.searchAccount(account);
	}


	@Override
	public void deleteAcount(long id) {
		accountDao.deleteAcount(id);
	}

	@Override
	public List<Account> findAllAccount() {
		return accountDao.findAllAccount();
	}

	@Override
	public Boolean checkAccountExist(String accountString) {
		return accountDao.checkAccountExist(accountString);
	}

	@Override
	public boolean updateAcount(long id, String account, float salary,
							Set<Long> projectIds) {
		Set<Project> projects = new HashSet<Project>();
		for (Long project : projectIds) {
			projects.add(projectDao.getProjects(project));
		}
		return accountDao.updateAccount(id, account, salary, projects);
	}

	@Override
	public Account getAccountbyAccount(String accountString) {
		return accountDao.getAccount(accountString);
	}

	@Override
	public void deleteAllAcount() {
		accountDao.deleteAllAcount();
	}

}
