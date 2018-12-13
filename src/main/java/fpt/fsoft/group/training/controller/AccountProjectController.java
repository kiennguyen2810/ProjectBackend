package fpt.fsoft.group.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fpt.fsoft.group.training.model.AccountProject;
import fpt.fsoft.group.training.service.AccountProjectService;

@RestController
public class AccountProjectController {
	@Autowired
	AccountProjectService accountProjectService;
	
	@PostMapping("/accountproject")
	public ResponseEntity<?> handleFormAccount(@RequestBody List<AccountProject> accountProjects) {
//		for (AccountProject accountProject : accountProjects) {
//			System.out.println(accountProject.getAccount()+ "   " + accountProject.getProjectCode()+ "   " + accountProject.getSalary());
//		}
		accountProjectService.handleAccountProject(accountProjects);
		String result = "Save successfully!";
		return ResponseEntity.ok().body(result);
	}
	
}
