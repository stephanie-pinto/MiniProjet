package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class InternalAccount {
	
	private String number;
	private float saldo;

	// relations
	@OneToMany(cascade=CascadeType.ALL)
	private List<Operation> operations;
	
	@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
	private Account account;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Client> owners;
	

	// number
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	// saldo
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	// constructors
	public InternalAccount() {
	}
	public InternalAccount(String number, String description, float saldo) {
		super(description);
		this.number = number;
		this.saldo = saldo;
	}

	// helper methods
	public void addOwner(Client client) {
		owners.add(client);
	}
	public void addOperation(Operation o) {
		operations.add(o);
	}
}
