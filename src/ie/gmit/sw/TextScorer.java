package ie.gmit.sw;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Compares each quad gram from the 4grams.txt with the Result returned 
 * from the decryption effort and scores accordingly
 * @author william
 */
public class TextScorer {
	
	private Map<String, Double> map = new ConcurrentHashMap<String, Double>();
	
	public TextScorer(Map<String, Double> map){
		this.map = map;
	}
	
	public double getScore(String text){
		double score = 0f;

		for (int i = 0; i < text.length(); i++){
			if (i + QuadGramMap.GRAM_SIZE <= text.length() -1){
				score += computeLogScore(text.substring(i, i + QuadGramMap.GRAM_SIZE));
			}
		}
		return score;
	}
	
	public double computeLogScore(String quadgram){
		if (map.containsKey(quadgram)){
			double frequency = map.get(quadgram);
			double total = (double) map.size();
			double probability = (double) (frequency/total);
			
			return Math.log10(probability);
		}else{
			return 0f;
		}
	}
}
