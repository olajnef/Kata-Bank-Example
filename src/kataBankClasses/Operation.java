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
	public Account account ;
	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
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
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	private static final Logger LOGGER = Logger.getLogger(Operation.class.getName());
public long deposit(long amount, long balance) {
		
		if (isDeposit(this.operationType)) {
			if (amount>0) {
				balance += amount;
			} else if (amount<0) {

				throw new IllegalStateException("You can't deposit a negative value.You should try again");

			}
		}

		else {
			
			LOGGER.info("the operation is not a deposit");

		}
		return balance;
	}
	
	
	public long withdraw(long amount , long balance){
		
		if(isWithdraw(this.operationType)){
			
		if(isPositifAmount(amount)){
			if(amount<balance){
			balance-=amount;
			}
			else throw new IllegalStateException("You have not enough money to retrieve this amount");
		}
		else if(isNegatifAmount(amount)){
			throw new IllegalStateException("You can't retrieve a negative value.You should try again");
		}
		}
		else LOGGER.info("the operation is not a withdrawal");
		return balance;
	}
	
	

	public Boolean isDeposit(Operation.OperationType operationType) {
		this.operationType = operationType;
		return OperationType.deposit.equals(operationType);
	}

	public Boolean isWithdraw(Operation.OperationType operationType) {
		this.operationType = operationType;
		return OperationType.withdraw.equals(operationType);
	}

	public Boolean isPositifAmount(long amount) {
		return amount > 0;
	}

	public Boolean isNegatifAmount(long amount) {
		return amount < 0;
	}

}

	



