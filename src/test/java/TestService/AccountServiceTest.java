//package TestService;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import fpt.fsoft.group.training.config.AppConfig;
//import fpt.fsoft.group.training.dao.ProjectDao;
//import fpt.fsoft.group.training.model.Project;
//import fpt.fsoft.group.training.service.AccountService;
//import fpt.fsoft.group.training.service.ProjectService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { AppConfig.class })
//public class AccountServiceTest {
//	@Autowired
//	AccountService accountService;
//	@Autowired
//	ProjectService projectService;
//	@Autowired
//	ProjectDao projectDao;
//
//	// Insert account with 3 fields: Account, Salary and Project_code
//	@Test
//	public void acc01() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//
//	// Insert account that existed in database: account = trangvt, salary =
//	// 20000, project_code = pj01
//	@Test
//	public void acc02() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		List<Project> projects = projectService.SearchProject("pj01");
//		projectIds.add(projects.get(0).getId());
//		accountService.saveAccount(account, salary, projectIds);
//		boolean result;
//		try {
//			accountService.saveAccount(account, salary, projectIds);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//		try {
//			accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		} catch (Exception e) {
//
//		}
//		projectService.delete(projects.get(0).getId());
//	}
//
//	// Insert account that only has Account, Salary and Project_code are null
//	@Test
//	public void acc03() {
//		String account = "trangvt";
//		Float salary = null;
//		List<Long> projectIds = new ArrayList<Long>();
//		accountService.saveAccount(account, salary, projectIds);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//	}
//
//	// Insert account that has Account and Salary, Project_code is null
//	@Test
//	public void acc04() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		accountService.saveAccount(account, salary, projectIds);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//	}
//
//	// Insert account that has Account and Project_code, Salary is null
//	@Test
//	public void acc05() {
//		String account = "trangvt";
//		Float salary = null;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//
//	// Insert account that only has Salary, Account and Project_code are null
//	@Test
//	public void acc06() {
//		String account = null;
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		boolean result;
//		try {
//			accountService.saveAccount(account, salary, projectIds);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertTrue(result);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//	}
//
//	// Insert account that has Salary and Project_code, Account is null
//	@Test
//	public void acc07() {
//		String account = null;
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		try {
//			accountService.saveAccount(account, salary, projectIds);
//		} catch (Exception exception) {
//
//		}
//		assertFalse(accountService.checkAccountExist(account));
//		try {
//			accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		} catch (Exception e) {
//
//		}
//		projectService.delete(project.getId());
//	}
//
//	// Insert account that only has Project_code, Account and Salary are null
//	@Test
//	public void acc08() {
//		String account = null;
//		Float salary = null;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		try {
//			accountService.saveAccount(account, salary, projectIds);
//		} catch (Exception exception) {
//
//		}
//		assertFalse(accountService.checkAccountExist(account));
//		try {
//			accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		} catch (Exception e) {
//
//		}
//		projectService.delete(project.getId());
//	}
//
//	// Account, Salary and Project_code are null
//	@Test
//	public void acc09() {
//		String account = null;
//		Float salary = null;
//		List<Long> projectIds = new ArrayList<Long>();
//		boolean result;
//		try {
//			accountService.saveAccount(account, salary, projectIds);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertTrue(result);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//	}
//
//	// Insert Account with 19 characters, Salary in right format
//	@Test
//	public void acc10() {
//		String account = "trangvt012345678910";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//
//	// Insert Account with 20 characters, Salary in right format
//	@Test
//	public void acc11() {
//		String account = "trangvt0123456789101";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//
//	// Insert Account with 21 characters, Salary in right format
//	@Test
//	public void acc12() {
//		String account = "trangvt01234567891011";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		try {
//			accountService.saveAccount(account, salary, projectIds);
//		} catch (Exception exception) {
//
//		}
//		assertFalse(accountService.checkAccountExist(account));
//		try {
//			accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		} catch (Exception e) {
//
//		}
//		projectService.delete(project.getId());
//	}
//
//	// Insert Salary in other format
//	// public void acc13() {
//	// String account = "trangvt";
//	// Float salary = abcef;
//	// List<Long> projectIds = new ArrayList<Long>();
//	// projectService.save("pj01", 500F, new ArrayList<Long>());
//	// Project project = projectDao.getProjectByProjectCode("pj01");
//	// projectIds.add(project.getId());
//	// accountService.saveAccount(account, salary, projectIds);
//	// accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//	// projectService.delete(project.getId());
//	// }
//
//	// Insert Salary with special characters
//	// public void acc14() {
//	// String account = "trangvt";
//	// Float salary = 12@20/!;
//	// List<Long> projectIds = new ArrayList<Long>();
//	// projectService.save("pj01", 500F, new ArrayList<Long>());
//	// Project project = projectDao.getProjectByProjectCode("pj01");
//	// projectIds.add(project.getId());
//	// accountService.saveAccount(account, salary, projectIds);
//	// accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//	// projectService.delete(project.getId());
//	// }
//
//	// Insert Project_code with 19 characters, Salary in right format
//	@Test
//	public void acc15() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01234567891011121", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01234567891011121");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//
//	// Insert Project_code with 20 characters, Salary in right format
//	@Test
//	public void acc16() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj012345678910111213", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj012345678910111213");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//
//	// Insert Project_code with 21 characters, Salary in right format
//	@Test
//	public void acc17() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		try {
//			projectService.save("pj0123456789101112131", 500F, new ArrayList<Long>());
//			Project project = projectDao.getProjectByProjectCode("pj0123456789101112131");
//			projectIds.add(project.getId());
//			try {
//				accountService.saveAccount(account, salary, projectIds);
//			} catch (Exception exception) {
//
//			}
//			assertFalse(accountService.checkAccountExist(account));
//			try {
//				accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//			} catch (Exception e) {
//
//			}
//			projectService.delete(project.getId());
//		} catch (Exception e) {
//
//		}
//	}
//
//	// Update account successfully: edit 3 fields Account, Salary and
//	// Project_code with existed id
//	@Test
//	public void acc18() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		long id = accountService.getAccountbyAccount(account).getId();
//
//		String account2 = "trangvt14";
//		Float salary2 = 21000f;
//		projectService.save("pj02", 300F, new ArrayList<Long>());
//		Project project2 = projectDao.getProjectByProjectCode("pj02");
//		projectIds.add(project2.getId());
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(projectIds);
//
//		accountService.updateAcount(id, account2, salary2, set);
//		accountService.deleteAcount(id);
//		projectService.delete(project.getId());
//		projectService.delete(project2.getId());
//	}
//
//	// Update account successfully: only edit Account with existed id
//	@Test
//	public void acc19() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		long id = accountService.getAccountbyAccount(account).getId();
//
//		String account2 = "trangvt14";
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(projectIds);
//
//		accountService.updateAcount(id, account2, salary, set);
//		accountService.deleteAcount(id);
//		projectService.delete(project.getId());
//	}
//
//	// Update account successfully: only edit Salary with existed id in right
//	// format
//	@Test
//	public void acc20() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		long id = accountService.getAccountbyAccount(account).getId();
//
//		Float salary2 = 21000f;
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(projectIds);
//
//		accountService.updateAcount(id, account, salary2, set);
//		accountService.deleteAcount(id);
//		projectService.delete(project.getId());
//	}
//
//	// Update account successfully: only edit Project_code with existed id
//	@Test
//	public void acc21() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		long id = accountService.getAccountbyAccount(account).getId();
//
//		projectService.save("pj02", 300F, new ArrayList<Long>());
//		Project project2 = projectDao.getProjectByProjectCode("pj02");
//		projectIds.add(project2.getId());
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(projectIds);
//
//		accountService.updateAcount(id, account, salary, set);
//		accountService.deleteAcount(id);
//		projectService.delete(project.getId());
//		projectService.delete(project2.getId());
//	}
//
//	// Update account unsuccessfully: edit Salary with special characters
//	// public void acc22() {
//	// String account = "trangvt";
//	// Float salary = 20000f;
//	// List<Long> projectIds = new ArrayList<Long>();
//	// projectService.save("pj01", 500F, new ArrayList<Long>());
//	// Project project = projectDao.getProjectByProjectCode("pj01");
//	// projectIds.add(project.getId());
//	// accountService.saveAccount(account, salary, projectIds);
//	// long id = accountService.getAccountbyAccount(account).getId();
//	//
//	// Float salary2 = 21/#00;
//	// Set<Long> set = new HashSet<>();
//	// set.addAll(projectIds);
//	//
//	// accountService.updateAcount(id, account, salary2, set);
//	// accountService.deleteAcount(id);
//	// projectService.delete(project.getId());
//	// }
//
//	// Update account unsuccessfully: 3 fields Account, Salary and Project_code
//	// are null
//	@Test
//	public void acc23() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		long id = accountService.getAccountbyAccount(account).getId();
//
//		String account2 = null;
//		Float salary2 = null;
//		Set<Long> set = new HashSet<Long>();
//		boolean result;
//		try {
//			accountService.updateAcount(id, account2, salary2, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//		try {
//			accountService.deleteAcount(id);
//			projectService.delete(project.getId());
//		} catch (Exception e) {
//
//		}
//	}
//
//	// Update account unsuccessfully: edit 3 fields Account, Salary and
//	// Project_code with an id that does not exist
//	@Test
//	public void acc24() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		long id = 200l;
//
//		String account2 = "trangvt14";
//		Float salary2 = 21000f;
//		projectService.save("pj02", 300F, new ArrayList<Long>());
//		Project project2 = projectDao.getProjectByProjectCode("pj02");
//		projectIds.add(project2.getId());
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(projectIds);
//		boolean result;
//
//		try {
//			accountService.updateAcount(id, account2, salary2, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//		projectService.delete(project2.getId());
//	}
//
//	// Update account unsuccessfully: edit Account with an id that does not
//	// exist
//	@Test
//	public void acc25() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		long id = 200l;
//
//		String account2 = "trangvt14";
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(projectIds);
//		boolean result;
//
//		try {
//			accountService.updateAcount(id, account2, salary, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//
//	// Update account unsuccessfully: edit Salary with an id that does not exist
//	@Test
//	public void acc26() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		long id = 200l;
//
//		Float salary2 = 21000f;
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(projectIds);
//		boolean result;
//
//		try {
//			accountService.updateAcount(id, account, salary2, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//
//	// Update account unsuccessfully: edit Project_code with an id that does not
//	// exist
//	@Test
//	public void acc27() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		long id = 200l;
//
//		projectService.save("pj02", 300F, new ArrayList<Long>());
//		Project project2 = projectDao.getProjectByProjectCode("pj02");
//		projectIds.add(project2.getId());
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(projectIds);
//		boolean result;
//
//		try {
//			accountService.updateAcount(id, account, salary, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//		projectService.delete(project2.getId());
//	}
//
//	// Delete account successfully in database
//	@Test
//	public void acc28() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		accountService.saveAccount(account, salary, projectIds);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//
//	// Delete account unsuccessfully with an id that does not exist
//	@Test
//	public void acc29() {
//		String account = "trangvt";
//		Float salary = 20000f;
//		List<Long> projectIds = new ArrayList<Long>();
//		projectService.save("pj01", 500F, new ArrayList<Long>());
//		Project project = projectDao.getProjectByProjectCode("pj01");
//		projectIds.add(project.getId());
//		long id = 200l;
//
//		accountService.saveAccount(account, salary, projectIds);
//		boolean result;
//		try {
//			accountService.deleteAcount(id);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//		accountService.deleteAcount(accountService.getAccountbyAccount(account).getId());
//		projectService.delete(project.getId());
//	}
//}
