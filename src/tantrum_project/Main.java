package tantrum_project;

import tantrum_project.InputManager.*;

public class Main {
	static TxtInputManager txt_file = new TxtInputManager("input.txt");
	
	public static void main(String[] args) {
		txt_file.ExtractWords();
	}

}