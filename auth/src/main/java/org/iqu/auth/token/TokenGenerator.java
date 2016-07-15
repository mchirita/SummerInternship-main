package org.iqu.auth.token;


import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.iqu.auth.entities.User;
import org.iqu.auth.maps.TokenTokenInfoMap;
import org.iqu.auth.maps.UserTokenMap;

public class TokenGenerator {
	private String token;
	private TokenInfo tokenInfo;
	private Map<String,String> utm  = UserTokenMap.getInstance();
	private Map<String, TokenInfo> ttm = TokenTokenInfoMap.getInstance();
	
	public void generateToken(User user){
		Calendar calendar = Calendar.getInstance();
		Date creationDate = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date validUntil = calendar.getTime();
		token  = user.getUserName()+user.getPassword();
		tokenInfo = new TokenInfo(token, creationDate, validUntil);
		utm.put(user.getUserName(), token);
		ttm.put(token, tokenInfo);
	}
}
