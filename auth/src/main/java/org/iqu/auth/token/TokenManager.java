package org.iqu.auth.token;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.iqu.auth.entities.TokenInfo;
import org.iqu.auth.entities.User;

/**
 * 
 * Manage token operation such as: add, remove, update, get and contain.
 * 
 * @author Mitroi Stefan-Daniel
 * 
 * 
 */
public class TokenManager {

	private static TokenManager instance = new TokenManager();
	private Map<String, TokenInfo> tokenMap;
	private Map<User, TokenInfo> userMap;
	private Map<TokenInfo, User> resetTokenMap;
	private TokenGenerator tokenGenerator;

	private TokenManager() {
		tokenMap = new ConcurrentHashMap<String, TokenInfo>();
		userMap = new ConcurrentHashMap<User, TokenInfo>();
		resetTokenMap = new ConcurrentHashMap<TokenInfo, User>();
		tokenGenerator = new TokenGenerator();
	}

	public static TokenManager getInstance() {
		return instance;
	}

	public String generateToken(User user) {
		LocalDateTime tokenValidityPeriod = LocalDateTime.now().plusDays(1);
		String token = tokenGenerator.generateToken(user.getUserName());
		TokenInfo tokenInfo = new TokenInfo(user, token, tokenValidityPeriod);
		tokenMap.put(token, tokenInfo);
		userMap.put(user, tokenInfo);
		return token;
	}

	public boolean containUser(User user) {
		return userMap.containsKey(user);
	}

	/**
	 * Check if token is valid.
	 * 
	 * @param token
	 * @return true if token is valid and flase otherwise.
	 */
	public boolean tokenValidator(String token) {
		boolean isValid = false;
		if (tokenMap.get(token).getvalidUntil().isAfter(LocalDateTime.now())) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * Check if user corresponding token is valid.
	 * 
	 * @param user
	 * @return true if token is valid and flase otherwise.
	 */
	public boolean tokenValidator(User user) {
		boolean isValid = false;
		if (userMap.get(user).getvalidUntil().isAfter(LocalDateTime.now())) {
			isValid = true;
		}
		return isValid;
	}

	public String getToken(User user) {
		return userMap.get(user).getToken();
	}

	public String getToken(String token) {
		TokenInfo returnToken;
		returnToken = tokenMap.get(token);
		if (returnToken != null) {
			return returnToken.getToken();
		} else {
			return "";
		}
	}

	public String getUser(String token) {
		return tokenMap.get(token).getUser().getUserName();
	}

	public void removeToken(String token) {
		tokenMap.remove(token);
	}

	public TokenInfo generateResetToken(User user, String generateToken) {
		LocalDateTime reserTokenVAlidityPeriod = LocalDateTime.now().plusHours(1);
		TokenInfo token = new TokenInfo(user, generateToken, reserTokenVAlidityPeriod);
		return token;
	}

	public boolean containsResetToken(User user) {
		return resetTokenMap.containsValue(user);
	}

	// TO DO : implement resetTokenVAlidator() for resetTokenUserMap
}
