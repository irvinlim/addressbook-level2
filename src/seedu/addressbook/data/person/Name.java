package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }
    
    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if they differ only in case, word ordering, or is a super/subset, etc.
     */
    public boolean isSimilar(Name other) {
    	if (other == null)
    		return false;
    	
    	String thisName = fullName.toLowerCase();
    	String otherName = other.fullName.toLowerCase();
    	
    	String[] thisNameWords = thisName.split(" ");
    	String[] otherNameWords = otherName.split(" ");

    	Set<String> thisNameSet = new HashSet<String>(Arrays.asList(thisNameWords));
    	Set<String> otherNameSet = new HashSet<String>(Arrays.asList(otherNameWords));
    	Set<String> thisNameSetCopy = new HashSet<String>(thisNameSet);
    	Set<String> otherNameSetCopy = new HashSet<String>(otherNameSet);
    	
    	// Get asymmetric set difference
    	otherNameSetCopy.removeAll(thisNameSet);
    	thisNameSetCopy.removeAll(otherNameSet);

    	// Check if either resultant set is empty, to determine if either of them were subsets of the other
    	boolean isEitherASubset = thisNameSetCopy.size() == 0 || otherNameSetCopy.size() == 0;
    	
    	return isEitherASubset;
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
