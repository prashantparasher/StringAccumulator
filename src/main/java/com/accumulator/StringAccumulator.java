package com.accumulator;


import com.accumulator.exception.NegativeNumberException;

// Other Options to match the solution to requirements 
// 1. Technically Guava Splitter API suits also suits here 

// 2. as for Functional approach Instead of blacklisting the delimiters , we can whitelist the non-word chars

// Assumption that input will be integers 

public class StringAccumulator {
	
	NegativeNumberException negNbrExp = new NegativeNumberException();
	
	DelimitedString delimitedStr = new DelimitedString();

	public static void main(String[] args) {
		try {
			
			System.out.println(new StringAccumulator().addString("//;\n-1;-2;3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addString(String nbrDelimitedString) throws Exception {

		int sum = 0;

		String[] nbrArray = delimitedStr.processDelimitedString(nbrDelimitedString);

		for (int i = 0; i < nbrArray.length; i++) {

			int nbr = Integer.parseInt(nbrArray[i]);

			if (nbr > 0 && nbr < 1000) {

				sum = sum + nbr;

			} else {

				negNbrExp.addNegativeNumber(nbr);

			}

		}

		if (negNbrExp.getNegativeNbrCount() > 1) {

			throw new NegativeNumberException(negNbrExp.getNegativeNbrList());
		}

		return String.valueOf(sum);
	}
}
