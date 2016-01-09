package ie.gmit.sw;

public interface Resultable {
	
	/* This Interface Resultable is purely declarative
	 * The class Result implements this class and is forced to Inherit all this interface's methods*/
	public abstract String getPlainText();
	public abstract void setPlainText(String plainText);
	public abstract int getKey();
	public abstract void setKey(int key);
	public abstract double getScore();
	public abstract void setScore(double score);
}