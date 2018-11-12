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
	public long balanceAfterOperation;

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

	/**
	 * @return the operationType
	 */
	public Operation.OperationType getOperationType() {
		return operationType;
	}

	/**
	 * @param operationType
	 *            the operationType to set
	 */
	public void setOperationType(Operation.OperationType operationType) {
		this.operationType = operationType;
	}

	/**
	 * @return the balanceAfterOperation
	 */
	public long getBalanceAfterOperation() {
		return balanceAfterOperation;
	}

	/**
	 * @param balanceAfterOperation
	 *            the balanceAfterOperation to set
	 */
	public void setBalanceAfterOperation(long balanceAfterOperation) {
		this.balanceAfterOperation = balanceAfterOperation;
	}

	public long deposit(long amount, Account account) {

		if (amount > 0) {
			balanceAfterOperation = account.getBalance() + amount;
		} else if (amount < 0) {

			throw new IllegalStateException("You can't deposit a negative value.You should try again");

		}

		return balanceAfterOperation;
	}

	public long withdraw(long amount, Account account) {

		if (amount > 0) {
			if (amount < account.getBalance()) {
				balanceAfterOperation = account.getBalance() - amount;
			} else
				throw new IllegalStateException("You have not enough money to retrieve this amount");
		} else if (amount < 0) {
			throw new IllegalStateException("You can't retrieve a negative value.You should try again");
		}

		return balanceAfterOperation;
	}

}
