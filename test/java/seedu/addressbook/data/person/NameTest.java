package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	@Test
	public void isSimilar_testWithNull() throws IllegalValueException {
		Name testCase = new Name("John Smith");
		Name otherCase = null;
		boolean actual = testCase.isSimilar(otherCase);
		assertEquals(false, actual);
	}

	@Test
	public void isSimilar_testWithDifferentName() throws IllegalValueException {
		Name testCase = new Name("John Smith");
		Name otherCase = new Name("Jack Wilde");
		boolean actual = testCase.isSimilar(otherCase);
		assertEquals(false, actual);
	}

	@Test
	public void isSimilar_testWithDifferentLastName() throws IllegalValueException {
		Name testCase = new Name("John Smith");
		Name otherCase = new Name("John Wilde");
		boolean actual = testCase.isSimilar(otherCase);
		assertEquals(false, actual);
	}

	@Test
	public void isSimilar_testWithExact() throws IllegalValueException {
		Name testCase = new Name("John Smith");
		Name otherCase = new Name("John Smith");
		boolean actual = testCase.isSimilar(otherCase);
		assertEquals(true, actual);
	}

	@Test
	public void isSimilar_testWithDifferentCase() throws IllegalValueException {
		Name testCase = new Name("John Smith");
		Name otherCase = new Name("john smith");
		boolean actual = testCase.isSimilar(otherCase);
		assertEquals(true, actual);
	}

	@Test
	public void isSimilar_testWithDifferentOrdering() throws IllegalValueException {
		Name testCase = new Name("John Smith");
		Name otherCase = new Name("Smith John");
		boolean actual = testCase.isSimilar(otherCase);
		assertEquals(true, actual);
	}

	@Test
	public void isSimilar_testWithSuperSet() throws IllegalValueException {
		Name testCase = new Name("John Smith");
		Name otherCase = new Name("John K Smith");
		boolean actual = testCase.isSimilar(otherCase);
		assertEquals(true, actual);
	}

	@Test
	public void isSimilar_testWithSubSet() throws IllegalValueException {
		Name testCase = new Name("John K Smith");
		Name otherCase = new Name("John Smith");
		boolean actual = testCase.isSimilar(otherCase);
		assertEquals(true, actual);
	}

}
