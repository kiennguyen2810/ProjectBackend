/**
 * 
 */
package fpt.fsoft.group.training.dao;

import java.util.List;
import java.util.Set;

import fpt.fsoft.group.training.model.Account;
import fpt.fsoft.group.training.model.Project;

/**
 * @author DuongBN
 *
 */
public interface ProjectDao {

	void save(Project project);

	Boolean checkProjectExist(String projectCode);
	
	List<Project> SearchProject(String projectCode);

	List<Project> list();

	boolean update(long id, String project_code, Float rate_card, Set<Account> accounts);

	public void delete(long id);

	Project getProjectByProjectCode(String projectCode);

	Project getProjects(Long projectId);
	
	void deleteAllProject();
}
