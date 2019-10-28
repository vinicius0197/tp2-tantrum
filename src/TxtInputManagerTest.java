import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tantrum_project.InputManager.TxtInputManager;

class TxtInputManagerTest {
	TxtInputManager txt_file;
	
	@BeforeEach
	public void init() {
		txt_file = new TxtInputManager("input.txt");
	}

	@Test
	void testUnfilteredWords() {
		List<String> words;
		txt_file.ExtractWords();
		words = txt_file.getUnfilteredWords();
		assertTrue(!words.isEmpty());
	}

}
