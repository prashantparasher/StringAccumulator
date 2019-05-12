package com.accumulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Other Options to match the solution to requirements 
// 1. Guava Splitter API 
// 2. Instead of blacklisting the delimiters , we can whitelist the non-word chars

public class StringAccumulator {
	public static void main(String[] args) {
		try {
			System.out.println(new StringAccumulator().addString("//***|%%\n1***2%%3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addString(String nbrString) throws Exception {

		int sum = 0;
		List<Integer> negativeNbrList = new ArrayList<Integer>();

		String[] nbrArray = null;
		if (nbrString.indexOf("//") == 0) {
			String[] delimString = nbrString.split("\n");
			String delimiters = delimString[0].substring(2);

			// String[] delimitersArray =
			// Arrays.asList(delimiters.split("\\|")).stream().map(s ->
			// s.substring(0)).toArray(String[]::new);

			// String test =
			// Arrays.asList(delimiters.split("\\|")).stream().collect(Collectors.joining("|","[","]+"));

			String test = "[" + delimiters + "]+";
			nbrArray = delimString[1].split(test);
		} else {
			nbrArray = nbrString.split("[,|\n]+");
		}

		for (int i = 0; i < nbrArray.length; i++) {
			int nbr = Integer.parseInt(nbrArray[i]);
			if (nbr > 0 && nbr < 1000) {
				sum = sum + nbr;
			} else {
				negativeNbrList.add(nbr);
			}

		}

		if (negativeNbrList.size() > 1) {
			System.out.println("Negative Number List " + negativeNbrList);
			throw new Exception("Negative Numbers not allowed in the input");
		}
		return String.valueOf(sum);
	}
}
