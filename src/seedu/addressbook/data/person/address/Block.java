package seedu.addressbook.data.person.address;

public class Block {
	private String value = "";
	
	public Block(String value) {
		if (!validateAndSet(value))
			throw new IllegalArgumentException("Invalid block number provided.");
	}
	
	public boolean validateAndSet(String value) {
		int parsedBlock;
		
		// Catch NumberFormatExceptions
		try {
			parsedBlock = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return false;
		}
		
		// Parsed integer must not be zero.
		if (parsedBlock <= 0)
			return false;
		
		// Set value
		this.value = value;
		
		return true;
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