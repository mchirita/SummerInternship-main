package org.iqu.auth.persistence.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.log4j.Logger;
import static org.iqu.auth.persistence.dao.JdbcConstants.*;

public class JdbcPropertiesLoader {

  private static final Logger LOGGER = Logger.getLogger(JdbcPropertiesLoader.class);
  private String userName;
  private String password;
  private Properties readProps;

  public JdbcPropertiesLoader() {
    readProps = new Properties();
  }

  public void loadDataBaseProperties() {
    try (FileInputStream input = new FileInputStream(PATH)) {
      readProps.load(input);
      userName = readProps.getProperty("username");
      password = readProps.getProperty("password");
    } catch (FileNotFoundException e) {
      LOGGER.error("File not found", e);
    } catch (IOException e) {
      LOGGER.error("Wrong data", e);
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
