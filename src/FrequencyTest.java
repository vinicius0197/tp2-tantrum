import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tantrum_project.Frequency.Frequency;


class FrequencyTest {
	List<String> word_list = new ArrayList<String>();
	Frequency words_freq;
	
	@BeforeEach
	void init() {		
		word_list.add("test");
		word_list.add("test");
		word_list.add("random");
		
		words_freq = new Frequency(word_list);
	}
	
	@Test
	void testReturnFreqMap() {
		Map<String, Integer> freqs;
		
		words_freq.calculateFreqs();
		freqs = words_freq.getWordsFreq();
		assertTrue(!freqs.isEmpty());
	}
	
	@Test
	void testIsSorted() {
		Map<String, Integer> sorted_hash;
		List<Integer> sorted_list = new ArrayList<Integer>();
		
		words_freq.calculateFreqs();
		words_freq.sort();
		
		sorted_hash = words_freq.getSortedWords();
		
		for(Integer value: sorted_hash.values()) {
			sorted_list.add(value);
		}
		
		assertTrue(this.isSorted(sorted_list));
	}
	
	
	
	// Helper methods
	private static boolean isSorted(List<Integer> listOfStrings) {
	    return isSorted(listOfStrings, listOfStrings.size());
	}
	 
	private static boolean isSorted(List<Integer> listOfStrings, int index) {
	    if (index < 2) {
	        return true;
	    } else if (listOfStrings.get(index - 2).compareTo(listOfStrings.get(index - 1)) > 0) {
	        return false;
	    } else {
	        return isSorted(listOfStrings, index - 1);
	    }
	}
}


