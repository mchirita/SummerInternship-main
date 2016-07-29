package org.iqu.auth.persistence.exception;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class AuthPersistenceException extends Exception {
  public AuthPersistenceException(String message) {
    super(message);
  }
  
  public AuthPersistenceException(String message, Throwable cause) {
    super(message, cause);
  }

}