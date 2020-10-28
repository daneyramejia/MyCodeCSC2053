/*
 * @author Daneyra Mejia
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class StopHashMap {

	ArrayList<String> stopList;
	HashMap<String, Integer> stopFreq;
	
	public StopHashMap () {
		instantiateStopList();
	}
	//reads in original file 
	public HashMap getSWordMap(ArrayList<String> fileLines) {
		stopFreq = new HashMap<>();
		for(String line: fileLines) {
			Scanner scan = new Scanner(line);
			while(scan.hasNext()) {
				scan.useDelimiter("[^a-zA-Z']");
				String word = scan.next();
				word=word.toLowerCase();
				word = word.replaceAll("^'+", "");
				word = word.replaceAll("'+$", "");
				
				if(!inStopList(word)) {
					if(stopFreq.containsKey(word)) {
						int num = stopFreq.get(word);
						num++;
						stopFreq.put(word, num);
					}
					else {
						stopFreq.put(word, 1);
					}
				}
				
			}
		}
		return stopFreq;
	}

	//checks if the word is there
	public boolean inStopList(String word) {
		for(String wordStop: stopList) {
			if(word.equals(wordStop)) {
				return true;
			}
		}
		return false;
	}
	
	//reads in file STOP-LIST.TXT
	public void instantiateStopList() {
		String fname = "stop-list.txt";      
		FileReader fin = null;
		stopList = new ArrayList<>();
		
		try {
			fin = new FileReader(fname);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner info = new Scanner(fin);
		info.useDelimiter("[#\\n\\r]");
		
		while(info.hasNext()) {
			String word = info.next();
			word=word.toLowerCase();
			word = word.replaceAll("^'+", "");
			word = word.replaceAll("'+$", "");

			stopList.add(word);
		}
		
	}
	
	
}
