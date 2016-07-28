package org.iqu.auth.persistence.exception;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class DataBaseConnectionException extends Exception {
  public DataBaseConnectionException(String message) {
    super(message);
  }

  public DataBaseConnectionException(String message, Throwable cause) {
    super(message, cause);
  }
}
