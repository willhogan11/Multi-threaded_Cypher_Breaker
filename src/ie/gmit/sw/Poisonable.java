package ie.gmit.sw;

/**
 * Interface that contains purely declarative methods 
 * @author william
 */
public interface Poisonable {
	
	public abstract String getPoisonPlaintext();
	public abstract void setPoisonPlaintext(String poisonPlaintext);
	public abstract int getPoisonKey();
	public abstract void setPoisonKey(int poisonKey);
	public abstract double getPoisonScore();
	public abstract void setPoisonScore(double poisonScore);
	public abstract boolean isRunning();
}