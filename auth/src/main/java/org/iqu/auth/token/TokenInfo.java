package org.iqu.auth.token;

import java.util.Date;

public class TokenInfo {
	private String token;
	private Date creationDate;
	private Date validUntil;
	
	public TokenInfo(String token, Date creationDate,Date validUnti ){
		this.token = token;
		this.creationDate = creationDate;
		this.validUntil = validUnti;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
}
