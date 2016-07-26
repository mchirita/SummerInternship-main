package org.iqu.auth.entities;

import java.time.LocalDateTime;

/**
 * 
 * Entity for token
 * 
 * @author Mitroi Stefan-Daniel
 * 
 *
 */
public class TokenInfo {
	private String userName;
	private String token;
	private LocalDateTime validUntil;

	public TokenInfo(String userName, String token, LocalDateTime validUnti) {
		this.userName = userName;
		this.token = token;
		this.validUntil = validUnti;
	}

	public void setValidUntil(LocalDateTime validUntil) {
		this.validUntil = validUntil;
	}

	public LocalDateTime getvalidUntil() {
		return validUntil;
	}

	public String getUserName() {
		return userName;
	}

	public String getToken() {
		return token;
	}

	public void setUser(String userName) {
		this.userName = userName;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
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
		return "TokenInfo [userName=" + userName + ", token=" + token + ", validUntil=" + validUntil + "]";
	}


}
