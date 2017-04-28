package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Client;
import ch.hevs.exception.BankException;

@Local
public interface BankWrapper {
	
	public void transferAndCreateClient(Account source, Account destination, int amount) throws
	BankException ;
	
	public Client getClientByName(String name);
	
	public List<Client> getClients();

}
