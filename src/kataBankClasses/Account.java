package kataBankClasses;

public class Account {
	public long balance ;
	
	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public long deposit(long amount){
		balance +=amount;
		return balance;
		
	}

}
