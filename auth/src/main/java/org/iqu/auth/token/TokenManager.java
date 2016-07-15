package org.iqu.auth.token;

import java.util.Map;

import org.iqu.auth.entities.User;
import org.iqu.auth.maps.TokenTokenInfoMap;
import org.iqu.auth.maps.UserTokenMap;

public class TokenManager {

	static TokenManager instance = new TokenManager();
	private Map<String, String> utm = UserTokenMap.getInstance();
	private Map<String, TokenInfo> ttm = TokenTokenInfoMap.getInstance();

	private TokenManager() {

	}

	public static TokenManager getInstance() {
		return instance;
	}

	public String getTokenForUser(User user) {
		String response = "";
		for (Map.Entry<String, String> entry : utm.entrySet()) {
			if (entry.getKey().equals(user.getUserName()) == true) {
				response = entry.getValue();
				break;
			} else {
				response = "user not found";
			}
		}
		return response;
	}

	public void addToken(User user, String token) {
		utm.put(user.getUserName(), token);
	}

	public void removeToken(String token) {
		String tokenToBeRemove="";
		for (Map.Entry<String, String> entry : utm.entrySet()) {
			if (entry.getValue().equals(token) == true) {
				utm.remove(entry.getKey());
				tokenToBeRemove = entry.getValue();
				break;
			}
		}
	}

	public void updateToken(String token) {

	}

	// singleton
	// fara interfata
	// public String getTokenForUser(User user);
	// public void addToken(User user, Token token);
	// public void removeToken(Token token);
	// public void updateToken(Token token);
}
// package token in auth
