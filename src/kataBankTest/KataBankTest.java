package kataBankTest;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import kataBankClasses.Account;
import kataBankClasses.Operation.OperationType;
import kataBankClasses.Client;
import kataBankClasses.Operation;

public class KataBankTest {
	private Operation operationForDeposit;
	private Operation operationForWithdraw;
	private Account account;
	private Client client;

	@Before
	public void setUp() throws Exception {
		account = new Account(client, 100);
		client = new Client();
		client.setName("Toto");
		operationForDeposit = new Operation( 50,LocalDate.now(), OperationType.deposit);
		operationForWithdraw = new Operation(50,LocalDate.now(), OperationType.withdraw);

	}

	
	@Test
	public void should_deposit_positif_amount() {
		long currentBalance = operationForDeposit.deposit(50, account.getBalance());
		assertEquals(50 + account.getBalance(), currentBalance);
	}

	@Test(expected = IllegalStateException.class)
	public void should_not_deposit_negatif_amount() {
		operationForDeposit.deposit(-50, account.getBalance());

	}
	
	@Test
	public void should_withdraw_positif_amount(){
		long currentBalance = operationForWithdraw.withdraw(50, account.getBalance());
		assertEquals(account.getBalance()-50, currentBalance);
	}
	
	@Test (expected = IllegalStateException.class)
	public void should_not_withdraw_negatif_amount(){
		operationForWithdraw.withdraw(-50, account.getBalance());
	}
	@Test
	public void should_retrieve_positif_amount_less_than_balance(){
		long currentBalance = operationForWithdraw.withdraw(50, account.getBalance());
		assertEquals(account.getBalance()-operationForWithdraw.getAmount(), currentBalance);
		}
	@Test (expected = IllegalStateException.class)
	public void should_not_retrieve_positif_amount_higher_than_balance(){
		operationForWithdraw.withdraw(150, account.getBalance());
	}

}
