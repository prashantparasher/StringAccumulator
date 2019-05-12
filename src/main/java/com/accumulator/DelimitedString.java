package com.accumulator;

public class DelimitedString {

	private static final String NEWLINE = "\n";
	private static final String PREFIX_REGEX = "[";
	private static final String SUFFIX_REGEX = "]+";
	private static final String DEFAULT_REGEX_PATTERN = "[,|\n]+";

	private DelimitedOperation getNumberListMultipleDynamicDelimiter = (String delimiterAndNbrList) -> {
		// For the multiple delimiters

		String[] delimiterNbrArray = delimiterAndNbrList.split(NEWLINE);

		String multipleDelimiter = delimiterNbrArray[0].substring(2);

		String regexPattern = PREFIX_REGEX + multipleDelimiter + SUFFIX_REGEX;

		String[] nbrArray = delimiterNbrArray[1].split(regexPattern);

		return nbrArray;
	};

	private DelimitedOperation getNumberListDefaultDelimiter = (String nbrDelimitedList) -> {
		
		String[] nbrArray = nbrDelimitedList.split(DEFAULT_REGEX_PATTERN);

		return nbrArray;
	};

	private String[] operate(String nbrDelimitedList, DelimitedOperation delimitedOperation) {
		
		return delimitedOperation.processDelimitedString(nbrDelimitedList);
	}

	public String[] processDelimitedString(String nbrString) {
		
		if (nbrString.startsWith("//")) {
			//For the multiple dynamic Delimiters 
			return operate(nbrString, getNumberListMultipleDynamicDelimiter);

		} else {
			// For the simple case of default delimiters
			return operate(nbrString, getNumberListDefaultDelimiter);
		}

	}
	// String[] delimitersArray =
	// Arrays.asList(delimiters.split("\\|")).stream().map(s ->
	// s.substring(0)).toArray(String[]::new);

	// String test =
	// Arrays.asList(delimiters.split("\\|")).stream().collect(Collectors.joining("|","[","]+"));

}
