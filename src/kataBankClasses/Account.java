package kataBankClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import sun.invoke.empty.Empty;

public class Account {

	public long balance;

	public List<Operation> operations;

	/**
	 * 
	 * @param amount
	 * @param balance
	 * @param date
	 */
	public Account(long balance, List<Operation> operations) {
		this.operations = operations;

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
	 * @return the operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}

	/**
	 * @param operations
	 *            the operations to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public List<Operation> showOperationsHistory(Account account) {

		if (null != operations)
			operations.stream().forEach(x -> {
				System.out.println("OperationsType : " + x.getOperationType() + " | " + "Date : " + x.getDate() + " | "
						+ "Amount : " + x.getAmount() + " | " + "Balance : " + x.getBalanceAfterOperation());
			});

		return operations;

	}

}
