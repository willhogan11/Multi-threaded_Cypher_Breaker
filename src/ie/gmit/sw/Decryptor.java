package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Responsible for putting result objects onto the BlockingQueue
 * @author william
 */
public class Decryptor implements Runnable {

	// Instance Variables
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	private ConcurrentHashMap<String, Double> map;
	private Result result;
	

	/**
	 * This is the Decryptor Constructor that takes 4 parameters
	 * @param queue The blocking queue that stores each result
	 * @param cypherText The encrypted plaintext
	 * @param key The key associated with it
	 * @param map The map used to compare result with values from the 4grams.txt file
	 */
	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key, ConcurrentHashMap<String, Double> map) {
		super();
		this.map = map;
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;
	}

	/**
	 * This is the producer, each result is put into the BlockingQueue
	 */
	public void run() {
		RailFence railFence = new RailFence();
		String plainText = railFence.decrypt(cypherText, key);
		
		// Get the score
		TextScorer score = new TextScorer(map);
		double scoreNum = score.getScore(plainText);
		
		// Create a result
		result = new Result(plainText, this.key, scoreNum);

		// Put the result onto the BlockingQueue
		try {
			queue.put(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the result
	 * @return result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * Takes the result as a parameter
	 * @param result 
	 */
	public void setResult(Result result) {
		this.result = result;
	}
}