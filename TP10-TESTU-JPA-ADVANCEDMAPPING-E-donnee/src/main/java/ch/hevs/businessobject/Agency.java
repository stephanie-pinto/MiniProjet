package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Agency {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	// relations
	
	// id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	// constructors
	public Agency() {
	}

	// helper methods
	public void addClient(Client c) {
		clients.add(c);
		c.setAgency(this);
	}
	public void addEmployee(Banker b) {
		employees.add(b);
		b.setAgency(this);
	}
}
