package com.accumulator;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class StringAccumulatorTest {

	//Test cases as per the sequence of requirements 
	
	@Test
	public void TestEquals1() throws Exception {

		String expectedResult = "6";
		assertEquals(expectedResult, new StringAccumulator().addString("1,2,3"));
	}

	@Test
	public void TestEquals2() throws Exception {

		String expectedResult = "21";
		assertEquals(expectedResult, new StringAccumulator().addString("1,2,3\n4,5,6"));
	}

	@Test
	public void TestEquals3() throws Exception {
		String expectedResult = "6";
		assertEquals(expectedResult, new StringAccumulator().addString("1\n2,3"));
	}

	@Test
	public void TestEquals4() throws Exception {
		String expectedResult = "3";
		System.out.println(new StringAccumulator().addString("//;\n1;2"));
		assertEquals(expectedResult, new StringAccumulator().addString("//;\n1;2"));
	}

	@Test(expected = Exception.class)
	public void TestEquals5() throws Exception {

		new StringAccumulator().addString("//;\n-1;-2;3");
	}

	@Test
	public void TestEquals6() throws Exception {
		String expectedResult = "5";

		assertEquals(expectedResult, new StringAccumulator().addString("//;\n1000;2;3"));
	}

	@Test
	public void TestEquals7() throws Exception {
		String expectedResult = "6";

		assertEquals(expectedResult, new StringAccumulator().addString("//***\n1***2***3"));
	}

	@Test
	public void TestEquals8() throws Exception {
		String expectedResult = "6";

		assertEquals(expectedResult, new StringAccumulator().addString("//*|%\n1*2%3"));
	}

	@Test
	public void TestEquals9() throws Exception {
		String expectedResult = "6";

		assertEquals(expectedResult, new StringAccumulator().addString("//***|%%\n1***2%%3"));
	}

}
