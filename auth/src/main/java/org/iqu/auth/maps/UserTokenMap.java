package org.iqu.auth.maps;

import java.util.HashMap;
import java.util.Map;
import org.iqu.auth.entities.User;

public class UserTokenMap {
	private static Map<String,String> map = new HashMap<String, String>();
	private UserTokenMap() {

	}

	public static Map<String, String> getInstance() {
		return map;
	}

}
