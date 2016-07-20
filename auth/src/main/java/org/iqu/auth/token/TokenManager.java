package org.iqu.auth.token;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.iqu.auth.entities.TokenInfo;
import org.iqu.auth.entities.User;

/**
 * 
 * @author Mitroi Stefan-Daniel
 * 
 *         Manage token operation such as: add, remove, update, get and contain
 *
 */
public class TokenManager {

	private static TokenManager instance = new TokenManager();
	private static final LocalDateTime TOKENVALIDITYPERIOD = LocalDateTime.now().plusDays(1);
	private Map<String, TokenInfo> tokenTokenInfoMap;
	private Map<User, TokenInfo> userTokenInfoMap;
	private Map<TokenInfo, User> resetTokenUserMap;
	private TokenGenerator tokenGenerator;

	public TokenManager() {
		tokenTokenInfoMap = new ConcurrentHashMap<String, TokenInfo>();
		userTokenInfoMap = new ConcurrentHashMap<User, TokenInfo>();
		resetTokenUserMap = new ConcurrentHashMap<TokenInfo, User>();
		tokenGenerator = new TokenGenerator();
	}

	public static TokenManager getInstance() {
		return instance;
	}

	public String addToken(User user) {
		String token = tokenGenerator.generateToken(user.getUserName());
		TokenInfo tokenInfo = new TokenInfo(user, token, TOKENVALIDITYPERIOD);
		tokenTokenInfoMap.put(token, tokenInfo);
		userTokenInfoMap.put(user, tokenInfo);
		return token;
	}

	public boolean containUser(User user) {
		return userTokenInfoMap.containsKey(user);
	}

	public boolean isValid(String token) {
		boolean isValid = false;
		if (tokenTokenInfoMap.get(token).getvalidUntil().isAfter(LocalDateTime.now()) == true) {
			isValid = true;
		}
		return isValid;
	}

	public boolean isValid(User user) {
		boolean isValid = false;
		if (userTokenInfoMap.get(user).getvalidUntil().isAfter(LocalDateTime.now()) == true) {
			isValid = true;
		}
		return isValid;
	}

	public String getToken(User user) {
		return userTokenInfoMap.get(user).getToken();
	}

	public String getToken(String token) {
		TokenInfo returnToken;
		returnToken = tokenTokenInfoMap.get(token);
		if (returnToken != null) {
			return returnToken.getToken();
		} else {
			return "";
		}
	}

	public String getUser(String token) {
		return tokenTokenInfoMap.get(token).getUser().getUserName();
	}

	public void removeToken(String token) {
		tokenTokenInfoMap.remove(token);
	}

	public TokenInfo addToResetTokenUserEmailMap(User user,String generateToken) {
		//LocalDate reserTokenVAlidityPeriod = LocalDate.now().plus(60*60, ChronoUnit.SECONDS);
		LocalDateTime reserTokenVAlidityPeriod = LocalDateTime.now();
		TokenInfo token = new TokenInfo(user, generateToken, reserTokenVAlidityPeriod);
		return token;
	}
	public boolean resetTokenUserEmailMapContains(User user){
		return resetTokenUserMap.containsValue(user);
	}
	
	public TokenInfo getFromResetTokenUserEmailMap(User user) {
		String userToken = getToken(user);
		LocalDateTime reserTokenVAlidityPeriod = LocalDateTime.now().plusHours(1);
		TokenInfo token = new TokenInfo(user, userToken, reserTokenVAlidityPeriod);
		return token;
	}
//TO DO : implement isvalid() and contains for resetTokenUserMap
	
	public void printUtm() {
		System.out.println("utm:");
		for (Map.Entry<String, TokenInfo> entryutm : tokenTokenInfoMap.entrySet()) {
			System.out.println(entryutm.getKey().toString() + " " + entryutm.getValue());
		}
	}
}
