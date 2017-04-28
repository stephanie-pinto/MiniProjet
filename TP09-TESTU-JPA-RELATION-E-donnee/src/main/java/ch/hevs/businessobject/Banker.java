package ch.hevs.businessobject;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Banker {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String email;	
	private String lastname;
	private String firstname;

	// add relations
	@ManyToOne(cascade=CascadeType.ALL)
	private Agency agency;

	public Agency getAgency() {
		return agency;
	}
	
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
	// id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	// email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// lastname
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	// firstname
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	// constructors
	public Banker() {
	}
	
	public Banker(String lastname, String firstname, String email) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
	}
}
