package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Client;
import ch.hevs.exception.BankException;

@Stateless
public class BankWrapperBean implements BankWrapper{

	@EJB
	Bank bank;

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void transferAndCreateClient(Account source, Account destination, int amount) throws BankException {
		bank.createClient();
		bank.transfer(source, destination, amount);
	}

	public Client getClientByName(String name){
		return bank.getClientByName(name);
	}

	public List<Client> getClients() {
		return bank.getClients();
	}



}
