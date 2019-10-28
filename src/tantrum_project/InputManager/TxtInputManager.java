package tantrum_project.InputManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtInputManager implements InputManager {
	public String path;
	Pattern p = Pattern.compile("[a-zA-Z]+");

	List<String> unfiltered_words = new ArrayList<String>();
	List<String> filtered_words = new ArrayList<String>();
	List<String> stopwords = new ArrayList<String>();
	
	
	public TxtInputManager(String file_path) {
		path = file_path;
	}
	
	public List<String> getFilteredWords() {
		return filtered_words;
	}
	
	public void ExtractWords() {
		unfiltered_words = this.LoadFile(path);
	}
	
	public void RemoveStopWords() {
		stopwords = this.LoadFile("stopwords.txt");
		
		for(String word: unfiltered_words) {
			if(!stopwords.contains(word)) {
				filtered_words.add(word);
			}
		}
	}
	
	private List<String> LoadFile(String file) {
		List<String> lines = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		
		try {			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
		} catch (Exception e) {
			System.err.format("Could not open file '%s'", file);
			e.printStackTrace();
		}
		
		for(String temp: lines) {
			Matcher m = p.matcher(temp);
			while(m.find()) {
				words.add(m.group().toLowerCase());
			}
		}
		
		return words;
	}
}
