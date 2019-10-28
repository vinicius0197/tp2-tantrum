package tantrum_project;

import java.util.List;
import java.util.Map;

import tantrum_project.Frequency.Frequency;
import tantrum_project.InputManager.*;

public class Main {
	static String file_path = "input.txt";
	static TxtInputManager txt_file = new TxtInputManager(file_path);
	static Frequency words_freq;
	static Map<String, Integer> sorted_words;
	
	public static void main(String[] args) {
		// Checa se os parâmetros de entrada estão corretos
		assert file_path instanceof String;
		assert !file_path.isEmpty();
		
		txt_file.ExtractWords();
		txt_file.RemoveStopWords();
		
		List<String> words = txt_file.getFilteredWords();
		words_freq = new Frequency(words);
		words_freq.calculateFreqs();
		words_freq.sort();
		
		sorted_words = words_freq.getSortedWords();
		
		// Printa na tela o HashMap ordenado
		System.out.println(sorted_words);
	}

}