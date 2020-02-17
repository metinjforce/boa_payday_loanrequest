package tr.com.jforce.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Customer {
	
    private Long id;
    private String externalId;
    private String name;
    private BigDecimal income;
    public Customer(Long id, String externalId, String name, BigDecimal income) {
        this.id = id;
        this.externalId = externalId;
        this.name = name;
        this.income = income;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getExternalId() {
        return externalId;
    }
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
    
    
  
}