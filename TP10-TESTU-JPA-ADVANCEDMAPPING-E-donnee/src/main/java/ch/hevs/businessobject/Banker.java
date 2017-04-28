package ch.hevs.businessobject;

import javax.persistence.Entity;

@Entity
public class Banker {

	private String email;

	// relations

	// email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// constructors
	public Banker() {
	}
	public Banker(String lastname, String firstname, String email) {
		this.email = email;
	}
}
