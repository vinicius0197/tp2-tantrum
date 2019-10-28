package tantrum_project;

import java.util.List;

import tantrum_project.InputManager.*;

public class Main {
	static String file_path = "input.txt";
	
	static TxtInputManager txt_file = new TxtInputManager(file_path);
	
	public static void main(String[] args) {
		// Checa se os parâmetros de entrada estão corretos
		assert file_path instanceof String;
		assert !file_path.isEmpty();
		
		txt_file.ExtractWords();
		txt_file.RemoveStopWords();
		
		List<String> words = txt_file.getFilteredWords();
		System.out.println(words);
	}

}