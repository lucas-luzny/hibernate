package pl.sdaacademy.model;

import org.hibernate.annotations.GenericGenerator;
import pl.sdaacademy.table.BaseManager;

import javax.persistence.*;

@Entity
@Table( name = "authors1" )

public class Author1 extends BaseModel{

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	@Column(name = "author_id")
	private String id;
	@Column(name = "year_of_birth")
	private int yearOfBirth;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "firstName", column = @Column(name = "second_name"))})
	private Human human;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	public Author1() {
	}

	public Author1(int yearOfBirth, Human human) {
		this.yearOfBirth = yearOfBirth;
		this.human = human;
	}

	@Override
	public String toString() {
		return "Author1{" +
				"id='" + id + '\'' +
				", yearOfBirth=" + yearOfBirth +
				", human=" + human +
				'}';
	}
}
