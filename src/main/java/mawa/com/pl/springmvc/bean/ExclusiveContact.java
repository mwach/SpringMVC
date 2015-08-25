package mawa.com.pl.springmvc.bean;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//TABLE per class hierarchy
//@Entity(name="contact")
//@DiscriminatorValue("E")

//TABLE per subclass
//@Entity
//@Table(name="exclusive_contact")
//@PrimaryKeyJoinColumn(name="C_ID")

//TABLE per subclass
@Entity
@Table(name="exclusive_contact")
@AttributeOverrides({
	@AttributeOverride(name="name", column=@Column(name="name")),
	@AttributeOverride(name="surname", column=@Column(name="surname"))
})
public class ExclusiveContact extends Contact{

	String goldenCardNo;

	public String getGoldenCardNo() {
		return goldenCardNo;
	}
	public void setGoldenCardNo(String goldenCardNo) {
		this.goldenCardNo = goldenCardNo;
	}
	
	
}
