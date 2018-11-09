package kataBankTest;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import kataBankClasses.Account;
import kataBankClasses.Account.Operation;
import kataBankClasses.Client;

public class KataBankTest {
	private Account accountForDeposit;
	private Account accountForWithdraw;
	private Client client;

	@Before
	public void setUp() throws Exception {
		client = new Client();
		client.setName("Toto");
		accountForDeposit = new Account(client, 50, 100, LocalDate.now(), Operation.deposit);
		accountForWithdraw = new Account(client, 50, 100, LocalDate.now(), Operation.withdraw);

	}

	@Test
	public void account_operation_type_should_be_deposit_when_we_call_deposit_service() {

		long currentBalance = accountForDeposit.deposit(accountForDeposit.getAmount(),
				accountForDeposit.getBalance());
		assertEquals(accountForDeposit.getAmount() + accountForDeposit.getBalance(), currentBalance);
	}
	
	@Test
	public void account_operation_type_should__not_be_withdraw_when_we_call_deposit_service() {

		long currentBalance = accountForWithdraw.deposit(accountForWithdraw.getAmount(),
				accountForWithdraw.getBalance());
		assertEquals("the operation is not a deposit", currentBalance, accountForWithdraw.getBalance());
	}

	@Test
	public void should_deposit_positif_amount() {
		long currentBalance = accountForDeposit.deposit(accountForDeposit.getAmount(), accountForDeposit.getBalance());
		assertEquals(accountForDeposit.getAmount() + accountForDeposit.getBalance(), currentBalance);
	}

	@Test(expected = IllegalStateException.class)
	public void should_not_deposit_negatif_amount() {
		accountForDeposit.deposit(-50, accountForDeposit.getBalance());

	}
	@Test
	public void account_operation_type_should_not_be_deposit_when_we_call_withdraw_service(){
		long currentBalance = accountForDeposit.withdraw(accountForDeposit.getAmount(),
				accountForDeposit.getBalance());
		assertEquals("the operation is not a withdraw", currentBalance, accountForDeposit.getBalance());
	}
	@Test
	public void account_operation_type_should_be_withdraw_when_we_call_deposit_service() {

		long currentBalance = accountForWithdraw.withdraw(accountForWithdraw.getAmount(),
				accountForWithdraw.getBalance());
		assertEquals( accountForWithdraw.getBalance()-accountForWithdraw.getAmount() , currentBalance);
	}
	@Test
	public void should_withdraw_positif_amount(){
		long currentBalance = accountForWithdraw.withdraw(accountForWithdraw.getAmount(), accountForWithdraw.getBalance());
		assertEquals(accountForWithdraw.getBalance()-accountForWithdraw.getAmount(), currentBalance);
	}
	
	@Test (expected = IllegalStateException.class)
	public void should_not_withdraw_negatif_amount(){
		accountForWithdraw.withdraw(-50, accountForWithdraw.getBalance());
	}

}
