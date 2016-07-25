package org.iqu.auth.persistence.service;

import java.sql.Connection;

import org.iqu.auth.persistence.dao.DaoFactory;
import org.iqu.auth.persistence.dao.DaoManager;
import org.iqu.auth.persistence.dto.UserCredentialsDto;

public class Test {

	public static void main(String[] args) {

		DaoManager d = DaoManager.getInstace();

		// DaoFactory factory = DaoFactory.getInstance();
		// UserDaoImpl u = factory.getUserDao();
		// User user = new User( "stn2", "mitroi1", "stefan", "pass", "msd","ro",
		// 20);
		// u.addUser(user);
		// UserCredentials uc = new UserCredentials("stn1", "pass");
		// UserCredentials uc1 = new UserCredentials("stn2", "pass");
		// UserCredentials uc2 = new UserCredentials("stn3", "pass");
		// UserCredentials uc3 = new UserCredentials("stn4", "pass");
		// DaoFactory factory = DaoFactory.getInstance();
		// UserCredentialsDto ucdt = new UserCredentialsDto(uc);
		// UserCredentialsDto ucdt1 = new UserCredentialsDto(uc1);
		// UserCredentialsDto ucdt2 = new UserCredentialsDto(uc2);
		// UserCredentialsDto ucdt3 = new UserCredentialsDto(uc3);

		// UserCredentialsDaoImpl ucd = factory.getUserCredentialsDao();

		// ucd.findUserCredentials(ucdt);
		// ucd.findUserCredentials(ucdt1);
		// ucd.findUserCredentials(ucdt2);
		// ucd.findUserCredentials(ucdt3);

	}

}
