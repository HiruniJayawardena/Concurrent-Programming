package lk.gugsi.cp.pt.week01;

public class BankSimulation {

	public static void main(String[] args) {
		
		BankAccount account = new BankAccount(25000, "ACC0001");
		
		// what I need to create next?
		
		Thread wife = new Thread(() -> {
			
			account.deposit(25000);
			
		}, "Career Minded Wife");
		
		Thread husband = new Thread(() -> {
			
			account.withdraw(25000);
			
		}, "House Based Husband");
		
		Thread manager = new Thread(() -> {
			synchronized (account) {
				double interest = account.getBalance() * 9 / 12 / 30 /100;
				account.deposit(interest);
			}
			
			
		}, "Bank Manager");
		
		wife.start();
		husband.start();
		manager.start();

	}

}

/*
 * public Thread(Runnable target,
              String name)
Allocates a new Thread object. This constructor has the same effect as Thread (null, target, name).
Parameters:
target - the object whose run method is invoked when this thread is started. If null, this thread's run method is invoked.
name - the name of the new thread
*/
