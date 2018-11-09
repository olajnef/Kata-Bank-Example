package kataBankClasses;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Account {
	public Client client;

	public long amount;
	public long balance;

	public enum Operation {
		deposit, withdraw
	}

	public LocalDate date;

	public Account.Operation operationType;

	private static final Logger LOGGER = Logger.getLogger(Account.class.getName());

	/**
	 * @param nameClient
	 * @param amount
	 * @param balance
	 * @param date
	 */
	public Account(Client client, long amount, long balance, LocalDate date, Account.Operation operationType) {
		this.operationType = operationType;
		this.client = new Client();
		this.amount = amount;
		this.balance = balance;
		this.date = date;
	}

	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(long amount) {
		this.amount = amount;
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
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
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

	/**
	 * @return the operationType
	 */
	public Account.Operation getOperationType() {
		return operationType;
	}

	/**
	 * @param operationType
	 *            the operationType to set
	 */
	public void setOperationType(Account.Operation operationType) {
		this.operationType = operationType;
	}

	public long deposit(long amount, long balance) {
		this.amount = amount;
		this.balance = balance;
		if (isDeposit(this.operationType)) {
			if (isPositifDeposit(amount)) {
				balance += amount;
			} else if (isNegatifDeposit(amount)) {

				throw new IllegalStateException("You can't deposit a negative value.You should try again");

			}
		}

		else {
			LOGGER.info("the operation is not a deposit");

		}
		return balance;
	}

	public Boolean isDeposit(Account.Operation operationType) {
		this.operationType = operationType;
		return Operation.deposit.equals(operationType);
	}

	public Boolean isWithDraw(Account.Operation operationType) {
		this.operationType = operationType;
		return Operation.withdraw.equals(operationType);
	}

	public Boolean isPositifDeposit(long amount) {
		return amount > 0;
	}

	public Boolean isNegatifDeposit(long amount) {
		return amount < 0;
	}

}
