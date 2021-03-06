package step4.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UserModelBean implements Serializable {
	private String lastname;
	private String surname;
	private int age;
	private String login;
	private String pwd;
	
	public UserModelBean(){
			
		}
	
	public UserModelBean(String lastname, String surname, int age,
			String login, String pwd) {
		super();
		this.lastname = lastname;
		this.surname = surname;
		this.age = age;
		this.login = login;
		this.pwd = pwd;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UserModelBean [lastname=" + lastname + ", surname=" + surname
				+ ", age=" + age + ", login=" + login + ", pwd=" + pwd + "]";
	}
}
