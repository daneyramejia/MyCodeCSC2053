/*
 * @author Daneyra Mejia
 */

import java.util.HashMap;
import java.util.Map;

public class topTen {

	//initialize hashmaps
	HashMap<Character, Integer> topLetters = new HashMap<Character, Integer>();
	HashMap<String, Integer> topWords = new HashMap<String, Integer>();
	
	//get top ten letters
	public HashMap topTenLetters(HashMap<Character, Integer> letters) {
			topLetters = new HashMap<Character, Integer>();
			
			for (int i = 0; i < 10; i++) {
				Map.Entry<Character, Integer> maxEntry = null;
				for(Map.Entry<Character, Integer> entry: letters.entrySet()) {
					if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue())>0) {
						maxEntry = entry;
						
					}
				}
				topLetters.put(maxEntry.getKey(), maxEntry.getValue());
				letters.remove(maxEntry.getKey());
			}
			return topLetters;
	}
		
	//get top ten words	
	public HashMap topTenWords(HashMap <String, Integer> words) {
		topWords = new HashMap<String, Integer>();
		
		for (int i = 0; i < 10; i++) {
			Map.Entry<String, Integer> maxEntry = null;
			for(Map.Entry<String, Integer> entry: words.entrySet()) {
				if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue())>0) {
					maxEntry = entry;
					
				}
			}
			topWords.put(maxEntry.getKey(), maxEntry.getValue());
			words.remove(maxEntry.getKey());
		}
		return topWords;
		
	}
	
	
}
