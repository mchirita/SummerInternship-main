package org.iqu.auth.token;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.iqu.auth.entities.TokenInfo;

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

    String token = tokenGenerator.generateToken(userName);
    TokenInfo tokenInfo = new TokenInfo(userName, token, LocalDateTime.now().plusMinutes(2));
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
    if (userMap.containsKey(userName)) {
      if (userMap.get(userName).getvalidUntil().isAfter(LocalDateTime.now())) {
        isValid = true;
      }
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

  public void removeTokenWithToken(String token) {
    String userName;
    TokenInfo tokenInfo = tokenMap.remove(token);
    if (tokenInfo == null) {
      userName = "";
    } else {
      userName = tokenInfo.getUserName();
    }
    userMap.remove(userName);

  }

  public void removeTokenWithUserName(String userName) {
    String token;
    TokenInfo tokenInfo = userMap.remove(userName);
    if (tokenInfo == null) {
      token = "";
    } else {
      token = tokenInfo.getToken();
    }
    tokenMap.remove(token);
  }

  public TokenInfo generateResetToken(String userName, String generateToken) {

    TokenInfo token = new TokenInfo(userName, generateToken, LocalDateTime.now().plusMinutes(2));
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
    if (resetTokenMap.containsKey(resetToken)) {
      if (resetTokenMap.get(resetToken).getvalidUntil().isAfter(LocalDateTime.now())) {
        isValid = true;
      }
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
    TokenInfo tokeInfo = resetTokenMap.remove(resetToken);
    String userName;
    if (tokeInfo == null) {
      userName = "";
    } else {
      userName = tokeInfo.getUserName();
    }
    userResetTokenMap.remove(userName);
  }

  public void removeResetTokenWithUserName(String userName) {
    TokenInfo tokenInfo = userResetTokenMap.remove(userName);
    String token;
    if (tokenInfo == null) {
      token = "";
    } else {
      token = tokenInfo.getToken();
    }
    resetTokenMap.remove(token);
  }
}
