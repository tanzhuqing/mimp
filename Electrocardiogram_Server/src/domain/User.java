package domain;

public class User {
	private Integer id;
	private String username;
	private String password;
	public User()
	{
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
