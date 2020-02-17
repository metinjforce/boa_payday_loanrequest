package tr.com.jforce.boa.model;

import java.math.BigDecimal;

public class RiskAnalysisRequest {
	
	private String customerId;
	private BigDecimal amount;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
}
