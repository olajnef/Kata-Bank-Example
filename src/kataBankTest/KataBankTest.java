package kataBankTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kataBankClasses.Account;

public class KataBankTest {
	private Account account;

	@Before
	public void setUp() throws Exception {
		account = new Account();

	}

	@Test
	public void shouldDepositPositifAmount() {
		long amount = 50;
		account.setBalance(100);
        long balanceAfterDeposit = account.deposit(amount);
		assertEquals(150, balanceAfterDeposit);
	}
	

}
