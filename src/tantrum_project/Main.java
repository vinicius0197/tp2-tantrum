package tantrum_project;

import java.util.List;

import tantrum_project.InputManager.*;

public class Main {
	static TxtInputManager txt_file = new TxtInputManager("input.txt");
	
	public static void main(String[] args) {
		txt_file.ExtractWords();
		txt_file.RemoveStopWords();
		
		List<String> words = txt_file.getFilteredWords();
		System.out.println(words);
	}

}