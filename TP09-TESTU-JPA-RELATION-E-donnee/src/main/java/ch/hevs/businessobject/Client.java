package ch.hevs.businessobject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String description;
	private String lastname;
	private String firstname;

	// add relations
	@ManyToOne(cascade=CascadeType.ALL)
	private Agency agency;
	
	@ManyToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<InternalAccount> internalAccounts;
	
	@OneToOne
	private List<ExternalAccount> externalAccounts;
	
	@OneToOne
	private Address addresses;

	public Address getAddress() {
		return addresses;
	}

	public void setAddress(Address addresses) {
		this.addresses = addresses;
	}

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

	// description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Client() {
		this.agency = new Agency();
		this.internalAccounts = new ArrayList<InternalAccount>();
		this.externalAccounts = new ArrayList<ExternalAccount>();		
	}
	
	public Client(String lastname, String firstname, String description) {
		this.description = description;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public void addInternalAccount(InternalAccount c) {
		internalAccounts.add(c);
		c.addOwner(this);
	}
	public void addExternalAccount(ExternalAccount c) {
		externalAccounts.add(c);
	}
}
