package org.iqu.auth.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Mitroi Stefan-Daniel
 * 
 *         Entity for token
 *
 */
public class TokenInfo {
	private User user;
	private String token;
	private LocalDateTime validUntil;

	public TokenInfo(User user, String token, LocalDateTime validUnti) {
		this.user = user;
		this.token = token;
		this.validUntil = validUnti;
	}


	public void setValidUntil(LocalDateTime validUntil) {
		this.validUntil = validUntil;
	}
	
	public LocalDateTime getvalidUntil() {
		return validUntil;
	}
	
	public User getUser() {
		return user;
	}
	public String getToken() {
		return token;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((validUntil == null) ? 0 : validUntil.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenInfo other = (TokenInfo) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (validUntil == null) {
			if (other.validUntil != null)
				return false;
		} else if (!validUntil.equals(other.validUntil))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TokenInfo [user=" + user + ", validUntil=" + validUntil + "]";
	}
	
	
	
}
