package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Client {

	private String description;

	// relations
	@ManyToMany(cascade=CascadeType.ALL)
	private List<InternalAccount> internalAccounts;
	
	
	
	// description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// constructors
	public Client() {
	}
	public Client(String lastname, String firstname, String description) {
		super(lastname, firstname);
		this.description = description;
	}

	// helper methods
	public void addInternalAccount(InternalAccount c) {
		internalAccounts.add(c);
		c.addOwner(this);
	}
	public void addExternalAccount(ExternalAccount c) {
		externalAccounts.add(c);
	}
}
