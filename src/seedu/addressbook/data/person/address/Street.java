package seedu.addressbook.data.person.address;

public class Street {
	private String value = "";
	
	public Street(String value) throws IllegalArgumentException {
		if (!validateAndSet(value))
			throw new IllegalArgumentException("Invalid street provided.");
	}
	
	public boolean validateAndSet(String value) {
		// Street must not be an empty string
		if (value.length() <= 0)
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
		else if (!(o instanceof Street))
			return false;
		else
			return this.toString().equals(o.toString());
	}
}
