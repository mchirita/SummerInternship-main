package org.iqu.auth.maps;

import java.util.HashMap;
import java.util.Map;
import org.iqu.auth.token.TokenInfo;

public class TokenTokenInfoMap {
	private static Map<String, TokenInfo> map = new HashMap<String, TokenInfo>();

	private TokenTokenInfoMap() {

	}

	public static Map<String, TokenInfo> getInstance() {
		return map;
	}
}
