package kataBankTest;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import kataBankClasses.Account;
import kataBankClasses.Account.Operation;
import kataBankClasses.Client;

public class KataBankTest {
	private Account account;
	private Client client;

	@Before
	public void setUp() throws Exception {
		client = new Client();
		client.setName("Toto");
		account = new Account(client,50,100,LocalDate.now(),Operation.deposit);

	}

	@Test
	public void shouldDepositPositifAmount() {
	long currentBalance = account.deposit(account.getAmount(),account.getBalance());
	assertEquals(account.getAmount()+account.getBalance(), currentBalance);
	}
	

}
