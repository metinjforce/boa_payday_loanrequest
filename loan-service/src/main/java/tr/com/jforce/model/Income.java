package tr.com.jforce.model;

import java.math.BigDecimal;

public class Income {
	private Long customerId;
	private BigDecimal income;

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	
	
	
}
