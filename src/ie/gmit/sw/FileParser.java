package ie.gmit.sw;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* This Class reads the Key Value pairs from the 4grams.txt into a ConcurrentHashMap 
 * where it will be later used to compare the values discovered during the decryption process*/
public class FileParser {
	
	// Instance variables
	private Map<String, Double> map = new ConcurrentHashMap<String, Double>();
	private static final String file = "4grams.txt";
	private String line;
	
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