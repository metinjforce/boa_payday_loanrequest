package tr.com.jforce.boa.model;

import java.util.Date;

public class SendMailResponse {
	
	private String message;
    private Boolean success;
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
    
}
