package lk.gugsi.cp.pt.week01;

public class BankAccount{
	
	private double balance;
	// shared variable 
	// any code that access the balance is critical section
	// you needs to lock any code the access critical section
	// getBalance()
	// withdraw()
	// deposit()
	private String accountNo;
	
	public BankAccount(double balance, String accountNo) {
		super();
		this.balance = balance;
		this.accountNo = accountNo;
	}

	public synchronized double getBalance() { // synchronized method
		return balance;
	}

	public String getAccountNo() {
		return accountNo;
	}
	
	public synchronized void deposit(double amount) {
		if (amount >= 0) {
			balance += amount;
		} else {
			throw new IllegalArgumentException("Amount cannot be negative");
		}
		System.out.println(Thread.currentThread().getName() + " after deposit balance is " + 
		balance);
	}
	
	public synchronized void withdraw(double amount) {
		if (amount > 0 && balance - amount >= 0) {
			balance -= amount;
		} else {
			throw new IllegalArgumentException("Amount cannot be negative or Insufficient funds");
		}
		System.out.println(Thread.currentThread().getName() + " after withdrawal balance is " + 
		balance);
	}
}
