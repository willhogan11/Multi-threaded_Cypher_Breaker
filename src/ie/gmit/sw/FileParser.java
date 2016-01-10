package ie.gmit.sw;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Reads the Key Value pairs from the 4grams.txt into a ConcurrentHashMap
 * @author william
 */
public class FileParser {
	
	// Instance variables
	private Map<String, Double> map = new ConcurrentHashMap<String, Double>();
	private static final String file = "4grams.txt";
	private String line;
	
	/**
	 * This method returns a ConcurrentHashMap that is used to compare values with those from the encrypted text. 
	 * It reads in each key value pair from each row of the 4grams.txt file into the Map
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Double> parse() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		while((line = br.readLine())!= null){
			String[] stuff = line.split(" ");
			map.put(stuff[0], Double.parseDouble(stuff[1]));
		}
		// Test that map was successfully populated with Key value pairs from 4grams.txt 
		// ** UNCOMMENT THE BELOW TO DEBUG **
		// System.out.println(map);
		
		br.close();
		return map;
		
	} // End FileParser
	
} // End class