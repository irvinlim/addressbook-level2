package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void nullArray_returnsCorrect() {
		Object[] test = { null, null, null };
		boolean actual = Utils.isAnyNull(test);
		
		assertEquals(actual, true);
	}

	@Test
	public void singleNullInArray_returnsCorrect() {
		Object[] test = { new ArrayList<String>(), null, new Object() };
		boolean actual = Utils.isAnyNull(test);
		
		assertEquals(actual, true);
	}

	@Test
	public void nonNullArray_returnsIncorrect() {
		Object[] test = { new ArrayList<String>() };
		boolean actual = Utils.isAnyNull(test);
		
		assertEquals(actual, false);
	}

}
