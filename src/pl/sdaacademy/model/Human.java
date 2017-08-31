package pl.sdaacademy.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Human {
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;


	public Human() {
	}

	public Human(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Human{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
