package seedu.addressbook.data.person.address;

public class Unit {
	private String floor = "";
	private String room = "";
	
	private final static char UNIT_PREFIX = '#';
	private final static String UNIT_DELIMITER = "-";
	private final static int NUM_UNIT_PARTS = 2;
	
	public Unit(String value) throws IllegalArgumentException {
		if (!validateAndSet(value))
			throw new IllegalArgumentException("Invalid unit number provided.");
	}
	
	public boolean validateAndSet(String value) {
		int parsedFloor, parsedRoom;
        
        // Unit number must begin with proper prefix
        if (value.charAt(0) != UNIT_PREFIX)
        	return false;
        
        // Split with # as prefix and - as delimiter
        String[] unitParts = splitUnitNumber(value);
        
        // Must have two parts to a unit number
        if (unitParts.length != NUM_UNIT_PARTS)
        	return false;
		
		// Catch NumberFormatExceptions
		try {
			parsedFloor = Integer.parseInt(unitParts[0]);
			parsedRoom = Integer.parseInt(unitParts[1]);
		} catch (NumberFormatException e) {
			return false;
		}
		
		// Parsed integer must not be zero.
		if (parsedFloor <= 0 || parsedRoom <= 0)
			return false;
		
		// Set values
		this.floor = unitParts[0];
		this.room = unitParts[1];
		
		return true;
	}
    
    private static String[] splitUnitNumber(String unitNumber) {
    	String removedPrefix = unitNumber.substring(1, unitNumber.length());
        return removedPrefix.split(UNIT_DELIMITER);
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
