package fpt.fsoft.group.training.service;

import java.util.List;
import java.util.Set;

import fpt.fsoft.group.training.model.Project;

public interface ProjectService {

	void save(String project_code, Float rate_card, List<Long> accountId);

	List<Project> SearchProject(String projectCode);
	
	Project getProjectByProjectCode (String project_code);

	List<Project> list();

	boolean update(long id, String project_code, Float rate_card, Set<Long> accountId);

	public void delete(long id);
	
	Boolean checkProjectExist(String projectCode);
	
	void deleteAllProject();
}
