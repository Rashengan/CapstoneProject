package Capstone.Project.model;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class User
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserId;

	@Column
	private String Name;

	@Column
	private String Mail;

	@Column
	private String Password;


	public Integer getUserId() {return UserId;}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {Name = name;}
	public String getMail() {return Mail;}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getPassword() {return Password;}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	

}
