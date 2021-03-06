package ie.gmit.sw;
import java.util.*;
import java.util.concurrent.*;

/**
 * Consumer threads that are responsible for taking results from the Blocking Queue
 * and incrementing a Synchronised counter
 * @author william
 */
public class Consumer {
	
	private BlockingQueue<Resultable> queue; // Make sure you can't read from an empty queue
	private String cypherText;
	private FileParser fileParser;
	private volatile boolean running = true;
	private Result result;
	private int MAX_QUEUE_SIZE;
	private PoisonResult poisonResult; 
	private volatile int counter = 0;
	Object lock = new Object();
	
	
	/**
	 * The Consumer constructor that takes 2 parameters
	 * @param cypherText The actual encrypted plainText values
	 * @throws Exception
	 */
	public Consumer(String cypherText) throws Exception{
		MAX_QUEUE_SIZE = cypherText.length()/2 - 2;
		queue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.cypherText = cypherText;
		consume();
	}


	/**
	 * Method that increments each count completed by each thread. It uses synchronized object locks to 
	 * ensure that correct values are calculated during the process. When the counter reachs the maximum number of the queue, 
	 * a poison onject is inserted into the queue to gracefully stop it
	 * @throws InterruptedException
	 */
	public void increment() throws InterruptedException {
		synchronized (lock) {
			counter++; // Increment the counter
			if(counter == MAX_QUEUE_SIZE){ // If the counter equals the MAX_QUEUE_SIZE...
				queue.put(new PoisonResult("Kill Queue", -1, -1.0)); // Add a poison object to the queue
				shutDown(); // Gracefully shutdown the queue

		    // Tried this way, but couldn't get it to work
			/*	if(result instanceof PoisonResult){
					return;
				}*/
			}
		}
	}
	
	/**
	 * This method gracefully stops the Program
	 */
	public void shutDown(){
		running = false;
		System.out.println("Queue Poisoned Successfully");
		System.exit(0);
	}
	
	/**
	 * This consumer method takes each result off the queue
	 * @throws Exception
	 */
	public void consume() throws Exception{
		fileParser = new FileParser(); // Create a FileParser Object
		
		// Start a load of producers
		Map<String, Double> map = new ConcurrentHashMap<String, Double>();
		map = fileParser.parse(); // Parse the 4grams.txt and populate ConcurrentHashMap with Key value pairs
		
		for (int i = 2; i < cypherText.length()/2; i++) {
			new Thread(new Decryptor(queue, cypherText, i, (ConcurrentHashMap<String, Double>) map)).start();
		}
		
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				while(running){
					try {
						result = (Result) queue.take();		
						result.printResult();	
						increment();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.err.println("Error killing queue");
					}
				} 
			}
		});
		thread1.start(); // Start thread
		thread1.join(); // Main waits for thread to finish
		
	} // End init
} // End class