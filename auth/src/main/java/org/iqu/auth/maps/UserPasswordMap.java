package org.iqu.auth.maps;

import java.util.HashMap;
import java.util.Map;
import org.iqu.auth.entities.User;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 * Class use for simulate database
 * 
 */
public class UserPasswordMap {

	private static Map<String, String> map = new HashMap<String, String>();

	private UserPasswordMap() {

	}

	public static Map<String, String> getInstance() {
		return map;
	}

}
