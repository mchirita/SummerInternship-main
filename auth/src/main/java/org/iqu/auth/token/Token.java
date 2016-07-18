package org.iqu.auth.token;

import java.util.Calendar;
import java.util.Date;

public class Token {
	private String token;
	private Date validUntil;

	public Token(String token, Date validUnti) {
		this.token = token;
		this.validUntil = validUnti;
	}

	public boolean isValid() {
		boolean valid = false;
		Calendar calendare = Calendar.getInstance();
		Date today = calendare.getTime();
		System.out.println(validUntil+" ---- "+today);
		System.out.println(validUntil.getTime()+" ---- "+today.getTime());
		if (validUntil.getTime() > today.getTime()) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
	public String getToken(){
		return token;
	}
	public void setToken(String token){
		this.token = token;
	}

	@Override
	public String toString() {
		return "Token [token=" + token + ", validUntil=" + validUntil + "]";
	}
	
}
