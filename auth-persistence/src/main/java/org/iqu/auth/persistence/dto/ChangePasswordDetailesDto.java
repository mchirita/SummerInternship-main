package org.iqu.auth.persistence.dto;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class ChangePasswordDetailesDto {
	
	private String resetToken;
	private String newPassword;
	
	public ChangePasswordDetailesDto(String resetToken, String newPassword) {
		
		this.resetToken = resetToken;
		this.newPassword = newPassword;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
