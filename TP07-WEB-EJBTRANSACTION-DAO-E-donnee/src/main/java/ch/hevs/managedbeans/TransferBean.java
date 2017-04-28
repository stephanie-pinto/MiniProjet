package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bankservice.Bank;
import ch.hevs.bankservice.BankWrapper;
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
    private BankWrapper bankWrapper;

    public TransferBean() throws NamingException {
		InitialContext ctx = new InitialContext();
		bankWrapper = (BankWrapper) ctx.lookup("java:global/TP07-WEB-EJBTRANSACTION-DAO-E-0.0.1-SNAPSHOT/BankWrapperBean!ch.hevs.bankservice.BankWrapper");
    }

    public List<Client> getClientList() throws NamingException {
    	
    	try {
			clientList = bankWrapper.getClients();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return clientList;
    }
    
    public List<String> getClientNameList() throws NamingException {
    	
    	try {
			List<Client> clientList = bankWrapper.getClients();
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
				Account compteSrc = bankWrapper.getClientByName(sourceClientName).getAccounts().get(0);
				Account compteDest = bankWrapper.getClientByName(destinationClientName).getAccounts().get(0);
	
				// Transfer and create client
				bankWrapper.transferAndCreateClient(compteSrc, compteDest, transactionAmount);
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