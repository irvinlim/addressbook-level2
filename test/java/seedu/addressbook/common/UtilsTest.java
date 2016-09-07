package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void isAnyNull_nullArray() {
		Object[] test = { null, null, null };
		boolean actual = Utils.isAnyNull(test);
		
		assertEquals(actual, true);
	}

	@Test
	public void isAnyNull_singleNullInArray() {
		Object[] test = { new ArrayList<String>(), null, new Object() };
		boolean actual = Utils.isAnyNull(test);
		
		assertEquals(actual, true);
	}

	@Test
	public void isAnyNull_nonNullArray() {
		Object[] test = { new ArrayList<String>() };
		boolean actual = Utils.isAnyNull(test);
		
		assertEquals(actual, false);
	}

	@Test
	public void isAnyNull_emptyArray() {
		Object[] test = {};
		boolean actual = Utils.isAnyNull(test);
		
		assertEquals(actual, false);
	}

	@Test
	public void elementsAreUnique_singleElementArray() {
		ArrayList<String> test = new ArrayList<String>();
		test.add("hello");
		
		boolean actual = Utils.elementsAreUnique(test);
		
		assertEquals(actual, true);
	}

	@Test
	public void elementsAreUnique_twoUniqueElementsInArray() {
		ArrayList<String> test = new ArrayList<String>();
		test.add("hello");
		test.add("world");
		
		boolean actual = Utils.elementsAreUnique(test);
		
		assertEquals(actual, true);
	}

	@Test
	public void elementsAreUnique_twoEqualElementsInArray() {
		ArrayList<String> test = new ArrayList<String>();
		test.add("hello");
		test.add("hello");
		
		boolean actual = Utils.elementsAreUnique(test);
		
		assertEquals(actual, false);
	}

	@Test
	public void elementsAreUnique_emptyArray() {
		ArrayList<String> test = new ArrayList<String>();
		boolean actual = Utils.elementsAreUnique(test);
		
		assertEquals(actual, true);
	}

}
