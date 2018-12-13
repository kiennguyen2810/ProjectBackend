/**
 * 
 */
package fpt.fsoft.group.training.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author DuongBN
 *
 */

@Entity(name = "Project")
public class Project {
	private Long id;

	@Column(unique = true)
	private String project_code;
	private Float rate_card;

	private Set<Account> accounts = new HashSet<Account>();

	public Project() {
		super();
	}

	public Project(String project_code) {
		super();
		this.project_code = project_code;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "project_code", nullable = false, unique = true, length = 20)
	public String getProject_code() {
		return project_code;
	}

	public void setProject_code(String project_code) {
		this.project_code = project_code;
	}

	public Float getRate_card() {
		return rate_card;
	}

	public void setRate_card(Float rate_card) {
		this.rate_card = rate_card;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinTable(name = "Account_Project", joinColumns = @JoinColumn(name = "projectId"), inverseJoinColumns = @JoinColumn(name = "accountId"))
	@JsonIgnoreProperties("projects")
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}