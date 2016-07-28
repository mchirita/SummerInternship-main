package org.iqu.auth.persistence.exception;

public class JdbcConfigurationException extends Exception {
  public JdbcConfigurationException(String message) {
    super(message);
  }

  public JdbcConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }
}
