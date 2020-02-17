package tr.com.jforce.model;

import java.math.BigDecimal;

public class Loan {
	
	private Long customerId;
	private BigDecimal amount;
	private int month;
	private String loanId;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	@Override
	public String toString() {
		return "Loan [customerId=" + customerId + ", amount=" + amount + ", month=" + month + ", loanId=" + loanId
				+ "]";
	}



}
