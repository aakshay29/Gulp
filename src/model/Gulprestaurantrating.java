package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GULPRESTAURANTRATING database table.
 * 
 */
@Entity
@NamedQuery(name="Gulprestaurantrating.findAll", query="SELECT g FROM Gulprestaurantrating g")
public class Gulprestaurantrating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private BigDecimal rating;

	//bi-directional many-to-one association to Gulprestaurant
	@ManyToOne
	@JoinColumn(name="GULPRESTAURANTID")
	private Gulprestaurant gulprestaurant;

	//bi-directional many-to-one association to Gulpuser
	@ManyToOne
	@JoinColumn(name="GULPUSERID")
	private Gulpuser gulpuser;

	public Gulprestaurantrating() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public Gulprestaurant getGulprestaurant() {
		return this.gulprestaurant;
	}

	public void setGulprestaurant(Gulprestaurant gulprestaurant) {
		this.gulprestaurant = gulprestaurant;
	}

	public Gulpuser getGulpuser() {
		return this.gulpuser;
	}

	public void setGulpuser(Gulpuser gulpuser) {
		this.gulpuser = gulpuser;
	}

}