package auth.persistence.entities;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class User {
	
	private int id;
	private String userName;
	private String firsName;
	private String lastName;
	private String password;
	private String email;
	private String country;
	private int age;


	public User(int id, String userName, String firsName, String lastName, String password, String email, String country,
			int age) {
		
		this.id = id;
		this.userName = userName;
		this.firsName = firsName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.country = country;
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
