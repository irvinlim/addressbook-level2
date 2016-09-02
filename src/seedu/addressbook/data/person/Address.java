package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

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

    /**
     * Validates given address.
     * 
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
    	if (!isValidAddress(address)) {
    		throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
    	}
    	
    	this.isPrivate = isPrivate;
    	splitAddressAndSave(address);
    }
    
    /**
     * Splits a valid address into its parts, and assigns them to the object instance.
     * 
     * @param address
     */
    private void splitAddressAndSave(String address) {
    	String[] parts = splitAddress(address);
    	String[] unitParts = splitUnitNumber(parts[2]);
    	
    	block = new Block(parts[0]);
    	street = new Street(parts[1]);
    	unit = new Unit(unitParts[0], unitParts[1]);
    	postalCode = new PostalCode(parts[3]);
    }
    
    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
    	String[] parts = splitAddress(test);
        
        // Check if we have the correct number of parts
        if (parts.length != 4)
        	return false;
        
        // Check if unit number must begin with #
        if (parts[2].charAt(0) != '#')
        	return false;
        
        String[] unitParts = splitUnitNumber(parts[2]);
        
        // Unit number must contain '-' exactly once, between two numbers
        if (unitParts.length != 2)
        	return false;
        
        // Check if the following are valid integers
        Integer block, floor, room, postalCode;
        
        try {
	        block = Integer.parseInt(parts[0]);
	        floor = Integer.parseInt(unitParts[0]);
	        room = Integer.parseInt(unitParts[1]);
	        postalCode = Integer.parseInt(parts[3]);
        } catch (NumberFormatException e) {
        	return false;
        }
        
        // Postal code must be 6 digits
        if (postalCode < 100000)
        	return false;
        
        // Finally, return true, since the other conditions have been short-circuited.
        return true;
    }
    
    private static String[] splitAddress(String address) {
        return address.split(", ");
    }
    
    private static String[] splitUnitNumber(String unitNumber) {
        return unitNumber.substring(1, unitNumber.length()).split("-");
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
    
    
    private class Block {
    	private String value = "";
    	
    	public Block(String val) {
    		value = val;
    	}

    	@Override
    	public String toString() {
    		return value;
    	}
    	
    	@Override
    	public boolean equals(Object o) {
    		if (o == this)
    			return true;
    		else if (!(o instanceof Block))
    			return false;
    		else
    			return this.toString().equals(o.toString());
    	}
    }
    
    private class Street {
    	private String value = "";
    	
    	public Street(String val) {
    		value = val;
    	}
    	
    	@Override
    	public String toString() {
    		return value;
    	}
    	
    	@Override
    	public boolean equals(Object o) {
    		if (o == this)
    			return true;
    		else if (!(o instanceof Street))
    			return false;
    		else
    			return this.toString().equals(o.toString());
    	}
    }
    
    private class Unit {
    	private String floor = "";
    	private String room = "";
    	
    	public Unit(String floor, String room) {
    		this.floor = floor;
    		this.room = room;
    	}

    	@Override
    	public String toString() {
    		return "#" + floor + "-" + room;
    	}
    	
    	@Override
    	public boolean equals(Object o) {
    		if (o == this)
    			return true;
    		else if (!(o instanceof Unit))
    			return false;
    		else
    			return this.toString().equals(o.toString());
    	}
    }
    
    private class PostalCode {
    	private String value = "";
    	
    	public PostalCode(String val) {
    		value = val;
    	}
    	
    	@Override
    	public String toString() {
    		return value;
    	}
    	
    	@Override
    	public boolean equals(Object o) {
    		if (o == this)
    			return true;
    		else if (!(o instanceof PostalCode))
    			return false;
    		else
    			return this.toString().equals(o.toString());
    	}
    }
}