package org.iqu.auth.exception;

public class RequestBodyException extends Exception {

  public RequestBodyException(String message) {
    super(message);
  }

  public RequestBodyException(String message, Throwable cause) {
    super(message, cause);
  }
}
