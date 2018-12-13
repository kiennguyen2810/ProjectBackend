package fpt.fsoft.group.training.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fsoft.group.training.dao.AccountDao;
import fpt.fsoft.group.training.dao.ProjectDao;
import fpt.fsoft.group.training.model.Account;
import fpt.fsoft.group.training.model.AccountProject;
import fpt.fsoft.group.training.model.Project;
import fpt.fsoft.group.training.service.AccountProjectService;

@Service
public class AccountProjectServiceImpl implements AccountProjectService {
	@Autowired
	ProjectDao projectDao;

	@Autowired
	AccountDao accountDao;

	@Override
	public void handleAccountProject(List<AccountProject> accountProjects) {
		Set<String> projectCodeSets = new HashSet<String>();
		Set<String> accountSets = new HashSet<String>();
		for (AccountProject accountProject : accountProjects) {
			// System.out.println(accountProject.getAccount()+ "   " +
			// accountProject.getProjectCode()+ "   " +
			// accountProject.getSalary());
			projectCodeSets.add(accountProject.getProjectCode()); // set
																	// projectCodes
																	// contain
																	// projectCode
																	// unique
			accountSets.add(accountProject.getAccount());
		}
		for (String projectCode : projectCodeSets) {
			if (!projectDao.checkProjectExist(projectCode)) {
				projectDao.save(new Project(projectCode)); // create all project
															// in
															// database
			}
		}

		// List<String> accountLists = new ArrayList<String>();
		// accountLists.addAll(accountSets); // add all account to list
		// Collections.sort(accountLists);

		// Collections.sort(accountProjects, new Comparator<AccountProject>() {
		// @Override
		// public int compare(AccountProject o1, AccountProject o2) {
		// return o1.getAccount().compareTo(o2.getAccount());
		// }
		// });

		for (String accountString : accountSets) {
			if (accountDao.checkAccountExist(accountString)) {
				Account account = accountDao.getAccount(accountString);
				System.out.println(account.getId() + account.getAccount());
				Set<Project> projects = new HashSet<Project>();
				projects.addAll(account.getProjects());
				
				for (AccountProject accountProject : accountProjects) {
					// System.out.println(accountProject.getAccount()+"  " +
					// accountProject.getSalary());
					if (accountProject.getAccount().equals(accountString)) {
						account.setSalary(accountProject.getSalary());
						projects.add(projectDao
								.getProjectByProjectCode(accountProject
										.getProjectCode()));
					}
				}
				account.setProjects(projects);
//				account.getProjects().addAll(projects);
				accountDao.saveAccount(account);
			} else {
				Account account = new Account();
				Set<Project> projects = new HashSet<Project>();
				for (AccountProject accountProject : accountProjects) {
					// System.out.println(accountProject.getAccount()+"  " +
					// accountProject.getSalary());
					if (accountProject.getAccount().equals(accountString)) {
						account.setAccount(accountProject.getAccount());
						account.setSalary(accountProject.getSalary());
						projects.add(projectDao
								.getProjectByProjectCode(accountProject
										.getProjectCode()));
					}
				}
				account.setProjects(projects);
				accountDao.saveAccount(account);
			}

		}
	}

}
