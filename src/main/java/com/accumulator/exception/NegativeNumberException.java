package com.accumulator.exception;

import java.util.ArrayList;
import java.util.List;

public class NegativeNumberException extends Exception {

	List<Integer> negativeNbrList = new ArrayList<Integer>();

	public NegativeNumberException(List<Integer> negativeNbrList) {
		super();
		this.negativeNbrList = negativeNbrList;
	}

	public NegativeNumberException() {
		super();

	}

	public void addNegativeNumber(int negNbr) {
		negativeNbrList.add(negNbr);
	}

	public int getNegativeNbrCount() {
		return negativeNbrList.size();
	}

	public String toString() {
		negativeNbrList.stream().forEach(nbr -> System.out.print(nbr));
		return " :: Found these Negative Numbers, Negatives Not allowed ";

	}

	public List<Integer> getNegativeNbrList() {
		return negativeNbrList;
	}

}
