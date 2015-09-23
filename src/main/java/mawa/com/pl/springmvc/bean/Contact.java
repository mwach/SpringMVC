package mawa.com.pl.springmvc.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;


// TABLE per class hierarchy
@Entity(name="contact")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="disc")
@DiscriminatorValue("C")

//TABLE per subclass
//@Entity
//@Table(name="contact")
//@Inheritance(strategy=InheritanceType.JOINED)

//TABLE per concrete class
//@Entity
//@Table(name="contact")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="C_ID")
	int id;

	@NotNull
	String name;
	String surname;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
