package org.iqu.auth.maps;

import java.util.HashMap;
import java.util.Map;
import org.iqu.auth.entities.User;

/**
 * 
 * Class use for simulate database
 * 
 * @author Mitroi Stefan-Daniel
 *
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
