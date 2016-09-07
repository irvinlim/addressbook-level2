package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;
import seedu.addressbook.data.person.address.PostalCode;


/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {
	
	private boolean isPrivate;
	public Block block;
	public Street street;
	public Unit unit;
	public PostalCode postalCode;
	
    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must follow the format: <BLOCK>, <STREET>, #<FLOOR>-<ROOM>, <POSTALCODE>, where BLOCK, FLOOR, ROOM are integers, and POSTALCODE is a 6 digit integer.";

    private static final int NUM_ADDRESS_PARTS = 4;
    
    /**
     * Validates given address.
     * 
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
    	if (!splitAddressAndSave(address)) {
    		throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
    	}
    	
    	this.isPrivate = isPrivate;
    }
    
    /**
     * Splits a valid address into its parts, and assigns them to the object instance.
     * 
     * @param address
     */
    private boolean splitAddressAndSave(String address) {
    	String[] parts = splitAddress(address);
    	
    	// Check for correct number of address parts
    	if (parts.length != NUM_ADDRESS_PARTS)
    		return false;
    		
    	try {
	    	block = new Block(parts[0]);
	    	street = new Street(parts[1]);
	    	unit = new Unit(parts[2]);
	    	postalCode = new PostalCode(parts[3]);	
    	} catch (IllegalArgumentException e) {
    		return false;
    	}
    	
    	return true;
    }
    
    private static String[] splitAddress(String address) {
        return address.split(", ");
    }

    @Override
    public String toString() {
        String[] parts = { block.toString(), street.toString(), unit.toString(), postalCode.toString() };
        return String.join(", ", parts);
    }

    @Override
    public boolean equals(Object other) {
    	if (this == other)
    		return true;
    	if (!(other instanceof Address))
    		return false;
    	
    	Address otherAddress = (Address) other;
    	
    	return block.equals(otherAddress.block) && 
    			street.equals(otherAddress.street) && 
    			unit.equals(otherAddress.unit) && 
    			postalCode.equals(otherAddress.postalCode);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}