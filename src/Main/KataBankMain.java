package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import kataBankClasses.Account;

import kataBankClasses.Operation;
import kataBankClasses.Operation.OperationType;

public class KataBankMain {

	public static void main(String Args[]) {

		List<Operation> operations = new ArrayList<>();
		Account account = new Account(100, operations);
		Operation operationDeposit = new Operation(50, LocalDate.now(), OperationType.deposit);

		operationDeposit.deposit(operationDeposit.getAmount(), account);
		operations.add(operationDeposit);
		Operation operationWithdraw = new Operation(30, LocalDate.of(2018, 11, 10), OperationType.withdraw);
		operationWithdraw.withdraw(operationWithdraw.getAmount(), account);
		operations.add(operationWithdraw);
		account.showOperationsHistory(account);

	}

}
