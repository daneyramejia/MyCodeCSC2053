/*
 * @author Daneyra Mejia
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * for project, keep a letter frequency count, then print out the top 10 letters and number of appearance
 * keep a word frequency count, then print out the top 10 words and the number of appearance
 * keep a word frequency count with StopList (eliminate the words on list), then print out the top 10 words and number of appearance
 * wild card?? come up w/ interesting question and find answer (have no clue)
 * 
 */
public class Project1 {
	
	//CREATE HASHMAPS
	static HashMap<Character, Integer> letterFreq = new HashMap<Character, Integer>();
	static HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();
	static HashMap<String, Integer> wildcard = new HashMap<String, Integer>();
	
	//for letter frequency
	public static HashMap letters (ArrayList<String> fileLines) {
		//scanner input for this section (given code)
		for(String line: fileLines) {
			Scanner scan = new Scanner(line);
			while(scan.hasNext()) {
				scan.useDelimiter("[^a-zA-Z']");
				String word = scan.next();
				word=word.toLowerCase();
				word = word.replaceAll("^'+", "");
				word = word.replaceAll("'+$", "");
			
				//actual code
				for (int i = 0; i < word.length(); i++) {
					char letter = word.charAt(i);
						if (letter != ' ' || letter != '"') {
								if (letterFreq.containsKey(letter)) {
									int num = letterFreq.get(letter);
									num++;
									letterFreq.put(letter, num);
								}else {
									letterFreq.put(letter, 1);
								}
						}
					}
				}
			
			}
		return letterFreq;
	}
	
	//for word frequency
	public static HashMap words (ArrayList<String> fileLines) {
		//scanner
		for(String line: fileLines) {
			Scanner scan = new Scanner(line);
			while(scan.hasNext()) {
			scan.useDelimiter("[^a-zA-Z']");
			String word = scan.next();
			word=word.toLowerCase();
			word = word.replaceAll("^'+", "");
			word = word.replaceAll("'+$", "");
			
			//code
			if (!word.equals("")) {
				if(wordFreq.containsKey(word)) {
					int num = wordFreq.get(word);
					num++;
					wordFreq.put(word, num);
				}else {
					wordFreq.put(word, 1);
				}
			}
		}
	}
	return wordFreq;
	}
	
	//for own
	public static HashMap WildCard (ArrayList<String> fileLines) {
		for(String line: fileLines) {
			Scanner scan = new Scanner(line);
			while(scan.hasNext()) {
			scan.useDelimiter("[^a-zA-Z']");
			String word = scan.next();
			word=word.toLowerCase();
			word = word.replaceAll("^'+", "");
			word = word.replaceAll("'+$", "");
			
			if (word.equals("river")) {
				if(wildcard.containsKey(word)) {
					int num = wildcard.get(word);
					num++;
					wildcard.put(word, num);
				}else {
					wildcard.put(word, 1);
				}
				}
			}	
		}
		return wildcard;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		//FILE READER
		ArrayList<String> lines = new ArrayList<String>();
		
		String fname = "tom-sawyer.txt";
		FileReader fin = null;
		
		try {
			fin = new FileReader(fname);
		}catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		}
		Scanner text = new Scanner(fin);
		
		while (text.hasNext()) {
			lines.add(text.nextLine());
		}
		
		//testing character count 
		//calling topTen class
		topTen ten = new topTen();
		
		//assigning Maps to arrays and then getting top ten
		
		letterFreq = letters(lines);
		letterFreq = ten.topTenLetters(letterFreq);
		
		wordFreq = words(lines);
		wordFreq = ten.topTenWords(wordFreq);
		
		wildcard = WildCard(lines);
		
		StopHashMap stopMap = new StopHashMap();
		HashMap<String, Integer> stopHash = new HashMap();
		stopHash = stopMap.getSWordMap(lines);
		stopHash = ten.topTenWords(stopHash);
		
		//printing
		System.out.println("The most frequent 10 letters in this text are: ");
		System.out.println(letterFreq + "\n");
		
		
		System.out.println("The most frequent 10 words in this text are: ");
		System.out.println(wordFreq + "\n");
		
		System.out.println("The most frequent 10 words not in stop list: ");
		System.out.println(stopHash + "\n");
		
		System.out.println("How many times does the word 'river' appear in the text: ");
		System.out.println(wildcard + "\n");
	}
}