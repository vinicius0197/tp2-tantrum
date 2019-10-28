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
	List<String> file_lines = new ArrayList<String>();
	List<String> unfiltered_words = new ArrayList<String>();
	
	public TxtInputManager(String file_path) {
		path = file_path;
	}
	
	public void ExtractWords() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line = reader.readLine()) != null) {
				file_lines.add(line);
			}
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception ocurred trying to read '%s'", path);
			e.printStackTrace();
		}
		
		// Itera na lista de linhas e usar REGEX para extrair as palavras individuais
		for(String temp: file_lines) {
			Matcher m1 = p.matcher(temp);
			while(m1.find()) {
				unfiltered_words.add(m1.group());
			}
		}
	}
	
	public void RemoveStopWords() {
		// TODO
	}	
}
