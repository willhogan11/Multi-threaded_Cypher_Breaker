package ie.gmit.sw;

/**
 * Deals with Poisoning a Blocking Queue, that effectively stops it
 * @author william
 */
public class PoisonResult extends Result implements Poisonable{
	
	private String poisonPlaintext;
	private int poisonKey;
	private double poisonScore;
	private boolean isRunning = true;
	 
	
	/**
	 * Constructor for the Result class, that takes three parameters,
	 * @param poisonPlaintext The Poison plain text used to kill the queue
	 * @param poisonKey The Key associated with it
	 * @param poisonScore The Score Associated with it
	 */
	public PoisonResult(String poisonPlaintext, int poisonKey, double poisonScore) {
		super(poisonPlaintext, poisonKey, poisonScore);
		this.poisonPlaintext = poisonPlaintext;
		this.poisonKey = poisonKey;
		this.poisonScore = poisonScore;
	}
	
	/**
	 * Displays the Result of each Result object
	 */
	public void printPoisonResult(){
		System.out.println("poisonPlainText: " + this.poisonPlaintext);
		System.out.println("poisonKey: " + this.poisonKey);
		System.out.println("poisonScore: " + this.poisonScore);
	}

	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Poisonable#getPoisonPlaintext()
	 */
	@Override
	public String getPoisonPlaintext() {
		return poisonPlaintext;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Poisonable#setPoisonPlaintext(java.lang.String)
	 */
	@Override
	public void setPoisonPlaintext(String poisonPlaintext) {
		this.poisonPlaintext = poisonPlaintext;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Poisonable#getPoisonKey()
	 */
	@Override
	public int getPoisonKey() {
		return poisonKey;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Poisonable#setPoisonKey(int)
	 */
	@Override
	public void setPoisonKey(int poisonKey) {
		this.poisonKey = poisonKey;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Poisonable#getPoisonScore()
	 */
	@Override
	public double getPoisonScore() {
		return poisonScore;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Poisonable#setPoisonScore(double)
	 */
	@Override
	public void setPoisonScore(double poisonScore) {
		this.poisonScore = poisonScore;
	}
	
	public void shutDown(){
		this.isRunning = false;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Poisonable#isRunning()
	 */
	@Override
	public boolean isRunning() {
		return isRunning;
	}

}