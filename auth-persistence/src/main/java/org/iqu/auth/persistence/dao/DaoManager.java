package org.iqu.auth.persistence.dao;

import static org.iqu.auth.persistence.dao.JdbcConstants.DRIVER;
import static org.iqu.auth.persistence.dao.JdbcConstants.URL;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.iqu.auth.persistence.exception.DataBaseConnectionException;
import org.iqu.auth.persistence.service.JdbcPropertiesLoader;

/**
 * Manages database connection.
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class DaoManager {

  private static final Logger LOGGER = Logger.getLogger(DaoManager.class);
  private static DaoManager instance = new DaoManager();
  private Connection connection;

  public static DaoManager getInstace() {
    return instance;
  }

  public Connection getConnection() throws DataBaseConnectionException {
    JdbcPropertiesLoader loader = new JdbcPropertiesLoader();
    loader.loadDataBaseProperties();

    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(DRIVER);
    dataSource.setUrl(URL);
    dataSource.setUsername(loader.getUserName());
    dataSource.setPassword(loader.getPssword());
    try {
      connection = dataSource.getConnection();
    } catch (SQLException e) {
      LOGGER.error("database connection problem", e);
      throw new DataBaseConnectionException("database connection problem");
    }
    return connection;
  }

  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      LOGGER.error(e.getMessage(), e);
    }
  }

  private DaoManager() {

  }
}
