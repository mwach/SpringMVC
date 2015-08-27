package mawa.com.pl.springmvc.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//TABLE per class hierarchy
@Entity(name="contact")
@DiscriminatorValue("E")

//TABLE per subclass
//@Entity
//@Table(name="exclusive_contact")
//@PrimaryKeyJoinColumn(name="C_ID")

//TABLE per subclass
//@Entity
//@Table(name="exclusive_contact")
//@AttributeOverrides({
//	@AttributeOverride(name="name", column=@Column(name="name")),
//	@AttributeOverride(name="surname", column=@Column(name="surname"))
//})
public class ExclusiveContact extends Contact{

	String goldenCardNo;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="contact_order", joinColumns = {@JoinColumn(name="C_ID")}, inverseJoinColumns = {@JoinColumn( name="O_ID")})
	Set<Order> orders = new HashSet<>();

	public String getGoldenCardNo() {
		return goldenCardNo;
	}
	public void setGoldenCardNo(String goldenCardNo) {
		this.goldenCardNo = goldenCardNo;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order){
		this.orders.add(order);
	}
}
