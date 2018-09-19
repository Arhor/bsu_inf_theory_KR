package by.bsu.approximation.util;

public class SimpleDictBuilder {

	private SimpleDictBuilder() {}
	
	public static String buildDictionary(String source) {
		StringBuilder sb = new StringBuilder();
		source.chars()
		      .mapToObj(c -> (char) c)
		      .distinct()
		      .sorted()
		      .forEach(c -> sb.append(c));
		return sb.toString();
	}
	
}
