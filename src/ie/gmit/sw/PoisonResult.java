package ie.gmit.sw;

public class PoisonResult implements Poisonable{
	
	private String poisonPlaintext = "KillQueue";
	private int poisonKey = -1;
	private double poisonScore = -1.0;
	private boolean isRunning = true;

	
	public PoisonResult(String poisonPlaintext, int poisonKey, double poisonScore) {
		super();
		this.poisonPlaintext = poisonPlaintext;
		this.poisonKey = poisonKey;
		this.poisonScore = poisonScore;
	}
	
	
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