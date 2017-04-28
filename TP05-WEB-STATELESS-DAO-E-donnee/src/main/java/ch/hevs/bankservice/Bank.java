package ch.hevs.bankservice;

import java.util.List;
import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Client;
import ch.hevs.dao.AccountDAO;
import ch.hevs.dao.ClientDAO;
import ch.hevs.exception.BankException;

public interface Bank {

	public List<Client> getClients();

	public Client getClientByName(String nom);

	public void storeNewClient(Client c) ;

	public void deleteClient(Client c) ;

	public void modifyClient(Client c) ;

	public void transfer(Account source, Account destination, int amount);

}
