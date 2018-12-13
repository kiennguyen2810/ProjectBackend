//package TestService;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import fpt.fsoft.group.training.config.AppConfig;
//import fpt.fsoft.group.training.dao.AccountDao;
//import fpt.fsoft.group.training.model.Account;
//import fpt.fsoft.group.training.service.AccountService;
//import fpt.fsoft.group.training.service.ProjectService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { AppConfig.class })
//public class ProjectServiceTest {
//
//	@Autowired
//	ProjectService projectService;
//	@Autowired
//	AccountService accountService;
//	@Autowired
//	AccountDao accountDao;
//
//	// Insert project with 3 fields: project_code, rate_card, account.
//	@Test
//	public void pj01() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Insert project that existed in database: project_code = "pj01", rate_card
//	// = 21, account = "trangvt".
//	@Test
//	public void pj02() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		boolean result;
//
//		try {
//			projectService.save(project_code, rate_card, accountId);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//
//		long id = projectService.getProjectByProjectCode(project_code).getId();
//		try {
//			projectService.delete(id);
//		} catch (Exception e) {
//
//		}
//
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Insert project that only has project_code, rate_card and account are
//	// null.
//	@Test
//	public void pj03() {
//		String project_code = "pj01";
//		Float rate_card = null;
//		List<Long> accountId = new ArrayList<Long>();
//		projectService.save(project_code, rate_card, accountId);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//	}
//
//	// Insert project that has project_code and rate_card, account is null.
//	@Test
//	public void pj04() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		projectService.save(project_code, rate_card, accountId);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//	}
//
//	// Insert project that has project_code and account, rate_card is null.
//	@Test
//	public void pj05() {
//		String project_code = "pj01";
//		Float rate_card = null;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Insert project that only has rate_card, project_code and account are
//	// null.
//	@Test
//	public void pj06() {
//		String project_code = null;
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		boolean result;
//		try {
//			projectService.save(project_code, rate_card, accountId);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertTrue(result);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//	}
//
//	// Insert project that has rate_card and account, project_code is null.
//	@Test
//	public void pj07() {
//		String project_code = null;
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		try {
//			projectService.save(project_code, rate_card, accountId);
//		} catch (Exception e) {
//		}
//		assertFalse(projectService.checkProjectExist(project_code));
//		try {
//			projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		} catch (Exception e) {
//
//		}
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Insert project that only has account, project_code and rate_card are
//	// null.
//	@Test
//	public void pj08() {
//		String project_code = null;
//		Float rate_card = null;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		try {
//			projectService.save(project_code, rate_card, accountId);
//		} catch (Exception e) {
//		}
//		assertFalse(projectService.checkProjectExist(project_code));
//		try {
//			projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		} catch (Exception e) {
//
//		}
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Project_code, rate_card and account are null.
//	@Test
//	public void pj09() {
//		String project_code = null;
//		Float rate_card = null;
//		List<Long> accountId = new ArrayList<Long>();
//		try {
//			projectService.save(project_code, rate_card, accountId);
//		} catch (Exception e) {
//		}
//		assertFalse(projectService.checkProjectExist(project_code));
//		try {
//			projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		} catch (Exception e) {
//
//		}
//	}
//
//	// Insert project_code with 19 characters, rate_card in right format.
//	@Test
//	public void pj10() {
//		String project_code = "pj01234567891011121";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Insert project_code with 20 characters, rate_card in right format.
//	@Test
//	public void pj11() {
//		String project_code = "pj012345678910111213";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Insert project_code with 21 characters, rate_card in right format.
//	@Test
//	public void pj12() {
//		String project_code = "pj0123456789101112131";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		try {
//			projectService.save(project_code, rate_card, accountId);
//		} catch (Exception e) {
//
//		}
//		assertFalse(projectService.checkProjectExist(project_code));
//		try {
//			projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		} catch (Exception e) {
//
//		}
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Insert rate_card in other format.
//	// public void pj13() {
//	// String project_code = "pj01";
//	// Float rate_card = abcdef;
//	// List<Long> accountId = new ArrayList<Long>();
//	// accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//	// Account account = accountDao.getAccount("trangvt");
//	// accountId.add(account.getId());
//	// projectService.save(project_code, rate_card, accountId);
//	// projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//	// accountService.deleteAcount(account.getId());
//	// }
//
//	// Insert rate_card with special characters.
//	// public void pj14() {
//	// String project_code = "pj01";
//	// Float rate_card = 21%;
//	// List<Long> accountId = new ArrayList<Long>();
//	// accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//	// Account account = accountDao.getAccount("trangvt");
//	// accountId.add(account.getId());
//	// projectService.save(project_code, rate_card, accountId);
//	// projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//	// accountService.deleteAcount(account.getId());
//	// }
//
//	// Insert account with 19 characters, rate_card in right format.
//	@Test
//	public void pj15() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt012345678910", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt012345678910");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Insert account with 20 characters, rate_card in right format.
//	@Test
//	public void pj16() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt0123456789101", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt0123456789101");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Insert account with 21 characters, rate_card in right format.
//	@Test
//	public void pj17() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		try {
//			accountService.saveAccount("trangvt01234567891011", 20000F, new ArrayList<Long>());
//			Account account = accountDao.getAccount("trangvt01234567891011");
//			accountId.add(account.getId());
//			try {
//				projectService.save(project_code, rate_card, accountId);
//			} catch (Exception e) {
//
//			}
//			assertFalse(projectService.checkProjectExist(project_code));
//			try {
//				projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//			} catch (Exception e) {
//
//			}
//		} catch (Exception e) {
//
//		}
//	}
//
//	// Update project successfully: edit 3 fields project_code, rate_card and
//	// account with existed id.
//	@Test
//	public void pj18() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		long id = projectService.getProjectByProjectCode(project_code).getId();
//
//		String project_code2 = "pj02";
//		Float rate_card2 = 25f;
//		accountService.saveAccount("trangvt14", 20000F, new ArrayList<Long>());
//		Account account2 = accountDao.getAccount("trangvt14");
//		accountId.add(account2.getId());
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(accountId);
//
//		projectService.update(id, project_code2, rate_card2, set);
//		projectService.delete(id);
//		accountService.deleteAcount(account.getId());
//		accountService.deleteAcount(account2.getId());
//	}
//
//	// Update project successfully: only edit project_code with existed id.
//	@Test
//	public void pj19() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		long id = projectService.getProjectByProjectCode(project_code).getId();
//
//		String project_code2 = "pj02";
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(accountId);
//
//		projectService.update(id, project_code2, rate_card, set);
//		projectService.delete(id);
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Update project successfully: only edit rate_card with existed id in right
//	// format.
//	@Test
//	public void pj20() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		long id = projectService.getProjectByProjectCode(project_code).getId();
//
//		Float rate_card2 = 25f;
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(accountId);
//
//		projectService.update(id, project_code, rate_card2, set);
//		projectService.delete(id);
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Update project successfully: only edit account with existed id.
//	@Test
//	public void pj21() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		long id = projectService.getProjectByProjectCode(project_code).getId();
//
//		accountService.saveAccount("trangvt14", 20000F, new ArrayList<Long>());
//		Account account2 = accountDao.getAccount("trangvt14");
//		accountId.add(account2.getId());
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(accountId);
//
//		projectService.update(id, project_code, rate_card, set);
//		projectService.delete(id);
//		accountService.deleteAcount(account.getId());
//		accountService.deleteAcount(account2.getId());
//	}
//
//	// Update project unsuccessfully: edit rate_card with special characters.
//	// public void pj22() {
//	// String project_code = "pj01";
//	// Float rate_card = 21%;
//	// List<Long> accountId = new ArrayList<Long>();
//	// accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//	// Account account = accountDao.getAccount("trangvt");
//	// accountId.add(account.getId());
//	// projectService.save(project_code, rate_card, accountId);
//	// long id = projectService.getProjectByProjectCode(project_code).getId();
//	//
//	// Float rate_card2 = 25f;
//	// Set<Long> set = new HashSet<>();
//	// set.addAll(accountId);
//	//
//	// projectService.update(id, project_code, rate_card2, set);
//	// projectService.delete(id);
//	// accountService.deleteAcount(account.getId());
//	// }
//
//	// Update project unsuccessfully: 3 fields project_code, rate_card and
//	// account are null.
//	@Test
//	public void pj23() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		long id = projectService.getProjectByProjectCode(project_code).getId();
//
//		String project_code2 = null;
//		Float rate_card2 = null;
//		Set<Long> set = new HashSet<Long>();
//		boolean result;
//		try {
//			projectService.update(id, project_code2, rate_card2, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//		try {
//			projectService.delete(id);
//			accountService.deleteAcount(account.getId());
//		} catch (Exception e) {
//
//		}
//	}
//
//	// Update project unsuccessfully: edit 3 fields project_code, rate_card and
//	// account with an id that does not exist.
//	@Test
//	public void pj24() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		long id = 200l;
//
//		String project_code2 = "pj02";
//		Float rate_card2 = 25f;
//		accountService.saveAccount("trangvt14", 20000F, new ArrayList<Long>());
//		Account account2 = accountDao.getAccount("trangvt14");
//		accountId.add(account2.getId());
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(accountId);
//		boolean result;
//		try {
//			projectService.update(id, project_code2, rate_card2, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//		accountService.deleteAcount(account2.getId());
//	}
//
//	// Update project unsuccessfully: edit project_code with an id that does not
//	// exist.
//	@Test
//	public void pj25() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		long id = 200l;
//
//		String project_code2 = "pj02";
//		Set<Long> set = new HashSet<Long>();
//		boolean result;
//		try {
//			projectService.update(id, project_code2, rate_card, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Update project unsuccessfully: edit rate_card with an id that does not
//	// exist.
//	@Test
//	public void pj26() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		long id = 200l;
//
//		Float rate_card2 = 25f;
//		Set<Long> set = new HashSet<Long>();
//		boolean result;
//		try {
//			projectService.update(id, project_code, rate_card2, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Update project unsuccessfully: edit account with an id that does not
//	// exist.
//	@Test
//	public void pj27() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		long id = 200l;
//
//		accountService.saveAccount("trangvt14", 20000F, new ArrayList<Long>());
//		Account account2 = accountDao.getAccount("trangvt14");
//		accountId.add(account2.getId());
//		Set<Long> set = new HashSet<Long>();
//		set.addAll(accountId);
//		boolean result;
//		try {
//			projectService.update(id, project_code, rate_card, set);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//		accountService.deleteAcount(account2.getId());
//	}
//
//
//	// Delete project successfully in database.
//	@Test
//	public void pj28() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		projectService.save(project_code, rate_card, accountId);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//
//	// Delete project unsuccessfully with an id that does not exist
//	@Test
//	public void pj29() {
//		String project_code = "pj01";
//		Float rate_card = 21f;
//		List<Long> accountId = new ArrayList<Long>();
//		accountService.saveAccount("trangvt", 20000F, new ArrayList<Long>());
//		Account account = accountDao.getAccount("trangvt");
//		accountId.add(account.getId());
//		long id = 200l;
//		projectService.save(project_code, rate_card, accountId);
//		boolean result;
//		try {
//			projectService.delete(id);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		assertFalse(result);
//		projectService.delete(projectService.getProjectByProjectCode(project_code).getId());
//		accountService.deleteAcount(account.getId());
//	}
//}
