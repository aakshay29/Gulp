package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GULPRESTAURANT database table.
 * 
 */
@Entity
@NamedQuery(name="Gulprestaurant.findAll", query="SELECT g FROM Gulprestaurant g")
public class Gulprestaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String address;

	private String description;

	private String name;

	public Gulprestaurant() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}