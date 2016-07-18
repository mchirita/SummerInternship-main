package org.iqu.auth.token;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.iqu.auth.entities.User;

public class TokenManager {

	private static TokenManager instance = new TokenManager();
	private Date tokenValidityPeriod; 
	private Map<User, Token> utm;
	private TokenGenerator tg;

	private TokenManager() {
		tokenValidityPeriod  = getTomorowDate();
		utm = new ConcurrentHashMap<User, Token>();
		tg = new TokenGenerator(tokenValidityPeriod);
	}

	public static TokenManager getInstance() {
		return instance;
	}

	public void setTokenValidity(Date tokenValidityPeriod) {
		this.tokenValidityPeriod = tokenValidityPeriod;
		tg.setValidUntil(tokenValidityPeriod);
	}

	public void addToken(User user) {
		Token token = tg.generateToken(user);
		utm.put(user, token);
	}

	public Token getToken(String tokenToBeFound) {
		for (Map.Entry<User, Token> entry : utm.entrySet()) {
			if (entry.getValue().getToken().equals(tokenToBeFound)) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	public Token getToken(User user) {
		
		return utm.get(user);
	}
	
	public void removeToken(User user) {
		utm.remove(user);
	}
	
	public void removeToken(String tokenToBeRemove) {

		for (Map.Entry<User, Token> entry : utm.entrySet()) {
			if (entry.getValue().getToken().equals(tokenToBeRemove)) {
				utm.remove(entry.getKey());
				break;
			}
		}
	}

	public void updateToken(String oldToken, String newToken) {
		for (Map.Entry<User, Token> entry : utm.entrySet()) {
			if (entry.getValue().equals(oldToken)) {
				entry.getValue().setToken(newToken);
				break;
			}
		}
	}
	
	public boolean containToken(User user){
		return utm.containsKey(user);
	}
	

	public void printUtm() {
		System.out.println("utm:");
		for (Map.Entry<User, Token> entryutm : utm.entrySet()) {
			System.out.println(entryutm.getKey().getUserName() + " " + entryutm.getValue());
		}
	}

	private Date getTomorowDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return calendar.getTime();
	}

	/*
	 * public String getTokenForUser(User user) { // return
	 * utm.get(user.getUserName()); }
	 * 
	 * public void addToken(User user) { tg.generateToken(user); }
	 * 
	 * public void removeToken(String token) { for (Map.Entry<String, String>
	 * entry : utm.entrySet()) { if (entry.getValue().equals(token) == true) {
	 * utm.remove(entry.getKey()); ttm.remove(entry.getValue()); break; } } }
	 * 
	 * public void updateToken(String oldToken, String newToken) {
	 * 
	 * for (Map.Entry<String, String> entry : utm.entrySet()) { if
	 * (entry.getValue().equals(oldToken) == true) { entry.setValue(newToken);
	 * ttm.put(newToken, ttm.remove(oldToken));
	 * //ttm.get(newToken).setToken(newToken); break; } } }
	 * 
	 * public void printUtmAndTtm() { for (Map.Entry<String, String> entryutm :
	 * utm.entrySet()) { System.out.println(entryutm.getKey() + " " +
	 * entryutm.getValue()); } for (Map.Entry<String, Token> entry :
	 * ttm.entrySet()) { System.out.println(entry.getKey() + " " +
	 * entry.getValue()); } }
	 */
}
