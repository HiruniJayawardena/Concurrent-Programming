package lk.gugsi.cp.pt.week01;

public class MTA {
	
	public static void main(String []args) {
		
		// by default one thread will be created
		// on that thread only the main method will
		// execute 
		// currently executing thread at this point
		// is main thread
		System.out.println(Thread.currentThread().getName());
		
		// Thread() constructor accepts one parameter which is an object
		// of Runnable 
		Thread t1 = new Thread(() -> {
			// this is the body of the thread
			// the LAMDA function
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+" : "+i);
			}
			
		});
		
		Thread t2 = new Thread(() -> {
			// this is the body of the thread
			// the LAMDA function
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+" : "+i);
			}
			
		});
		
		t1.start();
		t2.start();
		
		// you can make any assumptions on order in which the threads are
		// going to execute 
		// if you do so program correctness will go for toss
		// Because thread is designed to execute in Non Deterministic manner 
		
	}

}

/*public Thread(Runnable target)
Allocates a new Thread object. This constructor has the same effect as Thread (null, target, gname), where gname is a newly generated name. Automatically generated names are of the form "Thread-"+n, where n is an integer.
Parameters:
target - the object whose run method is invoked when this thread is started. If null, this classes run method does nothing.
*/