package ie.gmit.sw;

public class Result implements Resultable{
	
	private String plainText;
	private int key;
	private double score;
	private double maxScore;
	
	public Result(String plainText, int key, double score) {
		super();
		this.plainText = plainText;
		this.key = key;
		this.score = score;
	}
	
	public void printResult(){
		System.out.println("PlainText: " + this.plainText);
		System.out.println("Score: " + this.score);
		System.out.println("Key: " + this.key);
		System.out.println("\n");
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#getPlainText()
	 */
	@Override
	public String getPlainText() {
		return plainText;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#setPlainText(java.lang.String)
	 */
	@Override
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#getKey()
	 */
	@Override
	public int getKey() {
		return key;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#setKey(int)
	 */
	@Override
	public void setKey(int key) {
		this.key = key;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#getScore()
	 */
	@Override
	public double getScore() {
		return score;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#setScore(double)
	 */
	@Override
	public void setScore(double score) {
		this.score = score;
	}
	
	public double getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(double maxScore) {
		this.maxScore = maxScore;
	}

	@Override
	public String toString() {
		return "Result [plainText=" + plainText + ", key = " + key + ", score = " + score + "]";
	}
}