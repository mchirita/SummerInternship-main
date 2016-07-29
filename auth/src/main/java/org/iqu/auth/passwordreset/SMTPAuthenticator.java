package org.iqu.auth.passwordreset;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Authenticator use in EmailSender for getting a new session.
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class SMTPAuthenticator extends Authenticator {
  private String email;
  private String password;

  public SMTPAuthenticator(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(email, password);
  }
}
