package step2.model;

import java.io.Serializable;

public class UserModelBean implements Serializable {
	private String lastname;
	private String surename;
	private int age;
	private String login;
	private String pwd;
	
	public UserModelBean(){	
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
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
		return "UserModelBean [lastname=" + lastname + ", surename=" + surename
				+ ", age=" + age + ", login=" + login + ", pwd=" + pwd + "]";
	}
	
}
