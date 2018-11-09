package kataBankClasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Account {
	public Client client;

	
	public long balance;

	

	
	
	public List<Operation>operations = new ArrayList<>();

	
	
	

	/**
	 * @param nameClient
	 * @param amount
	 * @param balance
	 * @param date
	 */
	public Account(Client client, long balance) {
		//this.operations=operations;
		
		this.client = new Client();
		
		this.balance = balance;
		
	}

	

	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}


	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}





}
