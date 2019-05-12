package com.accumulator;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class StringAccumulatorTest {

	@Test
	public void TestEquals1() throws Exception {

		String expectedEmpObj = "6";
		assertEquals(expectedEmpObj, new StringAccumulator().addString("1,2,3"));
	}

	@Test
	public void TestEquals2() throws Exception {

		String expectedEmpObj = "21";
		assertEquals(expectedEmpObj, new StringAccumulator().addString("1,2,3\n4,5,6"));
	}

	@Test
	public void TestEquals3() throws Exception {
		String expectedEmpObj = "6";
		assertEquals(expectedEmpObj, new StringAccumulator().addString("1\n2,3"));
	}

	@Test
	public void TestEquals4() throws Exception {
		String expectedEmpObj = "3";
		System.out.println(new StringAccumulator().addString("//;\n1;2"));
		assertEquals(expectedEmpObj, new StringAccumulator().addString("//;\n1;2"));
	}

	@Test(expected = Exception.class)
	public void TestEquals5() throws Exception {

		new StringAccumulator().addString("//;\n-1;-2;3");
	}

	@Test
	public void TestEquals6() throws Exception {
		String expectedEmpObj = "5";

		assertEquals(expectedEmpObj, new StringAccumulator().addString("//;\n1000;2;3"));
	}

	@Test
	public void TestEquals7() throws Exception {
		String expectedEmpObj = "6";

		assertEquals(expectedEmpObj, new StringAccumulator().addString("//***\n1***2***3"));
	}

	@Test
	public void TestEquals8() throws Exception {
		String expectedEmpObj = "6";

		assertEquals(expectedEmpObj, new StringAccumulator().addString("//*|%\n1*2%3"));
	}

	@Test
	public void TestEquals9() throws Exception {
		String expectedEmpObj = "6";

		assertEquals(expectedEmpObj, new StringAccumulator().addString("//***|%%\n1***2%%3"));
	}

}
