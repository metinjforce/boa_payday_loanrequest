package tr.com.jforce.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerInfo implements Serializable{

	private String address; 
	private String lastEmployerName; 
	private Date startDate;

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLastEmployerName() {
		return lastEmployerName;
	}
	public void setLastEmployerName(String lastEmployerName) {
		this.lastEmployerName = lastEmployerName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
}
