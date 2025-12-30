package courseProject;

public class SavingsAccount extends Account implements AccountInterface {
	String accountNumber;
	String accountType = "savings";
	double serviceFee = .25;
	double interestRate;
	double overdraftFee;
	
	@Override
	public void withdraw(double transactionAmmount) {
		if (this.balance - (transactionAmmount + serviceFee) >= 0) {
			this.balance -= transactionAmmount + serviceFee;
		} else {
			System.out.println("Insufficient funds.");
		}

		this.getBalance();
	}

	@Override
	public void deposit(double transactionAmmount) {
		this.balance += transactionAmmount;
	}

}
