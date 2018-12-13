/**
 * 
 */
package fpt.fsoft.group.training.dao.Impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fpt.fsoft.group.training.dao.ProjectDao;
import fpt.fsoft.group.training.model.Account;
import fpt.fsoft.group.training.model.Project;

/**
 * @author DuongBN
 *
 */

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {

	/**
	 * Inject SessionFactory
	 */
	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * create and save project
	 */
	@Override
	public void save(Project project) {
		getSession().merge(project);
	}

	/**
	 * search project by projectCode
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Project> SearchProject(String project_code) {
		StringBuilder queryStb = new StringBuilder("from Project where project_code like :project_code");
		Query query = getSession().createQuery(queryStb.toString());
		query.setParameter("project_code", "%" + project_code + "%");
		return query.list();
	}

	/**
	 * show all project
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Project> list() {
		Query query = getSession().createQuery("from Project order by id desc");
		return query.getResultList();
	}

	/**
	 * Modify Project
	 */
	@Override
	public boolean update(long id, String project_code, Float rate_card, Set<Account> accounts) {
		Project project = getSession().byId(Project.class).load(id);
		if (project.getProject_code().equals(project_code)) {
			project.setRate_card(rate_card);
			project.setAccounts(accounts);
			return true;
		} else {
			if (checkProjectExist(project_code)) {
				return false;
			} else {
				project.setProject_code(project_code);
				project.setRate_card(rate_card);
				project.setAccounts(accounts);
				return true;
			}
		}
	}

	/**
	 * delete project
	 */
	@Override
	public void delete(long id) {
		Project project = getSession().byId(Project.class).load(id);
		getSession().delete(project);
	}

	/**
	 * get Project by id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Project getProjects(Long projectId) {
		String hql = "from Project where id= :projectId";
		Query<Project> query = getSession().createQuery(hql);
		query.setParameter("projectId", projectId);
		return query.getSingleResult();
	}

	/**
	 * Check project exist
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Boolean checkProjectExist(String projectCode) {
		Query query = getSession()
				.createQuery("select count(project_code) from Project where project_code = :projectCode");
		query.setParameter("projectCode", projectCode);
		Long result = (Long) query.getSingleResult();
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Search project by project_code
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Project getProjectByProjectCode(String projectCode) {
		Query query = getSession().createQuery("from Project where project_code = :projectCode ");
		query.setParameter("projectCode", projectCode);
		return (Project) query.getSingleResult();
	}

	/*8
	 * Delete all project
	 * 
	 * (non-Javadoc)
	 * @see fpt.fsoft.group.training.dao.ProjectDao#deleteAllProject()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void deleteAllProject() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("DELETE FROM Project");
		query.executeUpdate();
	}

}
