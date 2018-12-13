/**
 * 
 */
package fpt.fsoft.group.training.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fpt.fsoft.group.training.dao.AccountDao;
import fpt.fsoft.group.training.dao.ProjectDao;
import fpt.fsoft.group.training.model.Account;
import fpt.fsoft.group.training.model.Project;
import fpt.fsoft.group.training.service.ProjectService;

/**
 * @author DuongBN
 *
 */
@Service
@Transactional(readOnly = false)
public class ProjectServiceImpl implements ProjectService {

	/**
	 * Inject ProjectDao
	 */
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	AccountDao accountDao;

	@Override
	public void save(String project_code, Float rate_card, List<Long> accountId) {
		Set<Account> accounts = new HashSet<Account>();
		for (Long account : accountId) {
			accounts.add(accountDao.getAccountById(account));
		}
		Project project = new Project();
		project.setProject_code(project_code);
		project.setRate_card(rate_card);
		project.setAccounts(accounts);
		projectDao.save(project);
	}

	@Override
	public List<Project> SearchProject(String project_code) {
		return projectDao.SearchProject(project_code);
	}

	@Override
	public List<Project> list() {
		return projectDao.list();
	}

	@Override
	public boolean update(long id, String project_code, Float rate_card, Set<Long> accountId) {
		Set<Account> accounts = new HashSet<Account>();
		for (Long account : accountId) {
			accounts.add(accountDao.getAccountById(account));
		}
		return projectDao.update(id, project_code, rate_card, accounts);
	}
	
	@Override
	public void delete(long id) {
		projectDao.delete(id);
	}

	@Override
	public Boolean checkProjectExist(String projectCode) {
		return projectDao.checkProjectExist(projectCode);
	}

	@Override
	public Project getProjectByProjectCode(String project_code) {
		return projectDao.getProjectByProjectCode(project_code);
	}

	@Override
	public void deleteAllProject() {
		// TODO Auto-generated method stub
		projectDao.deleteAllProject();
	}

}
