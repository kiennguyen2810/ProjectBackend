/**
 * 
 */
package fpt.fsoft.group.training.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fpt.fsoft.group.training.model.Project;
import fpt.fsoft.group.training.service.ProjectService;

/**
 * @author DuongBN
 *
 */

@RestController
public class ProjectController {

	/**
	 * Inject ProjectService
	 */
	@Autowired
	private ProjectService projectService;

	/**
	 * Create project
	 * 
	 * @return
	 */
	@PostMapping("/saveproject/{project_code}/{rate_card:.+}")
	public ResponseEntity<?> save(@PathVariable("project_code") String project_code,
			@PathVariable("rate_card") Float rate_card, @RequestBody List<Long> accountId) {
		if (!projectService.checkProjectExist(project_code)) {
			projectService.save(project_code, rate_card, accountId);
			String result = "Create successfully!";
			return ResponseEntity.ok().body(result);
		} else {
			String result = "Project existed!";
			return ResponseEntity.ok().body(result);
		}
	}

	/**
	 * search all project
	 * 
	 * @return
	 */
	@GetMapping("/searchproject")
	public ResponseEntity<List<Project>> getProject() {
		List<Project> projects = projectService.list();
		return ResponseEntity.ok().body(projects);
	}

	/**
	 * search Project by projectCode
	 * 
	 * @return
	 */
	@GetMapping("/searchproject/{project_code}")
	public ResponseEntity<List<Project>> list(@PathVariable String project_code) {
		List<Project> projects = projectService.SearchProject(project_code);
		return ResponseEntity.ok().body(projects);
	}

	/**
	 * Update Project by id
	 * 
	 * @return
	 */
	@PutMapping("/updateproject/{id}/{project_code}/{rate_card:.+}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @PathVariable("project_code") String project_code,
			@PathVariable("rate_card") Float rate_card, @RequestBody Set<Long> accountId) {
		if (projectService.update(id, project_code, rate_card, accountId)) {
			return ResponseEntity.ok().body("Project has been updated.");
		} else {
			return ResponseEntity.ok().body("Project has been used");
		}
	}

	/**
	 * Delete Project
	 * 
	 * @return
	 */
	@DeleteMapping("/deleteproject/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		projectService.delete(id);
		return ResponseEntity.ok().body("This project has been deleted.");
	}
	
	/**
	 * Delete All Project
	 * 
	 * @return
	 */
	@DeleteMapping("/deleteallproject")
	public ResponseEntity<?> deleteAll(){
		projectService.deleteAllProject();
		return ResponseEntity.ok().body("All project deleted.");
	}

}
