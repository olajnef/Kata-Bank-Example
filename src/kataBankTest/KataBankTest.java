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
	private Operation accountForDeposit;
	private Operation accountForWithdraw;
	private Client client;

	@Before
	public void setUp() throws Exception {
		client = new Client();
		client.setName("Toto");
		accountForDeposit = new Account(client, 100, OperationType.deposit);
		accountForWithdraw = new Account(client,  100, OperationType.withdraw);

	}

	@Test
	public void account_operation_type_should_be_deposit_when_we_call_deposit_service() {

		long currentBalance = accountForDeposit.deposit(50,
				accountForDeposit.getBalance());
		assertEquals(50 + accountForDeposit.getBalance(), currentBalance);
	}
	
	@Test
	public void account_operation_type_should__not_be_withdraw_when_we_call_deposit_service() {

		long currentBalance = accountForWithdraw.deposit(50,
				accountForWithdraw.getBalance());
		assertEquals("the operation is not a deposit", currentBalance, accountForWithdraw.getBalance());
	}

	@Test
	public void should_deposit_positif_amount() {
		long currentBalance = accountForDeposit.deposit(50, accountForDeposit.getBalance());
		assertEquals(50 + accountForDeposit.getBalance(), currentBalance);
	}

	@Test(expected = IllegalStateException.class)
	public void should_not_deposit_negatif_amount() {
		accountForDeposit.deposit(-50, accountForDeposit.getBalance());

	}
	@Test
	public void account_operation_type_should_not_be_deposit_when_we_call_withdraw_service(){
		long currentBalance = accountForDeposit.withdraw(50,
				accountForDeposit.getBalance());
		assertEquals("the operation is not a withdraw", currentBalance, accountForDeposit.getBalance());
	}
	@Test
	public void account_operation_type_should_be_withdraw_when_we_call_deposit_service() {

		long currentBalance = accountForWithdraw.withdraw(50,
				accountForWithdraw.getBalance());
		assertEquals( accountForWithdraw.getBalance()-50 , currentBalance);
	}
	@Test
	public void should_withdraw_positif_amount(){
		long currentBalance = accountForWithdraw.withdraw(50, accountForWithdraw.getBalance());
		assertEquals(accountForWithdraw.getBalance()-50, currentBalance);
	}
	
	@Test (expected = IllegalStateException.class)
	public void should_not_withdraw_negatif_amount(){
		accountForWithdraw.withdraw(-50, accountForWithdraw.getBalance());
	}
	@Test
	public void should_retrieve_positif_amount_less_than_balance(){
		long currentBalance = accountForWithdraw.withdraw(50, accountForWithdraw.getBalance());
		assertEquals(accountForWithdraw.getBalance()-accountForWithdraw.getAmount(), currentBalance);
		}
	@Test (expected = IllegalStateException.class)
	public void should_not_retrieve_positif_amount_higher_than_balance(){
		accountForWithdraw.withdraw(150, 100);
	}

}
