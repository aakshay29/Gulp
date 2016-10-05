package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GULPUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Gulpuser.findAll", query="SELECT g FROM Gulpuser g")
public class Gulpuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String email;

	private String name;

	private String password;

	@Column(name="\"ROLE\"")
	private long role;

	private String username;

	private String zipcode;

	public Gulpuser() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRole() {
		return this.role;
	}

	public void setRole(long role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}