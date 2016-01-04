package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Decryptor implements Runnable {

	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	private ConcurrentHashMap<String, Double> map;
	private Result result;
	
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key, ConcurrentHashMap<String, Double> map) {
		super();
		this.map = map;
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;
	}

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
}