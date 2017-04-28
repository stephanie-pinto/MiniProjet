package ch.hevs.businessobject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InternalAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String number;	
	private String description;
	private float saldo;

	// add relations
	private List<Client> owners;
	
	private List<Operation> operations;

	// id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	// number
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	// description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	// saldo
	public float getSaldo() {
		return saldo;
	}
	public void setSolde(float saldo) {
		this.saldo = saldo;
	}


	// constructors
	public InternalAccount() {
	
		this.owners = new ArrayList<Client>();
		this.operations = new ArrayList<Operation>();
	}
	
	public InternalAccount(String number, String description, float saldo) {
		this.description = description;
		this.number = number;
		this.saldo = saldo;
	}

	public void addOwner(Client client) {
		owners.add(client);
	}
	public void addOperation(Operation o) {
		operations.add(o);
	}
}
