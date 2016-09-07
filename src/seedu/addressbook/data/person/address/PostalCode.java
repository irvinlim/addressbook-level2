package seedu.addressbook.data.person.address;

public class PostalCode {
	private String value = "";
	
	final static int NUM_POSTAL_CODE_DIGITS = 6;
	
	public PostalCode(String value) throws IllegalArgumentException {
		if (!validateAndSet(value))
			throw new IllegalArgumentException("Invalid postal code provided.");
	}
	
	public boolean validateAndSet(String value) {
		int parsedPostalCode;
		
		// Catch NumberFormatExceptions
		try {
			parsedPostalCode = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return false;
		}
		
		// Parsed integer must not be zero.
		if (parsedPostalCode <= 0)
			return false;
		
		// Postal code must be 6 digits
		if (value.length() != NUM_POSTAL_CODE_DIGITS)
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
		else if (!(o instanceof PostalCode))
			return false;
		else
			return this.toString().equals(o.toString());
	}
}
