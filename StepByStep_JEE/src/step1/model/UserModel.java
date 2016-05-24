package step1.model;

public class UserModel {

	private String surname;
	private String pwd;
	private int age;
	private String lastname;
	private String login;
	public UserModel(String surname, String pwd, int age, String lastname,
			String login) {
		super();
		this.surname = surname;
		this.pwd = pwd;
		this.age = age;
		this.lastname = lastname;
		this.login = login;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Override
	public
	String toString() {
		return"[SURNAME]:"+this.getSurname()+",[LASTNAME]:"+this.getLastname()+",[AGE]:"+this.getAge()+",[LOGIN]:"+this.getLogin()+",[PWD]:"+this.getPwd();
	}
	

}
