package ch.hevs.businessobject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Agency {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	// add relations
	@OneToMany(mappedBy="agency", cascade=CascadeType.ALL)
	private List<Banker> bankers;
	
	@OneToMany(mappedBy="agency", cascade=CascadeType.ALL)
	private List<Client> clients;
	
	@OneToOne
	private Address address;

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	// id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	// constructors
	public Agency() {
		this.bankers = new ArrayList<Banker>();
		this.clients = new ArrayList<Client>();
	}


	public List<Banker> getBankers() {
		return bankers;
	}
	
	public void setBankers(List<Banker> bankers) {
		this.bankers = bankers;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public void addClient(Client c) {
		clients.add(c);
		c.setAgency(this);
	}
	
	public void addBanker(Banker b) {
		bankers.add(b);
		b.setAgency(this);
	}
}
