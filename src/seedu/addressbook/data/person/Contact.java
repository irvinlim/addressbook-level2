package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public final String value;
    private boolean isPrivate;
    
    public Contact(String value, boolean isPrivate, String messageValueConstraints) throws IllegalValueException {
        this.isPrivate = isPrivate;
    	
        if (!isValid(value)) {
            throw new IllegalValueException(messageValueConstraints);
        }
        
        this.value = value;
    }
    
    public boolean isValid(String test) {
    	return false;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
