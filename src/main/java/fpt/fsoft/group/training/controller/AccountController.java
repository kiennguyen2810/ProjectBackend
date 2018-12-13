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

import fpt.fsoft.group.training.model.Account;
import fpt.fsoft.group.training.service.AccountService;

/**
 * @author DuongBN
 *
 */

@RestController
public class AccountController {

	/**
	 * Inject AccountService
	 */
	@Autowired
	private AccountService accountService;

	/**
	 * Create Account
	 * 
	 * @return
	 */

	@PostMapping("/saveaccount/{account}/{salary:.+}")
	public ResponseEntity<?> save(@PathVariable("account") String account,
			@PathVariable("salary") Float salary,
			@RequestBody List<Long> projectIds) {
		if (!accountService.checkAccountExist(account)) {
			accountService.saveAccount(account, salary, projectIds);
			String result = "Create successfully!";
			return ResponseEntity.ok().body(result);
		} else {
			String result = "Account existed!";
			return ResponseEntity.ok().body(result);
		}
	}

	/**
	 * Get all account
	 * 
	 * @return
	 */
	@GetMapping("/searchaccount")
	public ResponseEntity<List<Account>> getAccount() {
		List<Account> accounts = accountService.findAllAccount();
	
		return ResponseEntity.ok().body(accounts);
	}

	/**
	 * search table Account by account
	 * 
	 * @return
	 */
	@GetMapping("/searchaccount/{account}")
	public ResponseEntity<List<Account>> list(@PathVariable String account) {
		List<Account> accounts = accountService.searchAccount(account);
		return ResponseEntity.ok().body(accounts);
	}

	/**
	 * Update Account
	 * 
	 * @return
	 */
	@PutMapping("/updateaccount/{id}/{account}/{salary:.+}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @PathVariable("account") String account, @PathVariable("salary") Float salary,
			@RequestBody Set<Long> projectIds) {
		
		if(accountService.updateAcount(id, account, salary, projectIds)){
			return ResponseEntity.ok().body("Account has been updated.");
		}
		else{
			return ResponseEntity.ok().body("Account has been used");
		}
		
	}

	/**
	 * Delete Account
	 * 
	 * @return
	 */
	@DeleteMapping("/deleteaccount/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		accountService.deleteAcount(id);
		return ResponseEntity.ok().body("This account has been deleted.");
	}
	
	/**
	 * Delete All Account
	 * 
	 * @return
	 */
	@DeleteMapping("/deleteallaccount")
	public ResponseEntity<?> deleteAll(){
		accountService.deleteAllAcount();
		return ResponseEntity.ok().body("All account deleted.");
	}
	
}
