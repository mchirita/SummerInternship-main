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
	private Map<String, TokenInfo> userMap;
	private Map<String, TokenInfo> resetTokenMap;
	private Map<String, TokenInfo> userResetTokenMap;
	private TokenGenerator tokenGenerator;

	private TokenManager() {
		tokenMap = new ConcurrentHashMap<String, TokenInfo>();
		userMap = new ConcurrentHashMap<String, TokenInfo>();
		resetTokenMap = new ConcurrentHashMap<String, TokenInfo>();
		userResetTokenMap = new ConcurrentHashMap<String, TokenInfo>();
		tokenGenerator = new TokenGenerator();
	}

	public static TokenManager getInstance() {
		return instance;
	}

	public String generateToken(String userName) {
		LocalDateTime tokenValidityPeriod = LocalDateTime.now().plusMinutes(1);
		String token = tokenGenerator.generateToken(userName);
		TokenInfo tokenInfo = new TokenInfo(userName, token, tokenValidityPeriod);
		tokenMap.put(token, tokenInfo);
		userMap.put(userName, tokenInfo);
		return token;
	}

	public boolean containUser(String userName) {
		return userMap.containsKey(userName);
	}

	/**
	 * Check if token is valid.
	 * 
	 * @param token
	 * @return true if token is valid and flase otherwise.
	 */
	public boolean tokenValidator(String token) {
		boolean isValid = false;
		if (tokenMap.containsKey(token)) {
			if (tokenMap.get(token).getvalidUntil().isAfter(LocalDateTime.now())) {
				isValid = true;
			}
		}
		return isValid;
	}

	/**
	 * Check if user corresponding token is valid.
	 * 
	 * @param userName
	 * @return true if token is valid and flase otherwise.
	 */
	public boolean tokenValidatorForUser(String userName) {
		boolean isValid = false;
		if (userMap.get(userName).getvalidUntil().isAfter(LocalDateTime.now())) {
			isValid = true;
		}
		return isValid;
	}

	public String getTokenForUser(String userName) {
		return userMap.get(userName).getToken();
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
		return tokenMap.get(token).getUserName();
	}

	public void removeToken(String token) {
		String userName = tokenMap.remove(token).getUserName();
		userMap.remove(userName);
	}

	public TokenInfo generateResetToken(String userName, String generateToken) {
		LocalDateTime reserTokenVAlidityPeriod = LocalDateTime.now().plusMinutes(1);
		TokenInfo token = new TokenInfo(userName, generateToken, reserTokenVAlidityPeriod);
		resetTokenMap.put(generateToken, token);
		userResetTokenMap.put(userName, token);
		return token;
	}

	public boolean containsResetTokenForUserName(String userName) {

		return userResetTokenMap.containsKey(userName);
	}

	public boolean containsResetTokenForToken(String resetToken) {

		return resetTokenMap.containsKey(resetToken);
	}

	/**
	 * Check if reset token is valid.
	 * 
	 * @param resetToken
	 * @return true if token is valid and flase otherwise.
	 */
	public boolean resetTokenValidatorForToken(String resetToken) {
		boolean isValid = false;
		if (resetTokenMap.get(resetToken).getvalidUntil().isAfter(LocalDateTime.now())) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * Check if user corresponding reset token is valid.
	 * 
	 * @param userName
	 * @return true if token is valid and flase otherwise.
	 */
	public boolean resetTokenValidatorForUser(String userName) {
		boolean isValid = false;
		if (userResetTokenMap.containsKey(userName)) {
			if (userResetTokenMap.get(userName).getvalidUntil().isAfter(LocalDateTime.now())) {
				isValid = true;
			}
		}
		return isValid;
	}

	public String getUserWithResetToken(String resetToken) {
		return resetTokenMap.get(resetToken).getUserName();

	}

	public void removeResetTokenWithToken(String resetToken) {
		String userName = resetTokenMap.remove(resetToken).getUserName();
		userResetTokenMap.remove(userName);
	}

	public void removeResetTokenWithUserName(String userName) {
		String token = userResetTokenMap.remove(userName).getToken();
		resetTokenMap.remove(token);

	}

	public void printUserMap() {
		System.out.println("UserMap");
		for (String key : userMap.keySet()) {
			System.out.println(key + " " + userMap.get(key));
		}
	}

	public void printTokenMap() {
		System.out.println("TokenMap");
		for (String key : tokenMap.keySet()) {
			System.out.println(key + " " + tokenMap.get(key));
		}
	}

	public void printResetTokenMap() {
		System.out.println("ResetTokenMap");
		for (String key : resetTokenMap.keySet()) {
			System.out.println(key + " " + resetTokenMap.get(key));
		}
	}

	public void printUserResetTokenMap() {
		System.out.println("ResetTokenMap");
		for (String key : userResetTokenMap.keySet()) {
			System.out.println(key + " " + userResetTokenMap.get(key));
		}
	}

	// TO DO : implement resetTokenVAlidator() for resetTokenUserMap
}
