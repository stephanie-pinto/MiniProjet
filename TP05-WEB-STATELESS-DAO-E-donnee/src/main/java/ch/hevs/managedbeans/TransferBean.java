package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bankservice.Bank;
import ch.hevs.bankservice.Bank_;
import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Client;

/**
 * TransferBean.java
 * 
 */

public class TransferBean
{
    private List<Client> clientList;
    private List<String> clientNameList;
    private int transactionAmount;
    private String sourceClientName;
    private String destinationClientName;
    private String transactionResult;
    private Bank bank;

    public List<Client> getClientList() throws Exception {
    	
    	try {
			clientList = bank.getClients();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return clientList;
    }
    
    @PostConstruct
    public void init(){
    	try {
			InitialContext ctx = new InitialContext();
			bank = (Bank) ctx.lookup("java:global/TP05-WEB-STATELESS-DAO-E-0.0.1-SNAPSHOT/BankBean!ch.hevs.bankservice.Bank");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public List<String> getClientNameList() throws Exception {
    	
    	try {
			clientList = bank.getClients();
			clientNameList = new ArrayList<String>();
			for (Client client : clientList) {
				clientNameList.add(client.getLastname());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return clientNameList;
    }
    
    public int getTransactionAmount () {
    	return transactionAmount;
    }
    
    public void setTransactionAmount (final int transactionAmount) {
    	this.transactionAmount=transactionAmount;
    }
    
    public String getSourceClientName () {
    	return sourceClientName;
    }
    
    public void setSourceClientName (final String sourceClientName) {
    	this.sourceClientName=sourceClientName;
    }
    
    public String getDestinationClientName () {
    	return destinationClientName;
    }
    
    public void setDestinationClientName (final String destinationClientName) {
    	this.destinationClientName=destinationClientName;
    }
    
    public String performTransfer() throws NumberFormatException, Exception {
    	
		try {		
			if (!sourceClientName.equals(destinationClientName)) {
	
				// Simple hypothesis: the account debited and credited is 
				// the first of the accounts of an owner
				Account compteSrc = bank.getClientByName(sourceClientName).getAccounts().get(0);
				Account compteDest = bank.getClientByName(destinationClientName).getAccounts().get(0);
	
				// Transfer
				bank.transfer(compteSrc, compteDest, transactionAmount);
				this.transactionResult="Success!";
			} else {
				this.transactionResult="Error: accounts are identical!";
			}
		} catch (NumberFormatException e) {
			this.transactionResult="Wrong number format";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.transactionResult="Exception:" + e.getMessage();
		}
		return "showTransferResult"; //  the String value returned represents the outcome used by the navigation handler to determine what page to display next.
	}
    
    public String getTransactionResult () {
    	return transactionResult;
    }

}