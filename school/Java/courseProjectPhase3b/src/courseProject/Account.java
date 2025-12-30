package courseProject;
import java.util.Date;

public abstract class Account {
	double balance;
	Date transactionDate = new Date();


	public Account () {

	}

	public double getBalance() {
		return this.balance;
	}

}
