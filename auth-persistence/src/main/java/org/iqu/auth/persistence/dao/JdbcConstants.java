package org.iqu.auth.persistence.dao;

/**
 * Use for database connection.
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class JdbcConstants {
  public static final String DRIVER = "com.mysql.jdbc.Driver";
  public static final String PATH = "/iqu/database-config/jdbcProperties.properties";
  public static final String URL = "jdbc:mysql://localhost:3306/authdatabase";
  public static final String TABLENAME = "usertable";
}
