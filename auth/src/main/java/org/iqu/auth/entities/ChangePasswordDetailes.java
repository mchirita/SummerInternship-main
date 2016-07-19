package org.iqu.auth.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Cristi Badoi
 * 
 *         Service that updates the user password in the database
 *
 */
public class ChangePasswordDetailes {
	private String resetToken;
	private String newPassword;

	@JsonCreator
	public ChangePasswordDetailes(@JsonProperty("resetToken") String resetToken,
			@JsonProperty("newPassword") String newPassword) {
		this.resetToken = resetToken;
		this.newPassword = newPassword;
	}

	public String getResetToken() {
		return resetToken;
	}

	public String getNewPassword() {
		return newPassword;
	}
}
