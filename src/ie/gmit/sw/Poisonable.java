package ie.gmit.sw;

public interface Poisonable {
	
	/* This Interface Poisonable is purely declarative
	 * The class PoisonResult implements this class and is forced to Inherit all this interface's methods*/
	public abstract String getPoisonPlaintext();
	public abstract void setPoisonPlaintext(String poisonPlaintext);
	public abstract int getPoisonKey();
	public abstract void setPoisonKey(int poisonKey);
	public abstract double getPoisonScore();
	public abstract void setPoisonScore(double poisonScore);
	public abstract boolean isRunning();
}