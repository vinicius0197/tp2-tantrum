package tantrum_project.Frequency;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.Entry.*;
import static java.util.stream.Collectors.*;

public class Frequency {
	List<String> words;
	Map<String, Integer> words_freq = new HashMap<String, Integer>();
	
	public Frequency(List<String> word_list) {
		assert !word_list.isEmpty();
		words = word_list;
	}
	
	public void calculateFreqs() {
		for(String word: words) {
			if(words_freq.containsKey(word)) {
				int freq;
				freq = words_freq.get(word);
				freq++;
				words_freq.put(word, freq);
			} else {
				words_freq.put(word, 1);
			}
		}
		
		System.out.println(words_freq);
	}
	
	public void sort() {
		assert !words_freq.isEmpty();
		
		Map<String, Integer> sorted = words_freq
				.entrySet()
				.stream()
				.sorted(comparingByValue())
				.collect(
						toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
								LinkedHashMap::new));
		
		System.out.println(sorted);
	}
}
