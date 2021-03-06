package magic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Magic {
	public static void main(String[] args) {
		countWords();
	}

	private static void countWords() {
		var sentence = """
				The universe is all of space and time and their contents,
				including planets, stars, galaxies, and all other forms of matter and energy.
				While the spatial size of the entire universe is unknown, it is possible
				 to measure the size of the observable universe, which is currently estimated
				  to be 93 billion light-years in diameter.
				""";
		
		List<String> wordsList = Stream.of(sentence)
				.map(s -> s.split("\\s+"))
				.flatMap(Arrays::stream)
				.collect(Collectors.toList());

//		1. Using Collectors.toMap
		Map<String, Integer> countOfWords_usingtoMap = wordsList.stream()
				.filter(Objects::nonNull)
				.filter(word -> !word.isBlank())
				.collect(Collectors.toMap(String::toLowerCase, w -> 1, Integer::sum));

		Map<String, Integer> countOfWords_usingGroupingBy_summingInt = wordsList.stream()
				.filter(Objects::nonNull)
				.filter(word -> !word.isBlank())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

		Map<String, Long> countOfWords_usingGroupingBy_counting = wordsList.stream()
				.filter(Objects::nonNull)
				.filter(word -> !word.isBlank())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(countOfWords_usingtoMap);
		System.out.println(countOfWords_usingGroupingBy_summingInt);
		System.out.println(countOfWords_usingGroupingBy_counting);
	}

}
