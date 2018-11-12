package kataBankClasses;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Operation {

	public long amount;

	public LocalDate date;

	public enum OperationType {
		deposit, withdraw
	}

	public Operation.OperationType operationType;
	public Account account;
	

	public Operation(long amount, LocalDate date, OperationType operationType) {
		super();
		this.amount = amount;
		this.date = date;
		this.operationType = operationType;
		
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

	public long deposit(long amount, long balance) {

		if (amount > 0) {
			balance += amount;
		} else if (amount < 0) {

			throw new IllegalStateException("You can't deposit a negative value.You should try again");

		}

		return balance;
	}

	public long withdraw(long amount, long balance) {

		if (isPositifAmount(amount)) {
			if (amount < balance) {
				balance -= amount;
			} else
				throw new IllegalStateException("You have not enough money to retrieve this amount");
		} else if (isNegatifAmount(amount)) {
			throw new IllegalStateException("You can't retrieve a negative value.You should try again");
		}

		return balance;
	}

	public Boolean isPositifAmount(long amount) {
		return amount > 0;
	}

	public Boolean isNegatifAmount(long amount) {
		return amount < 0;
	}

}
