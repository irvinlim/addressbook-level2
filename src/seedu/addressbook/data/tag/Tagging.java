package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {

	private Person person;
	private Tag tag;
	private boolean isAddition;
	
	public Tagging(Person person, Tag tag, boolean isAddition) {
		this.person = person;
		this.tag = tag;
		this.isAddition = isAddition;
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		
		if (isAddition) {
			builder.append("+ ");
		} else {
			builder.append("- ");
		}
		
		builder.append(person.getName())
				.append(" [")
				.append(tag.tagName)
				.append("]");
		
		return builder.toString();
	}
}
