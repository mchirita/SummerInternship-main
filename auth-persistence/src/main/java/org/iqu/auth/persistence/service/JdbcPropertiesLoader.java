package org.iqu.auth.persistence.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.iqu.auth.persistence.dao.JdbcConstants;

public class JdbcPropertiesLoader {
	
	private static final Logger LOGGER = Logger.getLogger(JdbcPropertiesLoader.class);
	private String userName;
	private String password;

	public void loadDataBaseProperties() {

		try (InputStream fis = new FileInputStream(JdbcConstants.PATH);
				InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(isr);) {
			userName = br.readLine();
			password = br.readLine();
		} catch (FileNotFoundException e) {
			LOGGER.error("file not found",e);
		} catch (IOException e) {
			LOGGER.error("wrong data",e);;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPssword() {
		return password;
	}

	public void setPssword(String pssword) {
		this.password = pssword;
	}

}
