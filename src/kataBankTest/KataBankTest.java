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
	public void account_operation_type_should_be_deposit_when_we_call_deposit_service(){
		account.setOperationType(Operation.withdraw);
		long currentBalance=account.deposit(account.getAmount(), account.getBalance());
		assertEquals("the operation is not a deposit",currentBalance,account.getBalance());
	}

	@Test
	public void should_deposit_positif_amount() {
	long currentBalance = account.deposit(account.getAmount(),account.getBalance());
	assertEquals(account.getAmount()+account.getBalance(), currentBalance);
	}
	
	@Test
	public void shouldNotDepositNegatifAmount(){
		
	}
	

}
